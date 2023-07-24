package Monopoly.java;

import java.util.*;

public class Bank {
 
    public static ArrayList <Square> tickets = new ArrayList<Square>();

    public static void setProp(){

        tickets.add(new Square("GO",0,0,false,true));
        tickets.add(new Square("Old Kent Road",1,60,true,true));
        tickets.add(new Square("Community Chest",2,0,false,true));
        tickets.add(new Square("Whitechapel Road",3,60,true,true));
        tickets.add(new Square("King's Cross Station",4,200,true,true));
        tickets.add(new Square("The Angel Islignton",5,100,true,true));
        tickets.add(new Square("Euston Road",6,100,true,true));
        tickets.add(new Square("Jail",7,0,false,true));
        tickets.add(new Square("Pall Mall",8,140,true,true));
        tickets.add(new Square("Whitehall",9,140,true,true));
        tickets.add(new Square("Electric Company",10,150,true,true));
        tickets.add(new Square("Bow Street",11,500,true,true));
        tickets.add(new Square("Chance",12,500,false,true));
        tickets.add(new Square("Marlborough Street",13,500,true,true));
        tickets.add(new Square("Free Parking",14,500,false,true));
        tickets.add(new Square("The Strand",15,500,true,true));
        tickets.add(new Square("Community Chest",16,500,false,true));
        tickets.add(new Square("Trafalgar Square",17,500,true,true));
        tickets.add(new Square("Fenchurch St Station",18,500,true,true));
        tickets.add(new Square("Leicester Square",19,500,true,true));
        tickets.add(new Square("Coventry Street",20,500,true,true));
        tickets.add(new Square("Go to Jail",21,500,false,true));
        tickets.add(new Square("Regent Street",22,500,true,true));
        tickets.add(new Square("Chance",23,500,false,true));
        tickets.add(new Square("Oxford Street",24,500,true,true));
        tickets.add(new Square("Water Works",25,500,true,true));
        tickets.add(new Square("Park Lane",26,500,true,true));
        tickets.add(new Square("MayFair",27,500,true,true));


        } 
    static Stack <Card> commCards = new Stack<>();

    public static void setCards(){
    	
    	
        commCards.push(new Card("Income Tax"));
        commCards.push( new Card("Go to Jail"));
        commCards.push( new Card("Won a beauty contest"));
        commCards.push(new Card("Advance to GO"));
        commCards.push(new Card("Pay hospital"));
        
    }
}
