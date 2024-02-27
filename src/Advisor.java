import java.util.ArrayList;
import java.util.UUID;

public class Advisor extends User{
    private ArrayList<Student> studentsSupervising;
    private UUID userID;


    public Advisor(ArrayList<Student> studentsSupervising, UUID userID, String firstName, 
        String middleName, String lastName, String age, String email, String password){
        super(userID, firstName, middleName, lastName, age, email, password);
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

    public void addStudent(Student student){

    }

    //Removing student from system, must be admin, checked by Application.java
    //Returns true if student removed from system (default true)
    public boolean removeStudent(String userID){
        UserList users = UserList.getInstance();
        //will call users.removeStudent()
        return true;
    }

    public void editAdvisorNote(String userID){}

    public ArrayList<Student> getStudentList(){
        return studentsSupervising;
    }
}
