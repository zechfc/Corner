import java.util.ArrayList;

public class CourseChoice {
    private requireType prerequisite;
    private ArrayList<String> courses;
    public CourseChoice(requireType prereq, ArrayList<String> courseIDs) {
        this.prerequisite = prereq;
        this.courses = courseIDs;
    }
    public boolean checkPrerequisites(ArrayList<Class> classTaken) {
        return true;
    }
    public boolean checkCoreqs(ArrayList<Class> classTaking) {
        return true;
    }
}
