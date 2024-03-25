import java.util.ArrayList;
public class currentCourses {
    private String courseID;
    private String grade;
    private String semester;
    private long year;

    

    public currentCourses(String courseID, String grade, String semester,long year) {
        this.courseID = courseID;
        this.grade = grade;
        this.semester = semester;
        this.year = year;
        
    }

   public String getCurrentCourseID(){
    return this.courseID;
   }

   public String getCurrentCourseGrade(String courseID){
    return this.grade;
   }

   public String getCurrentCourseSemester(String courseID){
    return this.semester;
   }

   public long getCurrentCourseYear(String courseID){
    return this.year;
   }
   public Course getCurrentCourse(String courseID){
       return CourseList.getInstance().getCourse(courseID);
}

}