package org.uat.microchip.debug.ui.launcher;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;
import org.uat.microchip.debug.model.ToolProperty;

/**
 * Presents the user a SWT widget which will allow them to visually edit a specific tool property. 
 * @author Jacob
 */
public class ToolPropertyWidget {		
	private ToolProperty property;	
	private Composite parent;	
	private Widget display;
	
	/**
	 * Create the Label which will display the option to the user, and then create the Widget
	 * which will allow the user to edit a ToolProperty
	 */
	public ToolPropertyWidget(Composite parent, ToolProperty property ) {
		this.parent = parent;
		this.property = property;
	
		CreateLabel();	
		
		//If the property has values create a combo, if not, the user must enter a value. So create a text field. 
		if(this.property.hasPotentialValues())
			CreateCombo();
		else
			CreateText();
	}

	/**
	 * A property without default options will be set by the user. Create a textbox and set the properties value when the text is changed. 
	 */
	private void CreateText() {
		display = new Text(parent, SWT.SINGLE | SWT.BORDER);
		
		((Text) display).addModifyListener(new ModifyListener() {			
			public void modifyText(ModifyEvent e) {
				property.setCurrentValue(((Text) display).getText());				
			}
		});		
	}

	/**
	 * If the ToolProperty provides default options, then present them to the user in the form of a combo. 
	 */
	private void CreateCombo() {
		display = new Combo(parent, SWT.READ_ONLY);
		
		for (String option : property.getPotentialValues()) {
			((Combo) display).add(option);
		}		
		
		//When the user sets the property, store this. 
		((Combo) display).addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event){
				property.setCurrentValue(((Combo) display).getText());
			}
		});
	}

	/**
	 * This label will display the name of the device property. 
	 */
	private void CreateLabel() {
		Label display = new Label(parent, SWT.NONE);	
		display.setText(property.getName());
		display.setFont(parent.getFont());
	}
	
	public ToolProperty getProperty() {
		return property;
	}

	/**
	 * Sets the properties current value, and updates the Widget's display to reflect this value. 
	 */
	public void setCurrentValue(String value) {
		property.setCurrentValue(value);
		
		if(property.hasPotentialValues())
			SetComboValue(value);
		else
			SetTextValue(value);		
	}

	/**
	 * Set the value of a combo to the selected value of a property. 
	 */
	private void SetComboValue(String value) {		
		Combo combo = ((Combo)display);
		
		int indexOfValue = combo.indexOf(value);
		
		if(indexOfValue >= 0)
			combo.select(indexOfValue);		
	}
	
	/**
	 * Set the value of the text to the selected value of a property. 
	 * @param value
	 */
	private void SetTextValue(String value) {	
		 ((Text)display).setText(value);		
	}
}