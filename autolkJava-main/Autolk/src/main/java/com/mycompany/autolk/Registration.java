package com.mycompany.autolk;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Registration {

    //After registration user have to manually log in again.
    //Registration doesn't return any user id
    //Registration only put user in database

    JFrame frame ;
    DataBase dataBase ;

    public Registration(JFrame frame, DataBase dataBase){
        this.frame = frame ;
        this.dataBase = dataBase ;
    }


    public void setRegistration(){
        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(null);
        frame.add(registerPanel);

        JLabel registerUserName = new JLabel("userName");
        registerUserName.setBounds(10, 20, 80, 25);
        registerPanel.add(registerUserName);
        registerPanel.setBackground(Color.pink);

        JTextField registerUserNameTextField = new JTextField();
        registerUserNameTextField.setBounds(150, 20, 165, 25);
        registerPanel.add(registerUserNameTextField);

        JLabel registerPasswordLabel = new JLabel("Password");
        registerPasswordLabel.setBounds(10, 60, 80, 25);
        registerPanel.add(registerPasswordLabel);

        JPasswordField registerPasswordField = new JPasswordField();
        registerPasswordField.setBounds(150, 60, 165, 25);
        registerPanel.add(registerPasswordField);

        JLabel registerPasswordConfirm = new JLabel("Confirm Password");
        registerPasswordConfirm.setBounds(10, 100, 120, 25);
        registerPanel.add(registerPasswordConfirm);

        JPasswordField registerPAsswordConfirmTextField = new JPasswordField();
        registerPAsswordConfirmTextField.setBounds(150, 100, 165, 25);
        registerPanel.add(registerPAsswordConfirmTextField);

        JLabel telephone = new JLabel("Telephone");
        telephone.setBounds(10, 140, 120, 25);
        registerPanel.add(telephone);

        JTextField telephoneTextField = new JTextField();
        telephoneTextField.setBounds(150, 140, 165, 25);
        registerPanel.add(telephoneTextField);

        JLabel email = new JLabel("Email");
        email.setBounds(10, 180, 120, 25);
        registerPanel.add(email);

        JTextField emailTextField = new JTextField();
        emailTextField.setBounds(150, 180, 165, 25);
        registerPanel.add(emailTextField);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(120, 220, 100, 25);
        registerPanel.add(registerButton);

        JLabel registrationError = new JLabel() ;
        registrationError.setBounds(10, 260, 220, 25);
        registerPanel.add(registrationError) ;

        registerPanel.setVisible(true);

        registerButton.addActionListener(e -> {
            String registrationUserName = registerUserNameTextField.getText();
            String registrationPassword = registerPasswordField.getText();
            String registartionConfirmPassword = registerPAsswordConfirmTextField.getText();
            String phoneNumber = telephoneTextField.getText() ;
            String mail = emailTextField.getText() ;

            if (registartionConfirmPassword.equals((registrationPassword))) {
                try {
                    int newId = dataBase.getId("SELECT id FROM user ORDER BY id DESC LIMIT 1;") + 1 ;
                    String query = String.format("INSERT INTO user VALUES ('%s', '%s', %d, '%s', '%s')",
                            registrationUserName, registrationPassword, newId, phoneNumber, mail);
                    dataBase.setDataBase(query);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            registerPanel.setVisible(false);

            }else{
                registrationError.setText("Password doesn't match");
            }
        });

    }
}
