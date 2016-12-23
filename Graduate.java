import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Graduate extends Student {
    
    private double tuition;
    private String Thesis_Title;
    private String Thesis_Advisor;
    
    public Graduate() {
        
        super();
        tuition = 300;
        Thesis_Title = "Clean Energy";
        Thesis_Advisor = "Igo Green";
    }
    public void setThesisTitle(String X){
        Thesis_Title = X;
    }
    public void setThesisAdvisor(String Z){
        Thesis_Advisor = Z;
    }
    public String setThesis_Title(){
        return Thesis_Title;
    }
    public String setThesis_Advisor(){
        return Thesis_Advisor;
    }
    @Override public void add(){
        Statement passage = null;
        
        try{
            Connect combine = new Connect();
            passage = combine.makeStatement();
            
            passage.execute("Insert into Student Media(Student ID,First Name,Last Name,GPA,Student Status,Thesis Title,Thesis advisor)"
                    + "Values (' "
                    + Student_ID + "'  '"
                    + First_Name + "'  '"
                    + Last_Name  + "'  '"  
                    + GPA + "'  '"
                    + Student_Status + "' '"
                    + Thesis_Title + "'  '"
                    + Thesis_Advisor + "')");
                    
                    passage.close();
                    combine.close();
        }
        catch(SQLException e){
            e.printStackTrace();
            System.err.println("Could not Insert");
        }
        System.out.println("Successfully added Student to database");
    }
        @Override public void querybyStudentid(){
        Statement passage = null;
        ResultSet rs = null;
        String output = " ";
        
        try{
            Connect conn = new Connect();
            passage = conn.makeStatement();
            String sqlst = "Select * from media where Student id = " + Student_ID;
            
            rs = passage.executeQuery(sqlst);
            
            while (rs.next()){
                this.set_Student_ID(rs.getInt("Student id"));
                this.set_First_Name(rs.getString("First Name"));
                this.set_Last_Name(rs.getString("Last Name"));
                this.studentSituation(rs.getString("Student Staus"));
                this.grade_Point_Average(rs.getInt("GPA"));
                this.setThesisTitle(rs.getString("Thesis Title"));
                this.setThesisAdvisor(rs.getString("Thesis Advisor"));
            }
            rs.close();
            passage.close();
            conn.close();
            conn.close();
            
        }
        catch (SQLException e){
            e.printStackTrace();
            System.err.println("SQL Error");
        }
        System.out.println(this.toString());
    }
        @Override public void calculateTuition(int creditHours){
            Scanner cal = new Scanner(System.in);
            System.out.println("Select 1 for resident or 2 for non-resident : ");
            Integer answer = cal.nextInt();
            // insert tuition for choices
            Graduate reside = new Graduate();
            if (answer.equals(1)) {
                System.out.println("Your tuition cost is " + creditHours * 300);
            }
            if (answer.equals(2)) {
                System.out.println("Your tuition cost is " + creditHours * 350);
            }
            
        
        Statement stmt = null;
        ResultSet rs = null;
        String output = " ";
        double result = 0;
        
        try{
            Connect conn = new Connect();
            stmt = conn.makeStatement();
            
            String sqlst = "Select * from Student where student id= " + creditHours;
            
            System.out.println(sqlst);
            rs = stmt.executeQuery(sqlst);
            
            if(rs.next())
                result = rs.getInt("GPA");
            rs.close();
            stmt.close();
            conn.close();
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
            System.err.println("Error: Either cannot connect to the DB" +
                    "or error with the SQL statement");
        }
        
    }
        @Override public String toString(){
        
        String T = super.toString();
        T += "Student Status: " + Student_Status;
        return T;
    }
    } 
