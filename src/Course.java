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

    public ArrayList<CourseChoice> getPrereqs() { // Only if you want array itself. For string form look at other method.
        return this.prerequisite;
    }

    public String toString() {
        return courseKey + ": " + courseName;
    }

    public String getPrereqsToString() {
        String s = "";
        for (CourseChoice cc : this.prerequisite) {
            s += cc.getCoursesToString();
        }
        return s;
    }
}