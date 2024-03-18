import java.util.ArrayList;

public class Course {
    private ArrayList<CourseChoice> prerequisite;
    private String courseID;
    private String courseKey;
    private String courseNumber;
    private String courseName;
    private String courseDescription;
    private double courseCredits;

    // Not sure all of the things in the constructor are stored.
    public Course(ArrayList<CourseChoice> prereq, String id, String key, String name, String description,
            double credits, String semester, int year) {
        this.prerequisite = prereq;
        this.courseID = id;
        this.courseKey = key;
        this.courseName = name;
        this.courseDescription = description;
        this.courseCredits = credits;
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

    public String getCourseKey(){
        return courseKey;
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

    public ArrayList<CourseChoice> getPrereqs() { // Only if you want array itself. For string form look at other method.
        return this.prerequisite;
    }

    public String toString() {
        return courseName + " " + courseNumber + ": " + courseName;
    }

     public String getPrereqsToString() {
         String s = "";
         for (CourseChoice cc : this.prerequisite) {
             s += cc.getCoursesToString();
         }
         return s;
     }
}