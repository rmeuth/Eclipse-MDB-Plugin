package org.uat.microchip.debug.launcher;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.debug.core.model.RuntimeProcess;

/**
 * Launches the program
 * @author Jacob
 *
 */
public class MicrochipLaunchDelegate extends LaunchConfigurationDelegate{

	@Override
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {

		Process process = DebugPlugin.exec(new String[]{"cmd", "/C", "\"echo I'm Working!\""}, null);
		
		new RuntimeProcess(launch, process, "Hello", null);
		
	}

}
