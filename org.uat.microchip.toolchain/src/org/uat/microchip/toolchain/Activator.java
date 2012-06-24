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
}
