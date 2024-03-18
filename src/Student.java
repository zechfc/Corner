import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;

public class Student extends User {
    private JSONArray pastCourses;
    private JSONArray currentCourses;
    private SemesterPlan semesterPlan;
    private MajorMap majorMap;
    private String major;
    private double majorGPA;
    private double overallGPA;
    private boolean failureRisk;
    private int totalCredits;
    private int transferCredits;
    private String applicationArea;
    private Advisor advisor;
    public String advisorID;
    private String advisorNote;
    private String classification;

    public Student(String userID, String email, String firstName, String middleName, String lastName, String age, String password,  
        String major, String classification, int transferCredits, String applicationArea, JSONArray currentCourses, JSONArray pastCourses, 
        String advisorID, String advisorNote){
            
        super(userID, firstName, middleName, lastName, age, email, password);
        this.major = major;
        this.classification = classification; 
        this.advisorNote = advisorNote;
        this.transferCredits = transferCredits;
        this.totalCredits = 0;
        this.applicationArea = applicationArea;
        this.classification = classification;
        this.currentCourses = currentCourses;
        this.pastCourses = pastCourses;
        this.advisorID = advisorID;
    }

    //Error thrown line 43 of StudentList, no constructor matches args
    // overloaded removed ArrayLists 3/14
    public Student(String userID, String email, String firstName, String middleName, String lastName, String age, String password,
                   String major, String classification, int transferCredits){

        super(userID, firstName, middleName, lastName, age, email, password);
        this.major = major;
        this.classification = classification;
//        this.advisorNote = null;
        this.transferCredits = transferCredits;
        this.totalCredits = 0;
        this.classification = classification;
//        this.currentCourses = null;
//        this.pastCourses = null;
//        this.advisorID = null;
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

    // public void calcMajorGPA(String major){
    //     ArrayList<Course> temp = MajorList.getInstance().getMajor(major).getMajorCourses();
    //     int length = temp.size();

    //     //looping through the major courses array
    //     for (int i=0; i<length; i++) {
    //         //checking if the name matches a course a student has taken
    //         Course 
    //         if(temp.getCourseName)
    //     };



    // }

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
        this.advisorNote = note;
        DataWriter.saveStudents();
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

    public JSONArray getPastCourses(){
        return pastCourses;
    }

    public JSONArray getCurrentCourses(){
        return currentCourses;
    }

    public String getApplicationArea() {
        return applicationArea;
    }

    public void setApplicationArea(String area) {
        this.applicationArea = area;
    }

    public void getPastCourseValues(){
        for(int i = 0; i < pastCourses.size(); i++){
            JSONObject temp = (JSONObject) pastCourses.get(i);
            //Gets values from JSON array from student JSON
            String id = (String) temp.get("courseID");
            String grade = (String) temp.get("grade");
            String semester = (String) temp.get("semester");
            int year = ((Long) temp.get("year")).intValue();

            CourseList courseList = CourseList.getInstance();
            ArrayList<Course> courses = courseList.getCourses();
            for(Course course : courses){
                //Goes through EVERY course (from JSON) and finds matching ID
                if(course.getCourseID().equals(id)){
                    System.out.println(course.getCourseName() + ": " + grade + ", taken in " + semester + " " + year);
                }
            }
        }
    }

    public void getCurrentCourseValues(){
        for(int i = 0; i < currentCourses.size(); i++){
            JSONObject temp = (JSONObject) currentCourses.get(i);
            //Gets values from JSON array from student JSON
            String id = (String) temp.get("courseID");
            String grade = (String) temp.get("grade");
            String semester = (String) temp.get("semester");
            int year = ((Long) temp.get("year")).intValue();

            CourseList courseList = CourseList.getInstance();
            ArrayList<Course> courses = courseList.getCourses();
            for(Course course : courses){
                //Goes through EVERY course and matches ID
                if(course.getCourseID().equals(id)){
                    System.out.println(course.getCourseName() + ": " + grade + ", taking " + semester + " " + year);
                }
            }
        }
    }

    public Student student(){
        return student();
    }

    public void editAdvisorID(String advisorID){
        if(this.advisorID == ""){
            this.advisorID = advisorID;
            DataWriter.saveStudents();
        }
    }
}
