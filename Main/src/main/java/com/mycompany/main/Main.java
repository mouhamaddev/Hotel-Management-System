package com.mycompany.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


class NotAvailable extends Exception
{
    @Override
    public String toString()
    {
        return "Not Available !";
    }
}

class holder implements Serializable
{
    Doubleroom luxury_doublerrom[]=new Doubleroom[10]; //Luxury
    Doubleroom deluxe_doublerrom[]=new Doubleroom[20]; //Deluxe
    Singleroom luxury_singleerrom[]=new Singleroom[10]; //Luxury
    Singleroom deluxe_singleerrom[]=new Singleroom[20]; //Deluxe
}


class write implements Runnable
{
    holder hotel_ob;
    write(holder hotel_ob)
    {
        this.hotel_ob=hotel_ob;
    }
    @Override
    public void run() {
          try{
        FileOutputStream fout=new FileOutputStream("backup");
        ObjectOutputStream oos=new ObjectOutputStream(fout);
        oos.writeObject(hotel_ob);
        }
        catch(Exception e)
        {
            System.out.println("Error in writing "+e);
        }         
        
    }
    
}

public class Main {
    public static void main(String[] args){
        
        try
        {           
        File f = new File("backup");
        if(f.exists())
        {
            FileInputStream fin=new FileInputStream(f);
            ObjectInputStream ois=new ObjectInputStream(fin);
            Hotel.hotel_ob=(holder)ois.readObject();
        }
        Scanner sc = new Scanner(System.in);
        int ch,ch2;
        char wish;
        x:
        do{

        System.out.println("\nEnter your choice :\n1.Display room availability \n2.Book\n3.Checkout\n4.Exit\n");
        ch = sc.nextInt();
        switch(ch){
            case 1:System.out.println("\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room\n4.Deluxe Single Room\n");
                     ch2 = sc.nextInt();
                     Hotel.availability(ch2);
                break;
            case 2:System.out.println("\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room\n4.Deluxe Single Room\n");
                     ch2 = sc.nextInt();
                     Hotel.bookroom(ch2);                     
                break;
            case 3:                 
                System.out.print("Room Number -");
                     ch2 = sc.nextInt();
                     if(ch2>60)
                         System.out.println("Room doesn't exist");
                     else if(ch2>40)
                         Hotel.deallocate(ch2-41,4);
                     else if(ch2>30)
                         Hotel.deallocate(ch2-31,3);
                     else if(ch2>10)
                         Hotel.deallocate(ch2-11,2);
                     else if(ch2>0)
                         Hotel.deallocate(ch2-1,1);
                     else
                         System.out.println("Room doesn't exist");
                     break;
            case 4:break x;
                
        }
           
            System.out.println("\nContinue : (y/n)");
            wish=sc.next().charAt(0); 
            if(!(wish=='y'||wish=='Y'||wish=='n'||wish=='N'))
            {
                System.out.println("Invalid Option");
                System.out.println("\nContinue : (y/n)");
                wish=sc.next().charAt(0); 
            }
            
        }while(wish=='y'||wish=='Y');    
        
        Thread t=new Thread(new write(Hotel.hotel_ob));
        t.start();
        }        
            catch(Exception e)
            {
                System.out.println("Not a valid input");
            }
    }
}
