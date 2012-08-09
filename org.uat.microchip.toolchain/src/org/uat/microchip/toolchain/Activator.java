package org.uat.microchip.toolchain;

import java.util.ArrayList;

import org.osgi.framework.BundleContext;
import org.uat.microchip.debug.model.ToolProperty;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * This is the main class of the plugin and controls the lifecycle of the plugin. 
 * @author Jacob
 *
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "TestingLaunch"; //$NON-NLS-1$
	// The shared instance
	private static Activator plugin;
	// The collection of tool properties and their values.
	private static ArrayList<ToolProperty> toolProperties;
	// The tool which will be used, set once and should be referenced by whole project. 
	private static String toolType = "ICD 3";
	// The device which will be programmed,  set once and should be referenced by whole project. 
	private static String currentDevice = "PIC24FJ64GA004";
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		createToolProperties();
	}

	/**
	 * Create the collection of ToolProperties which will modify the debug behavior throughout
	 * the lifecycle of the plugin. 
	 */
	private void createToolProperties() {		
		String[] trueFalse = new String[] { "true", "false" };
		String[] autoNone = new String[] { "auto", "none" };
		String[] powerLevels = new String[] { "3.0", "3.125", "3.25", "3.375", "3.5" };
				
		toolProperties = new ArrayList<ToolProperty>();		
		toolProperties.add(new ToolProperty("AutoSelectMemRanges", autoNone));
		toolProperties.add(new ToolProperty("memories.programmemory", trueFalse));
		toolProperties.add(new ToolProperty("memories.eeprom", trueFalse));
		toolProperties.add(new ToolProperty("memories.id", trueFalse));
		toolProperties.add(new ToolProperty("memories.bootflash", trueFalse));
		toolProperties.add(new ToolProperty("memories.aux", trueFalse));
		toolProperties.add(new ToolProperty("eraseb4program", trueFalse));
		toolProperties.add(new ToolProperty("debugoptions.useswbreakpoints", trueFalse));
		toolProperties.add(new ToolProperty("debugoptions.powerenable", trueFalse));
		toolProperties.add(new ToolProperty("voltagevalue", powerLevels));
		toolProperties.add(new ToolProperty("memories.programmemory.start", null));
		toolProperties.add(new ToolProperty("memories.programmemory.end", null));		
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}
	
	/**
	 * 	The collection of tool properties and their values.
	 */
	public static ArrayList<ToolProperty> getToolProperties() {
		return toolProperties;
	}
	
	/**
	 * @return The type of tool which is to be used with this project. 
	 */
	public static String getToolType() {
		return toolType;
	}

	/**
	 * @return Set the tool type which will be used to program the device.  
	 */
	public static void setToolType(String toolType) {
		Activator.toolType = toolType;
	}

	/**
	 * @return The device which will be programmed. 
	 */
	public static String getCurrentDevice() {
		return currentDevice;
	}

	/**
	 * @param Changes the current device which will be programmed. 
	 */
	public static void setCurrentDevice(String currentDevice) {
		Activator.currentDevice = currentDevice;
	}

}
