import java.util.UUID;
import java.util.ArrayList;

public class Application {
    private StudentList studentList;
    private AdvisorList advisorList;
    private ClassList classList;
    private User user;

    public Application(){
        this.studentList = StudentList.getInstance();
        this.advisorList = AdvisorList.getInstance();
        this.classList = ClassList.getInstance();
    }

    public int checkUser(String input){
        if(input == "student"){
            return 1;
        }
        return 2;
    }

    public boolean login(int i, String email, String password){
        if(i == 1){
            User loggedInStudent = studentList.getVerifiedStudent(email, password);
            if(loggedInStudent != null){
                user = loggedInStudent;
                return true;
            }
        } else if(i == 2){
            User loggedInAdvisor = advisorList.getVerfiedAdvisor(email, password);
            if(loggedInAdvisor != null){
                user = loggedInAdvisor;
                return true;
            }
        }
        
        return false;
    }

    public User createAccount(int i, UUID uuid, String firstName, String middleName, String lastName, String age, String email, 
        String password, Advisor advisor, Major major, String concentration, ArrayList<Student> studentsSupervising, boolean admin){
        user = new User(uuid, email, firstName, middleName, lastName, age, password);
        if(i == 1){
            studentList.addStudent(uuid, firstName, middleName, lastName, age, email, password, advisor, major, concentration);
        }else if(i == 2){
            advisorList.addAdvisor(uuid, studentsSupervising, email, firstName, middleName, lastName, age, admin, password);
        }
        return user;
    }

    public boolean getMajorMap(String userID){
        if(user != null && user.getUserID().equals(userID)){
            if(user instanceof Student){
                System.out.println(((Student) user).getMajorMap());
                return true;
            }
        }
        return false;
    }

    public boolean editMajorMap(String userID, MajorMap map){
        if(user != null && user.getUserID().equals(userID)){
            if(user instanceof Student){
                ((Student) user).editMajorMap(map);
                return true;
            }
        }
        return false;
    }

    public boolean getSemesterPlan(){
        if(user != null){
            if(user instanceof Student){
                System.out.println(((Student) user).getSemesterPlan());
                return true;
            }
        }
        return false;
    }

    public boolean editAdvisorNote(String note){
        if(user != null){
            if(user instanceof Student){
                ((Student) user).editAdvisorNote(note);
                return true;
            }
        }
        return false;
    }

    public boolean getAdvisorNote(String userID){
        if(user !=null && user.getUserID().equals(userID)){
            if(user instanceof Student){
                String advisorNote = ((Student) user).getAdvisorNote();
                System.out.println("Advisor note: " + advisorNote);
                return true;
            }
        }
        return false;
    }

    public boolean addStudent(Advisor advisor, String userID, boolean admin){
        if(user != null && user.equals(advisor) && advisor.getAdmin() && advisor != null){
            Student studentToAdd = advisor.addStudent(userID);
            if(studentToAdd != null){
                advisor.addStudent(studentToAdd);
                return true;
            }
        }
        return false;
    }

    public boolean removeStudent(Advisor advisor, String userID, boolean admin){
        if(user != null && user.equals(advisor) && advisor.getAdmin() && advisor != null){
            return advisor.removeStudent(userID);
        }
        return false;
    }

    public Student getStudent(String email){
        User user = studentList.getStudent(email);
        if(user != null && user instanceof Student){
            return (Student) user;
        }
        return null;
    }

    public Student getStudent(String firstName, String lastName){
        User user = studentList.getStudent(firstName, lastName);
        if(user != null && user instanceof Student){
            return (Student) user;
        }
        return null;
    }

    public Advisor getAdvisor(String email){
        User user = advisorList.getAdvisor(email);
        if(user != null && user instanceof Advisor){
            return (Advisor) user;
        }
        return null;
    }

    public boolean isAdmin(boolean admin){
        return user != null && admin == true;
    }
}
