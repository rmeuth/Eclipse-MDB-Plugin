package mdbUAT;

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
import com.microchip.mplab.mdbcore.common.debug.exceptions.MDBCommonToolException;

//Loading a File
import com.microchip.mplab.mdbcore.loader.Loader;

//Other Imports
import java.util.List;
import java.util.Map;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;


/**
 *
 * @author Donkey
 */
public class Main {

    static AssemblyFactory assemblyFactory = null;
    static Assembly assembly = null;
    static Debugger MDB = null;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello World");

        System.out.println(System.getProperty("java.version"));
        
        String toolId = null;
        PlatformToolMeta meta = null;
        String currentDevice = "PIC24FJ64GA004";
        String tool = "ICD 3";

        toolId = AcquireToolID();
        meta = AcquireToolMeta(tool);
        InitializeAssembly(currentDevice, meta, toolId);
        SetToolProperties();

        //Initialize the Debugger
        MDB = assembly.getLookup().lookup(Debugger.class);

        try
        {
            System.out.println("***************\nConnecting to device now\n***************\n");
            MDB.Connect(Debugger.CONNECTION_TYPE.DEBUGGER);
            System.out.println("***************\n!!!Connected!!!\n***************\n");
            System.out.println("Sleeping");
            Thread.sleep(2000);

            //Loading a file
            System.out.println("Loading a file now");
//            String FileName = "C:/Microchip Project/Explorer16/Explorer16PIC24MCU_1/dist/default/production/Explorer16PIC24MCU_1.production.hex";
            String FileName = "C:/Users/Jacob/MPLABXProjects/Explorer16PIC24MCU_1.X/dist/default/debug/Explorer16PIC24MCU_1.X.debug.elf";
            Loader loader = assembly.getLookup().lookup(Loader.class);
            loader.Load(FileName);
            System.out.println("File Loaded");

            //Halt
//            System.out.println("Halting");
//            MDB.Halt();

            //Program file
            System.out.println("Programming Now");
            MDB.Program(Debugger.PROGRAM_OPERATION.AUTO_SELECT);
            Thread.sleep(10000);
            System.out.println("Programming Completed");

            //Reset
//            System.out.println("Reset");
//            MDB.Reset(false); //False to reset to reset vector

            //Run
            System.out.println("Running");
            MDB.Run();
            Thread.sleep(20000);

            //Halt
            System.out.println("Halting");
            MDB.Halt();

            //Disconnect
            System.out.println("Disconnecting");
            MDB.Disconnect();
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
            System.out.println("Oops, something went wrong...");
        }
        
        //Cleanup
        assemblyFactory.Destroy(assembly);

        System.exit(0);
    }

    private static void SetToolProperties() {
        Properties Props = new Properties();
        Props.setProperty("programoptions.eraseb4program ", "true");
        Props.setProperty("poweroptions.powerenable", "true");
        Props.setProperty("voltagevalue",Float.toString(assembly.GetDevice().getVddDefaultVoltage()));
        assemblyFactory.SetToolProperties(assembly, Props);
    }

    /*
     * @TODO Importance of setting the header
     * Initialize the assembly for the class. This takes the current device and sets up the tool
     * with that device. It also takes in the platform meta and the tool id, and initializes the
     * assembly with that as well.
     */
    private static void InitializeAssembly(String currentDevice, PlatformToolMeta meta, String toolId) {
        assemblyFactory = Lookup.getDefault().lookup(AssemblyFactory.class);
        assembly = assemblyFactory.Create(currentDevice);
        if (assembly != null) {
            System.out.println("\nAssembly Header Set to \"\"!\n");
            assembly.SetHeader("");
        }
        System.out.println();
        assemblyFactory.ChangeTool(assembly, meta.getName(), meta.getClassName(), meta.getFlavor(), toolId);


    }

    /*
     * @TODO Parse for multiple tools that are connected
     * @TODO Error handling in case no tools are connected
     * This method will check over all USB ports for any connected tools
     */
    private static String AcquireToolID() {
        MPLABCommProviderInterface Com = Lookup.getDefault().lookup(MPLABCommProviderInterface.class);
        Map<Integer, String> toolMap = Com.GetCurrentToolList();
        String ToolId = toolMap.get(0);
        return ToolId;
    }

    /*
     * It appears like the meta is the header file for the given tool.
     * This does not actually acquire the tool.
     */
    private static PlatformToolMeta AcquireToolMeta(String toolName) {
        PlatformToolMeta meta = null;
        List<PlatformToolMeta> metas = PlatformToolMetaManager.getAllTools();
        for (PlatformToolMeta m : metas) {
            if (m.getName().equals(toolName)) {
                meta = m;
                break;
            }
        }
        return meta;
    }

}
