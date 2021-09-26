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
public class SupplyDeteilDTO {
    private int srID;
    private String Sid;
    private String date;
    private ArrayList<ItemDTO> itemList;
    private float total;

    public SupplyDeteilDTO() {
    }

    public SupplyDeteilDTO(String Sid, String date, ArrayList<ItemDTO> itemList, float total) {
        this.Sid = Sid;
        this.date = date;
        this.itemList = itemList;
        this.total = total;
    }

    public int getSrID() {
        return srID;
    }

    public void setSrID(int srID) {
        this.srID = srID;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    

    public String getSid() {
        return Sid;
    }

    public void setSid(String Sid) {
        this.Sid = Sid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<ItemDTO> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<ItemDTO> itemList) {
        this.itemList = itemList;
    }
    
    
}
