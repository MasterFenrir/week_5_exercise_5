package nl.hanze.funda.admin.ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class InputTextField implements InputElement {
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JLabel label;
    private int[] inputBounds;
    private int textSeperation;

    public InputTextField(String inputLabel, int[] bounds, int seperation) {
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

    @Override
    public String getValue() {
        return textArea.getText();
    }

    @Override
    public void setValue(String value) {
        textArea.setText(value);
    }

    private void createElements(String inputLabel) {
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(inputBounds[0], inputBounds[1], inputBounds[2], inputBounds[3]);

        label = new JLabel(inputLabel);
        label.setBounds(inputBounds[0] - textSeperation, inputBounds[1], inputBounds[2], inputBounds[3]);
    }
}