package nl.hanze.funda.admin.ui;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;

import nl.hanze.funda.admin.settings.Settings;

public class InputField implements InputElement {
	private JLabel label;
	private JTextField textField;
	private int[] bounds;
	private int textSeperation;
	
	
	public InputField (String inputLabel, int[] inputBoundaries) {
		bounds = inputBoundaries;
		textSeperation = Settings.defaultTextSeperation;
		createElements(inputLabel);
		
	}
	
	public InputField(String inputLabel, int[] inputBoundaries, int seperation) {
		bounds = inputBoundaries;		
		textSeperation = seperation;
		createElements(inputLabel);
	}
	
	@Override
	public List<Component> getElements() {
		List<Component> rv = new ArrayList<Component>();
		rv.add(label);
		rv.add(textField);
		
		return rv;
	}
	
	private void createElements(String label) {
		createTextField();
		createLabel(label);
	}
	
	private void createTextField() {
		textField = new JTextField("");
		textField.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);		
	}
	
	private void createLabel(String inputLabel) {
		label = new JLabel(inputLabel);
		label.setBounds(bounds[0] - textSeperation, bounds[1], bounds[2], bounds[3]);
	}
}
