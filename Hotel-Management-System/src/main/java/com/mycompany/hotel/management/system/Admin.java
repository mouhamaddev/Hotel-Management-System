/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotel.management.system;


public class Admin implements Manager {
    public String username;
    public String password;
    
    public Admin() {
    }
    
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void addStaff() {
        // add staff
    }

    public void removeStaff() {
        // remove staff
    }
}
