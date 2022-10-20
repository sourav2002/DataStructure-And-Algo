/* Program: It Prints Floyd's triangle based on user inputs
 * Written by: Chaitanya from beginnersbook.com
 * Input: Number of rows
 * output: floyd's triangle*/
import java.util.Scanner;
class FloydTriangleExample
{
    public static void main(String args[])
    {
       int rows, number = 1, counter, j;
       //To get the user's input
       Scanner input = new Scanner(System.in);
       System.out.println("Enter the number of rows for floyd's triangle:");
       //Copying user input into an integer variable named rows
       rows = input.nextInt();
       System.out.println("Floyd's triangle");
       System.out.println("****************");
       for ( counter = 1 ; counter <= rows ; counter++ )
       {
           for ( j = 1 ; j <= counter ; j++ )
           {
                System.out.print(number+" ");
                //Incrementing the number value
                number++;
           }
           //For new line
           System.out.println();
       }
   }
}