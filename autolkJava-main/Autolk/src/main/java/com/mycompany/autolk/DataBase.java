package com.mycompany.autolk;

import java.sql.*;

public class DataBase {

    Connection connection ;
    Statement statement ;
    public DataBase() throws SQLException {
        connection = DriverManager.
                getConnection("jdbc:mysql://localhost:3306/oop", "root" ,"tharaka@1998") ;
        statement = connection.createStatement() ;
    }

    //Add below methods to the database connection class your code

    public void setDataBase(String query) throws SQLException {
            statement.execute(query) ;
    }

    public String getPassword(String query) throws SQLException {
        ResultSet result= statement.executeQuery(query) ;
        String password = "error";
        while(result.next()){
            password = result.getNString("password") ;
            return password ;
        }
        return password ;
    }

    public int getId(String query) throws SQLException {
        ResultSet result= statement.executeQuery(query) ;
        int id = -1 ;
        while(result.next()){
            id = result.getInt("id");
            return id ;
        }
        return id ;

    }

}
