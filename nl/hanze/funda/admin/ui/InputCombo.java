package nl.hanze.funda.admin.ui;

import nl.hanze.funda.admin.settings.Settings;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class InputCombo implements InputElement {
    private JLabel label;
    private JComboBox comboBox;
    private int[] bounds;
    private int textSeperation;

    public InputCombo(String label, int[] inputBounds) {
        bounds = inputBounds;
        textSeperation = Settings.defaultTextSeperation;
        createElements(label);
    }

    public InputCombo(String label, int[] inputBounds, int seperation) {
        bounds = inputBounds;
        textSeperation = seperation;
        createElements(label);
    }

    @Override
    public List<Component> getElements() {
        List<Component> rv = new ArrayList<Component>();
        rv.add(comboBox);
        rv.add(label);

        return rv;
    }

    private void createElements(String label) {
        createComboBox();
        createLabel(label);
    }

    private void createComboBox() {
        comboBox = new JComboBox();
        comboBox.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
    }

    private void createLabel(String inputLabel) {
        label = new JLabel(inputLabel);
        label.setBounds(bounds[0] - textSeperation, bounds[1], bounds[2], bounds[3]);
    }

}
