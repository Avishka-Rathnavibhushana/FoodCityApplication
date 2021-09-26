/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.city.system.controller;

import food.city.system.model.MainDAO;

/**
 *
 * @author maila
 */
public class MainController {
    private MainDAO mainDAO;

    
    public MainController() {
        this.mainDAO = new MainDAO();
    }
    
    public void checkDatabase() throws Exception{
        boolean isDatabaseExist = this.mainDAO.checkForDatabase();
        System.out.println(isDatabaseExist);
    }
}
