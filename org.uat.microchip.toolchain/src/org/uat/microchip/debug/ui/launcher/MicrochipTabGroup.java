package org.uat.microchip.debug.ui.launcher;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.debug.ui.sourcelookup.SourceLookupTab;

/**
 * Controls which tab groups will be displayed to the user when they select a debug configuration 
 * @author Jacob
 *
 */
public class MicrochipTabGroup extends AbstractLaunchConfigurationTabGroup{

	@Override
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		setTabs(new ILaunchConfigurationTab[] { 
				new ToolPropertiesTabLaunchOptions(),
				new SourceLookupTab(), 
				new CommonTab() 
		});
		
		
	}

}
