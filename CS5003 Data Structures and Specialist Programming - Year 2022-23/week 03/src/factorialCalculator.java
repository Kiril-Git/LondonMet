import java.util.Scanner;

public class factorialCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for (int i = 0; i <= n; i++) {
            System.out.printf("%d! = %d\n", i, factorial(i));
        }


    }
    public static long factorial(long num){
        if (num <= 1){
            return  1;
        }
        else {
            return num * factorial(num - 1);
        }
    }
}
