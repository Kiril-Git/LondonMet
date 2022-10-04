// Exercise 2.33 Solution: BMICalculator.java
// Calculate and display the user's body mass index.
import java.util.Scanner;

public class test
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );
        int weight; // weight in pounds
        int height; // height in inches
        int bmi; // user's body mass index

        // obtain weight in pounds and height in inches
        System.out.println( "Welcome to the body mass index (BMI) calculator" );
        System.out.print( "Enter your weight in pounds: " );
        weight = input.nextInt();
        System.out.print( "Enter your height in inches: " );
        height = input.nextInt();

        // calculate BMI
        bmi = ( weight * 703 ) / ( height * height );

        // display results
        System.out.printf( "Your BMI is: %d\n\n", bmi );
        System.out.println( "BMI VALUES" );
        System.out.println( "Underweight: less than 18.5" );
        System.out.println( "Normal:      between 18.5 and 24.9" );
        System.out.println( "Overweight:  between 25 and 29.9" );
        System.out.println( "Obese:       30 or greater" );
    } // end main
} // end class BMICalculator


/**************************************************************************
 * (C) Copyright 1992-2012 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
