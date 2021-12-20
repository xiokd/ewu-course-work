package lab4.cscd210lab4;

import java.util.Scanner;
import java.text.DecimalFormat;

public class CSCD210Lab4
{

   /* Resident per credit undergrad and graduate */
   public static final double RESIDENT_INSTATE_PER_CREDIT = 218.09; 
   public static final double GRAD_RESIDENT_INSTATE_PER_CREDIT = 390.71;
   
   /* Resident ten to eighteen credits undergrad and graduate */
   public static final double RESIDENT_INSTATE_TEN_TO_EIGHTEEN_CREDITS = 2180.91;
   public static final double GRAD_RESIDENT_INSTATE_TEN_TO_EIGHTEEN_CREDITS = 3907.11; 
   
   /* Non-Resident per credits undergrad and graduate */
   public static final double NON_RESIDENT_PER_CREDIT = 802.46;
   public static final double GRAD_NON_RESIDENT_PER_CREDIT = 907.14;
   
   /* Non-Resident ten to eighteen credits undergrad and graduate */
   public static final double NON_RESIDENT_TEN_TO_EIGHTEEN_CREDITS = 8024.64;
   public static final double GRAD_NON_RESIDENT_TEN_TO_EIGHTEEN_CREDITS = 9071.39;
   
   /* Resident additonal credit fee per credit undergrad and graduate */
   public static final double RESIDENT_INSTATE_ADDITIONAL = 194.56;
   public static final double GRAD_RESIDENT_INSTATE_ADDITIONAL = 368.48;
   
   /* Non-Resident additonal credit fee per credit undergrad and graduate */
   public static final double NON_RESIDENT_ADDITIONAL = 779.43;
   public static final double GRAD_NON_RESIDENT_ADDITIONAL = 885.11;
   
   
   public static void main(String [] args)
   {
      char resident;
      int totalCredits;
      String graduateStudent = "";
      Scanner kb = new Scanner(System.in);
      double tuition, percentageIncrease, newPerCredit, newTuition;

      System.out.println("Welcome to the Tuition Calculator Program");
      System.out.print("How many total credits are you taking? ");
      totalCredits = kb.nextInt();
      
      /* Your code goes below, except the constant declarations go above */

      System.out.print("Are you a WA resident (Y/N)? ");
      resident = kb.next().charAt(0);
      kb.nextLine();
      
      System.out.print("Are you a graduate student (Yes/No)? ");
      graduateStudent = kb.nextLine();
      
      System.out.print("What percentage increase? ");
      percentageIncrease = kb.nextDouble();
      
      System.out.println("Results:\n ");
      
      DecimalFormat df = new DecimalFormat(".00");
      
      /* Converting percentage to decimal */
      double convertPercenttoDecimal = percentageIncrease / 100;
      
      /* Calcultion of additional credits */
      int additionalCredit = totalCredits - 18;
      
      /* Calculation of percentage per credit */
      double percentPerCreditUndRes = RESIDENT_INSTATE_PER_CREDIT * convertPercenttoDecimal;
      double percentPerCreditGradRes =  GRAD_RESIDENT_INSTATE_PER_CREDIT * convertPercenttoDecimal;
      double percentPerCreditUndNon =  NON_RESIDENT_PER_CREDIT * convertPercenttoDecimal;
      double percentPerCreditGradNon = GRAD_NON_RESIDENT_PER_CREDIT * convertPercenttoDecimal;
      
      /* Calculation for amount per credit with percentage  */
      double sumPerCreditUndRes = RESIDENT_INSTATE_PER_CREDIT + percentPerCreditUndRes;
      double sumPerCreditGradRes = GRAD_RESIDENT_INSTATE_PER_CREDIT + percentPerCreditGradRes;
      double sumPerCreditUndNon = NON_RESIDENT_PER_CREDIT + percentPerCreditUndNon;
      double sumPerCreditGradNon = GRAD_NON_RESIDENT_PER_CREDIT + percentPerCreditGradNon;
      
      /* Calculation for the amount of credits and user input amount credits */
      double sumCreditUndRes = totalCredits * RESIDENT_INSTATE_PER_CREDIT;
      double sumCreditGradRes = totalCredits * GRAD_RESIDENT_INSTATE_PER_CREDIT;
      double sumCreditUndNonRes = totalCredits * NON_RESIDENT_PER_CREDIT;
      double sumCreditGradNonRes = totalCredits * GRAD_NON_RESIDENT_PER_CREDIT;
      
      /* Calculation of percentage from original fee for user input amount credits */
      double percentSumCreditUndRes = sumCreditUndRes * convertPercenttoDecimal;
      double percentSumCreditGradRes = sumCreditGradRes * convertPercenttoDecimal;
      double percentSumCreditUndNon = sumCreditUndNonRes * convertPercenttoDecimal;
      double percentSumCreditGradNon = sumCreditGradNonRes * convertPercenttoDecimal;
      
      /* Calculation of percentage from original fee for ten to eighteen credits */
      double percentTentoEighteenUndRes = RESIDENT_INSTATE_TEN_TO_EIGHTEEN_CREDITS * convertPercenttoDecimal;
      double percentTentoEighteenGradRes = GRAD_RESIDENT_INSTATE_TEN_TO_EIGHTEEN_CREDITS * convertPercenttoDecimal; 
      double percentTentoEighteenUndNon = NON_RESIDENT_TEN_TO_EIGHTEEN_CREDITS * convertPercenttoDecimal; 
      double percentTentoEighteenGradNon = GRAD_NON_RESIDENT_TEN_TO_EIGHTEEN_CREDITS * convertPercenttoDecimal;
      
      /* Calculation of the sum of original fee for credits and percentage increase */
      double totalSumCreditUndRes = sumCreditUndRes + percentSumCreditUndRes;
      double totalSumCreditGradRes = sumCreditGradRes + percentSumCreditGradRes;
      double totalSumCreditUndNon = sumCreditUndNonRes + percentSumCreditUndNon;
      double totalSumCreditGradNon = sumCreditGradNonRes + percentSumCreditGradNon;
      
       /* Calculation of the sum of original fee for ten to eighteen credits and percentage increase */
      double totalTentoEighteenUndRes =  RESIDENT_INSTATE_TEN_TO_EIGHTEEN_CREDITS + percentTentoEighteenUndRes;
      double totalTentoEighteenGradRes = GRAD_RESIDENT_INSTATE_TEN_TO_EIGHTEEN_CREDITS + percentTentoEighteenGradRes;
      double totalTentoEighteenUndNon = NON_RESIDENT_TEN_TO_EIGHTEEN_CREDITS + percentTentoEighteenUndNon;
      double totalTentoEighteenGradNon = GRAD_NON_RESIDENT_TEN_TO_EIGHTEEN_CREDITS + percentTentoEighteenGradNon;
      
      /* Calculation for amount of additional credits with user input amount credits */
      double additionalCredUndRes = RESIDENT_INSTATE_ADDITIONAL * additionalCredit;
      double additionalCredGradRes =  GRAD_RESIDENT_INSTATE_ADDITIONAL * additionalCredit;
      double additionalCredUndNon =  NON_RESIDENT_ADDITIONAL * additionalCredit;
      double additionalCredGradNon =  GRAD_NON_RESIDENT_ADDITIONAL * additionalCredit;
      
      /* Calculation of percentage per additional credit */
      double percentAdditionalUndRes = RESIDENT_INSTATE_ADDITIONAL * convertPercenttoDecimal;
      double percentAdditionalGradRes = GRAD_RESIDENT_INSTATE_ADDITIONAL * convertPercenttoDecimal;
      double percentAdditionalUndNon = NON_RESIDENT_ADDITIONAL * convertPercenttoDecimal;
      double percentAdditionalGradNon = GRAD_NON_RESIDENT_ADDITIONAL * convertPercenttoDecimal;
      
      /* Calculation of original fee and percentage */
      double originalPercentAdditionUndRes = RESIDENT_INSTATE_ADDITIONAL + percentAdditionalUndRes;
      double originalPercentAdditionGradRes = GRAD_RESIDENT_INSTATE_ADDITIONAL + percentAdditionalGradRes;
      double originalPercentAdditionUndNon = NON_RESIDENT_ADDITIONAL + percentAdditionalUndNon;
      double originalPercentAdditionGradNon = GRAD_NON_RESIDENT_ADDITIONAL + percentAdditionalGradNon;
      
      /* Calculation of ten to eighteen and user input amount of additional credits */
      double tentoEighteenAdditionalUndRes = additionalCredUndRes + RESIDENT_INSTATE_TEN_TO_EIGHTEEN_CREDITS;
      double tentoEighteenAdditionalGradRes = additionalCredGradRes + GRAD_RESIDENT_INSTATE_TEN_TO_EIGHTEEN_CREDITS;
      double tentoEighteenAdditionalUndNon = additionalCredUndNon + NON_RESIDENT_TEN_TO_EIGHTEEN_CREDITS;
      double tentoEighteenAdditionalGradNon = additionalCredGradNon + GRAD_NON_RESIDENT_TEN_TO_EIGHTEEN_CREDITS;
      
      /* Calculation of ten to eighteen and user input amount of additional credits with the addition of percentage */
      double sumTotalAdditionalUndRes = (originalPercentAdditionUndRes * additionalCredit) + totalTentoEighteenUndRes;
      double sumTotalAdditonalGradRes = (originalPercentAdditionGradRes * additionalCredit) + totalTentoEighteenGradRes;
      double sumTotalAdditionalUndNon = (originalPercentAdditionUndNon * additionalCredit) + totalTentoEighteenUndNon;
      double sumTotalAdditionalGradNon = (originalPercentAdditionGradNon * additionalCredit) + totalTentoEighteenGradNon;
      

       
      if (totalCredits > 1 && totalCredits < 10) { 
            if (resident == 'y' || resident == 'Y') {
                  if (graduateStudent.equalsIgnoreCase("yes")) {
                         System.out.println("A graduate student taking " + totalCredits + " credits pays $" + GRAD_RESIDENT_INSTATE_PER_CREDIT + " per credit for a total of $" + df.format(sumCreditGradRes));
                         System.out.println("With an increase in tuition of " + percentageIncrease + "% per credit tuition goes up to $" + df.format(sumPerCreditGradRes) + " per credit for a total of $" +  df.format(totalSumCreditGradRes));
                  }
                  else if (graduateStudent.equalsIgnoreCase("no")) { 
                         System.out.println("An undergraduate student taking " + totalCredits + " credits pays $" + RESIDENT_INSTATE_PER_CREDIT + " per credit for a total of $" + df.format(sumCreditUndRes));
                         System.out.println("With an increase in tuition of " + percentageIncrease + "% per credit tuition goes up to $" + df.format(sumPerCreditUndRes) + " per credit for a total of $" +  df.format(totalSumCreditUndRes));
                  }
            }      
            else if (resident == 'n' || resident == 'N') { 
                  if (graduateStudent.equalsIgnoreCase("yes")) {
                        System.out.println("A non-resident graduate student taking " + totalCredits + " credits pays $" + GRAD_NON_RESIDENT_PER_CREDIT + " per credit for a total of $" + df.format(sumCreditGradNonRes));
                        System.out.println("With an increase in tuition of " + percentageIncrease + "% per credit tuition goes up to $" + df.format(sumPerCreditGradNon) + " per credit for a total of $" +  df.format(totalSumCreditGradNon));                  
                  }
                  else if (graduateStudent.equalsIgnoreCase("no")) {
                        System.out.println("A non-resident undergraduate student taking " + totalCredits + " credits pays $" + NON_RESIDENT_PER_CREDIT + " per credit for a total of $" + df.format(sumCreditUndNonRes));
                        System.out.println("With an increase in tuition of " + percentageIncrease + "% per credit tuition goes up to $" + df.format(sumPerCreditUndNon) + " per credit for a total of $" +  df.format(totalSumCreditUndNon));
                  }
             }
      }
      else if (totalCredits >= 10 && totalCredits <= 18) { 
            if (resident == 'y' || resident == 'Y') {
                  if (graduateStudent.equalsIgnoreCase("yes")) {
                         System.out.println("A graduate student taking " + totalCredits + " credits pays a fee of $" + GRAD_RESIDENT_INSTATE_TEN_TO_EIGHTEEN_CREDITS);
                         System.out.println("With an increase in tuition of " + percentageIncrease + "% the cost of tuition would be $" + df.format(totalTentoEighteenGradRes));
                  }
                  else if (graduateStudent.equalsIgnoreCase("no")) { 
                         System.out.println("An undergraduate student taking " + totalCredits + " credits pays a fee of $" + RESIDENT_INSTATE_TEN_TO_EIGHTEEN_CREDITS);
                         System.out.println("With an increase in tuition of " + percentageIncrease + "% the cost of tuition would be $" + df.format(totalTentoEighteenUndRes));
                  }
            }      
            else if (resident == 'n' || resident == 'N') { 
                  if (graduateStudent.equalsIgnoreCase("yes")) {
                        System.out.println("A non-resident graduate student taking " + totalCredits + " credits pays a fee of $" + GRAD_NON_RESIDENT_TEN_TO_EIGHTEEN_CREDITS);
                        System.out.println("With an increase in tuition of " + percentageIncrease + "% the cost of tuition would be $" + df.format(totalTentoEighteenGradNon));                  
                  }
                  else if (graduateStudent.equalsIgnoreCase("no")) {
                        System.out.println("An undergraduate student taking " + totalCredits + " credits pays a fee of $" + NON_RESIDENT_TEN_TO_EIGHTEEN_CREDITS);
                        System.out.println("With an increase in tuition of " + percentageIncrease + "% the cost of tuition would be $" + df.format(totalTentoEighteenUndNon));
                  }
             }
      }
      else if (totalCredits > 18 && totalCredits < 26) { 
            if (resident == 'y' || resident == 'Y') {
                  if (graduateStudent.equalsIgnoreCase("yes")) {
                         System.out.println("A graduate student taking " + totalCredits + " credits pays a fee of $" + GRAD_RESIDENT_INSTATE_TEN_TO_EIGHTEEN_CREDITS + " and an extra fee per credit of $" + GRAD_RESIDENT_INSTATE_ADDITIONAL + " for a total of $" + df.format(tentoEighteenAdditionalGradRes));
                         System.out.println("With an increase in tuition of " + percentageIncrease + "% the cost of tuition would be " + df.format(totalTentoEighteenGradRes) + " and an extra fee per credit of $" + df.format(originalPercentAdditionGradRes) + " for a total of $" + df.format(sumTotalAdditonalGradRes));

                  }
                  else if (graduateStudent.equalsIgnoreCase("no")) { 
                         System.out.println("An undergraduate student taking " + totalCredits + " credits pays a fee of $" + RESIDENT_INSTATE_TEN_TO_EIGHTEEN_CREDITS + " and an extra fee per credit of $" + RESIDENT_INSTATE_ADDITIONAL + " for a total of $" + df.format(tentoEighteenAdditionalUndRes));
                         System.out.println("With an increase in tuition of " + percentageIncrease + "% the cost of tuition would be " + df.format(totalTentoEighteenUndRes) + " and an extra fee per credit of " + df.format(originalPercentAdditionUndRes) + " for a total of " + df.format(sumTotalAdditionalUndRes));                  }
            }      
            else if (resident == 'n' || resident == 'N') { 
                  if (graduateStudent.equalsIgnoreCase("yes")) {
                        System.out.println("A graduate student taking " + totalCredits + " credits pays a fee of $" + GRAD_NON_RESIDENT_TEN_TO_EIGHTEEN_CREDITS + " and an extra fee per credit of $" + GRAD_NON_RESIDENT_ADDITIONAL + " for a total of $" + df.format(tentoEighteenAdditionalGradNon));
                         System.out.println("With an increase in tuition of " + percentageIncrease + "% the cost of tuition would be $" + df.format(totalTentoEighteenGradNon) + " and an extra fee per credit of $" + df.format(originalPercentAdditionGradNon) + " for a total of $" + df.format(sumTotalAdditionalGradNon));                  
                  }
                  else if (graduateStudent.equalsIgnoreCase("no")) {
                         System.out.println("An undergraduate student taking " + totalCredits + " credits pays a fee of $" + RESIDENT_INSTATE_TEN_TO_EIGHTEEN_CREDITS + " and an extra fee per credit of $" + RESIDENT_INSTATE_ADDITIONAL + " for a total of $" + df.format(tentoEighteenAdditionalUndNon));
                         System.out.println("With an increase in tuition of " + percentageIncrease + "% the cost of tuition would be $" + df.format(totalTentoEighteenUndNon) + " and an extra fee per credit of $" + df.format(originalPercentAdditionUndNon) + " for a total of $" + df.format(sumTotalAdditionalUndNon));
                  }
             }
      }
      else if (totalCredits < 1 || totalCredits > 25) {
            throw new RuntimeException("Credits cannot be 0 or negative or greater than 25");
      }           
      
      
   }// end main
   
}// end class