package cscd327_project;

/*****************************
Query the University Database
*****************************/
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.sql.CallableStatement;
import java.util.*;

import javax.sound.sampled.AudioFileFormat.Type;

import java.lang.String;

public class MyQuery {

    private Connection conn = null;
	 private Statement statement = null;
	 private ResultSet resultSet = null;
    
    public MyQuery(Connection c)throws SQLException
    {
        conn = c;
        // Statements allow to issue SQL queries to the database
        statement = conn.createStatement();
    }
    
    public void findFall2009Students() throws SQLException
    {
        String query  = "select distinct name from student natural join takes where semester = \'Fall\' and year = 2009;";

        resultSet = statement.executeQuery(query);
    }
    
    public void printFall2009Students() throws IOException, SQLException
    {
	     System.out.println("******** Query 0 ********");
         System.out.println("name");
         while (resultSet.next()) {
			// It is possible to get the columns via name
			// also possible to get the columns via the column number which starts at 1
			String name = resultSet.getString(1);
         System.out.println(name);
   		}        
    }

    public void findGPAInfo() throws SQLException
    {
    	String query = "SELECT ID, name, round(sum(CASE\n"
    			+ "	WHEN grade = 'A' THEN 4.0\n"
    			+ "    WHEN grade = 'A-' THEN 3.7\n"
    			+ "    WHEN grade = 'B+' THEN 3.3\n"
    			+ "    WHEN grade = 'B' THEN 3.0\n"
    			+ "    WHEN grade = 'B-' THEN 2.7\n"
    			+ "    WHEN grade = 'C+' THEN 2.3\n"
    			+ "    WHEN grade = 'C' THEN 2.0\n"
    			+ "    WHEN grade = 'C-' THEN 1.7\n"
    			+ "    WHEN grade = 'D+' THEN 1.3\n"
    			+ "    WHEN grade = 'D' THEN 1.0\n"
    			+ "    WHEN grade = 'D-' THEN 0.7\n"
    			+ "    WHEN grade = 'F' THEN 0.0\n"
    			+ "    END * credits) / sum(credits), 2) as GPA\n"
    			+ "FROM takes join student using(ID) join course using(course_id)\n"
    			+ "WHERE grade IS NOT NULL\n"
    			+ "GROUP BY ID;";
    	
    	resultSet = statement.executeQuery(query);
    }
    
    public void printGPAInfo() throws IOException, SQLException
    {
		   System.out.println("\n******** Query 1 ********");
		   System.out.printf("%-10s%2s%-10s%2s%-10s%n", "id", "|", "name", "|", "GPA");
		   System.out.println("-----------------------------------------");
		   while(resultSet.next()) {
			   System.out.printf("%-10s%2s%-10s%2s%-10s%n", resultSet.getString(1), "|", resultSet.getString(2)
					   , "|", resultSet.getString(3));
		   }
    }

    public void findMorningCourses() throws SQLException
    {
    	String query = "SELECT course_id, sec_id, title, semester, year, name, count(distinct takes.ID) as enrollment\n"
    			+ "FROM course join section using(course_id) join time_slot using(time_slot_id) natural join\n"
    			+ "teaches natural join instructor join takes using(course_id, sec_id, semester, year)\n"
    			+ "WHERE start_hr < 12\n"
    			+ "GROUP BY course_id, sec_id,semester, year, name\n"
    			+ "HAVING count(distinct takes.id) > 0;";
    	
    	resultSet = statement.executeQuery(query);
    }

    public void printMorningCourses() throws IOException, SQLException
    {
	   	System.out.println("\n******** Query 2 ********");
	   	System.out.printf("%-15s%2s%-15s%2s%-30s%2s%-15s%2s%-15s%2s%-15s%2s%-15s%n"
	   			, "course_id", "|", "sec_id", "|", "title", "|", "semester", "|", "year"
	   			, "|", "name", "|", "enrollment");
		System.out.println("------------------------------------------------------------"
				+ "-----------------------------------------------------------------------");
	   	while(resultSet.next()) {
		   	System.out.printf("%-15s%2s%-15s%2s%-30s%2s%-15s%2s%-15s%2s%-15s%2s%-15s%n", 
		   			resultSet.getString(1), "|", resultSet.getString(2), "|", resultSet.getString(3), "|"
		   			, resultSet.getString(4), "|", resultSet.getString(5)
		   			, "|", resultSet.getString(6), "|", resultSet.getString(7));
	   	}
    }

    public void findBusyClassroom() throws SQLException
    {
    	String query = "SELECT building, room_number, count(building) as frequency \n"
    			+ "FROM section\n"
    			+ "GROUP BY building, room_number \n"
    			+ "HAVING count(building) = (\n"
    			+ "	SELECT max(freq) \n"
    			+ "    FROM (\n"
    			+ "		SELECT count(building) as freq\n"
    			+ "		FROM section\n"
    			+ "        GROUP BY building) as freq\n"
    			+ "	);";
    	
    	resultSet = statement.executeQuery(query);
    }

    public void printBusyClassroom() throws IOException, SQLException
    {
    	System.out.println("\n******** Query 3 ********");
		System.out.printf("%-15s%2s%-15s%2s%-15s%n", "building", "|", "room_number", "|"
				, "frequency");
		System.out.println("--------------------------------------------------");
		while(resultSet.next() ) {
			System.out.printf("%-15s%2s%-15s%2s%-15s%n", resultSet.getString(1), "|"
					, resultSet.getString(2), "|" , resultSet.getString(3));
		}
	}

    public void findPrereq() throws SQLException
    {
    	String query = "SELECT title as course,    \n"
    			+ "CASE   \n"
    			+ "    WHEN    \n"
    			+ "    course_id in (\n"
    			+ "		SELECT course_id\n"
    			+ "        FROM prereq\n"
    			+ "        ) \n"
    			+ "	THEN (\n"
    			+ "			SELECT title    \n"
    			+ "			FROM course as c2, prereq   \n"
    			+ "			WHERE c1.course_id = prereq.course_id   \n"
    			+ "			and c2.course_id = prereq_id\n"
    			+ "            )\n"
    			+ "    ELSE \"N/A\"   \n"
    			+ "    END as prereq \n"
    			+ "FROM course as c1;";
    	    	
    	resultSet = statement.executeQuery(query);
    }

    public void printPrereq() throws IOException, SQLException
    {
    	System.out.println("\n******** Query 4 ********");
    	System.out.printf("%-30s%2s%-30s%n", "course", "|", "prereq");
		System.out.println("----------------------------------------------------------");
    	while(resultSet.next()) {
    		System.out.printf("%-30s%2s%-30s%n", resultSet.getString(1), "|"
    				, resultSet.getString(2));
    	}
    }

    public void updateTable() throws SQLException
    {
    	String update = "UPDATE studentCopy   \n"
    			+ "SET tot_cred = (\n"
    			+ "	SELECT COALESCE(SUM(credits), 0)  \n"
    			+ "	FROM takes JOIN course USING (course_id)  \n"
    			+ "	WHERE studentCopy.ID = takes.ID AND grade <> 'F'\n"
    			+ "    );";
    	
    	statement.executeUpdate(update);
    	
    	String tempTable = "CREATE temporary table IF NOT EXISTS num_courses(\n"
    			+ "    SELECT studentCopy.ID, count(distinct course_id) as num_course\n"
    			+ "    FROM studentCopy left outer join takes on (studentCopy.ID = takes.id)\n"
    			+ "    GROUP BY studentCopy.ID);";
    	
    	statement.executeUpdate(tempTable);
    	
    	String query = "SELECT ID, name, dept_name, tot_cred, num_course as \"# of courses\"\n"
    			+ "FROM studentCopy natural join num_courses;";
    	
    	resultSet = statement.executeQuery(query);
    }

    public void printUpdatedTable() throws IOException, SQLException
    {
		   System.out.println("\n******** Query 5 ********");
		   System.out.printf("%-15s%2s%-15s%2s%-15s%2s%-15s%2s%-15s%n", "id", "|"
				   , "name", "|", "dept_name", "|", "tot_cred", "|", "# of Course");
		   System.out.println("----------------------------------------------------------------------------------");
		   while(resultSet.next()) {
			   System.out.printf("%-15s%2s%-15s%2s%-15s%2s%-15s%2s%-15s%n", resultSet.getString(1), "|"
					   , resultSet.getString(2), "|", resultSet.getString(3), "|", resultSet.getString(4)
					   , "|", resultSet.getString(5));
		   }
    }
	
	 public void findDeptInfo() throws SQLException
	 {
		  System.out.println("\n******** Query 6 ********");
		  Scanner input = new Scanner(System.in);
		  System.out.print("Please enter the department name: ");
		  String userInput = input.nextLine();
		  String userInputCopy = userInput;
		  
		  CallableStatement cStmt = conn.prepareCall("{call deptInfo(?, ?, ?, ?)}");
		  cStmt.setString(1, userInput);
		  cStmt.registerOutParameter(2, Types.INTEGER);
		  cStmt.registerOutParameter(3, Types.FLOAT);
		  cStmt.registerOutParameter(4, Types.FLOAT);
		  
		  cStmt.executeQuery();
		  
		  int num_instr = cStmt.getInt(2);
		  double total_sal = cStmt.getFloat(3);
		  double total_budget = cStmt.getFloat(4);
		  
		  System.out.printf("%s Department has %d instructors.%n", userInputCopy, num_instr);
		  System.out.printf("%s Department has total salary of $%.1f.%n", userInputCopy, total_sal);
		  System.out.printf("%s Department has a budget of $%.1f.%n", userInputCopy, total_budget);
		  input.close();
	 }
    
    
    public void findFirstLastSemester() throws SQLException
    {
 
    }

    public void printFirstLastSemester() throws IOException, SQLException
    {
        System.out.println("\n******** Query 7 ********");
    }

}
