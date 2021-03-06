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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This POJO class Responsible represents JRoadmap information.
 * @author Helio Frota (heliofrota at gmail dot com)
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "jroadmap_responsible")
public class Responsible implements Serializable {

    /** Responsible id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    /** Responsible name. */
    private String name;

    /** Responsible email. */
    private String email;

    /** Default constructor. */
    public Responsible() {

    }

   /**
    * Get the id of this Responsible.
    * @return Integer
    */
    public final Integer getId() {
        return id;
    }

    /**
    * Set the id of this Responsible.
    * @param idResponsible Integer
    */
    public final void setId(final Integer idResponsible) {
        this.id = idResponsible;
    }

   /**
    * Get the name of this Responsible.
    * @return String
    */
    public final String getName() {
        return name;
    }

   /**
    * Set the name of this Responsible.
    * @param nm String
    */
    public final void setName(final String nm) {
        this.name = nm;
    }

   /**
    * Get the email of this Responsible.
    * @return String
    */
    public final String getEmail() {
        return email;
    }

   /**
    * Set the email of this Responsible.
    * @param eml String
    */
    public final void setEmail(final String eml) {
        this.email = eml;
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
        if (name == null) {
            result = prime * result + 0;
        } else {
            result = prime * result + name.hashCode();
        }
        if (email == null) {
            result = prime * result + 0;
        } else {
            result = prime * result + email.hashCode();
        }
        return result;
    }


   /**
    * Determines whether another object is equal to this Responsible.
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
        Responsible other = (Responsible) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
              return false;
        }
        if (email == null) {
            if (other.email != null) {
                return false;
            }
        } else if (!email.equals(other.email)) {
              return false;
        }
        return true;
    }

   /**
    * Return representation of this Responsible as String.
    * @return String
    */
    @Override
    public final String toString() {
        return "com.boaglio.jroadmap.model.pojo.Responsible[id=" + id + "]";
    }

}
