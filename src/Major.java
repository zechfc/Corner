import java.util.ArrayList;

import org.json.simple.JSONObject;

public class Major {
    private String name;
    private String description;
    private ArrayList<String> programRequirements;
    private ArrayList<String> carolinacoreCoursesReq;
    //private ArrayList<Course> carolinacoreCourses;
    private ArrayList<String> majorCourses;
    private long totalhours;
    private long carolinaHours;
    private long majorHours;
    private long totalHoursProgramRequirements;



    private String majorID;


    public Major(String name, ArrayList<String> programRequirements, ArrayList<String> carolinacoreCoursesReq, ArrayList<String> majorCourses,
    String majorID, String description, long carolinaHours,long majorHours,long totalHoursProgramRequirements, long totalhours)
    {
        this.name = name;
        this.programRequirements = programRequirements;
        this.carolinacoreCoursesReq = carolinacoreCoursesReq;
        this.description = description;
        this.majorCourses = majorCourses;
        this.majorID = majorID;
        this.majorHours = majorHours;
        this.carolinaHours = carolinaHours;
        this.totalHoursProgramRequirements = totalHoursProgramRequirements;
        this.totalhours = totalhours;

        System.out.println(programRequirements.get(0));


    }

    public String getMajor() {
		return name;
	}

      public void getprogramRequirementsValues(){
        for(int i = 0; i < programRequirements.size(); i++){
           String temp = programRequirements.;
           
        }
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

    public ArrayList<String> getprogramRequirements() {    
        return programRequirements;
	}

    public ArrayList<String> getCarolinacoreCoursesReq() {    
        return carolinacoreCoursesReq;
	}

    public ArrayList<String> getCarolinacoreCourses() {    
        return carolinacoreCourses;
	}

    public ArrayList<String> getMajorCourses() {    
        return majorCourses;
	}
    
    // public ArrayList<Course> getRequiredCourses() {    
    //     ArrayList<Course> requiredCourses = new ArrayList<>();
    //     requiredCourses.addAll(this.getCarolinacoreCoursesReq());
    //     requiredCourses.addAll(this.getCarolinacoreCourses());
    //     requiredCourses.addAll(this.getprogramRequirements());
    //     requiredCourses.addAll(this.getMajorCourses());

    //     return requiredCourses;
	// }
}