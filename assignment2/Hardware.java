/************************************************************
 *                                                          *
 *  CSCI 470-1/502-1       Assignment 2        Summer 2020  *
 *                                                          *
 *  Class Name:  Hardware                                   *
 *                                                          *
 *  Programmer:  Adam Page z1859276                         *
 *                                                          *
 *  Purpose:  Invoice class that a hardware store might     *
 *            use to represent items sold at an store       *                                      
 ************************************************************/
//Class Hardware
public class Hardware 
{
 
 //Fields of the class Hardware
 private int partNumber;
 private String description;
 private int quantity;
 private double price;
 
 //Constructor of the class with no arguments
 public Hardware() 
 {
  partNumber = -1;
  description = "";
  quantity = 0;
  price = 0;
 }
 
 //Constructor of the class with 4 arguments for 4 instance fields
 public Hardware(int partNumber, String description, int quantity, double price) 
 {
  this.partNumber = partNumber;
  this.description = description;
  this.quantity = quantity;
  this.price = price;
 }
 
 //Setters for all instance variables
 public void setPartNumber(int partNumber) 
 {
  this.partNumber = partNumber;
 }
 
 public void setDescription(String description) 
 {
  this.description = description;
 }
 
 public void setQuantity(int quantity) 
 {
  this.quantity = quantity;
 }
 
 public void setPrice(double price) 
 {
  this.price = price;
 }
 
 //Getters for all instance fields
 public int getPartNumber() 
 {
  return partNumber;
 }
 
 public String getDescription() 
 {
  return description;
 }
 
 public int getQuantity() 
 {
  return quantity;
 }
 
 public double getPrice() 
 {
  return price;
 }
 
 //Method that calculates the invoice amount
 public double getInvoiceAmount() 
 {
  //check if both quantity and price are positive
  if(quantity >= 0 && price >= 0) 
  {
   //If true, then return the product of quantity and price
   return quantity * price;
  } else 
  {
   //If false,return zero
   return 0;
  }
 }
}
