import java.util.ArrayList;

public class ClassList {
    private static ArrayList<Class> courseList;
    private ClassList() {

    }
    public Class getInstance() {
        Class c = new Class(null, null, null, null, null, false, 0);
        return c;
    }
    public ArrayList<Class> getClass(String className) {
        return this.courseList;
    }
    public Class checkPrereq(Class cass, double grade) {
        Class c = new Class(null, null, null, null, null, false, 0);
        return c;
    }
}
