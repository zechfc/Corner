import java.util.ArrayList;

public class CourseList {
    private static CourseList classList;
    private static ArrayList<Course> courses;
    
    private CourseList() {
        courses = new ArrayList<Course>();
    }

    public static CourseList getInstance() {
        if (classList == null){
            classList = new CourseList();
        }
        return classList;
    }

    public ArrayList<Course> getCourse(String className) {
        return courses;
    }

    public Course checkPrereq(Course cass, double grade) {
        Course c = new Course(null, null, null, null, null, false, 0);
        return c;
    }
}
