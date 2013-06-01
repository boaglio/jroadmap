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
import java.util.Set;

import org.mentawai.list.ListItem;


/**
 * This VO represents JRoadmap information
 * @author Fernando Boaglio
 */
public class ProjectVO implements Serializable, ListItem  {



 private static final long serialVersionUID = 91779816472L;
 private int id ;
 private java.lang.String name ;
 private java.lang.String description ;
 private Set tasks;

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

 public java.lang.String getDescription() {
     return description;
 }

 public void setDescription(java.lang.String description) {
     this.description = description;
 }

 public Set getTasks() {
    return tasks;
 }

 public void setTasks(Set tasks) {
    this.tasks = tasks;
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