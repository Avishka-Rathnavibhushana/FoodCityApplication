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
public class PaysheetDTO {
    private int pid;
    private String eid;
    private float fixedSalary;
    private float otRate;
    private float otHours;
    private float otAmount;
    private float totalSalary;
    private String date;
    private String name;

    public PaysheetDTO() {
    }

    public PaysheetDTO(int pid, String eid, float fixedSalary, float otRate, float otHours, float otAmount, float totalSalary, String date, String name) {
        this.pid = pid;
        this.eid = eid;
        this.fixedSalary = fixedSalary;
        this.otRate = otRate;
        this.otHours = otHours;
        this.otAmount = otAmount;
        this.totalSalary = totalSalary;
        this.date = date;
        this.name = name;
    }
    
    public PaysheetDTO(String eid, float fixedSalary, float otRate, float otHours, float otAmount, float totalSalary, String date) {
        this.eid = eid;
        this.fixedSalary = fixedSalary;
        this.otRate = otRate;
        this.otHours = otHours;
        this.otAmount = otAmount;
        this.totalSalary = totalSalary;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public float getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(float fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public float getOtRate() {
        return otRate;
    }

    public void setOtRate(float otRate) {
        this.otRate = otRate;
    }

    public float getOtHours() {
        return otHours;
    }

    public void setOtHours(float otHours) {
        this.otHours = otHours;
    }

    public float getOtAmount() {
        return otAmount;
    }

    public void setOtAmount(float otAmount) {
        this.otAmount = otAmount;
    }

    public float getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(float totalSalary) {
        this.totalSalary = totalSalary;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}
