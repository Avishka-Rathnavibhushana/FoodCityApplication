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
public class SupplierDTO {
    private String Sid;
    private String name;

    public SupplierDTO() {
    }

    public SupplierDTO(String Sid, String name) {
        this.Sid = Sid;
        this.name = name;
    }

    public String getSid() {
        return Sid;
    }

    public void setSid(String Sid) {
        this.Sid = Sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
