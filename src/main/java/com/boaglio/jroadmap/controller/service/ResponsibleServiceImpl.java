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


import com.boaglio.jroadmap.model.dao.ResponsibleDAO;
import com.boaglio.jroadmap.model.pojo.Responsible;
import com.boaglio.jroadmap.model.vo.ResponsibleVO;

public class ResponsibleServiceImpl implements ResponsibleService {

    private ResponsibleDAO responsibleDAO;

    public void delete(Integer responsibleId) {
        responsibleDAO.delete(responsibleId);
    }

    public List findAll() {
        return responsibleDAO.findAll();
    }

    public Responsible getById(Integer id) {
        return responsibleDAO.getById(id);
    }

    public void publish(Responsible responsible) {
        responsibleDAO.add(responsible);
    }

    public void update(Responsible responsible) {
        responsibleDAO.update(responsible);

    }

    public ResponsibleDAO getResponsibleVODAO() {
        return responsibleDAO;
    }

    public void setResponsibleVODAO(ResponsibleDAO responsibleDAO) {
        this.responsibleDAO = responsibleDAO;
    }

}
