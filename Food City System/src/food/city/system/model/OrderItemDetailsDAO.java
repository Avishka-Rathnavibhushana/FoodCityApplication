/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.city.system.model;

import food.city.system.dbc.DBConnection;
import food.city.system.dto.ItemDTO;
import food.city.system.dto.OrderDetailDTO;
import food.city.system.dto.OrderItemDetailsDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Avishka
 */
public class OrderItemDetailsDAO {
    public boolean save(OrderItemDetailsDTO orderItemDetails) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO `oderitemsdetail`(`Oid`, `Iid`, `noOfItems`, `price`) VALUES ('"+orderItemDetails.getOid()+"','"+orderItemDetails.getIid()+"',"+orderItemDetails.getNoOfItems()+","+orderItemDetails.getPrice()+")";
        PreparedStatement pstm = connection.prepareStatement(sql);
        return pstm.executeUpdate(sql)>0;
        
    }
}
