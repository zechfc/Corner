import java.util.ArrayList;

public class CourseList {
    private static CourseList courses;
    private static ArrayList<Course> courseList;

    private CourseList() {
        courseList = DataLoader.getCourses();
    }

    public static CourseList getInstance() {
        if (courses == null) {
            courses = new CourseList();
        }
        return courses;
    }

    public ArrayList<Course> getCourses() {
        return courseList;
    }

    public Course getCourse(String courseKey) {
        for (Course course : courseList) {
            if (course.getCourseKey().equals(courseKey)) {
                return course;
            }
        }
        return null;
    }

    public Course checkPrereq(Course course, double grade) {
        Course c = new Course(null, null, null, null, null, false, 0, null, null, 0);
        return c;
    }
}
