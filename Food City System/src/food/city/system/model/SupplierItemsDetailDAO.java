/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.city.system.model;

import food.city.system.dbc.DBConnection;
import food.city.system.dto.OrderItemDetailsDTO;
import food.city.system.dto.SupplierItemDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Avishka
 */
public class SupplierItemsDetailDAO {
    public boolean save(SupplierItemDTO supplierItemDTO) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO `supplieritemsdetail`(`Sid`, `Iid`, `noOfItems`, `Date`, `buyingPrice`) VALUES ('"+supplierItemDTO.getSid()+"','"+supplierItemDTO.getIid()+"',"+supplierItemDTO.getNoOfItems()+",'"+supplierItemDTO.getDate()+"',"+supplierItemDTO.getBuyingPrice()+")";
        PreparedStatement pstm = connection.prepareStatement(sql);
        return pstm.executeUpdate(sql)>0;
        
    }
}
