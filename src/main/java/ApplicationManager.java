/*
 * JRoadMap - https://jroadmap.dev.java.net/
 * Copyright (C) 2007 Fernando Boaflio (boaglio at gmail dot com)
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.mentawai.core.ActionConfig;
import org.mentawai.core.Context;
import org.mentawai.core.Forward;
import org.mentawai.core.Redirect;
import org.mentawai.filter.DIFilter;
import org.mentawai.filter.HibernateFilter;
import org.mentawai.filter.InjectionFilter;
import org.mentawai.filter.IoCFilter;
import org.mentawai.filter.OVFilter;
import org.mentawai.filter.OutputFilter;
import org.mentawai.filter.TransactionFilter;
import org.mentawai.filter.VOFilter;
import org.mentawai.formatter.DateFormatter;
import org.mentawai.formatter.FormatterManager;
import org.mentawai.i18n.LocaleManager;
import org.mentawai.list.BaseListData;
import org.mentawai.list.ListManager;
import org.mentawai.log.Info;
import org.mentawai.transaction.HibernateTransaction;

import com.boaglio.jroadmap.controller.PlanAction;
import com.boaglio.jroadmap.controller.ProjectAction;
import com.boaglio.jroadmap.controller.ResponsibleAction;
import com.boaglio.jroadmap.controller.RoadmapAction;
import com.boaglio.jroadmap.controller.TaskAction;
import com.boaglio.jroadmap.controller.service.PlanServiceImpl;
import com.boaglio.jroadmap.controller.service.ProjectServiceImpl;
import com.boaglio.jroadmap.controller.service.ResponsibleServiceImpl;
import com.boaglio.jroadmap.controller.service.RoadmapServiceImpl;
import com.boaglio.jroadmap.controller.service.TaskServiceImpl;
import com.boaglio.jroadmap.controller.validator.ProjectValidationFilter;
import com.boaglio.jroadmap.controller.validator.ResponsibleValidationFilter;
import com.boaglio.jroadmap.controller.validator.TaskValidationFilter;
import com.boaglio.jroadmap.model.dao.HibernatePlanDAO;
import com.boaglio.jroadmap.model.dao.HibernateProjectDAO;
import com.boaglio.jroadmap.model.dao.HibernateResponsibleDAO;
import com.boaglio.jroadmap.model.dao.HibernateRoadmapDAO;
import com.boaglio.jroadmap.model.dao.HibernateTaskDAO;
import com.boaglio.jroadmap.model.pojo.Plan;
import com.boaglio.jroadmap.model.pojo.Project;
import com.boaglio.jroadmap.model.pojo.Responsible;
import com.boaglio.jroadmap.model.pojo.Task;
import com.boaglio.jroadmap.model.vo.PlanVO;
import com.boaglio.jroadmap.model.vo.ProjectVO;
import com.boaglio.jroadmap.model.vo.ResponsibleVO;
import com.boaglio.jroadmap.model.vo.TaskVO;

/**
 * ApplicationManager class configures all in Mentawai Environment.
 *
 * @author Fernando Boaglio (boaglio@gmail.com)
 *
 */
public class ApplicationManager extends org.mentawai.core.ApplicationManager {

    /** Hibernate SessionFactory. */
    SessionFactory sessionFactory;

    /**
     * Load dropdown lists.
     * @throws IOException exception
     */
    @Override
    public void loadLists() throws IOException {

        ListManager.init();
        try {
            // priority
            ListManager.addList(new BaseListData("priority",
                    BaseListData.ORDER_BY_ID));
            // status
            ListManager.addList(new BaseListData("status",
                    BaseListData.ORDER_BY_ID));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void init(Context context) {

        Class[] mapAnnotations = {
            Responsible.class, Project.class, Task.class, Plan.class
        };

        AnnotationConfiguration ac = new AnnotationConfiguration()
        .addPackage("com.boaglio.jroadmap.model.pojo");
        for (Class c : mapAnnotations) {
            ac.addAnnotatedClass(c);
        }
        sessionFactory = ac.configure().buildSessionFactory();

        ioc("responsibleService", ResponsibleServiceImpl.class);
        ioc("projectService", ProjectServiceImpl.class);
        ioc("taskService", TaskServiceImpl.class);
        ioc("planService", PlanServiceImpl.class);
        ioc("roadmapService", RoadmapServiceImpl.class);

        ioc("responsibleDAO", HibernateResponsibleDAO.class);
        ioc("projectDAO", HibernateProjectDAO.class);
        ioc("taskDAO", HibernateTaskDAO.class);
        ioc("planDAO", HibernatePlanDAO.class);
        ioc("roadmapDAO", HibernateRoadmapDAO.class);

        ioc("transaction", HibernateTransaction.class);
    }

    public void loadActions() {

        // Enable log
        Info.enable(true);

        final String URL_JROADMAP="/jroadmap/";

//    	setDebugMode(true);

        addGlobalFilter(new IoCFilter());
        // hibernate stuff
        addGlobalFilter(new HibernateFilter());
        addGlobalFilter(new DIFilter("session", Session.class));

        // DAOs
        addGlobalFilter(new DIFilter("responsibleDAO", HibernateResponsibleDAO.class));
        addGlobalFilter(new DIFilter("projectDAO", HibernateProjectDAO.class));
        addGlobalFilter(new DIFilter("taskDAO", HibernateTaskDAO.class));
        addGlobalFilter(new DIFilter("planDAO", HibernatePlanDAO.class));
        addGlobalFilter(new DIFilter("roadmapDAO", HibernateRoadmapDAO.class));

        addGlobalFilter(new InjectionFilter());
        addGlobalFilter(new OutputFilter());

        // responsible
        ActionConfig actionConfig = new ActionConfig(URL_JROADMAP+"responsible", ResponsibleAction.class)
         .addConsequence(ResponsibleAction.LIST_JSP, new Forward(URL_JROADMAP+"listResponsible.jsp"))
         .addConsequence(ResponsibleAction.LIST, new Redirect("responsible.mtw"))
         .addConsequence(ResponsibleAction.SHOW, new Forward(URL_JROADMAP+"updateResponsible.jsp"))
         .addFilter(new ResponsibleValidationFilter(), "update")
         .addFilter(new ResponsibleValidationFilter(), "add")
         .addFilter(new TransactionFilter(new String[] { ResponsibleAction.LIST }))
         .addConsequence(ResponsibleAction.ERROR, "add", new Forward(URL_JROADMAP+"addResponsible.jsp"))
         .addConsequence(ResponsibleAction.ERROR, "update", new Forward(URL_JROADMAP+"updateResponsible.jsp"))
         .addFilter(new VOFilter(ResponsibleVO.class, "responsible"));
        add(actionConfig);

        // project
        actionConfig = new ActionConfig(URL_JROADMAP+"project", ProjectAction.class)
         .addConsequence(ProjectAction.LIST_JSP, new Forward(URL_JROADMAP+"listProject.jsp"))
         .addConsequence(ProjectAction.LIST, new Redirect("project.mtw"))
         .addConsequence(ProjectAction.SHOW, new Forward(URL_JROADMAP+"updateProject.jsp"))
         .addFilter(new TransactionFilter(new String[] { ProjectAction.LIST }))
         .addFilter(new ProjectValidationFilter(), "update")
         .addFilter(new ProjectValidationFilter(), "add")
         .addConsequence(ProjectAction.ERROR, "add", new Forward(URL_JROADMAP+"addProject.jsp"))
         .addConsequence(ProjectAction.ERROR, "update", new Forward(URL_JROADMAP+"updateProject.jsp"))
         .addFilter(new VOFilter(ProjectVO.class, "project"));
        add(actionConfig);

        // task
        actionConfig = new ActionConfig(URL_JROADMAP+"task", TaskAction.class)
         .addConsequence(TaskAction.ADD, "executeAdd",new Forward(URL_JROADMAP+"addTask.jsp"))
         .addConsequence(TaskAction.LIST_JSP, new Forward(URL_JROADMAP+"listTask.jsp"))
         .addConsequence(TaskAction.LIST, new Redirect("task.mtw"))
         .addConsequence(TaskAction.SHOW, new Forward(URL_JROADMAP+"updateTask.jsp"))
         .addFilter(new TransactionFilter(new String[] { TaskAction.LIST }))
         .addFilter(new DIFilter("project", ProjectVO.class))
         .addFilter(new TaskValidationFilter(), "update")
         .addFilter(new TaskValidationFilter(), "add")
         .addConsequence(TaskAction.ERROR, "add", new Forward(URL_JROADMAP+"addTask.jsp"))
         .addConsequence(TaskAction.ERROR, "update", new Forward(URL_JROADMAP+"updateTask.jsp"))
         .addConsequence(TaskAction.LIST, "update", new Forward(URL_JROADMAP+"listTask.jsp"))
         .addFilter(new VOFilter(TaskVO.class, "task"))
         .addFilter(new VOFilter(ProjectVO.class, "project"))
         .addFilter(new OVFilter("task"));
        add(actionConfig);

        // plan
        actionConfig = new ActionConfig(URL_JROADMAP+"plan", PlanAction.class)
         .addConsequence(PlanAction.ADD, "executeAdd",new Forward(URL_JROADMAP+"addPlan.jsp"))
         .addConsequence(PlanAction.LIST_JSP, new Forward(URL_JROADMAP+"listPlan.jsp"))
         .addConsequence(PlanAction.LIST, new Redirect("plan.mtw"))
         .addConsequence(PlanAction.SHOW, new Forward(URL_JROADMAP+"updatePlan.jsp"))
         .addFilter(new TransactionFilter(new String[] { PlanAction.LIST }))
         .addFilter(new DIFilter("task", TaskVO.class))
         .addFilter(new DIFilter("responsible", ResponsibleVO.class))
         .addConsequence(PlanAction.ERROR, "add", new Forward(URL_JROADMAP+"addPlan.jsp"))
         .addConsequence(PlanAction.ERROR, "update", new Forward(URL_JROADMAP+"updatePlan.jsp"))
         .addFilter(new VOFilter(TaskVO.class, "task"))
         .addFilter(new VOFilter(ResponsibleVO.class, "responsible"))
         .addFilter(new VOFilter(PlanVO.class, "plan"))
         .addFilter(new OVFilter("plan"));
        add(actionConfig);

        // roadmap
        actionConfig = new ActionConfig(URL_JROADMAP+"roadmap", RoadmapAction.class)
         .addConsequence(RoadmapAction.LIST, new Forward(URL_JROADMAP+"roadmap.jsp"))
         .addConsequence(RoadmapAction.LIST, "priority",new Forward(URL_JROADMAP+"roadmap.jsp"))
         .addConsequence(RoadmapAction.LIST, "responsible",new Forward(URL_JROADMAP+"roadmap.jsp"))
         .addConsequence(RoadmapAction.LIST, "releaseDate",new Forward(URL_JROADMAP+"roadmap.jsp"))
         .addConsequence(RoadmapAction.LIST, "status",new Forward(URL_JROADMAP+"roadmap.jsp"));
        add(actionConfig);

    }

    public void loadFormatters() {
        FormatterManager.addFormatter("dateFormatter", new DateFormatter("dd/MM/yyyy"));
        LocaleManager.setDefaultDateMask("dd-MM-yyyy");
    }

    public void loadLocales() {

        LocaleManager.add("pt");
        LocaleManager.add("en");

    }
}
