package com.mycompany.autolk;

import javax.swing.*;
import java.sql.SQLException;

public class TestMain {

    //Add below code to the main function of the project

    public static void main(String[] args) throws SQLException, InterruptedException {
        DataBase database = new DataBase() ;

        //Main JFrame
        JFrame frame = new JFrame()  ;
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Registration registration = new Registration(frame, database ) ;

        Login login = new Login(frame, database, registration) ;

        int userId = login.setLogin();
        if(userId > 0){
            System.out.println("Successfully logged in");
        }else{
            System.out.println("Login failed");
        }

    }
}
