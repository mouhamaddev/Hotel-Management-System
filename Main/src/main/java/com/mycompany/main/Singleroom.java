package com.mycompany.main;

import java.io.Serializable;
import java.util.ArrayList;

class Singleroom implements Serializable
{
    String name;
    String contact;
    String gender;   

    Singleroom()
    {
        this.name="";
    }
    Singleroom(String name,String contact,String gender)
    {
        this.name=name;
        this.contact=contact;
        this.gender=gender;
    }
}