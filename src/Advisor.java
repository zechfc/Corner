import java.util.ArrayList;
import java.util.UUID;


public class Advisor extends User{

    private UUID userID;
    private String firstName;
    private String lastName;
    private String middleName;
    private String age;
    private String email;
    private boolean admin;
    private String password;
    private ArrayList<Student> studentsSupervising;


    public Advisor( UUID userID,ArrayList<Student> studentsSupervising, String firstName, String middleName, String lastName, String age, String email, 
        boolean admin, String password){
        super(userID, firstName, middleName, lastName, age, email, admin, password);
        this.studentsSupervising = studentsSupervising;
    }

    //Can't have overloaded methods with the same param types
    public void getStudent(String userID){

    }
    //public void getStudent(String lastName){}

    //Adding student to system, must be admin, checked by Application.java
    public Student addStudent(String userID){
        return null;
    }


    //Removing student from system, must be admin, checked by Application.java
    //Returns true if student removed from system (default true)
    public boolean removeStudent(String userID){
        StudentList students = StudentList.getInstance();
        //will call Advisors.removeStudent()
        return true;
    }

    public void editAdvisorNote(String userID){

    }

    public ArrayList<Student> getStudentList(){
        return studentsSupervising;
    }

    public String getAdvisorName() {
        return email;
      }

      public Boolean getAdmin() {
        return admin;
      }
    
    
      public String getAdvisorAge(){
        return age;
      }
    
      public String getFirstName(){
        return firstName;
      }
    
      public String getMiddleName(){
        return middleName;
      }
    
      
      public String getLastName() {
        return lastName;
      }
    
      public String getPassword() {
        return password;
      }
      
      public UUID getuserID(){
        return userID;
      }
}
