/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.city.system.model;

import food.city.system.dbc.DBConnection;
import food.city.system.dto.ItemDTO;
import food.city.system.dto.OrderDetailDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Avishka
 */
public class OrderDetailsDAO {
    public boolean save(OrderDetailDTO orderDetail) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO `oderdetail`(`Oid`, `Cid`, `Date`, `Total`) VALUES ('"+orderDetail.getOid()+"','"+orderDetail.getCid()+"','"+orderDetail.getDate()+"',"+orderDetail.getTotal()+")";
        PreparedStatement pstm = connection.prepareStatement(sql);
        return pstm.executeUpdate(sql)>0;
        
    }
}
