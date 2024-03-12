import java.util.ArrayList;
import java.util.UUID;


public class Advisor extends User{
    private boolean admin;
    private ArrayList<Student> studentsSupervising;

    public Advisor(String userID, ArrayList<Student> studentsSupervising, String firstName, String middleName, String lastName, String age, String email, 
        boolean admin, String password){
        super(userID, firstName, middleName, lastName, age, email, password);
        this.admin = admin;
        this.studentsSupervising = studentsSupervising;
    }

    //Can't have overloaded methods with the same param types
    public void getStudent(String userID){

    }
    //public void getStudent(String lastName){}

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

    public boolean hasStudent(Student student){
        for (Student students: studentsSupervising){
            if(students.equals(student))
            {
                return true;

            }
        }
        return false;
    }


      public Boolean getAdmin() {
        return admin;
      }
    
    
      public String getAdvisorAge(){
        return age;
      }
}
