import java.util.ArrayList;

public class Course {
    private ArrayList<CourseChoice> prerequisite;
    private String courseID;
    private String courseKey;
    private String courseName;
    private String courseDescription;
    private boolean courseAvailability;
    private double courseCredits;

    // Not sure all of the things in the constructor are stored.
    public Course(ArrayList<CourseChoice> prereq, String id, String key, String name, String description,
            boolean availability, double credits, String term, double passingGrade) {
        prerequisite = prereq;
        courseID = id;
        courseKey = key;
        courseName = name;
        courseDescription = description;
        courseAvailability = availability;
        courseCredits = credits;
    }

    public boolean checkPrerequisites(ArrayList<Course> courses) {
        return true;
    }

    public boolean checkCoreqs(ArrayList<Course> courses) {
        return true;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getCourseKey() {
        return courseKey;
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

    public ArrayList<CourseChoice> getPrereqs() {
        return this.prerequisite;
    }
}