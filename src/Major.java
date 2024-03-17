import java.util.ArrayList;

public class Major {
    private String name;
    private String description;
    private ArrayList<Course> programRequirements;
    private ArrayList<Course> carolinacoreCoursesReq;
    //private ArrayList<Course> carolinacoreCourses;
    private ArrayList<Course> majorCourses;
    private long totalhours;
    private long carolinaHours;
    private long majorHours;
    private long totalHoursProgramRequirements;



    private String majorID;


    public Major(ArrayList<Course> programRequirements, ArrayList<Course> carolinacoreCoursesReq, ArrayList<Course> majorCourses,
    String majorID, String description, long carolinaHours,long majorHours,long totalHoursProgramRequirements, long totalhours)
    {
        this.programRequirements = programRequirements;
        this.carolinacoreCoursesReq = carolinacoreCoursesReq;
        this.description = description;
        this.majorCourses = majorCourses;
        this.majorID = majorID;
        this.majorHours = majorHours;
        this.carolinaHours = carolinaHours;
        this.totalHoursProgramRequirements = totalHoursProgramRequirements;
        this.totalhours = totalhours;

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
    public long getTotalHours() {
		return totalhours;
	}

    public ArrayList<Course> getprogramRequirements() {    
        return programRequirements;
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
        requiredCourses.addAll(this.getprogramRequirements());
        requiredCourses.addAll(this.getMajorCourses());

        return requiredCourses;
	}
}