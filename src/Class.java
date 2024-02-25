import java.util.ArrayList;

public class Class {
    private ArrayList<CourseChoice> prerequisite;
    private String courseID;
    private String courseKey;
    private String courseName;
    private String courseDescription;
    private boolean courseAvailability;
    private double courseCredits;

    public Class(ArrayList<CourseChoice> prereq, String id, String key, String name, String description, boolean availability, double credits) {
        prerequisite = prereq; courseID = id; courseKey = key; courseName = name; courseDescription = description; courseAvailability = availability; courseCredits = credits;
    }


    public boolean checkPrerequisites(ArrayList<Class> classes) {
        return true;
    }
    public boolean checkCoreqs(ArrayList<Class> classes) {
        return true;
    }

    
}