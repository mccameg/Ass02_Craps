import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);

        boolean again;
        do {
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int crapsRoll = die1 + die2;
            int point = 0;
            String playAgain = "";
            again = false;

            System.out.println("You rolled " + die1 + " and " + die2 + " for a total of " + crapsRoll);
            if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12)
            {
                System.out.println("You crapped out. You lose");
            }
            else if (crapsRoll == 7 || crapsRoll == 11)
            {
                System.out.println("You rolled a natural. You win.");
            }
            else
            {
                point = crapsRoll;

                do
                {
                    System.out.println("Point is " + point + ". Roll a " + point + " to win or a 7 to lose");
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    crapsRoll = die1 + die2;
                    System.out.println("You rolled " + die1 + " and " + die2 + " for a total of " + crapsRoll);
                }while (crapsRoll != 7 && crapsRoll != point);
                if (crapsRoll == 7)
                {
                    System.out.println("You rolled a 7. You lose");
                }
                else
                {
                    System.out.println("You made point. You win!");
                }
            }

            System.out.print("Do you want to play again? [Y/N]: ");
            playAgain = in.nextLine();
            if (playAgain.equalsIgnoreCase("Y"))
            {
                again = true;
                System.out.println(" ");
            }
        } while (again);

    }
}
