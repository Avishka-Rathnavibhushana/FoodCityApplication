/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.city.system.controller;

import food.city.system.dto.EmployeeDTO;
import food.city.system.dto.PaysheetDTO;
import food.city.system.model.EmployeeDAO;
import food.city.system.model.PaysheetDAO;

/**
 *
 * @author Avishka
 */
public class EmployeePaysheetController {
    
    private PaysheetDAO paysheetDAO;
    private EmployeeDAO employeeDAO;
    
    public EmployeePaysheetController() {
        this.paysheetDAO = new PaysheetDAO();
        this.employeeDAO = new EmployeeDAO();
    }

    public EmployeeDTO getEmployee(String Eid) throws Exception {
        return employeeDAO.search(Eid);
    }

    public boolean savePaysheet(PaysheetDTO paysheetDTO) throws Exception {
        if (paysheetDAO.search(paysheetDTO.getEid())) {
            return false;
        }
        return paysheetDAO.save(paysheetDTO);
    }

    public boolean searchEmployee(String Eid) throws Exception {
        if (paysheetDAO.search(Eid)) {
            return true;
        }
        return false;
    }
    
    
    
}
