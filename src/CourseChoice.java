import java.util.ArrayList;

public class CourseChoice {
    private requireType prerequisite;
    private ArrayList<String> courses;
    public CourseChoice(requireType prereq, ArrayList<String> courseIDs) {
        this.prerequisite = prereq;
        this.courses = courseIDs;
    }
    public boolean checkPrerequisites(ArrayList<Course> classTaken) {
        return true;
    }
    public boolean checkCoreqs(ArrayList<Course> classTaking) {
        return true;
    }
}
