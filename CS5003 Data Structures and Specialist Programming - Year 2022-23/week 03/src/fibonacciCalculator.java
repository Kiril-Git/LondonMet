import java.math.BigInteger;
import java.util.Scanner;

public class fibonacciCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for (int i = 0; i <= n; i++) {

            System.out.printf("Fibonacci of %d is: %d\n", i, fibonacci(BigInteger.valueOf(i)));

        }

    }

    private static BigInteger TWO = BigInteger.valueOf(2);
    public static BigInteger fibonacci(BigInteger num){

        if (num.equals(BigInteger.ZERO) ||
        num.equals(BigInteger.ONE)){
            return num;
        }
        else {
            return fibonacci(num.subtract(BigInteger.ONE))
                    .add(fibonacci(num.subtract(TWO)));
        }
    }
}
