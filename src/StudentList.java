import java.util.ArrayList;

public class StudentList {
    //private static StudentList Students;
    private static StudentList Students;
    private ArrayList<Student> StudentList;
    public StudentList(){  //constructor
        StudentList = DataLoader.getStudents();
    }
    public static StudentList getInstance(){
        if (Students == null){
            Students = new StudentList();
        }
        return Students;
    }
    public String getStudent(String userID){
        return StudentList;  }
    public String getUsername(){ return "";  }
    public String getPassword(){ return "";  }
    public void setStudent(){ return;  }
    public void editStudent(String userID){ return;  }
    public void addStudent(String userID){ return;  }
    public boolean haveStudent(String email){ return false;  }
}
