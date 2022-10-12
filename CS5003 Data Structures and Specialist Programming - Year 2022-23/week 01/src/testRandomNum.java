import java.util.Random;
import java.util.Scanner;

public class testRandomNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int min = 1;
        int max = 100;

//                      create instance of Random class

        Random randomNum = new Random();

        int showMe = min + randomNum.nextInt(max);

        System.out.println(showMe);

    }
}
