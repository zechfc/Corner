import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Student extends User{
    private ArrayList<Class> pastClasses;
    private ArrayList<Class> currentClasses;
    private SemesterPlan semesterPlan;
    private MajorMap majorMap;
    private String major;
    private String concentration;
    private double majorGPA;
    private double overallGPA;
    private String classLevel;
    private String currentYear;
    private boolean failureRisk;
    private int totalCredits;
    private int USC_CREDITS;
    private long transferCredits;
    private Advisor advisor;
    private String advisorID;
    private String advisorNote;

    public Student(String Userid, String email, String firstName, String middleName, String lastName, String age, String password, String advisorID, 
        String major, String classification, long transferCredits){
        super(Userid, firstName, middleName, lastName, age, email, password);
        this.major = major;
        this.concentration = classification; //Isaac - I am assuming this is what classification meant?
        this.advisorNote = "";
        this.currentYear = "2024";
        this.transferCredits = transferCredits;
    }
    

    //this will need to be updated isaac
    public Student(String userID, String firstName, String middleName, String lastName, String age, String email, String userType, String password, Advisor advisor,  String major, String concentration){
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
        this.totalCredits = totalCredits;
        this.classLevel = classLevel;
        this.USC_CREDITS = USC_CREDITS;

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

    public boolean atFailure(Class course, double grade){
        return false;
    }

    public double updateGrade(Class course, double grade){
        return 0.0;
    }

    public Advisor getAdvisor(){
        return advisor;
    }

    public String getAdvisorID(){
        return advisor.getUserID();
        
    }

    public String getMajorName(){
        return major;
    }
    
    public MajorMap getMajorMap(){
        return majorMap;
    }

    //todo - implement functionality
    public boolean updateFailureRisk(){
        failureRisk = true;
        return failureRisk;
    }

    public void editMajorMap(MajorMap newMajorMap){
        majorMap = newMajorMap;
    }

    public SemesterPlan getSemesterPlan(){
        return new SemesterPlan(major, pastClasses);
        //SemesterPlan needs an ArrayList of completedCourses
        //Student only stores the hashmap of classesTaken

    }

    public void editAdvisorNote(String note){
        //This will need to DataWriter to that student's 'note' in their json
        advisorNote = note;
    }

    public String getAdvisorNote(){
        return advisorNote;
    }

    public String getCurrentYear() {
        return currentYear;
    }

    public long getTransferCredits(){
        return transferCredits;
    }
}
