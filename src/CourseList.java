import java.util.ArrayList;

public class CourseList {
    private static CourseList courseList;
    private static ArrayList<Course> courses;
    
    private CourseList() {
        courses = new ArrayList<Course>();
    }

    public static CourseList getInstance() {
        if (courseList == null){
            courseList = new CourseList();
        }
        return courseList;
    }

    public ArrayList<Course> getCourse(String courseName) {
        return courses;
    }

    public Course checkPrereq(Course course, double grade) {
        Course c = new Course(null, null, null, null, null, false, 0);
        return c;
    }
}
