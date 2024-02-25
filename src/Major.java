import java.util.ArrayList;

public class Major {
    private String name;
    private String description;
    private ArrayList<Class> collegeRequirements;
    private ArrayList<Class> carolinacoreCoursesReq;
    private ArrayList<Class> concentrationCourses;
    private ArrayList<Class> carolinacoreCourses;
    private ArrayList<Class> majorCourses;
    private int totalhours;


    public Major(ArrayList<Class> collegeRequirements, ArrayList<Class> carolinacoreCoursesReq, ArrayList<Class> concentrationCourses, ArrayList<Class> carolinacoreCourses, ArrayList<Class> majorCourses){
        this.collegeRequirements = collegeRequirements;
        this.carolinacoreCoursesReq = carolinacoreCoursesReq;
        this.concentrationCourses = concentrationCourses;
        this.carolinacoreCourses = carolinacoreCourses;
        this.majorCourses = majorCourses;
    }
    public String getMajor() {
		return name;
	}

    public int getTotalHours() {
		return totalhours;
	}
    public ArrayList<Class> getCollegeRequirements() {    
        return collegeRequirements;
	}
    public ArrayList<Class> getCarolinacoreCoursesReq() {    
        return carolinacoreCoursesReq;
	}
    public ArrayList<Class> getCarolinacoreCourses() {    
        return carolinacoreCourses;
	}
    public ArrayList<Class> getConcentrationCourses() {    
        return concentrationCourses;
	}
    public ArrayList<Class> getMajorCourses() {    
        return majorCourses;
	}
    public ArrayList<Class> getRequiredClasses() {    
        ArrayList<Class> requiredClasses = new ArrayList<>();
        requiredClasses.addAll(this.getCarolinacoreCoursesReq());
        requiredClasses.addAll(this.getCarolinacoreCourses());
        requiredClasses.addAll(this.getCollegeRequirements());
        requiredClasses.addAll(this.getConcentrationCourses());
        requiredClasses.addAll(this.getMajorCourses());

        return requiredClasses;
	}
    

}