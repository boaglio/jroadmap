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

import com.boaglio.jroadmap.controller.service.ResponsibleService;
import com.boaglio.jroadmap.model.pojo.Responsible;
import com.boaglio.jroadmap.model.vo.ResponsibleVO;

public class ResponsibleAction extends BaseAction {

    public static final String SHOW = "show";
    public static final String LIST = "list";
    public static final String LIST_JSP = "listJsp";

    private Integer id;
    private Responsible responsible;
    private Collection responsibleList;

    private ResponsibleService responsibleService;

    public String execute() throws Exception {
        responsibleList = responsibleService.findAll();
        return LIST_JSP;
    }

    public String show() {
        responsible = responsibleService.getById(id);
        return SHOW;
    }

    public String delete() {
        responsibleService.delete(id);
        return LIST;
    }

    public String add() {
        responsibleService.publish(responsible);

        return LIST;
    }

    public String update() {
        responsibleService.update(responsible);
        return LIST;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Responsible getResponsible() {
        return responsible;
    }

    public void setResponsible(Responsible responsible) {
        this.responsible = responsible;
    }

    public Collection getResponsibleList() {
        return responsibleList;
    }

    public void setResponsibleList(Collection responsibleList) {
        this.responsibleList = responsibleList;
    }

    public ResponsibleService getResponsibleService() {
        return responsibleService;
    }

    public void setResponsibleService(ResponsibleService responsibleService) {
        this.responsibleService = responsibleService;
    }

}
