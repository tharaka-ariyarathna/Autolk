package com.mycompany.autolk;

import javax.swing.*;
import java.sql.SQLException;

public class TestMain {
    public static void main(String[] args) throws SQLException, InterruptedException {

        //Add below code to your main method

        DataBase database = new DataBase() ;

        //Main JFrame
        //Below 3 lines is nt needed. Just give the main jFrame to needed classes
        JFrame frame = new JFrame()  ;
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Registration registration = new Registration(frame, database ) ;

        Login login = new Login(frame, database, registration) ;

        int userId = login.setLogin();
        if(userId > 0){
            System.out.println("Login successfull");
        }else{
            System.out.println("Login unsuccessfull");
        }

    }
}
