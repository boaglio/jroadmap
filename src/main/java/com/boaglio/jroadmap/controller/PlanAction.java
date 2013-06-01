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

package com.boaglio.jroadmap.controller;

import java.util.Collection;

import org.mentawai.core.BaseAction;

import com.boaglio.jroadmap.controller.service.PlanService;
import com.boaglio.jroadmap.controller.service.ResponsibleService;
import com.boaglio.jroadmap.controller.service.TaskService;
import com.boaglio.jroadmap.model.pojo.Plan;
import com.boaglio.jroadmap.model.pojo.Responsible;
import com.boaglio.jroadmap.model.pojo.Task;
import com.boaglio.jroadmap.model.vo.PlanVO;
import com.boaglio.jroadmap.model.vo.ResponsibleVO;
import com.boaglio.jroadmap.model.vo.TaskVO;

public class  PlanAction extends BaseAction {

    public static final String ADD = "add";
    public static final String SHOW = "show";
    public static final String LIST = "list";
    public static final String LIST_JSP = "listJsp";

    private Integer id;
    private Plan plan;
    private Task task;
    private Responsible responsible;
    private Collection planList;
    private Collection taskList;
    private Collection responsibleList;
    private TaskService taskService;
    private ResponsibleService responsibleService;
    private PlanService planService;

    public String execute() throws Exception {
        planList = planService.findAll();
        return LIST_JSP;
    }

    public String executeAdd() throws Exception {
        planList = planService.findAll();
        taskList = taskService.findAll();
        responsibleList= responsibleService.findAll();
        return ADD;
    }

    public String show() {
        plan = planService.getById(id);
        taskList = taskService.findAll();
        responsibleList= responsibleService.findAll();
        output.setValue("task.id", plan.getTask().getId());
        output.setValue("responsible.id", plan.getResponsible().getId());
        return SHOW;
    }

    public String delete() {
        planService.delete(id);
        planList = planService.findAll();
        return LIST;
    }

    public String add() {
        task = taskService.getById(input.getIntValue("task.id"));
        plan.setTask(task);

        responsible = responsibleService.getById(input.getIntValue("responsible.id"));
        plan.setResponsible(responsible);

        planService.publish(plan);
        planList = planService.findAll();
        return LIST;
    }

    public String update() {
        task = taskService.getById(input.getIntValue("task.id"));
        plan.setTask(task);

        responsible = responsibleService.getById(input.getIntValue("responsible.id"));
        plan.setResponsible(responsible);

        planService.update(plan);
        planList = planService.findAll();
        return LIST;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public Collection getPlanList() {
        return planList;
    }

    public void setPlanList(Collection planList) {
        this.planList = planList;
    }

    public PlanService getPlanService() {
        return planService;
    }

    public void setPlanService(PlanService planService) {
        this.planService = planService;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Responsible getResponsible() {
        return responsible;
    }

    public void setResponsible(Responsible responsible) {
        this.responsible = responsible;
    }

    public Collection getTaskList() {
        return taskList;
    }

    public void setTaskList(Collection taskList) {
        this.taskList = taskList;
    }

    public Collection getResponsibleList() {
        return responsibleList;
    }

    public void setResponsibleList(Collection responsibleList) {
        this.responsibleList = responsibleList;
    }

    public TaskService getTaskService() {
        return taskService;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    public ResponsibleService getResponsibleService() {
        return responsibleService;
    }

    public void setResponsibleService(ResponsibleService responsibleService) {
        this.responsibleService = responsibleService;
    }

}
