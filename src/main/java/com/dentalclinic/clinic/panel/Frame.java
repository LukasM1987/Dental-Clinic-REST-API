package com.dentalclinic.clinic.panel;

import javax.swing.*;

public class Frame {

    private static final JFrame frame = new JFrame("Dental Clinic Panel");

    public Frame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new ClinicPanel());
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
