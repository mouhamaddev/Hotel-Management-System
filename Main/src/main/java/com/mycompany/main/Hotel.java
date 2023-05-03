package com.mycompany.main;

import java.util.Scanner;

class Hotel
{
    static holder hotel_ob=new holder();
    static Scanner sc = new Scanner(System.in);
    
    static void CustDetails(int i,int rn)
    {
        String name, contact, gender;
        String name2 = null, contact2 = null; 
        String gender2="";
        System.out.print("\nEnter customer name: ");
        name = sc.next();
        System.out.print("Enter contact number: ");
        contact=sc.next();
        System.out.print("Enter gender: ");
        gender = sc.next();
        if(i<3)
        {
        System.out.print("Enter second customer name: ");
        name2 = sc.next();
        System.out.print("Enter contact number: ");
        contact2=sc.next();
        System.out.print("Enter gender: ");
        gender2 = sc.next();
        }      
          switch (i) {
            case 1:hotel_ob.luxury_doublerrom[rn]=new Doubleroom(name,contact,gender,name2,contact2,gender2);
                break;
            case 2:hotel_ob.deluxe_doublerrom[rn]=new Doubleroom(name,contact,gender,name2,contact2,gender2);
                break;
            case 3:hotel_ob.luxury_singleerrom[rn]=new Singleroom(name,contact,gender);
                break;
            case 4:hotel_ob.deluxe_singleerrom[rn]=new Singleroom(name,contact,gender);
                break;
            default:System.out.println("Wrong option");
                break;
        }
    }
    
    static void bookroom(int i)
    {
        int j;
        int rn;
        System.out.println("\nChoose room number from : ");
        switch (i) {
            case 1:
                for(j=0;j<hotel_ob.luxury_doublerrom.length;j++)
                {
                    if(hotel_ob.luxury_doublerrom[j]==null)
                    {
                        System.out.print(j+1+",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try{
                rn=sc.nextInt();
                rn--;
                if(hotel_ob.luxury_doublerrom[rn]!=null)
                    throw new NotAvailable();
                CustDetails(i,rn);
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            case 2:
                 for(j=0;j<hotel_ob.deluxe_doublerrom.length;j++)
                {
                    if(hotel_ob.deluxe_doublerrom[j]==null)
                    {
                        System.out.print(j+11+",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try{
                rn=sc.nextInt();
                rn=rn-11;
                if(hotel_ob.deluxe_doublerrom[rn]!=null)
                    throw new NotAvailable();
                CustDetails(i,rn);
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            case 3:
                  for(j=0;j<hotel_ob.luxury_singleerrom.length;j++)
                {
                    if(hotel_ob.luxury_singleerrom[j]==null)
                    {
                        System.out.print(j+31+",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try{
                rn=sc.nextInt();
                rn=rn-31;
                if(hotel_ob.luxury_singleerrom[rn]!=null)
                    throw new NotAvailable();
                CustDetails(i,rn);
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            case 4:
                  for(j=0;j<hotel_ob.deluxe_singleerrom.length;j++)
                {
                    if(hotel_ob.deluxe_singleerrom[j]==null)
                    {
                        System.out.print(j+41+",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try{
                rn=sc.nextInt();
                rn=rn-41;
                if(hotel_ob.deluxe_singleerrom[rn]!=null)
                    throw new NotAvailable();
                CustDetails(i,rn);
                }
                catch(Exception e)
                {
                   System.out.println("Invalid Option");
                    return;
                }
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
        System.out.println("Room Booked");
    }
    
    static void availability(int i)
    {
      int j,count=0;
        switch (i) {
            case 1:
                for(j=0;j<10;j++)
                {
                    if(hotel_ob.luxury_doublerrom[j]==null)
                        count++;
                }
                break;
            case 2:
                for(j=0;j<hotel_ob.deluxe_doublerrom.length;j++)
                {
                    if(hotel_ob.deluxe_doublerrom[j]==null)
                        count++;
                }
                break;
            case 3:
                for(j=0;j<hotel_ob.luxury_singleerrom.length;j++)
                {
                    if(hotel_ob.luxury_singleerrom[j]==null)
                        count++;
                }
                break;
            case 4:
                for(j=0;j<hotel_ob.deluxe_singleerrom.length;j++)
                {
                    if(hotel_ob.deluxe_singleerrom[j]==null)
                        count++;
                }
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
        System.out.println("Number of rooms available : "+count);
    }
    
    static void bill(int rn,int rtype)
    {
        double amount=0;
               
        switch(rtype)
        {
            case 1:
                amount+=240;
                    System.out.println("\nRoom Charge - "+amount);
                    
                break;
            case 2:amount+=300;
                    System.out.println("Room Charge - "+amount);

                break;
            case 3:amount+=120;
                    System.out.println("Room Charge - "+amount);

                break;
            case 4:amount+=150;
                    System.out.println("Room Charge - "+amount);

                break;
            default:
                System.out.println("Not valid");
        }
        System.out.println("Thank you for using our hotel!");
    }
    
    static void deallocate(int rn,int rtype)
    {
        int j;
        char w;
        switch (rtype) {
            case 1:               
                if(hotel_ob.luxury_doublerrom[rn]!=null)
                    System.out.println("Room used by "+hotel_ob.luxury_doublerrom[rn].name);                
                else 
                {    
                    System.out.println("Empty Already");
                        return;
                }
                System.out.println("Do you want to checkout ?(y/n)");
                 w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    hotel_ob.luxury_doublerrom[rn]=null;
                    System.out.println("Deallocated succesfully");
                }
                
                break;
            case 2:
                if(hotel_ob.deluxe_doublerrom[rn]!=null)
                    System.out.println("Room used by "+hotel_ob.deluxe_doublerrom[rn].name);                
                else 
                {    
                    System.out.println("Empty Already");
                        return;
                }
                System.out.println(" Do you want to checkout ?(y/n)");
                 w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    hotel_ob.deluxe_doublerrom[rn]=null;
                    System.out.println("Deallocated succesfully");
                }
                 
                break;
            case 3:
                if(hotel_ob.luxury_singleerrom[rn]!=null)
                    System.out.println("Room used by "+hotel_ob.luxury_singleerrom[rn].name);                
                else 
                 {    
                    System.out.println("Empty Already");
                        return;
                }
                System.out.println(" Do you want to checkout ? (y/n)");
                w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    hotel_ob.luxury_singleerrom[rn]=null;
                }
                
                break;
            case 4:
                if(hotel_ob.deluxe_singleerrom[rn]!=null)
                    System.out.println("Room used by "+hotel_ob.deluxe_singleerrom[rn].name);                
                else 
                 {    
                    System.out.println("Empty Already");
                        return;
                }
                System.out.println(" Do you want to checkout ? (y/n)");
                 w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    hotel_ob.deluxe_singleerrom[rn]=null;
                    System.out.println("Deallocated succesfully");
                }
                break;
            default:
                System.out.println("\nEnter valid option : ");
                break;
        }
    }
    
    static void order(int rn,int rtype)
    {
        int i,q;
        char wish;
         try{
             System.out.println("\n==========\n   Menu:  \n==========\n\n1.Sandwich\tRs.50\n2.Pasta\t\tRs.60\n3.Noodles\tRs.70\n4.Coke\t\tRs.30\n");
        do
        {
            i = sc.nextInt();
            System.out.print("Quantity- ");
            q=sc.nextInt();
           

              System.out.println("Do you want to order anything else ? (y/n)");
              wish=sc.next().charAt(0); 
        }while(wish=='y'||wish=='Y');  
        }
         catch(NullPointerException e)
            {
                System.out.println("\nRoom not booked");
            }
         catch(Exception e)
         {
             System.out.println("Cannot be done");
         }
    }
}