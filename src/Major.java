import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Major {
    private String name;
    private String description;
    private ArrayList<CourseReccommended> programRequirements;
    private ArrayList<CourseReccommended> carolinacoreCoursesReq;
    private ArrayList<Course> carolinacoreCourses;
    private ArrayList<CourseReccommended> majorCourses;
    private long totalhours;
    private long carolinaHours;
    private long carolinaReqHours;
    private long majorHours;
    private long totalHoursProgramRequirements;
    private String majorID;

    public Major(String name, ArrayList<CourseReccommended> programRequirements, ArrayList<CourseReccommended> carolinacoreCoursesReq, ArrayList<CourseReccommended> majorCourses,
    String majorID, String description, long carolinaHours,long majorHours,long carolinaReqHours,long totalHoursProgramRequirements, long totalhours)
    {
        this.name = name;
        this.programRequirements = programRequirements;
        this.carolinacoreCoursesReq = carolinacoreCoursesReq;
        this.description = description;
        this.majorCourses = majorCourses;
        this.carolinaReqHours = carolinaReqHours;
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

    // public ArrayList<Course> getCarolinaCoreCourses() {
	// 	return CourseList.getInstance().getCarolinaCoreCourses();
	// }

    public String getprogramRequirementsValues(String email){
        String toString;
        String list ="";

        
        ArrayList<pastCourses> pastCourses = new ArrayList<>();
        ArrayList<currentCourses> currentCourses = new ArrayList<>();
        StudentList studentList = StudentList.getInstance();

        ArrayList<Student> students = studentList.getStudents();

        for(Student student : students){
            if (email.equals(student.getEmail())) {
                pastCourses = student.getPastCourses();  
                break; 
            }

        // for(int i = 0; i < programRequirements.size(); i++){

        //     String id = programRequirements.get(i).getCourseRecID();
            
        //     CourseList courseList = CourseList.getInstance();
        //     ArrayList<Course> courses =courseList.getCourses();


        //     }
        }
           
            
            for(int j=0; j<pastCourses.size(); j++){
                String idPastCourse = pastCourses.get(j).getPastCourseID();
                String courseName = pastCourses.get(j).getPastCourse(idPastCourse).getCourseName();
                String courseGrade = pastCourses.get(j).getPastCourseGrade(courseName);
                
                String pass = "";

                    if (courseGrade.compareToIgnoreCase("C") <= 0) 
                    {
                         pass = "fail";    
                    }
                    if(courseGrade.equalsIgnoreCase("C+") || courseGrade.equalsIgnoreCase("B+")){
                        pass = "pass";    
                    }
                    else{
                        pass="pass";
                    }  
                    toString = (courseName + " " + courseGrade + " " + pass);
                    list += (toString + "\n");
                    }
                
              
            return list;

    }
    
    public String getRemaningProgramReq(String email){
        String toString;
        String list ="";
        JSONArray pastCourses = new JSONArray(); //wdwddwd
        StudentList studentList = StudentList.getInstance();
        ArrayList<Student> students = studentList.getStudents();
        JSONArray programRequirements = new JSONArray(); //wdwddwd
        JSONArray currentCourses = new JSONArray();

        
        for(Student student : students){
            if (email.equals(student.getEmail())) {
                pastCourses = student.getPastCourses();   
            }

        }
        for(int i = 0; i < pastCourses.size(); i++){
            JSONObject temp =  (JSONObject) pastCourses.get(i);
            String id = (String) temp.get("courseID"); //if this data field gets changed in majors.json, change it
           
            CourseList courseList = CourseList.getInstance();
            ArrayList<Course> courses =courseList.getCourses();

            for(int j=0; j<this.programRequirements.size(); j++){
                JSONObject programRequirement = (JSONObject) this.programRequirements.get(j); //fefeffefef
                String idCourse = (String) programRequirement.get("courseID"); //if this data field gets changed in majors.json, change it
                
                
                if((idCourse.equals(id))){
                    break;
                }
                else{
                    for(int k=0; k<courses.size(); k++){
                        String temp2 = courses.get(k).getCourseName();
                        String UUID = courses.get(k).getCourseID();
                        if (UUID.equalsIgnoreCase(idCourse)) {
                            toString = (temp2 + " " );

                            list += (toString + "\n");


                        }
                        }
                }
                  
                    }
                
              
                

            }
            return list;

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

    public String getMajorRequirementsValues(String email) {
        String toString;
        String list ="";
        for(int i = 0; i < majorCourses.size(); i++){
            JSONObject temp =  (JSONObject) majorCourses.get(i);
            String id = (String) temp.get("courseID"); //if this data field gets changed in majors.json, change it
           
            CourseList courseList = CourseList.getInstance();
            ArrayList<Course> courses =courseList.getCourses();
            StudentList studentList = StudentList.getInstance();
            ArrayList<Student> students = studentList.getStudents();
            JSONArray pastCourses = new JSONArray();
            JSONArray currentCourses = new JSONArray();


            for(Student student : students){
                if (email.equals(student.getEmail())) {
                    pastCourses = student.getPastCourses();   
                }

            }
            String pass = "";
           
            
            for(int j=0; j<pastCourses.size(); j++){
                JSONObject pastCourse = (JSONObject) pastCourses.get(j);
                String idCourse = (String) pastCourse.get("courseID"); //if this data field gets changed in majors.json, change it
                String courseName= (String) temp.get("name"); //if this data field gets changed in majors.json, change it
                String courseGrade = (String) pastCourse.get("grade"); //if this data field gets changed in majors.json, change it
                
                if(idCourse.equals(id)){
                    if (courseGrade.compareToIgnoreCase("C") <= 0) 
                    {
                         pass = "fail";    
                    }
                    if(courseGrade.equalsIgnoreCase("C+") || courseGrade.equalsIgnoreCase("B+")){
                        pass = "pass";    

                    }
                    else{
                        pass="pass";
                    }


                    for(int k=0; k<courses.size(); k++){
                        String temp2 = courses.get(k).getCourseName();
                        String UUID = courses.get(k).getCourseID();
                        if (UUID.equalsIgnoreCase(idCourse)) {
                            toString = (temp2 + " " + courseGrade + " " + pass);

                            list += (toString + "\n");


                        }
                        }
                    }
                }
              
                for(int j=0; j<currentCourses.size(); j++){
                    JSONObject currentCourse = (JSONObject) currentCourses.get(j);
                    String idCourse = (String) currentCourse.get("courseID"); //if this data field gets changed in majors.json, change it
                    String courseName= (String) temp.get("name"); //if this data field gets changed in majors.json, change it
                    String courseGrade = (String) currentCourse.get("grade"); //if this data field gets changed in majors.json, change it
                     pass = "";
    
                    if(idCourse.equals(id)){
                     
                        

    
                        for(int k=0; k<courses.size(); k++){
                            String temp2 = courses.get(k).getCourseName();
    
                            if (courses.get(k).getCourseID().equalsIgnoreCase(idCourse)) {
                                toString = ("Inprogress " + temp2 + " " + courseGrade + " " + "TBD");
                                list += (toString + "\n");
    
                            }
                            }
                        }
                    }

            }
            if (list == "") {
                list = "null";
            }
            return list;
    }

    public String getCarolinaCoreRequirementsValues(String email) {
        String toString;
        String list ="";
        for(int i = 0; i < carolinacoreCoursesReq.size(); i++){
            JSONObject temp =  (JSONObject) carolinacoreCoursesReq.get(i);
            String id = (String) temp.get("courseID"); //if this data field gets changed in majors.json, change it
           
            CourseList courseList = CourseList.getInstance();
            ArrayList<Course> courses =courseList.getCourses();
            StudentList studentList = StudentList.getInstance();
            ArrayList<Student> students = studentList.getStudents();
            JSONArray pastCourses = new JSONArray();
            JSONArray currentCourses = new JSONArray();


            for(Student student : students){
                if (email.equals(student.getEmail())) {
                    pastCourses = student.getPastCourses();   
                }

            }
            String pass = "";
           
            
            for(int j=0; j<pastCourses.size(); j++){
                JSONObject pastCourse = (JSONObject) pastCourses.get(j);
                String idCourse = (String) pastCourse.get("courseID"); //if this data field gets changed in majors.json, change it
                String courseName= (String) temp.get("name"); //if this data field gets changed in majors.json, change it
                String courseGrade = (String) pastCourse.get("grade"); //if this data field gets changed in majors.json, change it
                
                if(idCourse.equals(id)){
                    if (courseGrade.compareToIgnoreCase("C") <= 0) 
                    {
                         pass = "fail";    
                    }
                    if(courseGrade.equalsIgnoreCase("C+") || courseGrade.equalsIgnoreCase("B+")){
                        pass = "pass";    

                    }
                    else{
                        pass="pass";
                    }


                    for(int k=0; k<courses.size(); k++){
                        String temp2 = courses.get(k).getCourseName();
                        String UUID = courses.get(k).getCourseID();
                        if (UUID.equalsIgnoreCase(idCourse)) {
                            toString = (temp2 + " " + courseGrade + " " + pass);

                            list += (toString + "\n");


                        }
                        }
                    }
                }
              
                for(int j=0; j<currentCourses.size(); j++){
                    JSONObject currentCourse = (JSONObject) currentCourses.get(j);
                    String idCourse = (String) currentCourse.get("courseID"); //if this data field gets changed in majors.json, change it
                    String courseName= (String) temp.get("name"); //if this data field gets changed in majors.json, change it
                    String courseGrade = (String) currentCourse.get("grade"); //if this data field gets changed in majors.json, change it
                     pass = "";
    
                    if(idCourse.equals(id)){
                     
                        

    
                        for(int k=0; k<courses.size(); k++){
                            String temp2 = courses.get(k).getCourseName();
    
                            if (courses.get(k).getCourseID().equalsIgnoreCase(idCourse)) {
                                toString = ("Inprogress " + temp2 + " " + courseGrade + " " + "TBD");
                                list += (toString + "\n");
    
                            }
                            }
                        }
                    }

            }
            return list;

    }
    

    public String getCarolinaCoreValues(String email) {
        JSONArray allMajorCourses = new JSONArray();
        allMajorCourses.addAll(carolinacoreCoursesReq);
        allMajorCourses.addAll(majorCourses);
        allMajorCourses.addAll(programRequirements);
        String toString;
        String list ="";
        for(int i = 0; i < carolinacoreCoursesReq.size(); i++){
            JSONObject temp =  (JSONObject) carolinacoreCoursesReq.get(i);
            String id = (String) temp.get("courseID"); //if this data field gets changed in majors.json, change it
           
            CourseList courseList = CourseList.getInstance();
            ArrayList<Course> courses =courseList.getCourses();
            StudentList studentList = StudentList.getInstance();
            ArrayList<Student> students = studentList.getStudents();
            JSONArray pastCourses = new JSONArray();
            JSONArray currentCourses = new JSONArray();


            for(Student student : students){
                if (email.equals(student.getEmail())) {
                    pastCourses = student.getPastCourses();   
                }

            }
            String pass = "";
           
            
            for(int j=0; j<pastCourses.size(); j++){
                JSONObject pastCourse = (JSONObject) pastCourses.get(j);
                String idCourse = (String) pastCourse.get("courseID"); //if this data field gets changed in majors.json, change it
                String courseName= (String) temp.get("name"); //if this data field gets changed in majors.json, change it
                String courseGrade = (String) pastCourse.get("grade"); //if this data field gets changed in majors.json, change it
                
                if(!(idCourse.equals(id))){
                    if (courseGrade.compareToIgnoreCase("C") <= 0) 
                    {
                         pass = "fail";    
                    }
                    if(courseGrade.equalsIgnoreCase("C+") || courseGrade.equalsIgnoreCase("B+")){
                        pass = "pass";    

                    }
                    else{
                        pass="pass";
                    }


                    for(int k=0; k<courses.size(); k++){
                        String temp2 = courses.get(k).getCourseName();
                        String UUID = courses.get(k).getCourseID();
                        if (UUID.equalsIgnoreCase(idCourse)) {
                            toString = (temp2 + " " + courseGrade + " " + pass);

                            list += (toString + "\n");


                        }
                        }
                    }
                }
              
                for(int j=0; j<currentCourses.size(); j++){
                    JSONObject currentCourse = (JSONObject) currentCourses.get(j);
                    String idCourse = (String) currentCourse.get("courseID"); //if this data field gets changed in majors.json, change it
                    String courseName= (String) temp.get("name"); //if this data field gets changed in majors.json, change it
                    String courseGrade = (String) currentCourse.get("grade"); //if this data field gets changed in majors.json, change it
                     pass = "";
    
                    if(!(idCourse.equals(id))){
                     
                        

    
                        for(int k=0; k<courses.size(); k++){
                            String temp2 = courses.get(k).getCourseName();
    
                            if (courses.get(k).getCourseID().equalsIgnoreCase(idCourse)) {
                                toString = ("Inprogress " + temp2 + " " + courseGrade + " " + "TBD");
                                list += (toString + "\n");
    
                            }
                            }
                        }
                    }

            }
            if (list == "") {
                list = "null";
            }
            return list;
    }

    /*public void getCarolinaCoreValues(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCarolinaCoreValues'");
    }*/

    public long getProgramReqHours() {
        return this.totalHoursProgramRequirements;
    }

    public long getcarolinaHours() {
        return this.carolinaHours;
    }
    }


    
    // public ArrayList<Course> getRequiredCourses() {    
    //     ArrayList<Course> requiredCourses = new ArrayList<>();
    //     requiredCourses.addAll(this.getCarolinacoreCoursesReq());
    //     requiredCourses.addAll(this.getCarolinacoreCourses());
    //     requiredCourses.addAll(this.getprogramRequirements());
    //     requiredCourses.addAll(this.getMajorCourses());

    //     return requiredCourses;
	// }
