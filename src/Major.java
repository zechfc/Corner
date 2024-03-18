import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Major {
    private String name;
    private String description;
    private JSONArray programRequirements;
    private JSONArray carolinacoreCoursesReq;
    private JSONArray carolinacoreCourses;
    private JSONArray majorCourses;
    private long totalhours;
    private long carolinaHours;
    private long majorHours;
    private long totalHoursProgramRequirements;
    private String majorID;

    public Major(String name, JSONArray programRequirements, JSONArray carolinacoreCoursesReq, JSONArray majorCourses,
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

    public void getprogramRequirementsValues(String email){
        for(int i = 0; i < programRequirements.size(); i++){
            JSONObject temp =  (JSONObject) programRequirements.get(i);
            String id = (String) temp.get("courseID"); //if this data field gets changed in majors.json, change it
           
            CourseList courseList = CourseList.getInstance();
            StudentList studentList = StudentList.getInstance();
            ArrayList<Student> students = studentList.getStudents();
            JSONArray pastCourses = new JSONArray();

            for(Student student : students){
                if (email.equals(student.getEmail())) {
                    pastCourses = student.getPastCourses();   
                }

            }

            
            for(int j=0; j<pastCourses.size(); j++){
                JSONObject pastCourse = (JSONObject) pastCourses.get(j);
                String idCourse = (String) pastCourse.get("courseID"); //if this data field gets changed in majors.json, change it

                if(idCourse.equals(id)){
                        System.out.println(idCourse);
                }
            }
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

    public JSONArray getprogramRequirements() {    
        return programRequirements;
	}

    public JSONArray getCarolinacoreCoursesReq() {    
        return carolinacoreCoursesReq;
	}

    public JSONArray getCarolinacoreCourses() {    
        return carolinacoreCourses;
	}

    public JSONArray getMajorCourses() {    
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