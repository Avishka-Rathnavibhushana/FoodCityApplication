/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.city.system.controller;

import food.city.system.dto.ItemDTO;
import food.city.system.dto.OrderDetailDTO;
import food.city.system.dto.SupplyDeteilDTO;
import food.city.system.model.ItemDAO;
import food.city.system.model.QuerryDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Avishka
 */
public class DailyInfoController {
    
    private QuerryDAO querryDAO;
    private ItemDAO itemDAO;

    public DailyInfoController() {
        this.querryDAO = new QuerryDAO();
        this.itemDAO = new ItemDAO();
    }

    public ArrayList<OrderDetailDTO> getAllOrdersToday(String today) throws SQLException, ClassNotFoundException {
        return querryDAO.getAllOrdersToday(today);
    }

    public ArrayList<SupplyDeteilDTO> getAllSuppliersToday(String today) throws SQLException, ClassNotFoundException {
        return querryDAO.getAllSuppliersToday(today);
    }

    public ArrayList<ItemDTO> getAllItems() throws Exception {
        ArrayList<ItemDTO> itemDTOs = itemDAO.getAll();
        ArrayList<ItemDTO> limitedItemDTOs = new ArrayList<>();
        for (ItemDTO item : itemDTOs) {
            if (item.getNoOfItems()<item.getLowerLimit()) {
                limitedItemDTOs.add(item);
            }
        }
        
        return limitedItemDTOs;
   }

    
}
