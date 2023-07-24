package Monopoly.java;

import java.util.*;

public class Main {   
    public static void main(String[] args) {
        
        System.out.println("Enter the Number of Players: ");
        Bank.setProp();

         // Number of threads
        Scanner sc = new Scanner(System.in);
         int player_no = sc.nextInt();
         
         while(player_no >4 || player_no<2) {
        	 System.out.println("Please enter a number from 2 to 4");
        	 player_no= sc.nextInt();
         }
        sc.close();
        System.out.println("Game starting");
        //System.out.println("Created player array!");

        // Creating threads
         for (int i = 0; i < player_no; i++) {
        	 
        	 int j = i+1;

            Board.players.add(i,new Player("Player " + j));
   
            int turn =i;
            //System.out.println("creating threads");
            Thread object
                = new Thread(new Board( player_no, turn , Board.players.get(i)));
               object.start();
              
         }
         
       }
    }


