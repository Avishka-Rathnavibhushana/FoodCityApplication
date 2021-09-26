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
public class OrderDetailDTO {
    private String Cid;
    private String cName;
    private String Oid;
    private String date;
    private float total;
    private ArrayList<ItemDTO> itemList;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(String Cid, String cName, String Oid, String date, float total, ArrayList<ItemDTO> itemList) {
        this.Cid = Cid;
        this.cName = cName;
        this.Oid = Oid;
        this.date = date;
        this.total = total;
        this.itemList = itemList;
    }

    public String getCid() {
        return Cid;
    }

    public void setCid(String Cid) {
        this.Cid = Cid;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getOid() {
        return Oid;
    }

    public void setOid(String Oid) {
        this.Oid = Oid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public ArrayList<ItemDTO> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<ItemDTO> itemList) {
        this.itemList = itemList;
    }
    
    
}
