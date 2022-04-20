package lab9.cscd211classes;

import java.util.*;
import lab9.cscd211interfaces.*;
import lab9.cscd211classes.players.*;

/**
 * The Team class that defines the information about a team.
 */
public class Team implements Taxable, Payroll, Comparable<Team> {
   protected String city;
   protected String teamName;
   protected int payroll;
   protected ArrayList<Player> players;

   public Team(final String city, final String teamName, final Player[] players) throws CloneNotSupportedException {
      if(city == null || teamName == null || players == null || players.length <= 0) {
         throw new IllegalArgumentException("Parameters Team null or array length is less or equal to 0");
      }
      this.city = city;
      this.teamName = teamName;
      this.players = new ArrayList<Player>();
      for(int i = 0; i < players.length; i++) {
         this.players.add(players[i].clone());
      } // Fill ArrayList with elements from the Object array
   }

   public String getTeamName() {
      return this.teamName;
   }

   public ArrayList<Player> getPlayers() {
      return this.players;
   }

   public String getCity() {
      return this.city;
   }

   public int getPayroll() {
      return this.calculatePayroll();
   }

   @Override
   public String toString() {
      String cityTeam = this.city + " - " + this.teamName;
      String payRoll = "Payroll: " + String.valueOf(this.getPayroll());
      String teamTax = "Taxes: "+ String.valueOf(Double.valueOf(this.calculateTaxes()));
      String playerStat = "PLAYER NAME       SSN         SALARY         POSITION       STATS       NUMBER";
      String displayDivider = "-------------------------------------------------------------------------------";
      String playerList = "";
      for(int i = 0; i < this.players.size(); i++) {
         playerList = playerList + this.players.get(i) + "\n";
      }
      String completeString = cityTeam + "\n"+ payRoll + "\n" + teamTax + "\n\n" + playerStat +"\n" + displayDivider + "\n" + playerList + "\n";
      return completeString;
   }

   public double calculateTaxes() {
      int taxCheck;
      double taxAmount = 0, taxTotal = 0;

      for(int i = 0; i < this.players.size(); i++) {
         taxCheck =  this.players.get(i).getSalary();

         if(taxCheck > 250000) {
            taxAmount = taxCheck * BASE_TAX_RATE;
         }

         else if(taxCheck <= 250000) {
            taxAmount = taxCheck * (BASE_TAX_RATE - .1);
         }
         taxTotal = taxTotal + taxAmount;
      }
      return taxTotal;
   }

   public int calculatePayroll() {
      int payrollTemp = 0, cxalcPayroll = 0;
      for(int i = 0; i < this.players.size(); i++) {
         payrollTemp = payrollTemp + this.players.get(i).getSalary();
      }
      calcPayroll = payrollTemp + BASE_PAYROLL;
      return calcPayroll;
   }

   public int compareTo(Team pi) {
      if(pi == null) {
         throw new IllegalArgumentException("Parameters compareTo is null");
      }
      int res = this.city.compareTo(pi.city);
      if(res != 0) {
         return res;
      }
      return this.teamName.compareTo(pi.teamName);
   }
}// end class
