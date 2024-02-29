import java.util.ArrayList;

public class Application {
    private StudentList studentList;
    private AdvisorList advisorList;
    private CourseList classList;
    private User user;

    public Application(){
        this.studentList = StudentList.getInstance();
        this.advisorList = AdvisorList.getInstance();
        this.classList = CourseList.getInstance();
    }

    public int checkUser(String input){
        if(input == "student"){
            return 1;
        }
        return 2;
    }

    public boolean login(int i, String email, String password){
        ArrayList<Student> students = DataLoader.getStudents();
        ArrayList<Advisor> advisors = DataLoader.getAdvisors();
        if(i == 1){
            for(Student student : students){
                if(student != null && student.getEmail().equals(email) && student.getPassword().equals(password)){
                    user = student;
                    return true;
                }
            }
        }else if(i == 2){
            for(Advisor advisor : advisors){
                if(advisor != null && advisor.getEmail().equals(email) && advisor.getPassword().equals(password)){
                    user = advisor;
                    return true; 
                }
            }
        }
        return false;
    }

    public User createAccount(int i, String userID, String firstName, String middleName, String lastName, String age, String email, 
        String password, String major, String concentration, ArrayList<Student> studentsSupervising, boolean admin, int transferCredits){
        
        //Email (username) already used
        if(studentList.emailTaken(email) || advisorList.emailTaken(email)){
            return null;
        }
        
        user = new User(userID, email, firstName, middleName, lastName, age, password);
        if(i == 1){
            Student temp = new Student(userID, email, firstName, middleName, lastName, age, password, major, concentration, transferCredits);
            studentList.addStudent(temp);
            return temp; // do we want to return temp or a student list

        }else if(i == 2){
            Advisor temp = new Advisor(userID, studentsSupervising, firstName, middleName, lastName, age, email, admin, password);
            advisorList.addAdvisor(userID, studentsSupervising, email, firstName, middleName, lastName, age, admin, password);
            return temp;
        }
        return null;
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
                System.out.print(advisorNote);
                return true;
            }
        }
        return false;
    }

    // public boolean addStudent(Advisor advisor, String userID){
    //     if(user != null && user.equals(advisor) && advisor.getAdmin() && advisor != null){
    //         Student studentToAdd = studentList.addStudent(userID);
    //         if(studentToAdd != null){
    //             advisorList.addStudent(studentToAdd);
    //             return true;
    //         }
    //     }
    //     return false;
    // }

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

    // public String getAdvisorName(String userID){
    //     User user = advisorList.getAdvisor(userID);
    //     if(user != null && user instanceof Advisor){
    //         return user.getFirstName() + " " + user.getLastName();
    //     }
    //     return null;
    // }

    public boolean getAdvisorID(String userID){
        if(user != null && user.getUserID().equals(userID)){
            if(user instanceof Student){
                ((Student) user).getAdvisorID();
                return true;
            }
        }
        return false;
    }

    public Advisor getAdvisor(String userID){
        User user = advisorList.getAdvisor(userID);
        if(user != null && user instanceof Advisor){
            return (Advisor) user;
        }
        return null;
    }

    public boolean isAdmin(boolean admin){
        return user != null && admin == true;
    }
}
