/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.city.system.model;

import food.city.system.dbc.DBConnection;
import food.city.system.dto.ItemDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Avishka
 */
public class ItemDAO {
    public boolean update(ItemDTO item) throws Exception{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE `item` SET `name`='"+item.getName()+"',`buyingPrice`="+item.getBuyingPrice()+",`sellingPrice`="+item.getSellingPrice()+",`noOfItems`="+item.getNoOfItems()+",`lowerlimit`="+item.getLowerLimit()+" WHERE `Iid`='"+item.getIid()+"'";
        PreparedStatement pstm = connection.prepareStatement(sql);

        return pstm.executeUpdate(sql)>0;
    }

    public boolean save(ItemDTO item) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO `item`(`Iid`, `name`, `buyingPrice`, `sellingPrice`, `noOfItems`, `lowerlimit`) VALUES ('"+item.getIid()+"','"+item.getName()+"',"+item.getBuyingPrice()+","+item.getSellingPrice()+","+item.getNoOfItems()+","+item.getLowerLimit()+")";
        PreparedStatement pstm = connection.prepareStatement(sql);
        return pstm.executeUpdate(sql)>0;
        
    }

    public boolean delete(String itemId) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM `item` WHERE `item`.`Iid`='"+itemId+"'";
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        return pstm.executeUpdate(sql)>0;
        
    }

    public ItemDTO search(String itemId) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM `item` WHERE `item`.`Iid`='"+itemId+"'";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rst = pstm.executeQuery(sql);
        if (rst.next()){
            return new ItemDTO(rst.getString("Iid"), rst.getString("name"), rst.getFloat("buyingPrice"), rst.getFloat("sellingPrice"), rst.getInt("noOfItems"),rst.getInt("lowerlimit"));
        }
        return null;
    }
    
    public ArrayList<ItemDTO> getAll() throws Exception{
        
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM item";
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        ResultSet rst = pstm.executeQuery(sql);
        
        ArrayList<ItemDTO> itemList = new ArrayList<>();
        while (rst.next()) {
            ItemDTO item = new ItemDTO(rst.getString("Iid"), rst.getString("name"), rst.getFloat("buyingPrice"), rst.getFloat("sellingPrice"),rst.getInt("noOfItems"),rst.getInt("lowerlimit"));
            itemList.add(item);
        }
        return itemList;        
    }
}
