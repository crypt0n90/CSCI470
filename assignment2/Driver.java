/************************************************************
 *                                                          *
 *  CSCI 470-1/502-1       Assignment 2        Summer 2020  *
 *                                                          *
 *  Class Name:  Driver                                     *
 *                                                          *
 *  Programmer:  Adam Page z1859276                         *
 *                                                          *
 *  Purpose:  Invoice class that a hardware store might     *
 *            use to represent items sold at an store       *                                      
 ************************************************************/
import java.text.DecimalFormat;

//Driver class to test the app
public class Driver 
{
/************************************************************
 *                                                          *
 *  Method Name:  main               *
 *                                                          *
 *  Purpose: Create 5 different hardware items give value   *
 *           quality and price and part number.             *
 *                                                          *
 ************************************************************/
 //Main method
 public static void main(String[] args) 
 {
  //create 5 different items
  Hardware[] items = new Hardware[5];
  items[0] = new Hardware(1, "Hammer", 20, 145.6);
  items[1] = new Hardware(2, "Screwdriver", 4, 20);
  items[2] = new Hardware(3, "Light switch", 10, 5.99);
  items[3] = new Hardware(4, "Cordless Drill", 2, 150.5);
  items[4] = new Hardware(5, "Carpenter's square", 4, 10.49);
  //print all the invoices
  for(int i = 0; i < items.length; i++) 
  {
   String str = "Item: "+String.format("%-20s", items[i].getDescription())+"Part Num: "+items[i].getPartNumber()+
     "\tQuantity: "+items[i].getQuantity();
   //create a DecimalFormat object to format for both the price and the invoice
   DecimalFormat df = new DecimalFormat("##,###,###.00");
   str += "\tPrice: $"+df.format(items[i].getPrice())+"\tInvoice: "+df.format(items[i].getInvoiceAmount());
   //print the info
   System.out.println(str);
  }
 }
}
