/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.city.system.model;

import food.city.system.dbc.DBConnection;
import food.city.system.dto.SupplierDTO;
import food.city.system.dto.SupplierDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Avishka
 */
public class SupplierDAO {
    public boolean update(SupplierDTO supplier) throws Exception{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE `supplier` SET `name`='"+supplier.getName()+"' WHERE `Sid`='"+supplier.getSid()+"'";
        PreparedStatement pstm = connection.prepareStatement(sql);

        return pstm.executeUpdate(sql)>0;
    }

    public boolean save(SupplierDTO supplier) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO `supplier`(`Sid`, `name`) VALUES ('"+supplier.getSid()+"','"+supplier.getName()+"')";
        PreparedStatement pstm = connection.prepareStatement(sql);
        return pstm.executeUpdate(sql)>0;
        
    }

    public boolean delete(String supplierId) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM `supplier` WHERE `supplier`.`Sid`='"+supplierId+"'";
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        return pstm.executeUpdate(sql)>0;
        
    }

    public SupplierDTO search(String supplierId) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM `supplier` WHERE `supplier`.`Sid`='"+supplierId+"'";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rst = pstm.executeQuery(sql);
        if (rst.next()){
            return new SupplierDTO(rst.getString("Sid"), rst.getString("name"));
        }
        return null;
    }
    
    public ArrayList<SupplierDTO> getAll() throws Exception{
        
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM supplier";
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        ResultSet rst = pstm.executeQuery(sql);
        
        ArrayList<SupplierDTO> supplierList = new ArrayList<>();
        while (rst.next()) {
            SupplierDTO supplier = new SupplierDTO(rst.getString("Sid"), rst.getString("name"));
            supplierList.add(supplier);
        }
        return supplierList;        
    }
}
