package com.dentalclinic.clinic.panel;

import com.dentalclinic.clinic.domain.Doctor;
import com.dentalclinic.clinic.domain.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClinicPanel extends JPanel implements ActionListener {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 400;

    private JRadioButton doctorChoice;
    private JRadioButton patientChoice;
    private JRadioButton visitChoice;

    private Button save;
    private Button find;
    private Button delete;

    private JTextArea name;
    private JTextArea surname;
    private JTextArea specialisation;
    private JTextArea showResult;

    private JLabel doctorLabel;
    private JLabel patientLabel;
    private JLabel visitLabel;
    private JLabel selectOperationInfo;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel specialisationLabel;

    public ClinicPanel() {
        super();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(null);
        add(buttonSave());
        save.addActionListener(this);
        add(buttonFind());
        find.addActionListener(this);
        add(deleteButton());
        delete.addActionListener(this);
        add(doctorButton());
        doctorChoice.addActionListener(this);
        add(doctorLabel());
        add(patientButton());
        patientChoice.addActionListener(this);
        add(patientLabel());
        add(visitButton());
        visitChoice.addActionListener(this);
        add(visitLabel());
        add(operationInfo());
        add(nameArea());
        add(surnameArea());
        add(nameLabelInfo());
        add(surnameLabelInfo());
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (doctorChoice.isSelected()) {
            patientChoice.setSelected(false);
            visitChoice.setSelected(false);
            if (source == save) {
                System.out.println("Wciśnięty doctor");
                Doctor doctor = new Doctor();
                doctor.setName(nameArea().getText());
                doctor.setSurname(surnameArea().getText());

            }

            if (source == find) {

            }

            if (source == delete) {

            }
        } else if (patientChoice.isSelected()) {
            doctorChoice.setSelected(false);
            visitChoice.setSelected(false);
            if (source == save) {
                System.out.println("Zapisany patient");
                Patient patient = new Patient();
                patient.setName(nameArea().getText());
                patient.setSurname(surnameArea().getText());

            }

            if (source == find) {

            }

            if (source == delete) {

            }
        } else if (visitChoice.isSelected()) {
            doctorChoice.setSelected(false);
            patientChoice.setSelected(false);
            if (source == save) {
                System.out.println("Wciśnięty visit");
            }

            if (source == find) {

            }

            if (source == delete) {

            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(110, 10, 110, 390);
    }

    private Button buttonSave() {
        save = new Button("Save");
        save.setBounds(300, 10, 50, 25);
        return save;
    }

    private Button buttonFind() {
        find = new Button("Find");
        find.setBounds(300, 50, 50, 25);
        return find;
    }

    private Button deleteButton() {
        delete = new Button("Delete");
        delete.setBounds(300, 90, 50, 25);
        return delete;
    }

    private JRadioButton doctorButton() {
        doctorChoice = new JRadioButton();
        doctorChoice.setBounds(20, 34, 18, 18);
        return doctorChoice;
    }

    private JRadioButton patientButton() {
        patientChoice = new JRadioButton();
        patientChoice.setBounds(20, 54, 18, 18);
        return patientChoice;
    }

    private JRadioButton visitButton() {
        visitChoice = new JRadioButton();
        visitChoice.setBounds(20, 74, 18, 18);
        return visitChoice;
    }

    private JLabel doctorLabel() {
        doctorLabel = new JLabel("Doctor");
        doctorLabel.setBounds(40, 31, 50, 25);
        return doctorLabel;
    }

    private JLabel patientLabel() {
        patientLabel = new JLabel("Patient");
        patientLabel.setBounds(40, 51, 50, 25);
        return patientLabel;
    }

    private JLabel visitLabel() {
        visitLabel = new JLabel("Visit");
        visitLabel.setBounds(40, 71, 50, 25);
        return visitLabel;
    }

    private JLabel operationInfo() {
        selectOperationInfo = new JLabel("Select Operation");
        selectOperationInfo.setBounds(5, -10,100, 50);
        return selectOperationInfo;
    }

    private JTextArea nameArea() {
        name = new JTextArea();
        name.setBounds(120, 35, 150, 20);
        return name;
    }

    private JTextArea surnameArea() {
        surname = new JTextArea();
        surname.setBounds(120, 75, 150, 20);
        return surname;
    }

    private JLabel nameLabelInfo() {
        nameLabel = new JLabel("Name");
        nameLabel.setBounds(120, 15, 150, 20);
        return nameLabel;
    }

    private JLabel surnameLabelInfo() {
        surnameLabel = new JLabel("Surname");
        surnameLabel.setBounds(120, 55, 150, 20);
        return surnameLabel;
    }
}
