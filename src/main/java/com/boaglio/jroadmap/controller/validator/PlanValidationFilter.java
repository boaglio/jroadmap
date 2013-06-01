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
package com.boaglio.jroadmap.controller.validator;

import org.mentawai.core.Action;
import org.mentawai.filter.ValidationFilter;
import org.mentawai.rule.RequiredFieldRule;
import org.mentawai.validation.Validator;

public class PlanValidationFilter extends ValidationFilter {

	public void prepareValidator(Validator validator, Action action,String innerAction) {
		validator.add("task.id", new RequiredFieldRule(), "global.mandatory");
		validator.add("responsible.id", new RequiredFieldRule(),"global.mandatory");
		validator.add("realeaseDate", new RequiredFieldRule(),"global.mandatory");
		validator.add("status", new RequiredFieldRule(), "global.mandatory");
		validator.add("priority", new RequiredFieldRule(), "global.mandatory");
	}

}
