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

import org.mentawai.list.ListItem;


/**
 * This VO represents JRoadmap information
 * @author Fernando Boaglio
 */
public class TaskVO implements Serializable, ListItem  {


 private static final long serialVersionUID = 32205924316L;
 private int id ;
 private java.lang.String name ;
 private ProjectVO project;

 // getters and setters

 public int getId() {
     return id;
 }

 public void setId(int id) {
     this.id = id;
 }

 public java.lang.String getName() {
     return name;
 }

 public void setName(java.lang.String name) {
     this.name = name;
 }

public ProjectVO getProject() {
    return project;
}

public void setProject(ProjectVO project) {
    this.project = project;
}

public String getIdAsString() {
    return String.valueOf(this.id);
}

public String getValue() {
    return this.name;
}

public String getKey()
{
    return String.valueOf(this.id);
}

}