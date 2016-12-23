import java.sql.*;

public abstract class Student {
    protected int Student_ID;
    protected String First_Name;
    protected String Last_Name;
    protected int GPA;
    protected String Student_Status;
    protected String Mentor;
    protected int studentTuition;
    
    Student() {
        Student_ID = 0;
        First_Name = " ";
        Last_Name = " ";
        GPA = 0;
        Student_Status = " ";
        Mentor = " ";
    }
    public void set_Student_ID(int SID){
        Student_ID = SID;
    }
    public void set_First_Name(String firstName){
        First_Name = firstName;
    }
    public void set_Last_Name(String lastName) {
        Last_Name = lastName;
    }
    public void grade_Point_Average(int Average){
        GPA = Average;
    }
    public void set_Tuition(int tuition) {
        studentTuition = tuition;
    }
    public void studentSituation(String StudentStatus){
        Student_Status = StudentStatus;
    }
    public void Teacher(String Student_Mentor) {
        Student_Mentor = Mentor;
    }
    public int get_Student_ID() {
        return Student_ID;
    }
    public String get_first_Name(){
        return First_Name;
    }
    public String get_last_Name(){
        return Last_Name;
    }
    public int get_GPA(){
        return GPA;
    }
    public int get_Tuition(){
        return studentTuition;
    }
    public String get_Student_Status(){
        return Student_Status;
    }
    public String get_Mentor(){
        return Mentor;
    }
    public abstract void add();
    public abstract void querybyStudentid();
    public abstract void calculateTuition( int pricetag); //causing a problem
    
    public String toString(){
        
        String Y = "Student ID: " + Student_ID + "\n";
        Y += "First Name: " + First_Name;
        Y += "Last Name: " + Last_Name;
        Y += "GPA: " + GPA;
        Y += "Student Status: " + Student_Status;
        Y += "Mentor: " + Mentor;
        
        return Y;
    }
}