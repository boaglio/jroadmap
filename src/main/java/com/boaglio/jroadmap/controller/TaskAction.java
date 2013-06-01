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
import com.boaglio.jroadmap.controller.service.TaskService;
import com.boaglio.jroadmap.model.pojo.Project;
import com.boaglio.jroadmap.model.pojo.Task;
import com.boaglio.jroadmap.model.vo.ProjectVO;
import com.boaglio.jroadmap.model.vo.TaskVO;

public class TaskAction extends BaseAction {

    public static final String ADD = "add";
    public static final String SHOW = "show";
    public static final String LIST = "list";
    public static final String LIST_JSP = "listJsp";

    private Integer id;
    private Task task;
    private Project project;
    private Collection taskList;
    private Collection projectList;
    private ProjectService projectService;

    private TaskService taskService;

    public String execute() throws Exception {
        taskList = taskService.findAll();
        return LIST_JSP;
    }

    public String executeAdd() throws Exception {
        taskList = taskService.findAll();
        projectList = projectService.findAll();
        return ADD;
    }

    public String show() throws Exception {
        taskList = taskService.findAll();
        task = taskService.getById(id);
        projectList = projectService.findAll();
        output.setValue("project.id", task.getProject().getId());
        return SHOW;
    }

    public String delete() {
        taskService.delete(id);
        taskList = taskService.findAll();
        return LIST;
    }

    public String add() throws Exception {
        project = projectService.getById(input.getIntValue("project.id"));
        task.setProject(project);
        taskService.publish(task);
        taskList = taskService.findAll();
        return LIST;
    }

    public String update() {
        project = projectService.getById(input.getIntValue("project.id"));
        task.setProject(project);
        taskService.update(task);
        taskList = taskService.findAll();
        return LIST;
    }

   // getters e setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Collection getTaskList() {
        return taskList;
    }

    public void setTaskList(Collection taskList) {
        this.taskList = taskList;
    }

    public TaskService getTaskService() {
        return taskService;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    public ProjectService getProjectService() {
        return projectService;
    }

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    public Collection getProjectList() {
        return projectList;
    }

    public void setProjectList(Collection projectList) {
        this.projectList = projectList;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

}
