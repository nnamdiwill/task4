import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UnderGraduate extends Student {

 

 

    @Override
    public void calculateTuition(int creditHours) {
        // ask user if they're resident or non -resident,full-time,part how many credits
      
        Scanner cal = new Scanner(System.in);
     
        System.out.println("Are you a resident,non-resident, (1 = Resident,2 = non-resident: ");
        
        Integer answer = cal.nextInt();
        UnderGraduate resident = new UnderGraduate();
        if(answer.equals(1)) {
             System.out.println("Your tuition equals to : " + creditHours  * 200);
             
            
            
        }
        if(answer.equals(2)) {
         System.out.println("Your tuition equals to : " + creditHours  * 400);
            
        }
     
    }
 
    
    public UnderGraduate(){
        super();
        
    }
    @Override public void add(){
        Statement stmt = null;
        
        try {
            Connect conn = new Connect();
            stmt = conn.makeStatement();
            
            stmt.execute("Student Info(Student id,First name,Last Name, Tuition,GPA,Student Status)"
                    + Student_ID + "' '"
                    + First_Name + "' '"
                    + Last_Name + "' '"
                    + GPA + "' '"
                    + studentTuition + " "
                    + Student_Status + "')");
            
            stmt.close();
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
            System.err.println("Could not insert Student Info");
        }
        System.out.println("Successfully added to DataBase");
    }
    @Override public void querybyStudentid(){
        Statement stmt = null;
        ResultSet rs = null;
        String output = " ";
        
        try {
            Connect conn = new Connect();
            stmt = conn.makeStatement();
            String sqlStatement = "Select * from Student where student id = " + Student_ID;
            
            while(rs.next()){
                
                this.set_Student_ID(rs.getInt("Student ID"));
                this.set_First_Name(rs.getString("First Name"));
                this.set_Last_Name(rs.getString("Last Name"));
                this.grade_Point_Average(rs.getInt("GPA"));
                this.set_Tuition(rs.getInt("Tution"));
                this.studentSituation(rs.getString("Student Status"));
                
            }
            rs.close();
            stmt.close();
            conn.close();
            conn.close();
        }
        catch (SQLException e){
            e.printStackTrace();
            System.err.println("Error: Either cannot connect to the DB " + 
                    " OR error with Sql statement");
        }
        System.out.println(this.toString());
    }
  
    @Override public String toString(){
        return super.toString();
    }
}