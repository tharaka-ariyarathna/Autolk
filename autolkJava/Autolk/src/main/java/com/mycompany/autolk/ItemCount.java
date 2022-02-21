package com.mycompany.autolk;

import javax.swing.*;
import java.sql.SQLException;

public class ItemCount {
    public void displayCount(DataBase dataBase, JPanel panel ) throws SQLException {
        String query = "SELECT COUNT(*) FROM items" ; // Assuming table name is items
        int totalItems = dataBase.getData(query) ;
        JLabel totalItemsLabel = new JLabel(String.valueOf(totalItems)) ;
        //Change the size accordingly
        totalItemsLabel.setBounds(10, 200, 20, 25);
        panel.add(totalItemsLabel) ;
    }
}
