package nl.hanze.funda.admin.ui;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class InputTextField implements InputElement {
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JLabel label;
	private int[] inputBounds;
	private int textSeperation;

	public InputTextField(String inputLabel, int[] bounds, int seperation){		 
		inputBounds = bounds;					
		textSeperation = seperation;		
		createElements(inputLabel);	
	}
	
	@Override
	public List<Component> getElements() {
		List<Component> rv = new ArrayList<Component>();
		rv.add(label);
		rv.add(scrollPane);
		
		return rv;
	}
	
	private void createElements(String inputLabel) {
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(inputBounds[0], inputBounds[1], inputBounds[2], inputBounds[3]);
		
		label = new JLabel(inputLabel);
		label.setBounds (inputBounds[0] - textSeperation, inputBounds[1], inputBounds[2], inputBounds[3]);	
	}
}