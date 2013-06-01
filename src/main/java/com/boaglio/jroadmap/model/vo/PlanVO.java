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
package com.boaglio.jroadmap.model.vo;

import java.io.Serializable;


/**
 * This VO represents JRoadmap information
 * @author Fernando Boaglio
 */
public class PlanVO implements Serializable  {



 private static final long serialVersionUID = 47347511651L;
 private int id ;
 private java.util.Date releaseDate ;
 private TaskVO task;
 private ResponsibleVO responsible;
 private int priority ;
 private String priorityDesc;
 private int status;
 private String statusDesc;

 // getters and setters

 public int getId() {
     return id;
 }

 public void setId(int id) {
     this.id = id;
 }

 public java.util.Date getReleaseDate() {
     return releaseDate;
 }

 public void setReleaseDate(java.util.Date releaseDate) {
     this.releaseDate = releaseDate;
 }

 public int getPriority() {
     return priority;
 }

 public void setPriority(int priority) {
     this.priority = priority;
 }

 public int getStatus() {
     return status;
 }

 public void setStatus(int status) {
     this.status = status;
 }

public TaskVO getTask() {
    return task;
}

public void setTask(TaskVO task) {
    this.task = task;
}

public ResponsibleVO getResponsible() {
    return responsible;
}

public void setResponsible(ResponsibleVO responsible) {
    this.responsible = responsible;
}

public String getPriorityDesc() {
    return priorityDesc;
}

public void setPriorityDesc(String priorityDesc) {
    this.priorityDesc = priorityDesc;
}

public String getStatusDesc() {
    return statusDesc;
}

public void setStatusDesc(String statusDesc) {
    this.statusDesc = statusDesc;
}

}