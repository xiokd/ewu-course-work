package lab3.cscd210lab3;

import java.util.Scanner;

public class CSCD210Lab3
{

   public static void main(String [] args)
   {
   
      int beginningMeterValue, endingMeterValue;
      char customerCode;
      
      Scanner kb = new Scanner(System.in);
      
      System.out.print("Please enter the beginning meter value ");
      beginningMeterValue = kb.nextInt();
      
      /* 
         Your code goes below
         1) Prompt for ending meter value
         2) Read in the ending meter value
         3) Prompt for the customer code
         4) Read in the customer code.  NOTE: There is no nextChar in Scanner.  You will 
            need to read the value as a String and then using the String class methods pull
            out the char that is at position 0.
         5) Calculate bill
         6) Display results
      */
        
        System.out.print("Please enter the ending meter value ");
        endingMeterValue = kb.nextInt();
        
        kb.nextLine();
        
        System.out.print("Please enter the customer code ");
        String customerC = kb.nextLine();
        
        customerCode = customerC.charAt(0);
        
        int meterMath = endingMeterValue - beginningMeterValue;
        
        double resMath = 15.00 + (meterMath * 0.0005);
        double comMath = 1000.00 + (meterMath * 0.00002);
        double indMath1 = 1000.00 + (meterMath * 0.00002);
        double indMath2 = 2000.00 + (meterMath * 0.00001);
        double indMath3 =  2500.00 + (meterMath * 0.0025);
        
        if (customerCode == 'r' || customerCode == 'R') {
            System.out.println("Customer code: " + customerCode);
            System.out.println("Meter beginning reading: " + beginningMeterValue);
            System.out.println("Meter ending reading: " + endingMeterValue);
            System.out.println("Gallons of water used by customer: " + meterMath);
            System.out.printf("Amount billed to customer: $%.2f\n", resMath);
            }
              
        else if (customerCode == 'c' || customerCode == 'C') {
               System.out.println("Customer code: " + customerCode);
               System.out.println("Meter beginning reading: " + beginningMeterValue);
               System.out.println("Meter ending reading: " + endingMeterValue);
               System.out.println("Gallons of water used by customer: " + meterMath);
               System.out.printf("Amount billed to customer: $%.2f\n", comMath);
               }
               
        else if (customerCode == 'i' || customerCode == 'I') {
            if (meterMath <= 4000000) {
               System.out.println("Customer code: " + customerCode);
               System.out.println("Meter beginning reading: " + beginningMeterValue);
               System.out.println("Meter ending reading: " + endingMeterValue);
               System.out.println("Gallons of water used by customer: " + meterMath);
               System.out.printf("Amount billed to customer: $%.2f\n", indMath1);
               }
            else if (meterMath > 4000000 && meterMath < 10000000) {
               System.out.println("Customer code: " + customerCode);
               System.out.println("Meter beginning reading: " + beginningMeterValue);
               System.out.println("Meter ending reading: " + endingMeterValue);
               System.out.println("Gallons of water used by customer: " + meterMath);
               System.out.printf("Amount billed to customer: $%.2f\n", indMath2);
               }
            else if (meterMath > 10000000) {
               System.out.println("Customer code: " + customerCode);
               System.out.println("Meter beginning reading: " + beginningMeterValue);
               System.out.println("Meter ending reading: " + endingMeterValue);
               System.out.println("Gallons of water used by customer: " + meterMath);
               System.out.printf("Amount billed to customer: $%.2f\n", indMath3);
               }
              
              }       

   
   
   }// end main

}// end class