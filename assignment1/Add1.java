

    import java.util.Scanner;
    /********************************************************************
     *                                                                  *
     *  CSCI 470-1/502-1       In-Class Exercise 0         Summer 2019  *
     *                               Part 1                             *
     *                                                                  *
     *  Class Name:  Add1                                               *
     *                                                                  *
     *  Programmer:  Your name goes here.                               *
     *               (If you're working in a team, list                 *
     *               names of each team member here with                *
     *               Z-IDs and the team lead's name first.)             *
     *                                                                  *
     *  Purpose:     A console program that adds two numbers and        *
     *               displays the result.                               *
     *                                                                  *
     ********************************************************************/

    public class Add1
    {
        public static void main(String[] args)
        {
            String amountStr;
            double num1, num2;

            Scanner sc = new Scanner(System.in);

            // Read the first number as a String.

            System.out.println("Enter the first number: ");
            amountStr = sc.next();

            // Try to convert String to double for calculation.

            try
            {
                num1 = Double.parseDouble(amountStr);
            }
            catch (NumberFormatException nfe1)
            {
                System.out.println("1st number invalid.");
                return;
            }

            // Read the second number as a String.

            System.out.println("Enter the second number: ");
            amountStr = sc.next();

            // Try to convert String to double for calculation.

            try
            {
                num2 = Double.parseDouble(amountStr);
            }
            catch (NumberFormatException nfe1)
            {
                System.out.println("2nd number invalid.");
                return;
            }

            // Compute and print the sum.

            System.out.printf("Sum is: %.2f\n", num1 + num2);
        }
    }

