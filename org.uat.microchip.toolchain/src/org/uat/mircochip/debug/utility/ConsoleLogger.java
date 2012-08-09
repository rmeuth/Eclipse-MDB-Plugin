package org.uat.mircochip.debug.utility;

/**
 * Used to output helpful messages to the console. 
 * @author Jacob
 *
 */
public class ConsoleLogger {
	/**
	 * Singelton instance. 
	 */
	private static volatile ConsoleLogger instance = null;
	/**
	 * Used to wrap a message. 
	 */
	private final String lineBreak = "\n***************\n";
	
	/**
	 * Prints a specific message to the console. 
	 * @param message The message to output to the console. 
	 * @param printNewLine Should the message be wrapped with a line above and below? 
	 */
	public void OutputMessage(String message, boolean printNewLine){
		if(printNewLine)
			System.out.println(lineBreak + message + lineBreak);
		else
			System.out.println(message);			
	}
	
	
	/**
	 * @return Singelton Instance accessor. 
	 */
	public static ConsoleLogger getInstance() {
		if(instance == null){
			synchronized(ConsoleLogger.class){
				if(instance == null){
					instance = new ConsoleLogger();
				}
			}
		}
		return instance;
	}	
}
