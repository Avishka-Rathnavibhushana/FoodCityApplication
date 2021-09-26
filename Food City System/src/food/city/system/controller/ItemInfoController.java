/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.city.system.controller;

import food.city.system.dto.ItemDTO;
import food.city.system.dto.SupplierItemsDetailsDTO;
import food.city.system.model.ItemDAO;
import food.city.system.model.QuerryDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Avishka
 */
public class ItemInfoController {
    
    private ItemDAO itemDAO;
    private QuerryDAO querryDAO;
    
    public ItemInfoController() {
        this.itemDAO = new ItemDAO();
        this.querryDAO = new QuerryDAO();
    }
    
    public ArrayList<ItemDTO> getALLItems() throws Exception{
        ArrayList<ItemDTO> itemDTOs = itemDAO.getAll();
        return itemDTOs;
    }
    
    public SupplierItemsDetailsDTO getSupplierItemsDetailOnDay(String date) throws Exception{
        SupplierItemsDetailsDTO supplierItemsDetailsDTO = querryDAO.getSupplyItemsOnDate(date);
        return supplierItemsDetailsDTO;
    }

    public ArrayList<Object> getOrderItemsDetailOnDay(String date) throws SQLException, ClassNotFoundException {
        ArrayList<Object> orderItemDetailsDTOs = querryDAO.getOrderItemsOnDate(date);
        return orderItemDetailsDTOs;
    }
}
