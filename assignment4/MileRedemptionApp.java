/************************************************************
 *                                                          *
 *  CSCI 470-1/502-1       Assignment 4        Summer 2020  *
 *                                                          *
 *  Class Name:  Java Summer 2020                           *
 *                                                          *
 *  Programmer:  Adam Page z1859276                         *
 *  Purpose:  Destination console program                   *
 *                                                          *
 ************************************************************/
import java.util.Scanner;
import java.util.*; // This is for the input/ouput
import java.io.File;
import java.io.IOException;
// Declaration of class MileRedemptionApp
public class MileRedemptionApp
{

// main - if file not found, throw an exception
     public static void main(String[] args) throws IOException
     {
             // Create a scanner object for file.
    
             Scanner keyScan = new Scanner( System.in ) ;
           
            // File paths
            // File text = new File("C:/archive/destination.txt");
            // File text = new File("C:/JavaAirlines/destination.txt");
                           
            // Prompt user to enter file name.
           
             System.out.print("Please enter the name of the file: ");
            // Accept the file.
           
             String fileName = keyScan.next( );
            // Create a new File object.
           
             File text = new File(fileName);
            // Create another Scanner object fileScan.
           
             Scanner fileScan = new Scanner(text);
            // Print a border and label that welcomes user to the application.
             System.out.println("-------------------------------------------------");
             System.out.println("WELCOME TO THE JAVA AIRLINES FREQUENT FLYERS MILES REDEMPTION APP");
             System.out.println("-------------------------------------------------");
             System.out.println(" ");
           
             // Show user what cities he/she can travel to.
             System.out.println("List of destination cities you can travel to: ");
             
             // Create a MileRedeemer object MR.
           
             MileRedeemer MR = new MileRedeemer();
             // Call method readDestinations, passing it fileScan.
           
             MR.readDestinations(fileScan);
             // Call method getCityNames and put cities into a String array.
           
             String cities[] = MR.getCityNames();
             System.out.println(" ");
           
             // Print however many cities there are in the array cities.
             for (int i = 0; i < cities.length; i++)
             {
                  // Print cities.
            
                  System.out.println(cities[i]);
             }
                          
             // If user answers yes
           
             char answer = 'Y';
           
             // Create a new Scanner object scMiles.
             Scanner scMiles = new Scanner( System.in );
             // Create a new Scanner object scAnswer.
           
             Scanner scAnswer = new Scanner( System.in ) ;
             // Create a new Scanner object scMonth.
           
             Scanner scMonth = new Scanner( System.in );
                           
              do
              {
                   System.out.println(" ");
                   // Prompt user for accumulated Frequent Flyer Miles.        

                   System.out.print("Please enter your accumulated Frequent Flyer Miles: ");
                   // Accept miles.
                 
                   int miles = scMiles.nextInt( );    
                   System.out.println(" ");
                 
                   // Prompt user to enter month of departure.
                   System.out.print("Please enter your month of departure (1-12): ");
                   // Accept month of departure.
                 
                   int month = scMonth.nextInt( );
                   System.out.println(" ");
                 
                   // Tell user what he/she can redeem with miles.
                   System.out.println("Your Frequent Flyer Miles can be used to redeem the following tickets:");
                   System.out.println(" ");
                 
                   // Call method redeeMiles, passing it miles and month.
                   // Store results in array results.
                 
                   String results[] = MR.reedemMiles(miles, month);
                   // Print the results of array results.
                 
                   for (int i = 0; i < results.length; i++)
                   {    
                         // If element is not null,
                  
                         if (results[i] != null)
                         {
                       
                         // print results[i].
                         
                         System.out.println(results[i]);
                       
                      }
                         
                   }
                  // Call method redeemMiles, passing it miles and month.         
                  MR.reedemMiles(miles, month);
                  System.out.println(" ");
                
                  // Show remaining Frequent Flyer Miles.
                  System.out.println("Your remaining Frequent Flyer Miles: " + MR.getRemainingMiles());
                  // Ask user if he/she would like to continue with application.
                
                  System.out.print("Do you want to continue (y/n)? ");
                  // Accept an answer of 'y' or 'n' for yes or no, respectively.
                 
                  answer=scAnswer.next().charAt(0);
                 // The application will continue until the user decides to stop.
               } while (answer != 'n');
                 // Close fileScan.
            
                 fileScan.close();
                 // Close keyScan.
               
                 keyScan.close();
                 // Close scAnswer.
               
                 scAnswer.close();
                 // Close scMiles.
               
                 scMiles.close();

                 // Close scMonth.
                
                 scMonth.close();
               
                 // Print a border and a label that thanks traveler for using the application.
                 System.out.println("------------------------------------------------------------");
                 System.out.println("THANK YOU FOR USING THE JAVA AIRLINES FREQUENT FLYERS MILES REDEMPTION APP!");
                 System.out.println("------------------------------------------------------------");
               }

}