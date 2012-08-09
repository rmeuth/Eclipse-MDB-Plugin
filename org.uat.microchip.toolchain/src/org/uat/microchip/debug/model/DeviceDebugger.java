package org.uat.microchip.debug.model;

//Tool Meta
import com.microchip.mplab.mdbcore.platformtool.PlatformToolMeta;
import com.microchip.mplab.mdbcore.platformtool.PlatformToolMetaManager;

//tool Id
import com.microchip.mplab.comm.MPLABCommProviderInterface;

//Assembly Factory
import org.openide.util.Lookup;
import com.microchip.mplab.mdbcore.assemblies.AssemblyFactory;
import com.microchip.mplab.mdbcore.assemblies.Assembly;

//Tool Properties
import java.util.Properties;

//Debug Interface
import com.microchip.mplab.mdbcore.debugger.Debugger;
import com.microchip.mplab.mdbcore.debugger.DebugException;
import com.microchip.mplab.mdbcore.debugger.Debugger.CONNECTION_TYPE;
import com.microchip.mplab.mdbcore.common.debug.exceptions.MDBCommonToolException;

//Loading a File
import com.microchip.mplab.mdbcore.loader.Loader;

//Other Imports
import java.util.List;
import java.util.Map;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * Responsible for connecting to the device and programming it. 
 * A wrapper around MDBCore. 
 * @author Jacob 
 *
 */
public class DeviceDebugger {

	//TODO: Abstract this so one this can be used for debug or programming.  
	
	//Responsible for creating the Assembly. 
	private AssemblyFactory assemblyFactory = null;
	//The MDBCore super class that creates and contains all of the classes and information necessary to use MDBCore
	private Assembly assembly = null;
	//Main MDB core class
	private Debugger MDB = null;
	//Answers questions about the kind of tool that can load applications. 
	private PlatformToolMeta meta;
	
	
}
