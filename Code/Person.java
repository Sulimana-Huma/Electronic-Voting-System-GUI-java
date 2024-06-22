/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.guievoting1;

/**
 *
 * @author thinkpad
 */
import java.util.Scanner;
public class Person
{
    private String name;
    private String cnic;
    private String province;
    private String city;
    private String party;
    private String password;
  //  private String nameCandidate;
   // private boolean ValidCandidate;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    
    
   public void setParty(String party){
       this.party=party;
   }
    
    public String getParty(){
        return this.party;
    }
    
    public String getCnic() {
        return cnic;
    }
    public void setCnic(String cnic) {
        this.cnic = cnic;
    }
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
