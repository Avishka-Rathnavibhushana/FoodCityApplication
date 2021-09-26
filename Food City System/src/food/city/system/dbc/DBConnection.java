/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.city.system.dbc;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Avishka
 */
public class DBConnection {
    private Connection connection;
    private static DBConnection dBConnection;
    
    private DBConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        
        String ip = "localhost";
        String port = "3306";
        String db = "foodcity";
        
        String jdbcURL = "jdbc:mysql://" + ip + ":" + port + "/" + db;
        
        String userName = "root";
        String password = "";
        
        connection = (Connection) DriverManager.getConnection(jdbcURL,userName,password);
    }
    
    public static DBConnection getInstance() throws ClassNotFoundException, SQLException{
        if (dBConnection == null) {
            dBConnection = new DBConnection();
        }
        
        return dBConnection;
    }
    
    public Connection getConnection(){
        return connection;
    }
}
