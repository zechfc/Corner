import java.util.ArrayList;

public class MajorClass {
    private String name;
    private String description;
    private ArrayList<Class> liberalArtsCourses;
    private ArrayList<Class> electiveCourses;
    private ArrayList<Class> concentrationCourses;
    private ArrayList<Class> carolinaCoreCourses;
    private ArrayList<Class> requiredCourses;

    public MajorClass(String name, String description, ArrayList<Class> liberalArtsCourses, ArrayList<Class> electiveCourses, ArrayList<Class> concentrationCourses, ArrayList<Class> carolinaCoreCourses, ArrayList<Class> requiredCourses) {
        this.name = name;
        this.description = description;
        this.liberalArtsCourses = liberalArtsCourses;
        this.electiveCourses = electiveCourses;
        this.concentrationCourses = concentrationCourses;
        this.carolinaCoreCourses = carolinaCoreCourses;
        this.requiredCourses = requiredCourses;
    }

    public ArrayList<Class> getRequiredClasses() {
        return requiredCourses;
    }

    // Getters and setters for other attributes as needed

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Class> getLiberalArtsCourses() {
        return liberalArtsCourses;
    }

    public void setLiberalArtsCourses(ArrayList<Class> liberalArtsCourses) {
        this.liberalArtsCourses = liberalArtsCourses;
    }

    // Implement getters and setters for other attributes similarly
}
