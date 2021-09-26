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
public class ItemDTO {
    private String Iid;
    private String name;
    private float buyingPrice;
    private float sellingPrice;
    private int noOfItems;
    private int lowerLimit;

    public ItemDTO(String Iid, String name, float buyingPrice, float sellingPrice, int noOfItems, int lowerLimit) {
        this.Iid = Iid;
        this.name = name;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.noOfItems = noOfItems;
        this.lowerLimit = lowerLimit;
    }
    
    

    public ItemDTO(String Iid, String name, float buyingPrice, float sellingPrice, int noOfItems) {
        this.Iid = Iid;
        this.name = name;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.noOfItems = noOfItems;
    }

    public int getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(int lowerLimit) {
        this.lowerLimit = lowerLimit;
    }
    
    
    public ItemDTO() {
    }
    
    public String getIid() {
        return Iid;
    }

    public void setIid(String Iid) {
        this.Iid = Iid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(float buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getNoOfItems() {
        return noOfItems;
    }

    public void setNoOfItems(int noOfItems) {
        this.noOfItems = noOfItems;
    }
    
}
