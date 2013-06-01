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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.boaglio.jroadmap.model.pojo.Plan;
import com.boaglio.jroadmap.model.vo.PlanVO;

public class HibernateRoadmapDAO implements RoadmapDAO {

    private Session session;

    private final String COMMON_SQL = "from PlanVO p";

    public List findAllByTask(){
        Query query =  session.createQuery(COMMON_SQL+" order by p.task.name");
        List roadmap = new ArrayList();
        for (Iterator it = query.iterate(); it.hasNext();) {
            Plan p = (Plan) it.next();
            roadmap.add(p);
        }
        return roadmap;
    }

    public List findAllByPriority(){
        Query query =  session.createQuery(COMMON_SQL+" order by p.priority");
        List roadmap = new ArrayList();
        for (Iterator it = query.iterate(); it.hasNext();) {
            Plan p = (Plan) it.next();
            roadmap.add(p);
        }
        return roadmap;
    }

    public List findAllByStatus(){
        Query query =  session.createQuery(COMMON_SQL+" order by p.status");
        List roadmap = new ArrayList();
        for (Iterator it = query.iterate(); it.hasNext();) {
            PlanVO p = (PlanVO) it.next();
            roadmap.add(p);
        }
        return roadmap;
    }

    public List findAllByResponsible(){
        Query query =  session.createQuery(COMMON_SQL+" order by p.responsible.name");
        List roadmap = new ArrayList();
        for (Iterator it = query.iterate(); it.hasNext();) {
            PlanVO p = (PlanVO) it.next();
            roadmap.add(p);
        }
        return roadmap;
    }

    public List findAllByReleaseDate(){
        Query query =  session.createQuery(COMMON_SQL+" order by p.releaseDate");
        List roadmap = new ArrayList();
        for (Iterator it = query.iterate(); it.hasNext();) {
            Plan p = (Plan) it.next();
            roadmap.add(p);
        }
        return roadmap;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

}
