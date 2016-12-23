import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PartTime extends Student {
    
    private double tuition;
    private String Student_Status;
    
    public PartTime(){
        super();
        tuition = 250;
        Student_Status = " ";
    }
        public void StudentSituation(String StudentStatus) {
            
            Student_Status = StudentStatus;
        }
        public String getStudentSituation() {
            return Student_Status;
        }
        @Override public void add(){
            Statement speech = null;
            
            try{
                Connect together = new Connect();
                speech = together.makeStatement();
                
                speech.execute("Insert Student(Student ID,First Name,Last Name,GPA,Tuition,Student Status)"
                        +" Values (' "
                        + Student_ID + "' '"
                        + First_Name + "' '"
                        + Last_Name + "' '"
                        + GPA + "' '"
                        + tuition + "' '"
                        + Student_Status + "')");
                
                speech.close();
                together.close();
            }
            catch (SQLException e){
                e.printStackTrace();
                System.err.println("Could not Insert");
            }
            System.out.println("Sucessfully added student to the database");
        }
            @Override public void querybyStudentid(){
            
            Statement stmt = null;
            ResultSet ptrs = null;
            String output = " ";
            
            try {
                Connect unite = new Connect();
                stmt = unite.makeStatement();
                
                String sqltalk = "Select * from student where student id " + get_Student_ID();
                ptrs = stmt.executeQuery(sqltalk);
                
                while(ptrs.next()){
                    
                    this.set_Student_ID(ptrs.getInt("Student id"));
                    this.set_First_Name(ptrs.getString("First Name"));
                    this.set_Last_Name(ptrs.getString("Last Name"));
                    this.grade_Point_Average(ptrs.getInt("GPA"));
                    this.set_Tuition(ptrs.getInt("Tuition"));
                    this.StudentSituation(ptrs.getString("Student Status"));
                }
                ptrs.close();
                stmt.close();
                unite.close();
                unite.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
                System.err.println("SQL Error");
            }
            System.out.println(this.toString());
        }
            @Override public void calculateTuition(int creditHours) {
                Scanner cal = new Scanner(System.in);
                //ASK WHETHER RESIDENT OR NON-RESIDENT
                System.out.println("Please select 1 for resident or 2 for non-resident: ");
                Integer answer = cal.nextInt();
                if(answer.equals(1)) {
                    System.out.println("Your tuition is equal to " + creditHours * 250);
                }
                
                if(answer.equals(2)) {
                    System.out.println("Your tuition is equal to " + creditHours * 450);
                }
                
            Statement price = null;
            ResultSet rs = null;
            String showcost = " ";
            double expense = 0;
            
            try {
                Connect conn = new Connect();
                price = conn.makeStatement();
                String sqlst = "Select * from student where Student id = " + Student_ID;
                
                System.out.println(sqlst);
                
                if (rs.next())
                    
                    expense = rs.getDouble("Tuition");
                rs.close();
                price.close();
                conn.close();
                conn.close();
            }
            catch (SQLException I) {
                
                I.printStackTrace();
                System.err.println("Error: Either cannot connect to the db" + " or error with the"
                        + " Sql statement");
        }
          
        }
            @Override public String toString() {
            String lastStatement = super.toString();
            
            lastStatement += "Student Status: " + Student_Status;
            return lastStatement;
        }
    }
