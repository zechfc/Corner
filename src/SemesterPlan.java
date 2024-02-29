import java.util.ArrayList;
public class SemesterPlan {
    private String studentRequirements;
    protected ArrayList<String> SemesterPlan;

    public SemesterPlan(String major, ArrayList<Course> completedCourses) {
        this.studentRequirements = major;
        this.SemesterPlan = new ArrayList<>();
        // Generate semester plan based on completed courses and major requirements
        generatePlan(completedCourses);
    }

    private void generatePlan(ArrayList<Course> completedCourses) {
        // Logic to generate semester plan based on completed courses and major requirements
        // This can include checking prerequisites, corequisites, and other major requirements
        // and then planning out the upcoming semesters accordingly
    }

    public ArrayList<String> getStudentReq(String majorReq) {
        // Logic to retrieve specific student requirements based on major
        return new ArrayList<>(); // Placeholder
    }

    public ArrayList<Course> remainingCourses(String input) {
        // Logic to calculate remaining courses based on input
        return new ArrayList<>(); // Placeholder
    }

    public int totalCourses(String input) {
        // Logic to calculate total number of courses based on input
        return 0; // Placeholder
    }

    public ArrayList<String> output(String semesterPlan) {
        // Logic to output semester plan
        return new ArrayList<>(); // Placeholder
    }

    public int progress(double remainingCourses, double totalCourses) {
        // Logic to calculate progress based on remaining and total courses
        return 0; // Placeholder
    }
}
