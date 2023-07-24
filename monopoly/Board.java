package Monopoly.java;

import java.util.*;
//maintains the turn system
class Board implements Runnable {
    int playerNo;
    int turn;
    Player player;
    static ArrayList <Player> players = new ArrayList<Player>();
   

    Board(int playerNo,int turn, Player player) {

            this.playerNo = playerNo;
            this.player = player;
            this.turn = turn;
           
    }

    public void run()
    {
        try { 
        	
        	while(true) {
            // turn=0;
            while(State.game_turn != turn) {
                Thread.sleep(5000); // time for sleep???
            }
            
                // Logic of the player
                Bank.setCards();
                
                // roll dice and move player
                Dice dice = new Dice();
                int move = dice.roll();

                player.position += move;
                System.out.println(player.name + " rolled " + move);
                if(player.position>=28){

                    player.position-=28; // to keep position less than 28
                    player.wallet +=200; // money added for passing GO
                }


                // player landing on square

                System.out.println(player.name + " has landed on " + Bank.tickets.get(player.position).name);

                
                //land on ticket square
                if(Bank.tickets.get(player.position).ticket){

                    if(player.wallet >= Bank.tickets.get(player.position).price && Bank.tickets.get(player.position).available == true ){

                        System.out.println(player.name + " has bought "+ Bank.tickets.get(player.position).name + " for " + Bank.tickets.get(player.position).price);
                        
                        // remove bought property from available properties list
                        Bank.tickets.get(player.position).available = false; 
                        
                        player.boughtProp.add(Bank.tickets.get(player.position).name);              
    
                        player.wallet -= Bank.tickets.get(player.position).price;
    
    
                    }
                    else if (player.wallet < Bank.tickets.get(player.position).price && Bank.tickets.get(player.position).available == true){
    
                        System.out.println(player.name + " does not have enough money to buy. ");
                    }
                    else if(Bank.tickets.get(player.position).available == false){
    
                        // pay rent ( rent = 5% of buy price)
                    	System.out.println(Bank.tickets.get(player.position).name + " is already owned.");
                    	System.out.println(player.name + " pays rent of " + 0.05* Bank.tickets.get(player.position).price);
                        player.wallet -= (0.05* Bank.tickets.get(player.position).price);
                        
    
                    }

                }
                // land on special square
                else{

                    
                    //Community Chest or Chance
                    if(player.position==2 || player.position==16 || player.position==12 || player.position==23){
                    	
                    	System.out.println(player.name + " picks a card.");
                    	
                    	Card buffer = Bank.commCards.pop();
                    	System.out.println(player.name + " receives "+ buffer.name);
                    	
                    	if(buffer.name == "Income Tax") {
                    		
                    		System.out.println(player.name + " pays 100. ");
                    		player.wallet-=100;
                    	}
                    	
                    	else if(buffer.name == "Go to Jail") {
                    		
                    		player.position=14;
                    	}
                    	
                    	else if(buffer.name == "Won a beauty contest") {
                    		
                    		System.out.println(player.name + " wins 100. ");
                    		player.wallet+=100;
                    	}
                    	else if(buffer.name == "Advance to GO") {
                    		
                    		System.out.println(player.name + " advances to GO ");
                    		player.position =0;
                    	}
                    	else if(buffer.name == "Pay hospital") {
                    		
                    		System.out.println(player.name + " pays 150. ");
                    		player.wallet-=150;
                    	}
                    
                    	Random rand = new Random();
                    	int ind = rand.nextInt(5);
                    	
                    	Bank.commCards.add(ind,buffer);

                    }

                    //Jail/Visiting Jail
                    else if(player.position==7){
                    	System.out.println(player.name + " visits Jail.");

                    }

                    // Go To Jail
                    else if(player.position==14){

                        player.position = 7;
                        System.out.println(player.name + " goes to Jail.");
                        System.out.println(player.name + " pays bail of 200");
                        player.wallet-=200;

                    }
                    // GO or Free Parking 
                    else if(player.position ==0 || player.position==14){
                    	
                    	System.out.println(player.name + " waits at " + Bank.tickets.get(player.position).name);

                    }
                }
                
                System.out.println(player.name + " turn ended. ");
                State.game_turn++;
                
                if(State.game_turn == playerNo) {
                	System.out.println(" ");
                  	 System.out.println("Game State: ");
                     for(int i=0;i<playerNo;i++){
             	   
                          System.out.println(players.get(i).name + "  " + Bank.tickets.get(players.get(i).position).name + "  " + players.get(i).wallet + "  " + players.get(i).boughtProp);
                          
                       }
                       System.out.println(" ");
                       State.game_turn++;
                   }
        
                if(State.game_turn>playerNo){
                    State.game_turn-=(playerNo +1);
                } 
     
       }
        }
        catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception while creating thread" + e);
        }
        
    }
}