import com.mysql.jdbc.Driver;
import java.sql.*;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        
        Integer menuSelect = 0;
        Scanner select = new Scanner(System.in);
        
        do {
            System.out.println("============");
            System.out.println("    Menu    ");
            System.out.println("Menu Options:     ");
            System.out.println("             1. Add Students");
            System.out.println("             2. Update Student Info");
            System.out.println("             3. Delete Students");
            System.out.println("             4. Query Student Info");
            System.out.println("             5. Calculate Tuition");
            System.out.println("             6. Quit");
            
            try {
                menuSelect = select.nextInt();
                Integer.valueOf(menuSelect).intValue();
            }
            catch (NumberFormatException e) {
                System.out.print("Invalid input. Not an integer");
            }
                switch(menuSelect) {
                    case 6 :
                        System.exit(0);
                        break;
                    case 1 :
                        add();
                        break;
                    case 2 :
                        update();
                        break;
                    case 3 :
                        delete();
                        break;
                    case 4 :
                        query();
                        break;
                    case 5 :
                        calculateTuition();
                    default:
                        break;
                        
                        
                }
            } while  (menuSelect != 6); }
            public static void add() {
                Integer answer = 0;
                
                Scanner addinText = new Scanner(System.in);
                Scanner addinInt = new Scanner(System.in);
                
                System.out.println("Add a student");
                System.out.println("Please enter student ID");
                
                int Student_ID = addinInt.nextInt();
                
                System.out.println("Student First name");
                String first_Name = addinText.nextLine();
                
                System.out.println("Student Last Name");
                String last_Name = addinText.nextLine();
                
                System.out.println("Are they Resident or Non-Resident?( 1 = Resident or 2 = Non-resident)");
                Integer Student_choice = addinInt.nextInt();
                
                String Student_Status = null;
                
                if(Student_choice.equals(1)) {
                    
                  Student_Status = "resident";
                } else {
                    Student_Status = "non-resident";
                    
                }
            }
            public static void update() {
                //update info
                Statement updateStmt = null;
                ResultSet updateRS = null;
                String change_Student_info = "Select * from student";
                
                try {
                    Connect conn = new Connect();
                    updateStmt = conn.makeStatement();
                    updateRS = updateStmt.executeQuery(change_Student_info);
                    
                    while(updateRS.next()) {
                        String output = " ";
                        output += updateRS.getInt("Student Id") + " "
                                + updateRS.getString("Student First Name ") + " "
                                + updateRS.getString("Student Last Name ") + " "
                                + updateRS.getInt("GPA ") + " "
                                + updateRS.getString("Student Status ") + " "
                                + updateRS.getString("Mentor ") + "\n";
                                System.out.printf("%s", output);
                }
                //close Resultset,statement and connection
                updateRS.close();
                updateStmt.close();
                conn.close();
                conn.close();
            }
                catch (Exception e) {
                    System.err.println("Error: Either cannot connect to the DB " + "or error with the SQL statement");
                
                }
            }
            public static void delete() {
                Statement delStmt = null;
                ResultSet delRS = null;
                String delete_Student = "Select * from student";
                
                try {
                    Connect conn = new Connect();
                    delStmt = conn.makeStatement();
                    delRS = delStmt.executeQuery(delete_Student);
                    
                    while (delRS.next()) {
                        String output = " ";
                        output += delRS.getInt("Student id") + " "
                                + delRS.getString("Student First Name") + " "
                                + delRS.getString("Student Last Name") + " "
                                + delRS.getInt("GPA") + " "
                                + delRS.getString("Student Status") + " "
                                + delRS.getString("Mentor") + "\n";
                               System.out.printf("%s", output);
                    }
                    delStmt.close();
                    delRS.close();
                    conn.close();
                    conn.close();
                }
                catch (Exception e) {
                    System.err.println("Error:Either cannot connect to the db" + "or error with the SQL statement");
                }
            }
            public static void query() {
                Statement stmt = null;
                ResultSet rs = null;
                String st = "Select * from Student Info";
                
                try {
                    
                    Connect together = new Connect();
                    stmt = together.makeStatement();
                    rs = stmt.executeQuery(st);
                    
                    while (rs.next()) {
                        
                        String output = " ";
                        output += rs.getInt("Student ID" ) + " "
                                + rs.getString("First Name ") + " "
                                + rs.getString("Last Name ") + " "
                                + rs.getInt("GPA ") + " "
                                + rs.getString("Student Status") + " "
                                + rs.getString("Mentor") + "\n";
                        
                        System.out.printf("%s", output);
                              
                    }
                    rs.close();
                    stmt.close();
                    together.close();
                    together.close();
                }
                catch (Exception l) {
                    System.err.println("Error: Either cannot connect to the DB " + 
                            " OR error with the SQL statement");
                } 
            }
            public static void QueryStudentbyId() {
                String st = " ";
                Scanner queryInt = new Scanner(System.in);
                System.err.println("Please enter the Student ID number: ");
                int studentId = queryInt.nextInt();
                
                System.out.println("Are they undergrad, graduate, or part-time( 1 = undergrad, 2 = grad,3 = part-time) " );
                      Integer status = queryInt.nextInt();
                      
                      if(status.equals(1)) {
                          
                          Student firstYear = new UnderGraduate();
                          firstYear.set_Student_ID(studentId);
                          firstYear.querybyStudentid();
                          firstYear.set_First_Name(st);
                          firstYear.set_Last_Name(st);
                          firstYear.set_Tuition(studentId);
                      }
                      if(status.equals(2)) {
                          Student goingBack = new Graduate();
                          goingBack.set_Student_ID(studentId);
                          goingBack.set_Tuition(studentId);
                          goingBack.set_First_Name(st);
                          goingBack.set_Last_Name(st);
                      }
                      if(status.equals(3)) {
                          Student pt = new PartTime();
                          pt.set_First_Name(st);
                          pt.set_Last_Name(st);
                          pt.set_Student_ID(studentId);
                          pt.set_Tuition(studentId);
                      }
            }
            public static void calculateTuition() {
                int creditHours = 0;
                Scanner cal = new Scanner(System.in);
                System.out.println("How many credit hours?");
                creditHours = cal.nextInt();
                System.out.print("Are you undergraduate, graduate, or part-time? (1= undergrad or " +
                       " 2 = graduate, 3 = parttime)>  )");
                        
                        Integer answer = cal.nextInt();
                        if (answer.equals(1)) {
                            UnderGraduate frosh = new UnderGraduate();
                            frosh.calculateTuition(creditHours);
                          
                        }
                        if(answer.equals(2)) {
                            Graduate backAgain = new Graduate();
                            backAgain.calculateTuition(creditHours);
                        }
                        if(answer.equals(3)) {
                            PartTime pt1 = new PartTime();
                            pt1.calculateTuition(creditHours);
                        }
            }
        }

    
