package org.uat.microchip.toolchain;

import org.eclipse.cdt.managedbuilder.ui.wizards.MBSCustomPage;
import org.eclipse.cdt.managedbuilder.ui.wizards.MBSCustomPageManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;

public class WizardPage extends MBSCustomPage {
	Composite composite;

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

		Text pageText = new Text(composite, SWT.CENTER);
		pageText.setBounds(composite.getBounds());
		pageText.setText("This page is a test page provided by the org.eclipse.cdt.managedbuilder.ui.tests plugin.");
		pageText.setVisible(true);
		
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
		return new String("This page is for testing, please ignore it.");
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
		return null;
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

}
