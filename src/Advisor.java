import java.util.ArrayList;
import java.util.UUID;

public class Advisor {
    private ArrayList<Student> studentsSupervising;
    private UUID userID;


    public Advisor(String userName, String firstName, String lastName, String userID, int userRolse){

    }

    //Can't have overloaded methods with the same param types
    public void getStudent(String userID){

    }
//    public void getStudent(String lastName){
//
//    }
    public void addStudent(String userID){}

    public void removeStudent(String userID){}

    public void editAdvisorNote(String userID){}

    public ArrayList<Student> getStudentList() {
        return studentsSupervising;
    }
}
