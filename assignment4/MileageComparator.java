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
import java.util.Comparator;
/* Object of a class that defines the ordering
 class MileageComparator implements a Comparator of type Destination. */
public class MileageComparator implements Comparator<Destination>
 {
  // compare Destination objects d1 and d2.
  public int compare(Destination d1, Destination d2)
  {
 // return the difference of the distances between Destination objects d1 and d2.
   return(d2.getNormalMiles() - d1.getNormalMiles());
    }
 }