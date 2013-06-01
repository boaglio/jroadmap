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


import com.boaglio.jroadmap.model.dao.TaskDAO;
import com.boaglio.jroadmap.model.pojo.Task;
import com.boaglio.jroadmap.model.vo.TaskVO;

public class TaskServiceImpl implements TaskService {

    private TaskDAO taskDAO;

    public void delete(Integer taskId) {
        taskDAO.delete(taskId);
    }

    public List findAll() {
        return taskDAO.findAll();
    }

    public Task getById(Integer id) {
        return taskDAO.getById(id);
    }

    public void publish(Task task) {
        taskDAO.add(task);
    }

    public void update(Task task) {
        taskDAO.update(task);

    }

    public TaskDAO getTaskVODAO() {
        return taskDAO;
    }

    public void setTaskVODAO(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

}
