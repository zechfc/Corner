import java.util.ArrayList;
import java.util.HashMap;

public class Student extends User {
    private ArrayList<Course> pastCourses;
    private ArrayList<Course> currentCourses;
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
    private int transferCredits;
    private Advisor advisor;
    private String advisorNote;
    private String classification;

    public Student(String userID, String email, String firstName, String middleName, String lastName, String age,
            String password,
            String major, String classification, int transferCredits) {
        super(userID, firstName, middleName, lastName, age, email, password);
        this.major = major;
        this.concentration = concentration; 
        this.classification = classification; 
        this.advisorNote = advisorNote;
        this.currentYear = currentYear;
        this.transferCredits = transferCredits;
        this.totalCredits = 0;
        this.classLevel = "Freshman";
        this.USC_CREDITS = 0;
    }

    public void totalCompletedCredits(int transferCredits, int USC_CREDITS) {
        totalCredits = transferCredits + USC_CREDITS;
    }

    public double GPA(int totalCredits, int totalHours) {
        // where is totalHours coming from (not on UML)
        return 0.0;
    }

    public void updateGPA(double gpa, int credits) {

    }

    public void whatIf(String major, String concentration) {

    }

    public void contactAdvisor(String firstName, String lastName) {
        // is this a priority?
    }

    public void courseFeedback(String courseName) {
        // is this a priority?
    }

    public boolean atFailure(Course course, double grade) {
        return false;
    }

    public double updateGrade(Course course, double grade) {
        return 0.0;
    }

    public Advisor getAdvisor(){
        

        for(Advisor advisor: AdvisorList.getInstance().getAdvisors()){
            if(Advisor.hasStudent(this.getStudent()))
            {
                return true;

            }
        }
        return false;
        return advisor;

    }



    public String getAdvisorID(){
        return advisor.getUserID();

    }

    public String getMajorName() {
        return major;
    }

    public MajorMap getMajorMap() {
        return majorMap;
    }

    // todo - implement functionality
    public boolean updateFailureRisk() {
        failureRisk = true;
        return failureRisk;
    }

    public void editMajorMap(MajorMap newMajorMap) {
        majorMap = newMajorMap;
    }

    public SemesterPlan getSemesterPlan() {
        return new SemesterPlan(major, pastCourses);
        // SemesterPlan needs an ArrayList of completedCourses
        // Student only stores the hashmap of classesTaken

    }

    public void editAdvisorNote(String note) {
        // This will need to DataWriter to that student's 'note' in their json
        advisorNote = note;
    }

    public String getAdvisorNote() {
        return advisorNote;
    }

    public String getCurrentYear() {
        return currentYear;
    }

    public int getTransferCredits() {
        return transferCredits;
    }

    public String getClassification(){
        return classification;
    }

    public Student student(){
        return student();
    }
}
