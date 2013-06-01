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

import com.boaglio.jroadmap.model.pojo.Plan;

public class HibernatePlanDAO implements PlanDAO {

    private Session session;

    public void delete(Integer planId) {
        session.delete(getById(planId));
    }

    public List findAll() {
        return session.createCriteria(Plan.class).list();
    }

    public Plan getById(Integer id) {

        return (Plan) session.get(Plan.class, id);
    }

    public void add(Plan plan) {
        session.save(plan);

    }
    public void update(Plan plan) {
        Plan old = getById(plan.getId());
        old.setId(plan.getId());
        old.setPriority(plan.getPriority());
        old.setReleaseDate(plan.getReleaseDate());
        old.setResponsible(plan.getResponsible());
        old.setStatus(plan.getStatus());
        old.setTask(plan.getTask());
        session.update(old);
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

}
