import java.math.BigInteger;
import java.util.Scanner;

public class factorialCalculator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for (int i = 0; i <= n; i++) {
            System.out.printf("%d! = %d\n", i, factorial(BigInteger.valueOf(i)));
        }


    }
    public static BigInteger factorial(BigInteger num){
        if (num.compareTo(BigInteger.ONE) <= 0){
            return  BigInteger.ONE;
        }
        else {
            return num.multiply(factorial(num.subtract(BigInteger.ONE)));
        }
    }
}
