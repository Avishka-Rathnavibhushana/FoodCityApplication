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
import food.city.system.dto.PaysheetDTO;
import food.city.system.dto.SupplierItemsDetailsDTO;
import food.city.system.dto.SupplyDeteilDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author Avishka
 */
public class QuerryDAO {
    public SupplierItemsDetailsDTO getSupplyItemsOnDate(String date) throws Exception{
        
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM `supplieritemsdetail` WHERE `supplieritemsdetail`.`Date`='"+date+"'";
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        ResultSet rst = pstm.executeQuery(sql);
        
        
        SupplierItemsDetailsDTO supplierItemsDetailsDTO = new SupplierItemsDetailsDTO();
        supplierItemsDetailsDTO.setDate(date);
        ArrayList<String> Iids = new ArrayList<>();
        ArrayList<Integer> noItems = new ArrayList<>();
        
        while (rst.next()) {
            if (Iids.contains(rst.getString("Iid"))) {
                int index = Iids.indexOf(rst.getString("Iid"));
                noItems.set(index, noItems.get(index)+rst.getInt("noOfItems")); 
            }else{
                Iids.add(rst.getString("Iid"));
                noItems.add(rst.getInt("noOfItems"));
            }
            
        }
        supplierItemsDetailsDTO.setIids(Iids);
        supplierItemsDetailsDTO.setNoItems(noItems);
        
        return supplierItemsDetailsDTO;        
    }

    public String getLastCustomerID() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT `Cid` FROM `customer` ORDER BY `Ccid` DESC LIMIT 1";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rst = pstm.executeQuery(sql);
        String lastCID = "";
        if (rst.next()){
            lastCID = rst.getString("Cid");
            return lastCID;
        }
        return null;
    }

    public String getLastOrderID() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT `Oid` FROM `oderdetail` ORDER BY `Oid` DESC LIMIT 1";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rst = pstm.executeQuery(sql);
        String lastOID = "";
        if (rst.next()){
            lastOID = rst.getString("Oid");
            return lastOID;
        }
        return null;
    }

    public ArrayList<Object> getOrderItemsOnDate(String date) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT oderitemsdetail.Iid,oderitemsdetail.noOfItems FROM oderdetail,oderitemsdetail WHERE oderdetail.Oid=oderitemsdetail.Oid AND oderdetail.Date='"+date+"'";
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        ResultSet rst = pstm.executeQuery(sql);
        
        
        ArrayList<OrderItemDetailsDTO> orderItemDetailsDTOs = new ArrayList<>();

        ArrayList<String> Iids = new ArrayList<>();
        ArrayList<Integer> noItems = new ArrayList<>();
        
        while (rst.next()) {
            if (Iids.contains(rst.getString("Iid"))) {
                int index = Iids.indexOf(rst.getString("Iid"));
                noItems.set(index, noItems.get(index)+rst.getInt("noOfItems"));
            }else{
                Iids.add(rst.getString("Iid"));
                noItems.add(rst.getInt("noOfItems"));
                
            }
            
        }
        
        ArrayList<Object> arrayList = new ArrayList<Object>();
        arrayList.add(Iids);
        arrayList.add(noItems);
        
        return arrayList;
    }

    public ArrayList<OrderDetailDTO> getAllOrdersToday(String today) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM `oderdetail`,`oderitemsdetail` WHERE `oderdetail`.`Oid`=`oderitemsdetail`.`Oid` AND `oderdetail`.`Date`='"+today+"'";
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        ResultSet rst = pstm.executeQuery(sql);
       
        
        ArrayList<OrderDetailDTO> orderDetailDTOs = new ArrayList<>();
         if (!rst.next()) {
            return orderDetailDTOs;
        }
         rst.beforeFirst();
        String Oid = "";
        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
        ArrayList<ItemDTO> items = new ArrayList<>();
        ItemDTO item = new ItemDTO();
        while (rst.next()) {
            item = new ItemDTO(rst.getString("Iid"), "", 0, rst.getFloat("price"), rst.getInt("noOfItems"));
            if (Oid.equals(rst.getString("Oid"))) {
                items.add(item);
            }else{
                if (Oid.equals("")) {
                    orderDetailDTO = new OrderDetailDTO(rst.getString("Cid"), "", rst.getString("Oid"), today, rst.getFloat("Total"), new ArrayList<>());
                    Oid = rst.getString("Oid");
                    items.add(item);
                    continue;
                }
                orderDetailDTO.setItemList(items);
                items = new ArrayList<>();
                items.add(item);
                orderDetailDTOs.add(orderDetailDTO);
                orderDetailDTO = new OrderDetailDTO(rst.getString("Cid"), "", rst.getString("Oid"), today, rst.getFloat("Total"), new ArrayList<>());
                Oid = rst.getString("Oid");
            }
        }
        orderDetailDTO.setItemList(items);
        orderDetailDTOs.add(orderDetailDTO);
        return orderDetailDTOs;        
    }

    public ArrayList<SupplyDeteilDTO> getAllSuppliersToday(String today) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM `supplieritemsdetail` WHERE `supplieritemsdetail`.`Date` = '"+today+"'";
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        ResultSet rst = pstm.executeQuery(sql);
        
        
        ArrayList<SupplyDeteilDTO> supplyDeteilDTOs = new ArrayList<>();
        if (!rst.next()) {
            return supplyDeteilDTOs;
        }
        rst.beforeFirst();
        String Sid = "";
        SupplyDeteilDTO supplyDeteilDTO = new SupplyDeteilDTO();
        ArrayList<ItemDTO> items = new ArrayList<>();
        ItemDTO item = new ItemDTO();
        float tot = 0;
        while (rst.next()) {
            item = new ItemDTO(rst.getString("Iid"), "", rst.getFloat("buyingPrice"), 0, rst.getInt("noOfItems"));
            if (Sid.equals(rst.getString("Sid"))) {
                items.add(item);
                tot = tot + item.getBuyingPrice()*item.getNoOfItems();
            }else{
                if (Sid.equals("")) {
                    supplyDeteilDTO = new SupplyDeteilDTO(rst.getString("Sid"), today, new ArrayList<ItemDTO>(),0);
                    Sid = rst.getString("Sid");
                    items.add(item);
                    tot = tot + item.getBuyingPrice()*item.getNoOfItems();
                    continue;
                }
                supplyDeteilDTO.setItemList(items);
                supplyDeteilDTO.setTotal(tot);
                tot = 0;
                items = new ArrayList<>();
                items.add(item);
                tot = tot + item.getBuyingPrice()*item.getNoOfItems();
                supplyDeteilDTOs.add(supplyDeteilDTO);
                supplyDeteilDTO = new SupplyDeteilDTO(rst.getString("Sid"), today, new ArrayList<ItemDTO>(),0);
                Sid = rst.getString("Sid");
            }
        }
        supplyDeteilDTO.setItemList(items);
        supplyDeteilDTO.setTotal(tot);
        supplyDeteilDTOs.add(supplyDeteilDTO);
        return supplyDeteilDTOs;  
    }

    public ArrayList<OrderDetailDTO> getAllOrdersThisMonth(String thisMonth) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM `oderdetail`,`oderitemsdetail` WHERE `oderdetail`.`Oid`=`oderitemsdetail`.`Oid` AND `oderdetail`.`Date`  LIKE '"+thisMonth+"%'";
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        ResultSet rst = pstm.executeQuery(sql);
        

        ArrayList<OrderDetailDTO> orderDetailDTOs = new ArrayList<>();
        if (!rst.next()) {
            return orderDetailDTOs;
        }
        rst.beforeFirst();
        String Oid = "";
        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
        ArrayList<ItemDTO> items = new ArrayList<>();
        ItemDTO item = new ItemDTO();
        while (rst.next()) {
            item = new ItemDTO(rst.getString("Iid"), "", 0, rst.getFloat("price"), rst.getInt("noOfItems"));
            if (Oid.equals(rst.getString("Oid"))) {
                items.add(item);
            }else{
                if (Oid.equals("")) {
                    orderDetailDTO = new OrderDetailDTO(rst.getString("Cid"), "", rst.getString("Oid"), rst.getString("Date"), rst.getFloat("Total"), new ArrayList<>());
                    Oid = rst.getString("Oid");
                    items.add(item);
                    continue;
                }
                orderDetailDTO.setItemList(items);
                items = new ArrayList<>();
                items.add(item);
                orderDetailDTOs.add(orderDetailDTO);
                orderDetailDTO = new OrderDetailDTO(rst.getString("Cid"), "", rst.getString("Oid"), rst.getString("Date"), rst.getFloat("Total"), new ArrayList<>());
                Oid = rst.getString("Oid");
            }
        }
        orderDetailDTO.setItemList(items);
        orderDetailDTOs.add(orderDetailDTO);
        return orderDetailDTOs;        
    }

    public ArrayList<SupplyDeteilDTO> getAllSuppliersThisMonth(String thisMonth) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM `supplieritemsdetail` WHERE `supplieritemsdetail`.`Date` LIKE '"+thisMonth+"%'";
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        ResultSet rst = pstm.executeQuery(sql);
        
        
        ArrayList<SupplyDeteilDTO> supplyDeteilDTOs = new ArrayList<>();
        if (!rst.next()) {
            return supplyDeteilDTOs;
        }
        rst.beforeFirst();
        String Sid = "";
        String date = "";
        SupplyDeteilDTO supplyDeteilDTO = new SupplyDeteilDTO();
        ArrayList<ItemDTO> items = new ArrayList<>();
        ItemDTO item = new ItemDTO();
        float tot = 0;
        int srID = 0;
        while (rst.next()) {
            item = new ItemDTO(rst.getString("Iid"), "", rst.getFloat("buyingPrice"), 0, rst.getInt("noOfItems"));
            if (Sid.equals(rst.getString("Sid")) && date.equals(rst.getString("Date"))) {
                items.add(item);
                tot = tot + item.getBuyingPrice()*item.getNoOfItems();
            }else{
                if (Sid.equals("") && date.equals("")) {
                    supplyDeteilDTO = new SupplyDeteilDTO(rst.getString("Sid"), rst.getString("Date"), new ArrayList<ItemDTO>(),0);
                    supplyDeteilDTO.setSrID(srID);
                    Sid = rst.getString("Sid");
                    date = rst.getString("Date");
                    items.add(item);
                    tot = tot + item.getBuyingPrice()*item.getNoOfItems();
                    continue;
                }
                supplyDeteilDTO.setItemList(items);
                supplyDeteilDTO.setTotal(tot);
                srID = srID + 1;
                tot = 0;
                items = new ArrayList<>();
                items.add(item);
                tot = tot + item.getBuyingPrice()*item.getNoOfItems();
                supplyDeteilDTOs.add(supplyDeteilDTO);
                supplyDeteilDTO = new SupplyDeteilDTO(rst.getString("Sid"), rst.getString("Date"), new ArrayList<ItemDTO>(),0);
                supplyDeteilDTO.setSrID(srID);
                Sid = rst.getString("Sid");
                date = rst.getString("Date");
            }
        }
        supplyDeteilDTO.setItemList(items);
        supplyDeteilDTO.setTotal(tot);
        supplyDeteilDTOs.add(supplyDeteilDTO);
        return supplyDeteilDTOs;  
    }

    public ArrayList<PaysheetDTO> getAllPaysheetsThisMonth(String thisMonth) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM `paysheet`,`employee` WHERE `paysheet`.`Eid`=`employee`.`Eid` AND `paysheet`.`Date` LIKE '"+thisMonth+"%'";
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        ResultSet rst = pstm.executeQuery(sql);
        
        
        ArrayList<PaysheetDTO> paysheetDTOs = new ArrayList<>();
        if (!rst.next()) {
            return paysheetDTOs;
        }
        rst.beforeFirst();
        while (rst.next()) {
            PaysheetDTO paysheetDTO = new PaysheetDTO(rst.getInt("Pid"), rst.getString("Eid"), rst.getFloat("fixedSalary"), rst.getFloat("otRate"), rst.getFloat("otHours"), rst.getFloat("otAmount"), rst.getFloat("totalSalary"), rst.getString("Date"), rst.getString("name"));
            paysheetDTOs.add(paysheetDTO);
            
        }
        
        return paysheetDTOs;
    }
}
