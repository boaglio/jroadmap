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

import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.mentawai.core.BaseAction;
import org.mentawai.i18n.LocaleManager;
import org.mentawai.list.ListData;
import org.mentawai.list.ListItem;
import org.mentawai.list.ListManager;
import org.mentawai.log.Info;

import com.boaglio.jroadmap.controller.service.RoadmapService;
import com.boaglio.jroadmap.model.vo.PlanVO;

public class RoadmapAction extends BaseAction {

    public static final String LIST = "list";

    private RoadmapService roadmapService;
    private Collection<PlanVO> roadmapList;
    private HashMap <String, String> prioritiesHM;
    private HashMap <String, String> statusHM;

    public String execute() throws Exception {

        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, loc);
        Info.log("data = "+ df.format(new Date()));

        roadmapList = roadmapService.findAllByTask();
        fixList(roadmapList,loc);
        output.setValue("op","1");
        return LIST;
    }


    public String priority() throws Exception {
        roadmapList = roadmapService.findAllByPriority();
        fixList(roadmapList,loc);
        output.setValue("op","2");
        return LIST;
    }

    public String responsible() throws Exception {
        roadmapList = roadmapService.findAllByResponsible();
        fixList(roadmapList,loc);
        output.setValue("op","3");
        return LIST;
    }

    public String status() throws Exception {
        roadmapList = roadmapService.findAllByStatus();
        fixList(roadmapList,loc);
        output.setValue("op","4");
        return LIST;
    }

    public String releaseDate() throws Exception {
        roadmapList = roadmapService.findAllByReleaseDate();
        fixList(roadmapList,loc);
        output.setValue("op","5");
        return LIST;
    }

    // getters e setters
    public RoadmapService getRoadmapService() {
        return roadmapService;
    }

    public void setRoadmapService(RoadmapService roadmapService) {
        this.roadmapService = roadmapService;
    }

    public Collection<PlanVO> getRoadmapList() {
        return roadmapList;
    }

    public void setRoadmapList(Collection<PlanVO> roadmapList) {
        this.roadmapList = roadmapList;
    }

    // rotinas privadas

    /**
     * adiciona as descricoes nos VOs
     */
    private void fixList(Collection<PlanVO> roadmapList,Locale localeList) {
        readStaticLists(localeList);
        for (PlanVO plan  : roadmapList) {
            plan.setPriorityDesc(prioritiesHM.get(String.valueOf(plan.getPriority())));
            plan.setStatusDesc(statusHM.get(String.valueOf(plan.getStatus())));
        }

    }

    /**
     * Carrega as listas para os HashMaps
     * @param localeList
     */
    private void readStaticLists(Locale localeList) {

        if (localeList==null)
            localeList = LocaleManager.getDefaultLocale();

        ListData priorities = ListManager.getList("priority");
        List<ListItem> prioritiesList = priorities.getValues(localeList);
        prioritiesHM = new HashMap<String, String>();
        for (ListItem item  : prioritiesList) {
        prioritiesHM.put(item.getKey(), item.getValue());
        }

        ListData status = ListManager.getList("status");
        List<ListItem> statusList = status.getValues(localeList);
        statusHM = new HashMap<String, String>();
        for (ListItem item  : statusList) {
        statusHM.put(item.getKey(), item.getValue());
        }
    }

}
