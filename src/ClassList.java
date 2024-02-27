import java.util.ArrayList;

public class ClassList {
    private static ClassList classList;
    private static ArrayList<Class> courses;
    
    private ClassList() {
        courses = new ArrayList<Class>();
    }

    public static ClassList getInstance() {
        if (classList == null){
            classList = new ClassList();
        }
        return classList;
    }

    public ArrayList<Class> getClass(String className) {
        return courses;
    }

    public Class checkPrereq(Class cass, double grade) {
        Class c = new Class(null, null, null, null, null, false, 0);
        return c;
    }
}
