package com.mycompany.hotel.management.system;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class HotelManagementSystem {

    public static void main(String[] args) {
        try {
            String conf = "C:\\Users\\winte\\Documents\\NetBeansProjects\\mavenproject1\\conf.properties";
            
            Properties prop = new Properties();
            FileInputStream fis = new FileInputStream(conf);
            prop.load(fis);


            // WRITE CODE HERE
            
            //Get value of key0
            //System.out.println(prop.getProperty("key0"));

            //Set value of key1
            //prop.setProperty("key1", "value1");

            FileOutputStream fos = new FileOutputStream(conf);
            prop.store(fos, "Updated properties");

            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}