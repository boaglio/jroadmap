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

import com.boaglio.jroadmap.controller.service.ProjectService;
import com.boaglio.jroadmap.model.pojo.Project;
import com.boaglio.jroadmap.model.vo.ProjectVO;

public class ProjectAction extends BaseAction {

    public static final String SHOW = "show";
    public static final String LIST = "list";
    public static final String LIST_JSP = "listJsp";

    private Integer id;
    private Project project;
    private Collection projectList;

    private ProjectService projectService;

    public String execute() throws Exception {

        projectList = projectService.findAll();
        return LIST_JSP;
    }

    public String show() {
        project = projectService.getById(id);
        return SHOW;
    }

    public String delete() {
        projectService.delete(id);
        return LIST;
    }

    public String add() {
        projectService.publish(project);

        return LIST;
    }

    public String update() {
        projectService.update(project);
        return LIST;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Collection getProjectList() {
        return projectList;
    }

    public void setProjectList(Collection projectList) {
        this.projectList = projectList;
    }

    public ProjectService getProjectService() {
        return projectService;
    }

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

}
