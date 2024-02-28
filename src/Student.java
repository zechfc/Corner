import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Student extends User{
    private ArrayList<Class> pastClasses;
    private ArrayList<Class> currentClasses;
    private SemesterPlan semesterPlan;
    private MajorMap majorMap;
    private Major major;
    private String concentration;
    private double majorGPA;
    private double overallGPA;
    private String classLevel;
    private String currentYear;
    private boolean failureRisk;
    private int totalCredits;
    private int USC_CREDITS;
    private int transferCredits;
    private Advisor advisor;
    private String advisorNote;

    public Student(UUID Userid, String email, String firstName, String middleName, String lastName, String age, String password, 
        Major major, String classification, String advisorNote, String currentYear, int transferCredits){
        super(Userid, firstName, middleName, lastName, age, email, password);
        this.major = major;
        this.concentration = classification; //Isaac - I am assuming this is what classification meant?
        this.advisorNote = advisorNote;
        this.currentYear = currentYear;
        this.transferCredits = transferCredits;
    }

    public Student(UUID userID, String firstName, String middleName, String lastName, String age, String email, String password, Advisor advisor,  Major major, String concentration){
        super(userID, firstName, middleName, lastName, age, email, password); //User(UUID userID, String firstName, String middleName, String lastName, String age, String email, String userType, String password)
        this.email = email;
        this.password = password;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userID = userID;
        this.advisor = advisor;
        this.major = major;
        this.concentration = concentration;
    }

    public void totalCompletedCredits(int transferCredits, int USC_CREDITS){
        totalCredits = transferCredits + USC_CREDITS;
    }

    public double GPA(int totalCredits, int totalHours){
        //where is totalHours coming from (not on UML)
        return 0.0;
    }

    public void updateGPA(double gpa, int credits){

    }

    public void whatIf(String major, String concentration){

    }

    public void contactAdvisor(String firstName, String lastName){
        //is this a priority?
    }

    public void courseFeedback(String courseName){
        //is this a priority?
    }

    public boolean atFailure(Class class, double grade){
        return false;
    }

    public double updateGrade(Class class, double grade){
        return 0.0;
    }

    public Advisor getAdvisor(){
        return advisor;
    }

    public Major getMajor(){
        return major;
    }
    
    public MajorMap getMajorMap(){
        return majorMap;
    }

    public boolean updateFailureRisk(){
        failureRisk = true;
    }

    public void editMajorMap(MajorMap newMajorMap){
        majorMap = newMajorMap;
    }

    public SemesterPlan getSemesterPlan(){
        SemesterPlan(major, classesTaken); 
        //SemesterPlan needs an ArrayList of completedCourses
        //Student only stores the hashmap of classesTaken
    }

    public void editAdvisorNote(String note){
        advisorNote = note;
    }

    public String getAdvisorNote(){
        return advisorNote;
    }

    public String getCurrentYear() {
        // TODO Auto-generated method stub
        return "2024";
    }

    public int getTransferCredits(){
        return transferCredits;
    }
}
