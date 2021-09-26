/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.city.system.dto;

/**
 *
 * @author Avishka
 */
public class OrderItemDetailsDTO {
    private String Oid;
    private String Iid;
    private int noOfItems;
    private float price;

    public OrderItemDetailsDTO() {
    }

    public OrderItemDetailsDTO(String Oid, String Iid, int noOfItems, float price) {
        this.Oid = Oid;
        this.Iid = Iid;
        this.noOfItems = noOfItems;
        this.price = price;
    }

    public String getOid() {
        return Oid;
    }

    public void setOid(String Oid) {
        this.Oid = Oid;
    }

    public String getIid() {
        return Iid;
    }

    public void setIid(String Iid) {
        this.Iid = Iid;
    }

    public int getNoOfItems() {
        return noOfItems;
    }

    public void setNoOfItems(int noOfItems) {
        this.noOfItems = noOfItems;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
}
