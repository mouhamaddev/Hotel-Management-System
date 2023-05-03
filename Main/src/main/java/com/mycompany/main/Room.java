package com.mycompany.main;

import java.io.Serializable;
import java.util.ArrayList;

class Room implements Serializable
{
    String name;
    String contact;
    String gender;   

    Room()
    {
        this.name="";
    }
    Room(String name,String contact,String gender)
    {
        this.name=name;
        this.contact=contact;
        this.gender=gender;
    }
}