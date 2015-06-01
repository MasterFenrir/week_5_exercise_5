package nl.hanze.funda.admin.ui;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

public class InputButton extends ButtonListener implements InputElement {
	private JButton theButton;
	
	
	public InputButton(String inputLabel, int[] bounds) {
		theButton = new JButton(inputLabel);
		theButton.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
		theButton.addActionListener(this);
	}

	public void disable() {
		theButton.setEnabled(false);
	}
	
	public void enable() {
		theButton.setEnabled(true);
	}
	
	@Override
	public List<Component> getElements() {
		List<Component> rv = new ArrayList<Component>();		
		rv.add (theButton);
		return rv;
	}
}