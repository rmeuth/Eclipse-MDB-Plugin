package org.uat.microchip.toolchain;

import org.eclipse.cdt.managedbuilder.ui.wizards.MBSCustomPage;
import org.eclipse.cdt.managedbuilder.ui.wizards.MBSCustomPageManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;

public class WizardPage extends MBSCustomPage implements Runnable {
	private Composite composite;
	
	public WizardPage() {
		// TODO Auto-generated constructor stub
		pageID = "org.uat.microchip.toolchain.wizardPage";
	}

	public boolean canFlipToNextPage()
	{
	return (MBSCustomPageManager.getNextPage(pageID) != null);
	}
	
	public WizardPage(String pageID) {
		super(pageID);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return new String("Properties");
	}

	@Override
	public void createControl(Composite parent) {
		// TODO Auto-generated method stub
		composite = new Composite(parent, SWT.NULL);
		composite.setLayout(new GridLayout());
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Group deviceGroup = new Group(composite, SWT.SHADOW_ETCHED_IN);
		deviceGroup.setText("Device Settings");
		
		Label picLabel = new Label(deviceGroup, SWT.LEFT);
		picLabel.setSize(300,30);
		picLabel.setText("Microcontroller");
		picLabel.setLocation(20, 20);
		picLabel.pack();
		
		Combo picCombo = new Combo (deviceGroup, SWT.READ_ONLY);
		picCombo.setItems (new String [] {"PIC1111", "PIC2222", "PIC3333"});
		picCombo.setLocation(150, 20);
		picCombo.pack();
		
		Group debuggerGroup = new Group(composite, SWT.SHADOW_ETCHED_IN);
		debuggerGroup.setText("Debugger Settings");
		
		Label debugDeviceLabel = new Label(debuggerGroup, SWT.LEFT);
		debugDeviceLabel.setSize(300,30);
		debugDeviceLabel.setText("Debugger Tool");
		debugDeviceLabel.setLocation(20, 20);
		debugDeviceLabel.pack();
		
		Combo debugDeviceCombo = new Combo (debuggerGroup, SWT.READ_ONLY);
		debugDeviceCombo.setItems (new String [] {"ICD3", "PICKit2", "PICKit3", "PM3", "Real ICE", "Simulator", "Other Licenced Debugger"});
		debugDeviceCombo.setLocation(150, 20);
		debugDeviceCombo.pack();
		
		Label debugPowerLabel = new Label(debuggerGroup, SWT.LEFT);
		debugPowerLabel.setSize(300,30);
		debugPowerLabel.setText("Power device?");
		debugPowerLabel.setLocation(20, 50);
		debugPowerLabel.pack();
		
		Button debugPowerButton = new Button(debuggerGroup, SWT.CHECK);
		debugPowerButton.setLocation(150, 50);
		debugPowerButton.pack();
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		composite.dispose();
	}

	@Override
	public Control getControl() {
		// TODO Auto-generated method stub
		return composite;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return new String("Set your device settings.");
	}

	@Override
	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return new String("Microchip Device Settings");
	}

	@Override
	public void performHelp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDescription(String description) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setImageDescriptor(ImageDescriptor image) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setVisible(boolean visible) {
		// TODO Auto-generated method stub
		composite.setVisible(visible);
	}
	
	@Override
	protected boolean isCustomPageComplete() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		// TODO Code to store information from this wizard page to the build properties.
	}
	

}
