package lab9.cscd211methods;

import java.util.*;
import lab9.cscd211classes.*;
import lab9.cscd211classes.players.*;

/**
 * I have provided the menu method for you.  You must write the fill method. Please look at the file teamlist.txt
 * <br>
 * The file format is City\n Number of teams\n Type, Team Name\n Number of Players\n <br>
 * player name, ssn, salary, position, specific info based on type <br>
 * if football then # of touch downs, jersey number <br>
 * if baseball then batting average <br>
 * if hockey then jersey number <br>
 *
 * @NOTE All parameters passed must be final
 */
public class CSCD211Lab9Methods
{	
   /**
    * reads from the file and creates the appropriate player for the array and 
    * creates the appropriate team
    *
    * @param fin Scanner object
    * @param myTeam ArrayList of type Team
    *
    * @throws IllegalArgumentException for fin or myTeam being null
    * @throws CloneNotSupportedException to propagate the clone method
    *
    * @NOTE To add to MyArrayList it is an addLast method call myTeam.addLast(team stuff)
    */
   public static void fillArrayList(final Scanner fin, final ArrayList<Team>myTeam)throws CloneNotSupportedException
   {
      if(fin == null || myTeam == null)
      {
         throw new IllegalArgumentException("Parameters fillArrayList is null");
      }
      
      while(fin.hasNext()) // Ensures that the file has content left in it
      {
         String city = fin.nextLine();
         int numTeams = Integer.parseInt(fin.nextLine());
         
         int counter = 0;
         while(counter < numTeams) // Creates the number of teams for specified city
         {
            String tempTypeName = fin.nextLine();
            String[] tempSport = new String[2]; // Sport type, Team name
            tempSport = tempTypeName.split(",");
            String teamSport = tempSport[0].trim();
            String teamName = tempSport[1].trim();
            int totalPlayers = Integer.parseInt(fin.nextLine());
            
            Player[] tempPlayerArray = new Player[totalPlayers];
                    
            int playerCounter = 0;
            for(int i = 0; playerCounter < totalPlayers; i++)
            {
            String fbPlayer, bbPlayer, hPlayer, playerName, playerSsn, playerPosition;
            int playerSalary, playerTd, playerJersey;
            double batAvg;
            
               if(teamSport.equalsIgnoreCase("football"))
               {
                  String[] footballPlayer = new String[6];
                  fbPlayer = fin.nextLine();
                  footballPlayer = fbPlayer.split(",");
                  playerName = footballPlayer[0].trim();
                  playerSsn = footballPlayer[1].trim();
                  playerSalary = Integer.parseInt(footballPlayer[2].trim());
                  playerPosition = footballPlayer[3].trim();
                  playerTd = Integer.parseInt(footballPlayer[4].trim());
                  playerJersey = Integer.parseInt(footballPlayer[5].trim());
                  
                  FootballPlayer tempFootballPlayer = new FootballPlayer(playerName.trim(), playerSsn.trim(), playerSalary, playerPosition.trim(), playerTd, playerJersey);
                  tempPlayerArray[i] = tempFootballPlayer;           
               }
               
               else if(teamSport.equalsIgnoreCase("baseball"))
               {
                  String[] baseballPlayer = new String[5];
                  bbPlayer = fin.nextLine();
                  baseballPlayer = bbPlayer.split(",");
                  playerName = baseballPlayer[0].trim();
                  playerSsn = baseballPlayer[1].trim();
                  playerSalary = Integer.parseInt(baseballPlayer[2].trim());
                  playerPosition = baseballPlayer[3].trim();
                  batAvg = Double.parseDouble(baseballPlayer[4].trim());
                  
                  BaseballPlayer tempBaseballPlayer = new BaseballPlayer(playerName.trim(), playerSsn.trim(), playerSalary, playerPosition.trim(), batAvg);
                  tempPlayerArray[i] = tempBaseballPlayer;  
               }
               
               else if(teamSport.equalsIgnoreCase("hockey"))
               {
                  String[] hockeyPlayer = new String[5];
                  hPlayer = fin.nextLine();
                  hockeyPlayer = hPlayer.split(",");
                  playerName = hockeyPlayer[0].trim();
                  playerSsn = hockeyPlayer[1].trim();
                  playerSalary = Integer.parseInt(hockeyPlayer[2].trim());
                  playerPosition = hockeyPlayer[3].trim();
                  playerJersey = Integer.parseInt(hockeyPlayer[4].trim());
                  
                  HockeyPlayer tempHockeyPlayer = new HockeyPlayer(playerName.trim(), playerSsn.trim(), playerSalary, playerPosition.trim(), playerJersey);
                  tempPlayerArray[i] = tempHockeyPlayer; 
               }
               
               playerCounter++;
            }
            
           Team createTeam = new Team(city, teamName, tempPlayerArray);
           myTeam.add(createTeam);
           counter++;       
         }// end of second while loop
              
      }// end of first while loop
       
      myTeam.trimToSize();      
   }// end createAndFill
   
   /**
    * The menu method ensures a valid choice is entered and returns that value
    * <br> 1 Print all Teams
    * <br> 2 Sort all Teams by city and team name
    * <br> 3 Sort all Teams by Payroll
    * <br> 4 Exit program
    *
    * @param kb Representing a valid Scanner object
    * @return int Representing the menu choice
    *
    * @throws IllegalArgumentException If Scanner is null
    */
   public static int menu(final Scanner kb)
   {
      if (kb == null)
         throw new IllegalArgumentException("Error Precond: Scanner cannot be null - menu");
         
      int choice;
      
      do
      {
         System.out.println("Please choose from the following");
         System.out.println("1) Print all Teams");
         System.out.println("2) Sort all Teams by city and team name");
         System.out.println("3) Sort all Teams by Payroll");
         System.out.println("4) Exit program");
         System.out.print("Choice --> ");
         choice = kb.nextInt();
         kb.nextLine();
      } while (choice < 1 || choice > 4);
      
      return choice;  
   }// end menu
   
}// end class