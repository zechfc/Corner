import java.util.ArrayList;

public class Major {
    private String name;
    private String description;
    private ArrayList<Course> collegeRequirements;
    private ArrayList<Course> carolinacoreCoursesReq;
    private ArrayList<Course> carolinacoreCourses;
    private ArrayList<Course> majorCourses;
    private int totalhours;
    private String majorID;


    public Major(ArrayList<Course> collegeRequirements, ArrayList<Course> carolinacoreCoursesReq, 
        ArrayList<Course> concentrationCourses, ArrayList<Course> carolinacoreCourses, ArrayList<Course> majorCourses, String majorID, String description){
        this.collegeRequirements = collegeRequirements;
        this.carolinacoreCoursesReq = carolinacoreCoursesReq;
        this.description = description;
        this.carolinacoreCourses = carolinacoreCourses;
        this.majorCourses = majorCourses;
        this.majorID = majorID;
    }

    public String getMajor() {
		return name;
	}

    public String getMajorID() {
		return majorID;
	}

    public String getDescription() {
		return description;
	}
    public int getTotalHours() {
		return totalhours;
	}

    public ArrayList<Course> getCollegeRequirements() {    
        return collegeRequirements;
	}

    public ArrayList<Course> getCarolinacoreCoursesReq() {    
        return carolinacoreCoursesReq;
	}

    public ArrayList<Course> getCarolinacoreCourses() {    
        return carolinacoreCourses;
	}

    public ArrayList<Course> getMajorCourses() {    
        return majorCourses;
	}
    
    public ArrayList<Course> getRequiredCourses() {    
        ArrayList<Course> requiredCourses = new ArrayList<>();
        requiredCourses.addAll(this.getCarolinacoreCoursesReq());
        requiredCourses.addAll(this.getCarolinacoreCourses());
        requiredCourses.addAll(this.getCollegeRequirements());
        requiredCourses.addAll(this.getMajorCourses());

        return requiredCourses;
	}
}