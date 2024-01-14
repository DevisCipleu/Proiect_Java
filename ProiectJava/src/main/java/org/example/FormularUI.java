package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FormularUI extends JFrame {

    private JTextField textField;
    private JCheckBox checkBox;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JComboBox<String> comboBox;
    private JPasswordField passwordField;

    private final List<FormularData> dataList = new ArrayList<>();

    private static final String FILE_PATH = "date.json";

    public FormularUI() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Formular Swing");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2));

        JLabel label1 = new JLabel("Nume:");
        textField = new JTextField();
        JLabel label2 = new JLabel("Permis de conducere:");
        checkBox = new JCheckBox("Detin");
        JLabel label3 = new JLabel("Stare civila:");
        radioButton1 = new JRadioButton("Casatorit");
        radioButton2 = new JRadioButton("Necasatorit");
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(radioButton1);
        radioGroup.add(radioButton2);

        JLabel label4 = new JLabel("Vehicul:");
        String[] items = {"Masina", "Motocicleta", "Bicicleta"};
        comboBox = new JComboBox<>(items);

        JLabel label5 = new JLabel("Parola:");
        passwordField = new JPasswordField();

        JButton saveButton = new JButton("Salvare");
        JButton cancelButton = new JButton("Anulare");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvareInJSON();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel.add(label1);
        panel.add(textField);
        panel.add(label2);
        panel.add(checkBox);
        panel.add(label3);
        panel.add(radioButton1);
        panel.add(new JLabel()); // pentru a lăsa un spațiu între radio buttons
        panel.add(radioButton2);
        panel.add(label4);
        panel.add(comboBox);
        panel.add(label5);
        panel.add(passwordField);
        panel.add(saveButton);
        panel.add(cancelButton);

        add(panel);

        setVisible(true);
    }

    private void salvareInJSON() {
        FormularData formData = new FormularData(
                textField.getText(),
                checkBox.isSelected(),
                radioButton1.isSelected() ? "Casatorit" : "Necasatorit",
                comboBox.getSelectedItem().toString(),
                passwordField.getText()
        );

        dataList.add(formData);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(FILE_PATH), dataList);
            JOptionPane.showMessageDialog(this, "Datele au fost salvate cu succes!");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Eroare la salvarea datelor!", "Eroare", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new FormularUI();
    }
}
