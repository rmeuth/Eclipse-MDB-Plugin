package org.uat.microchip.debug.model;

/**
 * Encapsulates a property which the user can set on the debug tool. 
 * @author Jacob
 */
public class ToolProperty {
	private String name;
	private String currentValue = null;
	/**
	 * The potential values of this property (e.g. true or false) 
	 * If this is left null, it will be assumed that there are no suitable default values
	 * and that the user will provide a value (e.g. setting memory addresses)
	 */
	private String[] potentialValues = null;


	public ToolProperty(String name, String[] potentialValues){		
		if(name == null || name.isEmpty())
			throw new NullPointerException("PropertyName cannot be null!");
		
		this.name = name;
		this.potentialValues = potentialValues;			
	}	
	
	public String getName() {
		return name;
	}

	public String getCurrentValue() {
		return currentValue;
	}
	
	public void setCurrentValue(String currentValue) {
		this.currentValue = currentValue;
	}

	public String[] getPotentialValues() {
		return potentialValues;
	}
	
	public Boolean hasPotentialValues(){
		return potentialValues != null;
	}
	
	@Override
	public String toString() {
		return name + " | " + currentValue;
	}
}