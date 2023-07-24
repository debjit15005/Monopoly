package Monopoly.java;


import java.util.Random;

public class Dice {

    int sum;

    public int roll() {
        Random random = new Random(); 
        // since nextInt() returns no. from 0 to 11(not including 11), we add 2 
        // so that sum will be random no. bw 2 and 12
        sum = random.nextInt(11) + 2; 
        return sum;
    }
}
