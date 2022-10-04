import java.util.Scanner;

public class calculatorBMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your weight in kg bellow: ↓");
        double kg = scanner.nextDouble();

        System.out.println("Please enter your height in meters bellow: ↓");
        double m = scanner.nextDouble();

        double bmi = kg / Math.pow(m, 2);

        if (bmi < 18.5) {
            System.out.printf("Underweight: %.2f", bmi);
        }
        else if (bmi < 25) {
            System.out.printf("Normal:  %.2f", bmi);
        }
        else if (bmi < 30) {
            System.out.printf("Overweight:  %.2f", bmi);
        }
        else if (bmi >= 30) {
            System.out.printf("Obese:  %.2f", bmi);
        }
        else {
            System.out.println();
        }

    }
}
