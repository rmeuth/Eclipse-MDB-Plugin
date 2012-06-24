package org.uat.microchip.debug.ui.launcher;

import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.uat.microchip.debug.model.ToolProperty;
import org.uat.microchip.toolchain.Activator;

/**
 * Creates a LaunchConfigurationTab which allows the user to edit the ToolProperties. 
 * @author Jacob
 *
 */
public class ToolPropertiesTabLaunchOptions extends AbstractLaunchConfigurationTab{
	/**
	 * The widgets which display the ToolProperties the user can configure. 
	 */
	ArrayList<ToolPropertyWidget> toolProperties;

	@Override
	public void createControl(Composite parent) {
		Font font = parent.getFont();
		Composite comp = createParentComposite(parent, font);
		
		createToolPropertyWidgets(comp);
	}

	/**
	 * The parent control which will contain all of the widgets of this ConfigurationTab
	 */
	private Composite createParentComposite(Composite parent, Font font) {
		Composite comp = new Composite(parent, SWT.NONE);
		setControl(comp);
		GridLayout topLayout = new GridLayout();
		topLayout.numColumns = 2;
		comp.setLayout(topLayout);
		comp.setFont(font);
		return comp;
	}

	/**
	 * Creates the GUI Widgets which will allow the user to set the Tool Properties.
	 */
	private void createToolPropertyWidgets(Composite comp) {
		toolProperties = new ArrayList<ToolPropertyWidget>();

		for (ToolProperty property : Activator.getToolProperties()) {
			toolProperties.add(new ToolPropertyWidget(comp, property));
		}
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// TODO Auto-generated method stub
		System.out.println("eheh");

	}

	@Override
	/**
	 * Set the property values from a persisted configuration. 
	 */
	public void initializeFrom(ILaunchConfiguration configuration) {
		for (ToolPropertyWidget toolProperty : toolProperties) {
			try {
				String value = configuration.getAttribute(toolProperty
						.getProperty().getName(), (String) null);

				if (value != null)
					toolProperty.setCurrentValue(value);

			} catch (CoreException e) {
				setErrorMessage(e.getMessage());
			}
		}
	}

	@Override
	/**
	 * Append all of the property values to the current configuration
	 */
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		// Save all of the tool properties to the launch configuration
		for (ToolPropertyWidget toolProperty : toolProperties) {
			configuration.setAttribute(toolProperty.getProperty().getName(),
					toolProperty.getProperty().getCurrentValue());
		}
	}

	@Override
	public String getName() {
		return "Tool Properties";
	}
}

