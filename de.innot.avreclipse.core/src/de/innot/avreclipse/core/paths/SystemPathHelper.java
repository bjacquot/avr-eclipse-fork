/*******************************************************************************
 * 
 * Copyright (c) 2007,2008 Thomas Holland (thomas@innot.de) and others
 * 
 * This program and the accompanying materials are made
 * available under the terms of the GNU Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     Thomas Holland - initial API and implementation
 *     
 * $Id$
 *     
 *******************************************************************************/
package de.innot.avreclipse.core.paths;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;

import de.innot.avreclipse.core.paths.posix.SystemPathsPosix;
import de.innot.avreclipse.core.paths.win32.SystemPathsWin32;

/**
 * Convenience class to get the current operating system dependent path for a
 * given resource.
 * 
 * This class acts as a switch to the the operating system dependent </code>IPathProvider</code>s.
 * 
 * @author Thomas Holland
 * @since 2.1
 */
final class SystemPathHelper {

	/**
	 * Get the path to a resource, depending on the operating system.
	 * 
	 * @param avrpath AVRPath for which to get the system path.
	 * @return IPath with the current system path.
	 */
	public static IPath getPath(AVRPath avrpath) {

		if (isWindows()) {
			IPathProvider pathprovider = SystemPathsWin32.valueOf(avrpath.name());
			return pathprovider.getPath();
		}
		// else posix path provider
		IPath path = SystemPathsPosix.getDefault().getSystemPath(avrpath);
		return path;
	}

	/**
	 * @return true if running on windows
	 */
	private static boolean isWindows() {
		return (Platform.getOS().equals(Platform.OS_WIN32));
	}

}
