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

import com.boaglio.jroadmap.model.pojo.Task;
import com.boaglio.jroadmap.model.vo.TaskVO;

public class HibernateTaskDAO implements TaskDAO {

    private Session session;

    public void delete(Integer taskId) {
        session.delete(getById(taskId));
    }

    public List findAll() {
        return session.createCriteria(TaskVO.class).list();
    }

    public Task getById(Integer id) {

        return (Task) session.get(Task.class, id);
    }

    public void add(Task task) {
        session.save(task);

    }
    public void update(Task task) {
        Task old = getById(task.getId());
        old.setProject(task.getProject());
        old.setId(task.getId());
        old.setName(task.getName());
        session.update(old);
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

}
