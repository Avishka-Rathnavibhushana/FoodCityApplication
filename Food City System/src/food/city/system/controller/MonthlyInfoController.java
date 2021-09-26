/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.city.system.controller;

import food.city.system.dto.OrderDetailDTO;
import food.city.system.dto.PaysheetDTO;
import food.city.system.dto.SupplyDeteilDTO;
import food.city.system.model.QuerryDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Avishka
 */
public class MonthlyInfoController {

    private QuerryDAO querryDAO;
    
    public MonthlyInfoController() {
        
        this.querryDAO = new QuerryDAO();
    
    }

    public ArrayList<OrderDetailDTO> getAllOrdersThisMonth(String thisMonth) throws ClassNotFoundException, SQLException {
        return querryDAO.getAllOrdersThisMonth(thisMonth);
    }

    public ArrayList<SupplyDeteilDTO> getAllSuppliersThisMonth(String thisMonth) throws ClassNotFoundException, SQLException {
        return querryDAO.getAllSuppliersThisMonth(thisMonth );
    }

    public ArrayList<PaysheetDTO> getAllPaysheetsThisMonth(String thisMonth) throws ClassNotFoundException, SQLException {
        return querryDAO.getAllPaysheetsThisMonth(thisMonth );
    }
    
}
