public class Application {
    private UserList userList;
    private ClassList classList;
    private User user;

    public Application(){

    }

    public User login(String userName, String password){
        return user;
    }

    public User createAccount(String userName, String password, String firstName, String lastName){
        return user;
    }

    public MajorMap getMajorMap(String userID){
        return null;
    }

    public void editMajorMap(String userID){

    }

    public SemesterPlan getSemesterPlan(){
        return null;
    }

    public void editAdvisorNote(String note){

    }

    public void getAdvisorNote(String userID){

    }

    public void addStudent(Advisor advisor, String userType){

    }

    public void removeStudent(String userID){

    }

    public Student getStudent(String userID){
        return null;
    }

    public Student getStudent(String firstName, String lastName){
        return null;
    }

    public Advisor getAdvisor(){
        return null;
    }

    public boolean isAdmin(){
        return false;
    }
}
