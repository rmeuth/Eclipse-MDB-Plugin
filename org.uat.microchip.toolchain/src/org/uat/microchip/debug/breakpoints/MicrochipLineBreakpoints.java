package org.uat.microchip.debug.breakpoints;

import org.eclipse.debug.core.model.LineBreakpoint;

public class MicrochipLineBreakpoints extends LineBreakpoint {

	public MicrochipLineBreakpoints() {
		System.out.println("Hello World");
	}
	
	@Override
	public String getModelIdentifier() {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		return null;
	}
	

}
