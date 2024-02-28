import java.util.ArrayList;

public class StudentList {
    private static StudentList students;
    private ArrayList<Student> studentList;

    public StudentList(){  //constructor
        this.studentList = DataLoader.getStudents();
    }

    public static StudentList getInstance(){ 
        if (students == null){
            students = new StudentList();
        }
        return students;
    }

    public ArrayList<Student> getStudents(){ 
        return studentList;  
    }

    public Student getVerifiedStudent(String email, String password){
        for(Student student : studentList){
            if(student.getEmail().equals(email) && student.getPassword().equals(password)){
                return student;
            }
        }
        return null;
    }

    public void setStudent(){ 
        
    } 

    public void editStudent(String student){ 
        
    } 

    public void addStudent(String userID, String email, String firstName, String middleName, String lastName, String age, 
        String password, String advisorID,  String major, String concentration, long transferCredits){ 

        studentList.add(new Student(userID, email, firstName, middleName, lastName, age, password, advisorID, major, concentration, transferCredits));
        DataWriter.saveStudents();
    } 

    public void addStudent(Student student){ 
        studentList.add((student));
        DataWriter.saveStudents();
    } 

    public boolean haveStudent(String email){ 
        for(Student student : studentList )  {
            if(student.getEmail().equals(email)){
                return true;
            }
        }
        return false;  
    }

    public Student getStudent(String email){
        for(Student student : studentList){
            if(student.getEmail().equals(email)){
                return student;
            }
        }
        return null;
    }

    public Student getStudent(String firstName, String lastName){
        for(Student student : studentList){
            if(student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)){
                return student;
            }
        }
        return null;
    }
}
