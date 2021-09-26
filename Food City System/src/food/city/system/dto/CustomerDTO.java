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
public class CustomerDTO {
    private String Cid;
    private String name;

    public CustomerDTO(String Cid, String name) {
        this.Cid = Cid;
        this.name = name;
    }

    public String getCid() {
        return Cid;
    }

    public void setCid(String Cid) {
        this.Cid = Cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
