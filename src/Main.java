import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);

        boolean finishPlay;
        do // this loop allows the game to repeat if the user indicates that they want to play again
        {
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int crapsRoll = die1 + die2;
            int point = 0;
            String playAgain = "";
            String YNResp = "";
            finishPlay = false;
            boolean validYN = false;


            System.out.println("You rolled " + die1 + " and " + die2 + " for a total of " + crapsRoll); // output to tell the user what they rolled and the sum of the roll
            if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12) // if the player initially rolls a 2, 3, or 12, the game ends with a loss
            {
                System.out.println("You crapped out. You lose"); // output to tell the user that they crapped out and lose the game
            }
            else if (crapsRoll == 7 || crapsRoll == 11) // if the player initially rolls a 7 or 11, the game ends with a win
            {
                System.out.println("You rolled a natural. You win."); // output to tell the user that they rolled a natural and win the game
            }
            else // if the user does not roll a 2, 3, 7, 11, or 12 on their first roll, the game continues with everything in the "else" block
            {
                point = crapsRoll; // this tells the program that point is now set at the sum of the first roll

                do // this loop will run until the game ends by the user making point to win or rolling a 7 to lose. If they roll any other number, the loop will run again to simulate rolling again
                {
                    System.out.println("Point is " + point + ". Roll a " + point + " to win or a 7 to lose"); // prompt to tell the user what is point and that they need to roll point to win or a 7 to lose
                    die1 = rnd.nextInt(6) + 1; // randomly generates an int between 1 and 6 for die 1. Important that we do this step again to generate new random numbers or a "new roll"
                    die2 = rnd.nextInt(6) + 1; // randomly generates an int between 1 and 6 for die 2. Important that we do this step again to generate new random numbers or a "new roll"
                    crapsRoll = die1 + die2; // calculates the sum of the roll by adding the two die together
                    System.out.println("You rolled " + die1 + " and " + die2 + " for a total of " + crapsRoll); // output to tell the user what they rolled
                }while (crapsRoll != 7 && crapsRoll != point); // the do loop will repeat until the user rolls point or a 7
                    if (crapsRoll == 7) // if the user rolls a total of 7, they lose
                    {
                        System.out.println("You rolled a 7. You lose"); // output to tell the user that they rolled a 7 and therefore, lose
                    }
                    else // we know that this can only be if the user rolls "point"
                    {
                        System.out.println("You made point. You win!"); // output to tell the user that they rolled "point" and therefore, win the game
                    }
                }

            do {
                System.out.print("Do you want to play again? [Y/N]: "); // prompt to ask the user if they want to play again
                playAgain = in.nextLine(); // user input is stored in playAgain
                if (playAgain.equalsIgnoreCase("Y") || playAgain.equalsIgnoreCase("N")) // if a valid response of Y or N is entered, the if block will run
                {
                    validYN = true; // a valid input was entered, so we move to the next step and do not need to loop back and repeat the prompt/input
                    YNResp = playAgain; // since we have a valid input, we can store the input in YNResp
                }
                else // if the user enters anything other than y or n when asked if they want to play again
                {
                    System.out.println("Must enter a valid response [Y/N]: " + playAgain); // output to tell the user that their input was invalid and echo their response back
                }
            }while(!validYN); // when we do not have a valid response to "do you want to play again?", we loop back to ask the user again

            if (YNResp.equalsIgnoreCase("N")) // if the user inputs N, finishPlay will be true and the program will not loop
            {
                finishPlay = true; //finishPlay is true if user enters N
            }
            else // we know that the user input must be Y, so we will run this else block to set ourselves up for a new game before the "do" loop runs again
            {
                System.out.println("\nNEW GAME"); // output to indicate that a new game is starting and start a new line
            }

        } while (!finishPlay); // if user enters "Y" when asked if they want to play again, the program will loop and the game will be replayed

    }
}
