import java.util.ArrayList;

public class Major {
    private String name;
    private String description;
    private  ArrayList<Class> liberalArtsCourses;
    private  ArrayList<Class> electiveCourses;
    private  ArrayList<Class> concentrationCourses;
    private  ArrayList<Class> carolinacoreCourses;
    private  ArrayList<Class> requiredCourses;


    public Major(ArrayList<Class> liberalArtsCourses, ArrayList<Class> electiveCourses, ArrayList<Class> concentrationCourses, ArrayList<Class> carolinacoreCourses, ArrayList<Class> requiredCourses){
        this.liberalArtsCourses = liberalArtsCourses;
        this.electiveCourses = electiveCourses;
        this.concentrationCourses = concentrationCourses;
        this.carolinacoreCourses = carolinacoreCourses;
        this.requiredCourses = requiredCourses;
    }
    public String getMajor() {
		return name;
	}
    

}