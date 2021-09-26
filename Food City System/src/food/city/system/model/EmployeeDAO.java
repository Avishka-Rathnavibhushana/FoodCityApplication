/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.city.system.model;

import food.city.system.dbc.DBConnection;
import food.city.system.dto.EmployeeDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Avishka
 */
public class EmployeeDAO {
    public boolean update(EmployeeDTO employee) throws Exception{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE `employee` SET `name`='"+employee.getName()+"',`salary`="+employee.getSalary()+" WHERE `Eid`='"+employee.getEid()+"'";
        PreparedStatement pstm = connection.prepareStatement(sql);

        return pstm.executeUpdate(sql)>0;
    }

    public boolean save(EmployeeDTO employee) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO `employee`(`Eid`, `name`, `salary`) VALUES ('"+employee.getEid()+"','"+employee.getName()+"',"+employee.getSalary()+")";
        PreparedStatement pstm = connection.prepareStatement(sql);
        return pstm.executeUpdate(sql)>0;
        
    }

    public boolean delete(String employeeId) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM `employee` WHERE `employee`.`Eid`='"+employeeId+"'";
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        return pstm.executeUpdate(sql)>0;
        
    }

    public EmployeeDTO search(String employeeId) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM `employee` WHERE `employee`.`Eid`='"+employeeId+"'";
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet rst = pstm.executeQuery(sql);
        if (rst.next()){
            return new EmployeeDTO(rst.getString("Eid"), rst.getString("name"), rst.getFloat("salary"));
        }
        return null;
    }
    
    public ArrayList<EmployeeDTO> getAll() throws Exception{
        
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM employee";
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        ResultSet rst = pstm.executeQuery(sql);
        
        ArrayList<EmployeeDTO> employeeList = new ArrayList<>();
        while (rst.next()) {
            EmployeeDTO employee = new EmployeeDTO(rst.getString("Eid"), rst.getString("name"), rst.getFloat("salary"));
            employeeList.add(employee);
        }
        return employeeList;        
    }
}
