import java.util.UUID;

public class Application {
    private UserList userList;
    private ClassList classList;
    private User user;

    public Application(){
        this.userList = UserList.getInstance();
        this.classList = ClassList.getInstance();
    }

    public boolean login(String userName, String password){
        User loggedInUser = userList.getUser(userName, password);
        if(loggedInUser != null){
            user = loggedInUser;
            return true;
        }
        return false;
    }

    public User createAccount(UUID uuid, String email, String firstName, String middleName, String lastName, String age, String password, String userType){
        user = new User(uuid, email, firstName, middleName, lastName, age, password, userType);
        userList.addUser(uuid, email, firstName, middleName, lastName, age, userType, password);
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

    public boolean addStudent(Advisor advisor, String userID, String userType){
        if(user != null && user.equals(advisor) && isAdmin(userType) && advisor != null){
            Student studentToAdd = advisor.addStudent(userID);
            if(studentToAdd != null){
                advisor.addStudent(studentToAdd);
                return true;
            }
        }
        return false;
    }

    public boolean removeStudent(Advisor advisor, String userID, String userType){
        if(user != null && user.equals(advisor) && isAdmin(userType) && advisor != null){
            return advisor.removeStudent(userID);
        }
        return false;
    }

    public Student getStudent(String userID){
        User user = userList.getUser(userID);
        if(user != null && user instanceof Student){
            return (Student) user;
        }
        return null;
    }

    public Student getStudent(String firstName, String lastName){
        User user = userList.getUser(firstName, lastName);
        if(user != null && user instanceof Student){
            return (Student) user;
        }
        return null;
    }

    public Advisor getAdvisor(String userID){
        User user = userList.getUser(userID);
        if(user != null && user instanceof Advisor){
            return (Advisor) user;
        }
        return null;
    }

    public boolean isAdmin(String userType){
        return user != null && userType == "Admin";
    }
}
