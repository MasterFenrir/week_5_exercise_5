package nl.hanze.funda.admin.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class InputButton implements InputElement {
    private JButton theButton;


    public InputButton(String inputLabel, int[] bounds) {
        theButton = new JButton(inputLabel);
        theButton.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
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
        rv.add(theButton);
        return rv;
    }

    @Override
    public String getValue() {
        return "";
    }

    @Override
    public void setValue(String value) {

    }

    public void setActionListener(ActionListener e) {
        theButton.addActionListener(e);
    }
}