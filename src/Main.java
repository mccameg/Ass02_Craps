import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rnd = new Random();

        int die1 = rnd.nextInt(6)+1;
        int die2 = rnd.nextInt(6)+1;
        int crapsRoll = die1 + die2;

        
    }
}
