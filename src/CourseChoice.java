import java.util.ArrayList;

public class CourseChoice {
    private requireType prerequisite;
    private ArrayList<String> courseIDs;
    private ArrayList<Course> courses;

    public CourseChoice(String prereq, ArrayList<String> courseIDs) {
        this.prerequisite = requireType.valueOf(prereq);
        this.courseIDs = courseIDs;
    }

    public void linkFromUUIDRelatedClasses(ArrayList<Course> classes) {
        for (String s : courseIDs) {
            for (Course c : courses) {
                if (c.getCourseID().equals(s))
                    courses.add(c);
            }
        }
    }

    public boolean checkPrerequisites(ArrayList<Course> classTaken) {
        if (this.prerequisite.equals(requireType.OR)) {
            for (Course cR : courses) {
                for (Course cT : classTaken) { // Could probably just check the courses themselves, they should match.
                    if (cT.getCourseID().equals(cR.getCourseID()))
                        return true; // Dare I say .contains()
                }
            }
        } else if (this.prerequisite.equals(requireType.AND)) {
            for (Course cR : courses) { // Brain broke pls fix
                boolean b = false;
                for (Course cT : classTaken) {
                    if (cT.getCourseID().equals(cR.getCourseID())) {
                        b = true;
                        break;
                    }
                }
                if (!b)
                    return false;
            }
        } else if (this.prerequisite.equals(requireType.PRE_OR_COREQ)) {
            for (Course cR : courses) {
                for (Course cT : classTaken) { // The same as OR here
                    if (cT.getCourseID().equals(cR.getCourseID()))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean checkCoreqs(ArrayList<Course> classTaking) {
        return true;
    }
}
