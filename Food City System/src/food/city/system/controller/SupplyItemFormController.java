/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.city.system.controller;

import food.city.system.dto.CustomerDTO;
import food.city.system.dto.ItemDTO;
import food.city.system.dto.OrderItemDetailsDTO;
import food.city.system.dto.SupplierDTO;
import food.city.system.dto.SupplierItemDTO;
import food.city.system.dto.SupplyDeteilDTO;
import food.city.system.model.ItemDAO;
import food.city.system.model.SupplierDAO;
import food.city.system.model.SupplierItemsDetailDAO;

/**
 *
 * @author Avishka
 */
public class SupplyItemFormController {
    
    private SupplierDAO supplierDAO;
    private SupplierItemsDetailDAO supplierItemsDetailDAO;
    private ItemDAO itemDAO;

    public SupplyItemFormController() {
        this.supplierDAO = new SupplierDAO();
        this.supplierItemsDetailDAO = new SupplierItemsDetailDAO();
        this.itemDAO = new ItemDAO();
    }

    public SupplierDTO getSupplier(String text) throws Exception {
        return supplierDAO.search(text);
    }

    public ItemDTO getItemDetails(String itemID) throws Exception {
        return itemDAO.search(itemID);
    }

    public boolean saveSupplyItems(SupplyDeteilDTO supplyDeteilDTO) throws Exception {
        
        //boolean out = false;
        //int count = 0;
        for (ItemDTO itemDTO : supplyDeteilDTO.getItemList()) {
            SupplierItemDTO supplierItemDTO = new SupplierItemDTO(supplyDeteilDTO.getSid(), itemDTO.getIid(), itemDTO.getNoOfItems(), supplyDeteilDTO.getDate(), itemDTO.getBuyingPrice());
            supplierItemsDetailDAO.save(supplierItemDTO);
            ItemDTO itemDTOold = itemDAO.search(itemDTO.getIid());
            itemDTO.setName(itemDTOold.getName());
            itemDTO.setSellingPrice(itemDTOold.getSellingPrice());
            itemDTO.setNoOfItems(itemDTOold.getNoOfItems()+itemDTO.getNoOfItems());
            itemDAO.update(itemDTO);
            //count++;
        }
        
        return true;
    }
    
}
