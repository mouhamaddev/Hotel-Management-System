package com.mycompany.hotel.management.system;

import com.mycompany.hotel.management.system.gui.Login;
import com.mycompany.hotel.management.system.Admin;
import java.io.ByteArrayOutputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Base64;
import java.util.Properties;

public class HotelManagementSystem {

    public static void main(String[] args) {
        Login mainFrame = new Login();
        mainFrame.setVisible(true);
        
        Admin myadmin = new Admin("admin","root");        
        
        try {
            String conf = "C:\\Users\\winte\\Documents\\github\\Hotel-Management-System\\Hotel-Management-System\\conf.properties";
            
            Properties prop = new Properties();
            FileInputStream fis = new FileInputStream(conf);
            prop.load(fis);


            prop.setProperty("adminUsername", myadmin.username);
            prop.setProperty("adminPassword", myadmin.password);

            FileOutputStream fos = new FileOutputStream(conf);
            prop.store(fos, "Updated properties");

            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
            
    }
    
}