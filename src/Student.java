import java.util.ArrayList;
import java.util.HashMap;

public class Student extends User{
    private HashMap<Class, grade> classesTaken;
    private ArrayList<Class> currentClasses;
    private SemesterPlan SemesterPlan;
    private MajorMap majorMap;
    private Major major;
    private String concentration;
    private double majorGPA;
    private double overallGPA;
    private String firstName;
    private String lastName;
    private String userName;
    private String userID;
    private String userType;
    private String classLevel;
    private boolean failureRisk;
    private int totalCredits;
    private int USC_CREDITS;
    private int transferCredits;
    private Advisor advisor;
    private String advisorNote;

    public Student(String userName, String firstName, String lastName, String userID, Advisor advisor, String userType, Major major, String concentration){
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userID = userID;
        this.advisor = advisor;
        this.userType = userType;
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

    public MajorMap getMajorMap(){
        return majorMap;
    }

    public boolean updateFailureRisk(){
        failureRisk = true;
    }
}