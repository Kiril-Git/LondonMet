// Exercise 6.30 Solution: Guess.java
// Program plays guess the number.
import java.util.Random;
import java.util.Scanner;

public class test3

{
    private static final Random randomNumbers = new Random();
    private static int answer; // the answer to be guessed
    private static boolean gameOver = false; // whether the game is over

    // play games of guess the number
    public static void main( String args[] )
    {
        Scanner input = new Scanner( System.in );

        while ( !gameOver )
        {
            newGame(); // start a new game

            do
            {
                System.out.print( "Guess (1 - 1000): " );
                checkUserGuess( input.nextInt() );
            } while ( !gameOver );

            if ( gameOver )
            {
                System.out.print( "Play again (1=yes, 2=no)? " );
                int playAgain = input.nextInt();

                // if playAgain is 1, set gameOver back to false
                if ( playAgain == 1 )
                    gameOver = false;
            } // end if
        } // end while
    } // end main

    // create a new number to guess
    public static int getNumber()
    {
        return 1 + randomNumbers.nextInt( 1000 );
    } // end method getNumber

    // starts a new game
    public static void newGame()
    {
        answer = getNumber();
        System.out.println( "\nGuess a number between 1 and 1000" );
    } // end method newGame

    // checks user input
    public static void checkUserGuess( int userGuess )
    {
        if ( userGuess < answer )
            System.out.printf( "%d is too low. Try again.\n", userGuess );
        else if ( userGuess > answer )
            System.out.printf( "%d is too high. Try again.\n", userGuess );
        else
        {
            gameOver = true; // game is over
            System.out.println( "Congratulations. You guessed the number!\n" );
        } // end else
    } // end method checkUserGuess
} // end class Guess


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
