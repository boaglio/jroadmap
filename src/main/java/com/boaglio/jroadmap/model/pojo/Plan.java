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
package com.boaglio.jroadmap.model.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * This POJO class Plan represents JRoadmap information.
 * @author Helio Frota (heliofrota at gmail dot com)
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "jroadmap_plan")
public class Plan implements Serializable {

    /** Plan id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    /** Plan release date. */
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    /** Plan priority. */
    private Integer priority;

    /** Plan status. */
    private Integer status;

    /** Plan responsible. */
    @ManyToOne
    private Responsible responsible;

    /** Plan task. */
    @ManyToOne
    private Task task;

    /** Default constructor. */
    public Plan() {

    }

   /**
    * Get the id of this Plan.
    * @return Integer
    */
    public final Integer getId() {
        return id;
    }

    /**
    * Set the id of this Plan.
    * @param idResponsible Integer
    */
    public final void setId(final Integer idResponsible) {
        this.id = idResponsible;
    }

   /**
    * Get the priority of this Plan.
    * @return Integer
    */
    public final Integer getPriority() {
        return priority;
    }

   /**
    * Set the priority of this Plan.
    * @param prty Integer
    */
    public final void setPriority(final Integer prty) {
        this.priority = prty;
    }

   /**
    * Get the status of this Plan.
    * @return Integer
    */
    public final Integer getStatus() {
        return status;
    }

   /**
    * Set the status of this Plan.
    * @param sts Integer
    */
    public final void setStatus(final Integer sts) {
        this.status = sts;
    }

   /**
    * Get the release date of this Plan.
    * @return Date
    */
    public final Date getReleaseDate() {
        return releaseDate;
    }

   /**
    * Set the release date of this Plan.
    * @param dt Date
    */
    public final void setReleaseDate(final Date dt) {
        this.releaseDate = dt;
    }

   /**
    * Get the responsible of this Plan.
    * @return Responsible
    */
    public final Responsible getResponsible() {
        return responsible;
    }

   /**
    * Set the responsible of this Plan.
    * @param res Responsible
    */
    public final void setResponsible(final Responsible res) {
        this.responsible = res;
    }

   /**
    * Get the task of this Plan.
    * @return Task
    */
    public final Task getTask() {
        return task;
    }

   /**
    * Set the task of this Plan.
    * @param tsk Task
    */
    public final void setTask(final Task tsk) {
        this.task = tsk;
    }

   /**
    * Returns a hash code value for the object. This implementation computes
    * a hash code value based on the id fields in this object.
    * @return a hash code value for this object
    */
    @Override
    public final int hashCode() {
        final int prime = 31;
        int result = 1;
        if (id == null) {
            result = prime * result + 0;
        } else {
            result = prime * result + id.hashCode();
        }
        if (priority == null) {
            result = prime * result + 0;
        } else {
            result = prime * result + priority.hashCode();
        }
        if (status == null) {
            result = prime * result + 0;
        } else {
            result = prime * result + status.hashCode();
        }
        if (releaseDate == null) {
            result = prime * result + 0;
        } else {
            result = prime * result + releaseDate.hashCode();
        }
        return result;
    }


   /**
    * Determines whether another object is equal to this Plan.
    * The result is  <code>true</code> if and only if the argument is
    * not null and is a Item object that has the same id field values
    * as this object.
    * @return <code>true</code> if this object is the same as the argument;
    * @param obj Object
    * <code>false</code> otherwise.
    */
    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Plan other = (Plan) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (priority == null) {
            if (other.priority != null) {
                return false;
            }
        } else if (!priority.equals(other.priority)) {
              return false;
        }
        if (status == null) {
            if (other.status != null) {
                return false;
            }
        } else if (!status.equals(other.status)) {
              return false;
        }
        if (releaseDate == null) {
            if (other.releaseDate != null) {
                return false;
            }
        } else if (!releaseDate.equals(other.releaseDate)) {
              return false;
        }
        return true;
    }

   /**
    * Return representation of this Plan as String.
    * @return String
    */
    @Override
    public final String toString() {
        return "com.boaglio.jroadmap.model.pojo.Plan[id=" + id + "]";
    }

}
