import java.util.ArrayList;
import java.util.HashMap;

public class Student extends User {
    private ArrayList<Course> pastCourses;
    private ArrayList<Course> currentCourses;
    private SemesterPlan semesterPlan;
    private MajorMap majorMap;
    private String major;
    private double majorGPA;
    private double overallGPA;
    private boolean failureRisk;
    private int totalCredits;
    private int transferCredits;
    private Advisor advisor;
    public String advisorID;
    private String advisorNote;
    private String classification;

    public Student(String userID, String email, String firstName, String middleName, String lastName, String age, String password,  
        String major, String classification, int transferCredits, ArrayList<Course> currentCourses,ArrayList<Course> pastCourses ){
        super(userID, firstName, middleName, lastName, age, email, password);
        this.major = major;
        this.classification = classification; 
        this.advisorNote = advisorNote;
        this.transferCredits = transferCredits;
        this.totalCredits = 0;
        this.classification = classification;
        this.currentCourses = currentCourses;
        this.pastCourses = pastCourses;

        this.advisorID = advisorID;
    }

    public void totalCompletedCredits(int transferCredits, int USC_CREDITS) {
        totalCredits = transferCredits + USC_CREDITS;
    }

    public double overallGPA(double overallGPA){
        return overallGPA;
    }

    public double majorGPA(double majorGPA){
        return majorGPA;
    }

    public void calcMajorGPA(String major){
        ArrayList<Course> temp = MajorList.getInstance().getMajor(major).getMajorCourses();
        int length = temp.size();

        //looping through the major courses array
        for (int i=0; i<length; i++) {
            //checking if the name matches a course a student has taken
            Course 
            if(temp.getCourseName)
        };



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

    // This does not work since DataWriter is calling this method, and this is returning
    // a type Advisor, which the DataWriter line is setting the ADVISOR_ID, which is a string
    // public Advisor getAdvisor(){
    //     for(Advisor advisor: AdvisorList.getInstance().getAdvisors()){
    //         Student temp = this.student();
    //         if(advisor.hasStudent(temp))
    //         {
    //             return advisor;
    //         }
    //     }
    //     return null;
    // }

    //The DataWriter should be calling this, no? (I have changed)
    public String getAdvisorID(){
        return advisorID;
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
