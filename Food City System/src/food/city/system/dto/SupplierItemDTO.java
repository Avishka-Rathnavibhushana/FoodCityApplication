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
public class SupplierItemDTO {
    private String Sid;
    private String Iid;
    private int noOfItems;
    private String date;
    private float buyingPrice;

    public SupplierItemDTO() {
    }

    public SupplierItemDTO(String Sid, String Iid, int noOfItems, String date, float buyingPrice) {
        this.Sid = Sid;
        this.Iid = Iid;
        this.noOfItems = noOfItems;
        this.date = date;
        this.buyingPrice = buyingPrice;
    }

    public String getSid() {
        return Sid;
    }

    public void setSid(String Sid) {
        this.Sid = Sid;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(float buyingPrice) {
        this.buyingPrice = buyingPrice;
    }
    
    
}
