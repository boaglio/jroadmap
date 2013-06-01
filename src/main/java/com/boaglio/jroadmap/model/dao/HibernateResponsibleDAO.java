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

import com.boaglio.jroadmap.model.pojo.Responsible;
import com.boaglio.jroadmap.model.vo.ResponsibleVO;

public class HibernateResponsibleDAO implements ResponsibleDAO {

    private Session session;

    public void delete(Integer responsibleId) {
        session.delete(getById(responsibleId));
    }

    public List findAll() {
        return session.createCriteria(ResponsibleVO.class).list();
    }

    public Responsible getById(Integer id) {
        return (Responsible) session.get(Responsible.class, id);
    }

    public void add(Responsible responsible) {
        session.save(responsible);
    }

    public void update(Responsible responsible) {
        Responsible old = getById(responsible.getId());
        old.setEmail(responsible.getEmail());
        old.setId(responsible.getId());
        old.setName(responsible.getName());
        session.update(old);
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

}
