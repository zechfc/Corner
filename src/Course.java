import java.util.ArrayList;

public class Course {
    private ArrayList<CourseChoice> prerequisite;
    private String courseID;
    private String courseKey;
    private String courseName;
    private String courseDescription;
    private boolean courseAvailability;
    private double courseCredits;

    public Course(ArrayList<CourseChoice> prereq, String id, String key, String name, String description, boolean availability, double credits) {
        prerequisite = prereq; courseID = id; courseKey = key; courseName = name; courseDescription = description; courseAvailability = availability; courseCredits = credits;
    }


    public boolean checkPrerequisites(ArrayList<Course> courses) {
        return true;
    }
    
    public boolean checkCoreqs(ArrayList<Course> courses) {
        return true;
    }

    
}