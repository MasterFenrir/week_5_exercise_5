package nl.hanze.funda.admin.main;

import nl.hanze.funda.admin.logic.Controller;

import javax.swing.*;

public class Runner {
    public static void main(String[] args) {
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Funda");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Controller();
    }
}
