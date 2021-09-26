/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.city.system.dto;

import java.util.ArrayList;

/**
 *
 * @author Avishka
 */
public class SupplierItemsDetailsDTO {
    private ArrayList<String> Iids;
    private ArrayList<Integer> noItems;
    private String date;
    
    public SupplierItemsDetailsDTO(){
        
    }
    
    public SupplierItemsDetailsDTO(ArrayList<String> Iids, ArrayList<Integer> noItems, String date) {
        this.Iids = Iids;
        this.noItems = noItems;
        this.date = date;
    }

    public ArrayList<String> getIids() {
        return Iids;
    }

    public void setIids(ArrayList<String> Iids) {
        this.Iids = Iids;
    }

    public ArrayList<Integer> getNoItems() {
        return noItems;
    }

    public void setNoItems(ArrayList<Integer> noItems) {
        this.noItems = noItems;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
}
