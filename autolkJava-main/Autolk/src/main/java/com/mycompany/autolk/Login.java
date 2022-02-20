package com.mycompany.autolk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Login {
    JFrame frame  ;
    DataBase dataBase ;
    int id = 0;
    Registration registration ;
    public Login(JFrame frame , DataBase dataBase, Registration registration){

        this.frame = frame ;
        this.dataBase = dataBase ;
        this.registration = registration ;
    }

    public int setLogin() throws InterruptedException {

            //////////////////////////////////////Login Form//////////////////////////////////////////////////////////

            //Login return a id of the user
            //For this to work properly user has to complete login within 12 secnds
            //If not id will be returned as 0

            JPanel panel = new JPanel();
            JLabel userLabel = new JLabel("User Name");
            JTextField userTextField = new JTextField();
            Font customFont1 = new Font(Font.SERIF, Font.PLAIN, 15);

            frame.add(panel) ;

            panel.setLayout(null);
            panel.setBackground(Color.pink);

            userLabel.setBounds(10, 20, 80, 25);
            panel.add(userLabel);

            userTextField.setBounds(100, 20, 165, 25);
            panel.add(userTextField);

            JLabel passwordLabel = new JLabel("Password");
            passwordLabel.setBounds(10, 70, 80, 25);
            panel.add(passwordLabel);

            JPasswordField passwordField = new JPasswordField();
            passwordField.setBounds(100, 70, 165, 25);
            panel.add(passwordField);

            JButton loginButton = new JButton("Login");
            loginButton.setBounds(80, 120, 80, 25);
            panel.add(loginButton);

            JLabel registerLabel = new JLabel("Don't have an account");
            registerLabel.setFont(customFont1);
            registerLabel.setBounds(10, 160, 150, 15);
            panel.add(registerLabel);

            JLabel registerLink = new JLabel("Register");
            registerLink.setBounds(160, 160, 80, 15);
            registerLink.setForeground(Color.BLUE.brighter());
            registerLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            panel.add(registerLink);
            JLabel error = new JLabel() ;
            error.setBounds(10, 200, 250, 25);
            panel.add(error) ;

            frame.setVisible(true);

            /////////////////////////////////////////////Register Form/////////////////////////////////////////////////


            /////////////////////////////////////Navigation///////////////////////////////////////////////////////////////


            loginButton.addActionListener(e -> {
                String userName = userTextField.getText();
                String password = passwordField.getText();

                try {
                    String query = String.format("SELECT password FROM user WHERE username = '%s'", userName) ;
                    String originalPassword = dataBase.getPassword(query);

                    if (password.equals(originalPassword)) {
                        query = String.format("SELECT id FROM user WHERE username = '%s'", userName) ;
                        id = dataBase.getId(query) ;
                        panel.setVisible(false);
                    } else {
                        error.setText("Password and username doesn't match");
                    }

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            });

            registerLink.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    panel.setVisible(false);
                    registration.setRegistration();
                }
            });



        Thread.sleep(14000);
        return id;
    }

}
