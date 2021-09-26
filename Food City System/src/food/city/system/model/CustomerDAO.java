/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.city.system.model;

import food.city.system.dbc.DBConnection;
import food.city.system.dto.CustomerDTO;
import food.city.system.dto.ItemDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Avishka
 */
public class CustomerDAO {
    public boolean save(CustomerDTO customer) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO `customer`(`Ccid`,`Cid`, `name`) VALUES ("+Integer.parseInt(customer.getCid().substring(1))+",'"+customer.getCid()+"','"+customer.getName()+"')";
        PreparedStatement pstm = connection.prepareStatement(sql);
        return pstm.executeUpdate(sql)>0;
        
    }
}
