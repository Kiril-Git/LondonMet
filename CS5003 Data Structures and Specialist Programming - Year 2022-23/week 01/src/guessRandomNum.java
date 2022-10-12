import java.util.Random;
import java.util.Scanner;

public class guessRandomNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter an integer bellow between 1 and 1000: ↓");

        Random randomNum = new Random();
        int randomN = 1 + randomNum.nextInt(10);

        String input = scanner.nextLine();
        int userInput = Integer.parseInt(input);

        while (!input.equals("End!") || userInput != randomN){

            if (userInput > randomN){
                System.out.println("Too high. Try again.");
                System.out.println("Please enter another number: ↓");

            }
            else if (userInput < randomN){
                System.out.println("Too low. Try again.");
                System.out.println("Please enter another number: ↓");

            }
            else {
                System.out.println("Congratulations. You guessed the number!");
                System.out.println("Fancy another go?");
                System.out.println("If yes, pres 1, else pres 0.");
            }
            input = scanner.nextLine();

        }


        System.out.println();
    }
}
