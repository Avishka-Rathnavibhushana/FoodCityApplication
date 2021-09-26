/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.city.system.model;

import food.city.system.dbc.DBConnection;
import food.city.system.dto.ItemDTO;
import food.city.system.dto.PaysheetDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Avishka
 */
public class PaysheetDAO {
    public boolean save(PaysheetDTO paysheetDTO) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO `paysheet`(`Eid`, `fixedSalary`, `otRate`, `otHours`, `otAmount`, `totalSalary`, `Date`) VALUES ('"+paysheetDTO.getEid()+"',"+paysheetDTO.getFixedSalary()+","+paysheetDTO.getOtRate()+","+paysheetDTO.getOtHours()+","+paysheetDTO.getOtAmount()+","+paysheetDTO.getTotalSalary()+",'"+paysheetDTO.getDate()+"')";
        PreparedStatement pstm = connection.prepareStatement(sql);
        return pstm.executeUpdate(sql)>0;
        
    }
    
    public boolean search(String employeeId) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM `paysheet` WHERE `paysheet`.`Eid`='"+employeeId+"'";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rst = pstm.executeQuery(sql);
        if (rst.next()){
            return true;
        }
        return false;
    }
}
