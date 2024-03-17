import java.util.ArrayList;

public class Course {
    private ArrayList<CourseChoice> prerequisite;
    private String courseID;
    private String courseSubject;
    private String courseNumber;
    private String courseName;
    private String courseDescription;
    private boolean courseAvailability;
    private double courseCredits;

    // Not sure all of the things in the constructor are stored.
    public Course(ArrayList<CourseChoice> prereq, String id, String subject, String number, String name, String description,
            boolean availability, double credits, String semester, int year) {
        prerequisite = prereq;
        courseID = id;
        courseSubject = subject;
        courseNumber = number;
        courseName = name;
        courseDescription = description;
        courseAvailability = availability;
        courseCredits = credits;
    }

    public boolean checkPrerequisites(ArrayList<Course> courses) {
        boolean b = true;
        for (CourseChoice pre : prerequisite) {
            b = b && pre.checkPrerequisites(courses); // This is genius don;t think about it
        }
        return b;
    }

    public boolean checkCoreqs(ArrayList<Course> courses) {
        return true;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getCourseSubject() {
        return courseSubject;
    }

    public String getCourseNumber(){
        return courseNumber;
    }

    public double getCourseCredits(){
        return courseCredits;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDescription() {
        return courseDescription;
    }

    public boolean getAvailability() {
        return courseAvailability;
    }

    public ArrayList<CourseChoice> getPrereqs() { // Only if you want array itself. For string form look at other method.
        return this.prerequisite;
    }

    public String toString() {
        return courseSubject + " " + courseNumber + ": " + courseName;
    }

    public String getPrereqsToString() {
        String s = "";
        for (CourseChoice cc : this.prerequisite) {
            s += cc.getCoursesToString();
        }
        return s;
    }
}