package Monopoly.java;

public class Square {

    String name;
    int position;
    int price;
    boolean ticket;
    boolean available;

    Square(String name, int position,int price, boolean ticket,boolean available){

        this.name = name;
        this.position = position;
        this.price = price;
        this.ticket = ticket;
        this.available=available;
    } 
}