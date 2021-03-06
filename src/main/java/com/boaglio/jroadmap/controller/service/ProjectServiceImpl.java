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
package com.boaglio.jroadmap.controller.service;

import java.util.List;


import com.boaglio.jroadmap.model.dao.ProjectDAO;
import com.boaglio.jroadmap.model.pojo.Project;
import com.boaglio.jroadmap.model.vo.ProjectVO;

public class ProjectServiceImpl implements ProjectService {

    private ProjectDAO projectDAO;

    public void delete(Integer projectId) {
        projectDAO.delete(projectId);
    }

    public List findAll() {
        return projectDAO.findAll();
    }

    public Project getById(Integer id) {
        return projectDAO.getById(id);
    }

    public void publish(Project project) {
        projectDAO.add(project);
    }

    public void update(Project project) {
        projectDAO.update(project);

    }

    public ProjectDAO getProjectVODAO() {
        return projectDAO;
    }

    public void setProjectVODAO(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

}
