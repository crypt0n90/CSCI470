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
import java.util.*;
// Declaration of class MileRedeemer.
public class MileRedeemer
{
 // create an ArrayList of type Destination called destinationList.
 ArrayList<Destination> destinationList = new ArrayList<Destination>();
 // Initialize remainingMiles to 0.
 static int remainingMiles = 0;
/*readDestination() method read and parses the destination data into an array of Destination objects, which should then be sorted by their normal mileage.*/
public void readDestinations(Scanner fileScanner)
{
/*while there is data in the file, put each city and field on a line, separating them by the semicolon(“;�?) delimeter. */
while(fileScanner.hasNextLine())
{
 String line = fileScanner.nextLine();  // Put the next line into  line.
 // Split fields by semicolon delimeter.
String[] splitedStr = line.split(";");
// Create a destination object dest and put each field in an array element.
Destination dest = new Destination( splitedStr[0], splitedStr[1], splitedStr[2], splitedStr[3], splitedStr[4]);
 /* create a new object.
 call add passing it dest – Adding it to the list. */
 destinationList.add(dest);
 }
}
/* getCityNames() method loops through the array of Destination objects and creates an array of String objects from the city names. */
public String[] getCityNames()
{
 /* Create an array of type Destination called destinationArray.
     Convert the ArrayList destinationList to an array. 
     Create a Destination array the size of destinationList. */
 Destination[] destinationArray = (Destination[]) destinationList.toArray(new   
Destination[destinationList.size()]);
 // Create a String array, cities of size dstinationList.
  String cities[] = new String[destinationList.size()];
 // Loop the contents of the array destinationArray into array cities.
  for ( int i = 0; i< destinationArray.length; i++)
  {
 // Load contents of destinationArray into cities by calling method getCity.
  cities[i] = destinationArray[i].getCity();
  }
 // Call Array class method sort, passing it cities.
  Arrays.sort(cities);
 // Return the String array containing destination cities.
  return cities;
 }
 /* redeemMiles() returns an array of String objects containing descriptions of redeemed tickets to be printed out by the main program. Also saves the miles remaining after the tickets have been redeemed. */
 public String[] reedemMiles(int miles, int month)
 {
  // call the sort method for destinationList, passing it MileageComparator.
  destinationList.sort(new MileageComparator());
  // Set i equal to 0.
  int i =0;
  // set remainingMiles equal to miles.
  remainingMiles = miles;
  // create a String array results of size of destinationList.
  String[] results = new String[destinationList.size()];
  // advanced for loop – for each destination of list destinationList.
  for (Destination eachDestination : destinationList)
  {
  // check the month range for each destination.
if (eachDestination.getbeginMonth() <= month && eachDestination.getendMonth() >= month)
{
  // If cheapMilesm are less than remainingMiles,
  if (eachDestination.getCheapMiles() < remainingMiles)
  {
  // subtract them from remainingMiles and apply them – select destination.
  remainingMiles = remainingMiles - eachDestination.getCheapMiles();
  // Put the selected destination in array results( Economy class flight).
  results[i] = " A trip to " + eachDestination.getCity() + " in Economy Class";
  // if remainingMiles are greater than additionalMiles, traveler can upgrade.
  if (remainingMiles > eachDestination.getAdditionalMile())
  {
/*Subtract additionalMiles and apply them – select destination, upgrading traveler to First Class. */
remainingMiles = eachDestination.getAdditionalMile();
// Put the selected destination in array results (First Class Flight).
results[i] = " * A trip to "+ eachDestination.getCity() + "in First Class";
  }
 }
}
 // If NormalMiles are less than remainingMiles,
      
        else if (eachDestination.getNormalMiles() < remainingMiles)
       {
          // apply remaining miles and tell traveler where he/she is going.
          // Store selection in array results.
       
             results[i] = "* A trip to " + eachDestination.getCity() + " in Economy Class";
          // Subtract NormalMiles of the destination from remainingMiles.
             
             remainingMiles-= eachDestination.getNormalMiles();                           
          // If remainingMiles are greater than AdditionalMiles,
         
             if (remainingMiles > eachDestination.getAdditionalMile())
             {
              // subtract AdditionalMiles from remainingMiles.
            
                  remainingMiles-= eachDestination.getAdditionalMile();
                // Put the selected destination in array results (this is for a First Class flight).
                  
                  results[i] = "* A trip to " + eachDestination.getCity() + " in First Class";

             }
       }
                
               // Increment i.
      
               i++;

   }                            
               // Return results.
    
        return results;
}
 // getRemainingMiles returns the saved remaining miles.
 public int getRemainingMiles()
                  {
                            // Return the saved remaining miles.
   
                            return remainingMiles;
                   }
}