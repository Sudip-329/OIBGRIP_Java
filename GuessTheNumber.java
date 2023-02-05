//Name : Sudip Chakrabarty

import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber{
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            Random random = new Random();
            int score=0;
            int round=1;
            int maxRounds=3;
            int maxAttempts = 0; // number of attempts per round

            System.out.println("                                 !!! Welcome to the Guessing Game. !!!");

            while (round <= maxRounds) {    //valid rounds

                System.out.println("Enter level (Hard or Easy). For Hard enter -->1 and for Easy enter --> 0");
                int level = input.nextInt();    //For selecting game level.
                if(level==1)
                {
                    maxAttempts = 5;
                }
                else if(level==0){
                    maxAttempts = 10;
                }
                else
                {
                   System.out.print("Invalid Input.");
                   break; 
                }

                int systemchoice = random.nextInt(100)+1;  //To Generate a random number between 1 to 100.
                int attempts = 0;
                System.out.println("Round " + round + ":\nI have picked a number between 1 and 100. Can you guess the number?");
                while (attempts < maxAttempts) {
                    System.out.print("Enter your guess: ");
                    int guess = input.nextInt();
                    attempts++;
                    if (guess == systemchoice) {
                        System.out.println("\nPerfact Guess! You took " + attempts + " attempts.");
                        int roundScore = maxAttempts - attempts + 1;
                        System.out.println("You earned " + roundScore + " points in this round.\n");                       
                        score += roundScore;
                        break;
                    }
                    else{
                        System.out.println("\nIncorrect. You have " + (maxAttempts - attempts) + " attempts left.");
                        if((maxAttempts-attempts)==0)
                        {
                            System.out.println("You failed to guess the number. The system choice was " + systemchoice + ".");
                            continue;
                        }
                        if (guess < systemchoice) {
                            System.out.println("Too low. Guess again: \n");
                        } else {
                            System.out.println("Too high. Guess again: \n");
                        }
                    }
                    
                }
                if(round < maxRounds){
                System.out.println("Lets play another round.Be the highest scorrer!\n");
                }
                round++;
            }
            System.out.println("\nFINAL SCORE: " + score);
        }
    }
}