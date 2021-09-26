/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.city.system.controller;

import food.city.system.dto.EmployeeDTO;
import food.city.system.dto.ItemDTO;
import food.city.system.dto.SupplierDTO;
import food.city.system.model.EmployeeDAO;
import food.city.system.model.ItemDAO;
import food.city.system.model.QuerryDAO;
import food.city.system.model.SupplierDAO;
import java.util.ArrayList;

/**
 *
 * @author Avishka
 */
public class ManageDatabaseController {
    private ItemDAO itemDAO;
    private EmployeeDAO employeeDAO;
    private SupplierDAO supplierDAO;
    private QuerryDAO querryDAO;
    
    public ManageDatabaseController() {
        this.itemDAO = new ItemDAO();
        this.employeeDAO = new EmployeeDAO();
        this.supplierDAO = new SupplierDAO();
        this.querryDAO = new QuerryDAO();
    }
    
    public String saveItem(ItemDTO itemDTO) throws Exception{
        if (itemDAO.search(itemDTO.getIid())==null) {
            return itemDAO.save(itemDTO)==true? "true":"false";
        }else{
            return "Item already Exist";
        }
        
    }
    
    public boolean deleteItem(String itemId) throws Exception{
        return itemDAO.delete(itemId);
    }
    
    public boolean updateItem(ItemDTO itemDTO) throws Exception{
        return itemDAO.update(itemDTO);
    }
    
    public ArrayList<ItemDTO> getAllItems()throws Exception{
        return itemDAO.getAll();
    }
    
    
    public String saveEmployee(EmployeeDTO employeeDTO) throws Exception{
        if (employeeDAO.search(employeeDTO.getEid())==null) {
            return employeeDAO.save(employeeDTO)==true? "true":"false";
        }else{
            return "Employee already Exist";
        }
    }
    
    public boolean deleteEmployee(String employeeId) throws Exception{
        return employeeDAO.delete(employeeId);
    }
    
    public boolean updateEmployee(EmployeeDTO employeeDTO) throws Exception{
        return employeeDAO.update(employeeDTO);
    }
    
    public ArrayList<EmployeeDTO> getAllEmployees()throws Exception{
        return employeeDAO.getAll();
    }
    
    
    public String saveSupplier(SupplierDTO supplierDTO) throws Exception{
        if (supplierDAO.search(supplierDTO.getSid())==null) {
            return supplierDAO.save(supplierDTO)==true? "true":"false";
        }else{
            return "Supplier already Exist";
        }
    }
    
    public boolean deleteSupplier(String supplierID) throws Exception{
        return supplierDAO.delete(supplierID);
    }
    
    public boolean updateSupplier(SupplierDTO supplierDTO) throws Exception{
        return supplierDAO.update(supplierDTO);
    }
    
    public ArrayList<SupplierDTO> getAllSuppliers()throws Exception{
        return supplierDAO.getAll();
    }
}
