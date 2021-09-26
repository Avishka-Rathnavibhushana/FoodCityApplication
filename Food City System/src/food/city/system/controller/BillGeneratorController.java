/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.city.system.controller;

import food.city.system.dto.CustomerDTO;
import food.city.system.dto.ItemDTO;
import food.city.system.dto.OrderDetailDTO;
import food.city.system.dto.OrderItemDetailsDTO;
import food.city.system.model.CustomerDAO;
import food.city.system.model.ItemDAO;
import food.city.system.model.OrderDetailsDAO;
import food.city.system.model.OrderItemDetailsDAO;
import food.city.system.model.QuerryDAO;
import java.sql.SQLException;

/**
 *
 * @author Avishka
 */
public class BillGeneratorController {
    
    private ItemDAO itemDAO;
    private CustomerDAO customerDAO;
    private OrderDetailsDAO orderDetailsDAO;
    private OrderItemDetailsDAO orderItemDetailsDAO;
    private QuerryDAO querryDAO;
    
    public BillGeneratorController() {
        this.querryDAO = new QuerryDAO();
        this.itemDAO = new ItemDAO();
        this.customerDAO =new CustomerDAO();
        this.orderDetailsDAO = new OrderDetailsDAO();
        this.orderItemDetailsDAO = new OrderItemDetailsDAO();
    }

    public String loadCustomerID() throws SQLException, ClassNotFoundException {
        String lastID = querryDAO.getLastCustomerID();
        if (lastID==null) {
            return "C1";
        }
        int newID = Integer.parseInt(lastID.substring(1))+1;
        return "C"+newID;
    }

    public String loadOrderID() throws SQLException, ClassNotFoundException {
        String lastID = querryDAO.getLastCustomerID();
        if (lastID==null) {
            return "O1";
        }
        int newID = Integer.parseInt(lastID.substring(1))+1;
        return "O"+newID;
    }

    public ItemDTO getItemDetails(String itemID) throws Exception {
        return itemDAO.search(itemID);
    }

    public boolean saveOrder(OrderDetailDTO orderDetaildDTO) throws Exception {
        CustomerDTO customer = new CustomerDTO(orderDetaildDTO.getCid(), orderDetaildDTO.getcName());
        if (customerDAO.save(customer)) {
            if (orderDetailsDAO.save(orderDetaildDTO)) {
                for (ItemDTO itemDTO : orderDetaildDTO.getItemList()) {
                    OrderItemDetailsDTO orderItemDetails = new OrderItemDetailsDTO(orderDetaildDTO.getOid(), itemDTO.getIid(), itemDTO.getNoOfItems(), itemDTO.getSellingPrice());
                    orderItemDetailsDAO.save(orderItemDetails);
                    ItemDTO itemDTOold = itemDAO.search(itemDTO.getIid());
                    itemDTO.setName(itemDTOold.getName());
                    itemDTO.setBuyingPrice(itemDTOold.getBuyingPrice());
                    itemDTO.setNoOfItems(itemDTOold.getNoOfItems()-itemDTO.getNoOfItems());
                    itemDTO.setLowerLimit(itemDTOold.getLowerLimit());
                    itemDAO.update(itemDTO);
                }
                return true;
            }
        }
        return false;
    }
    
    
}
