import java.util.ArrayList;

public class Application {
    private StudentList studentList;
    private AdvisorList advisorList;
    private CourseList classList;
    private User user;

    public Application() {
        this.studentList = StudentList.getInstance();
        this.advisorList = AdvisorList.getInstance();
        this.classList = CourseList.getInstance();
    }

    public int checkUser(String input) {
        if (input == "student") {
            return 1;
        }
        return 2;
    }

    public boolean login(int i, String email, String password) {
        ArrayList<Student> students = DataLoader.getStudents();
        ArrayList<Advisor> advisors = DataLoader.getAdvisors();
        if (i == 1) {
            for (Student student : students) {
                if (student != null && student.getEmail().equals(email) && student.getPassword().equals(password)) {
                    user = student;
                    return true;
                }
            }
        } else if (i == 2) {
            for (Advisor advisor : advisors) {
                if (advisor != null && advisor.getEmail().equals(email) && advisor.getPassword().equals(password)) {
                    user = advisor;
                    return true;
                }
            }
        }
        return false;
    }

    public User createStudentAccount(String userID, String firstName, String middleName, String lastName, String age,
            String email, String password, String major, String classification, int transferCredits, String advisorID, 
            String advisorNote, ArrayList<Course> currentCourses, ArrayList<Course> pastCourses) {
        // Email (username) already used
        if (studentList.emailTaken(email)){
            return null;
        }
        Student newStudent = new Student(userID, email, firstName, middleName, lastName, age, password, major, classification, 
                transferCredits, currentCourses, pastCourses, advisorID, advisorNote);
        studentList.addStudent(newStudent);
        return newStudent; 
    }

    public User createAdvisorAccount(String userID, String firstName, String middleName, String lastName, String age, String email, String password,
        ArrayList<Student> studentsSupervising, boolean admin){
            if (advisorList.emailTaken(email)){
                return null;
            }
            Advisor newAdvisor = new Advisor(userID, studentsSupervising, firstName, middleName, lastName, age, email, admin, password);
            advisorList.addAdvisor(newAdvisor);
            return newAdvisor;
        }

    public boolean getMajorMap(String userID) {
        if (user != null && user.getUserID().equals(userID)) {
            if (user instanceof Student) {
                System.out.println(((Student) user).getMajorMap());
                return true;
            }
        }
        return false;
    }

    public boolean editMajorMap(String userID, MajorMap map) {
        if (user != null && user.getUserID().equals(userID)) {
            if (user instanceof Student) {
                ((Student) user).editMajorMap(map);
                return true;
            }
        }
        return false;
    }

    public boolean getSemesterPlan() {
        if (user != null) {
            if (user instanceof Student) {
                System.out.println(((Student) user).getSemesterPlan());
                return true;
            }
        }
        return false;
    }

    public boolean editAdvisorNote(String userID, String note) {
        User user = studentList.getStudent(userID);
        if (user != null) {
            if (user instanceof Student) {
                ((Student) user).editAdvisorNote(note);
                return true;
            }
        }
        return false;
    }

    public boolean getAdvisorNote(String userID) {
        User user = studentList.getStudent(userID);
        if (user != null && user.getUserID().equals(userID)) {
            if (user instanceof Student) {
                String advisorNote = ((Student) user).getAdvisorNote();
                System.out.print(advisorNote);
                return true;
            }
        }
        return false;
    }

    // This adds a student to the system, do not worry about right now
    // public boolean addStudent(Advisor advisor, String userID){
    //     if(user != null && user.equals(advisor) && advisor.getAdmin() && advisor != null){
    //         Student studentToAdd = studentList.addStudent(userID);
    //         if(studentToAdd != null){
    //             advisorList.addStudent(studentToAdd);
    //         return true;
    //         }
    //     }
    //     return false;
    // }

    public boolean addStudentList(String advisorID, String studentID){
        User user = advisorList.getAdvisor(advisorID);
        if (user != null && user instanceof Advisor){
            advisor.addStudentList(studentID);
            return true;
        }
        return false;
    }

    //This removes a student from the system, do not worry about right now
    // public boolean removeStudent(Advisor advisor, String userID, boolean admin) {
    //     if (user != null && user.equals(advisor) && advisor.getAdmin() && advisor != null) {
    //         return advisor.removeStudent(userID);
    //     }
    //     return false;
    // }

    public Student getStudent(String email) {
        User user = studentList.getStudent(email);
        if (user != null && user instanceof Student) {
            return (Student) user;
        }
        return null;
    }

    public Student getStudent(String firstName, String lastName) {
        User user = studentList.getStudent(firstName, lastName);
        if (user != null && user instanceof Student) {
            return (Student) user;
        }
        return null;
    }

    public boolean getAdvisorID(String userID) {
        if (user != null && user.getUserID().equals(userID)) {
            if (user instanceof Student) {
                ((Student) user).getAdvisorID();
                return true;
            }
        }
        return false;
    }

    public Course getClass(String classCode) {
        return classList.getCourse(classCode);
    }

    public ArrayList<Course> getClasses() {
        return classList.getCourses();
    }

    public Advisor getAdvisor(String userID) {
        User user = advisorList.getAdvisor(userID);
        if (user != null && user instanceof Advisor) {
            return (Advisor) user;
        }
        return null;
    }

    public boolean isAdmin(boolean admin) {
        return user != null && admin == true;
    }
}
