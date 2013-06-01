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

package com.boaglio.jroadmap.model.dao;

import java.util.List;

import org.hibernate.Session;

import com.boaglio.jroadmap.model.pojo.Project;
import com.boaglio.jroadmap.model.vo.ProjectVO;

public class HibernateProjectDAO implements ProjectDAO {

    private Session session;

    public void delete(Integer projectId) {
        session.delete(getById(projectId));
    }

    public List findAll() {
        return session.createCriteria(ProjectVO.class).list();
    }

    public Project getById(Integer id) {
        return (Project) session.get(Project.class, id);
    }

    public void add(Project project) {
        session.save(project);

    }
    public void update(Project project) {
        Project old = getById(project.getId());
        old.setId(project.getId());
        old.setName(project.getName());
        old.setDescription(project.getDescription());
        session.update(old);
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

}
