package com.mycompany.autolk;

import javax.swing.*;
import java.sql.SQLException;

public class ItemCount {
    public void displayCount(JFrame frame, DataBase dataBase, JPanel panel ) throws SQLException {
        String query = "SELECT COUNT(*) FROM items" ; // Assuming table name is items
        int totalItems = dataBase.getData(query) ;
        JLabel totalItemsLabel = new JLabel(String.valueOf(totalItems)) ;
    }
}
