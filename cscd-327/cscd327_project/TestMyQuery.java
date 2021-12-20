package cscd327_project;

/*******************************************************
Tester for the project
By: Dan Li
*******************************************************/
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestMyQuery {
        public static void main(String[] args) {                
            try {
                    Connection conn = getConnection();
                    MyQuery mquery = new MyQuery(conn);
                    
     				     // Query 0
                    mquery.findFall2009Students();
                    mquery.printFall2009Students();
                    
                    // Query 1
                    mquery.findGPAInfo();
                    mquery.printGPAInfo();

                    // Query 2
                    mquery.findMorningCourses();
                    mquery.printMorningCourses();
                    
                    // Query 3
                    mquery.findBusyClassroom();
                    mquery.printBusyClassroom();
                    
                    // Query 4
                    mquery.findPrereq();
                    mquery.printPrereq();
                
                    // Query 5
                    mquery.updateTable();
                    mquery.printUpdatedTable();
                    
                    // Query 6
					     mquery.findDeptInfo();
                    
                    // Query 7 (extra credit)      
                    mquery.findFirstLastSemester();
                    mquery.printFirstLastSemester();
				
                    conn.close();
            } catch (SQLException e) {
                    e.printStackTrace();
            }
            catch (IOException e) {
                    e.printStackTrace();
            }
        }
        
        public static Connection getConnection() throws SQLException{
            Connection connection; 
            try {
                    Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            } catch (InstantiationException e1) {
                    e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                    e1.printStackTrace();
            } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
            }
            //Create a connection to the database
            String serverName = "<serverip>";
            String mydatabase = "<database>"; //change needed
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase; // a JDBC url
            String username = "<username>"; //change needed
            String password = "<password>"; //change needed

            connection = DriverManager.getConnection(url, username, password);
            return connection;

        }
}
