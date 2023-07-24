package Monopoly.java;


import java.util.*;


public class Player  {

    String name;
    ArrayList <String> boughtProp;
    int position=0;
    int wallet =1500;

    Player(String name){

        this.name = name;
        this.boughtProp = new ArrayList<String>();
    } 
}