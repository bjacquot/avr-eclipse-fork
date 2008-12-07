/*******************************************************************************
 * 
 * Copyright (c) 2007 Thomas Holland (thomas@innot.de) and others
 * 
 * This program and the accompanying materials are made
 * available under the terms of the GNU Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     Thomas Holland - initial API and implementation
 *     
 * $Id: ProjectUpdateConverter.java 190 2008-02-08 09:15:54Z innot $
 *     
 *******************************************************************************/
package de.innot.avreclipse.mbs.converter;

import org.eclipse.cdt.managedbuilder.core.IBuildObject;
import org.eclipse.cdt.managedbuilder.core.IConvertManagedBuildObject;

/**
 * @author Thomas
 * 
 */
public class ProjectUpdateConverter implements IConvertManagedBuildObject {

	/**
	 * Update a given Project to the latest AVR Eclipse Plugin settings
	 * 
	 * @author Thomas Holland
	 * 
	 */
	public ProjectUpdateConverter() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.cdt.managedbuilder.core.IConvertManagedBuildObject#convert(org.eclipse.cdt.managedbuilder.core.IBuildObject,
	 *      java.lang.String, java.lang.String, boolean)
	 */
	public IBuildObject convert(IBuildObject buildObj, String fromId,
			String toId, boolean isConfirmed) {

		// This is currently only called from the CDT ConvertTargetDialog and
		// only for an existing AVR Eclipse Plugin project.
		
		if (toId.endsWith("2.1.0")) {
			buildObj = Convert21.convert(buildObj, fromId);
		}
		return buildObj;
	}

}
