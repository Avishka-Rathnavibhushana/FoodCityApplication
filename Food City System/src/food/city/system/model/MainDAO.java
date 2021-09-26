/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.city.system.model;

import food.city.system.dbc.DBConnection;
import food.city.system.dto.ItemDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author maila
 */
public class MainDAO {
    public boolean checkForDatabase() throws Exception{
        Connection connection = null;
        Statement statement = null;
        boolean isDatabaseExist = false;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/",
                    "root", "");
            
            
            // Connection connection = <your java.sql.Connection>
            ResultSet resultSet = connection.getMetaData().getCatalogs();

            //iterate each catalog in the ResultSet
            while (resultSet.next()) {
              // Get the database name, which is at position 1
                
              String databaseName = resultSet.getString(1);
              
              
                if ("foodcity".equals(databaseName)) {
                    
                    isDatabaseExist = true;
                }
            }
            resultSet.close();
            
            if (!isDatabaseExist) {
                statement = connection.createStatement();
                String sql = "CREATE DATABASE foodcity";
                //To delete database: sql = "DROP DATABASE DBNAME";
                statement.executeUpdate(sql);
                System.out.println("Database created!");
                
                Connection connection2 = DBConnection.getInstance().getConnection();
                Statement statement2 = connection2.createStatement();
                
                String tbl = "CREATE TABLE item (Iid VARCHAR(10) PRIMARY KEY NOT NULL, name TINYTEXT NOT NULL, buyingPrice float NOT NULL, sellingPrice float NOT NULL, noOfItems int(10) NOT NULL, lowerlimit int(10) NOT NULL);";
                statement2.executeUpdate(tbl);
                
                
                tbl = "CREATE TABLE employee ( \n" +
                        "    Eid VARCHAR(10) PRIMARY KEY NOT NULL,\n" +
                        "    name TINYTEXT NOT NULL,\n" +
                        "    salary float NOT NULL\n" +
                        ");";
                statement2.executeUpdate(tbl);
                
                tbl = "CREATE TABLE supplier ( \n" +
                        "    Sid VARCHAR(10) PRIMARY KEY NOT NULL,\n" +
                        "    name TINYTEXT NOT NULL\n" +
                        ");";
                statement2.executeUpdate(tbl);
                
                tbl = "CREATE TABLE customer ( \n" +
                        "    Ccid int(9) NOT NULL,\n" +
                        "    Cid VARCHAR(10) PRIMARY KEY NOT NULL,\n" +
                        "    name TINYTEXT NOT NULL\n" +
                        ");";
                statement2.executeUpdate(tbl);
                
                tbl = "CREATE TABLE oderDetail ( \n" +
                        "    Oid VARCHAR(10) PRIMARY KEY NOT NULL,\n" +
                        "    Cid VARCHAR(10),\n" +
                        "    FOREIGN KEY(Cid) REFERENCES customer(Cid),\n" +
                        "    Date DATE NOT NULL,\n" +
                        "    Total Float NOT NULL\n" +
                        ");";
                statement2.executeUpdate(tbl);
                
                tbl = "CREATE TABLE oderItemsDetail ( \n" +
                        "    OIid int(10) AUTO_INCREMENT PRIMARY KEY NOT NULL,\n" +
                        "    Oid VARCHAR(10) NOT NULL,\n" +
                        "    FOREIGN KEY(Oid) REFERENCES oderDetail(Oid),\n" +
                        "    Iid VARCHAR(10),\n" +
                        "    FOREIGN KEY(Iid) REFERENCES item(Iid),\n" +
                        "    noOfItems int(10) NOT NULL,\n" +
                        "    price Float NOT NULL\n" +
                        ");";
                statement2.executeUpdate(tbl);
                
                tbl = "CREATE TABLE supplierItemsDetail ( \n" +
                        "    SIid int(10) AUTO_INCREMENT PRIMARY KEY NOT NULL,\n" +
                        "    Sid VARCHAR(10) NOT NULL,\n" +
                        "    FOREIGN KEY(Sid) REFERENCES supplier(Sid),\n" +
                        "    Iid VARCHAR(10),\n" +
                        "    FOREIGN KEY(Iid) REFERENCES item(Iid),\n" +
                        "    noOfItems int(10) NOT NULL,\n" +
                        "    Date DATE NOT NULL,\n" +
                        "    buyingPrice Float NOT NULL\n" +
                        ");";
                statement2.executeUpdate(tbl);
                
                tbl = "CREATE TABLE paysheet( \n" +
                        "    Pid int(10) AUTO_INCREMENT PRIMARY KEY NOT NULL,\n" +
                        "    Eid VARCHAR(10),\n" +
                        "    FOREIGN KEY(Eid) REFERENCES employee(Eid),\n" +
                        "    fixedSalary float NOT NULL,\n" +
                        "    otRate float NOT NULL,\n" +
                        "    otHours float NOT NULL,\n" +
                        "    otAmount float NOT NULL,\n" +
                        "    totalSalary float NOT NULL,\n" +
                        "    Date DATE NOT NULL\n" +
                        ");";
                statement2.executeUpdate(tbl);
                
//                tbl = "";
//                statement.executeUpdate(tbl);
               
            }else{
                System.out.println("Database already exist!");
            }
            
        } catch (SQLException sqlException) {
            if (sqlException.getErrorCode() == 1007) {
                // Database already exists error
                System.out.println(sqlException.getMessage());
            } else {
                // Some other problems, e.g. Server down, no permission, etc
                sqlException.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            // No driver class found!
        }
        // close statement & connection
    
        
        
        return isDatabaseExist;
    }
}
