import java.util.ArrayList;
import java.util.Scanner;
import org.json.simple.JSONArray;

public class UI {
    private Scanner scanner;
    private Application application;

    UI(){
        scanner = new Scanner(System.in);
        application = new Application();
    }

    public void run(){
        //scenario1(); //Student login success scenario
        //scenario2(); //Student login failure scenario
        //scenario3(); //Student account created success scenario
        //scenario4(); //Student account created failure scenario
        //scenario5(); //Advisor (not an admin) account created success scenario
        //scenario6();
        demoscenario1();
        demoscenario2();
    }

    public void scenario1(){
        //Login success scenario
        System.out.println("Scenario 1");
    
        System.out.println("Type student or advisor for what you are"); // ?
        application.checkUser("student"); 
        System.out.println("User is a student");
    
        if(!application.login(1, "jlDoe@email.sc.edu", "password1")){
            System.out.println("Sorry we couldn't login."); //login failed
            return;
        }
        System.out.println("John Doe is now logged in");

        Advisor advisor = application.getAdvisor("4c01faab-34eb-482d-8def-1c45ea80a22d");
        if(advisor == null){
            System.out.println("Sorry advisor not found.");
        }
        System.out.println("Advisor is in the system");
        System.out.println("Mark Stevens is your advisor");

        application.getAdvisorNote("d5478261-e50a-4ff9-b8bf-8c03b0280bc2");

        if(!application.editAdvisorNote("d5478261-e50a-4ff9-b8bf-8c03b0280bc2", "Student recommended to take CSCE247")){
            System.out.println("Failed to edit advisor note.");
        }else {
            System.out.println("Advisor note edited.");
        }
    }

    public void scenario2(){
        //Login FAILURE scenario
        System.out.println("\nScenario 2");
        //I can change what student this looks at, but if I remember correctly it was not grabbing the
        // other student's userIDs
        System.out.println("Type student or advisor for what you are");
        application.checkUser("student");
        System.out.println("User is a student");
    
        if(!application.login(1, "jlDoe@email.sc.edu", "correctpassword")){
            System.out.println("Sorry we couldn't login."); //login failed (not the right password in the system)
            return;
        }
        System.out.println("John Doe is now logged in");
    }

    public void scenario3(){
        //Create account scenario
        System.out.println("\nScenario 3");
        System.out.println("Creating a new account...");

        String email = "definitelyrealemail@gmail.com";
        String firstName = "Isaac";
        String middleName = "Andrew";
        String lastName = "Mayernik";
        String age = "20";
        String password = "lol987";
        String major = "CS";
        String classification = "Senior";
        String userID = "esnfaslkdfmlsakmdf";
        int transferCredits = 48;
        String advisorID = "d5478261-e50a-4ff9-b8bf-8c03b0280bc2";
        String note = "...";
        JSONArray currentCourses = new JSONArray();
        JSONArray pastCourses = new JSONArray();
        User newUser = application.createStudentAccount(userID, firstName, middleName, lastName, age, email, password, major, classification, 
        transferCredits, advisorID, note, currentCourses, pastCourses);
        if(newUser == null){
            System.out.println("Failed to create account.");
        }else {
            System.out.println("Successfully created account for " + newUser.getFirstName());
        }
    }

    public void scenario4(){
        System.out.println("\nScenario 4");
        //The way it is setup now, users cannot share the same email. Therefore,
        System.out.println("Creating a new account...");
        String email = "jlDoe@email.sc.edu";
        String firstName = "Jane";
        String middleName = "Lauren";
        String lastName = "Doe";
        String age = "19";
        String password = "sAfEpassword";
        String classification = "Sophomore";
        String major = "CIS";
        String userID = "sflkve-dfsfde34fsdfv-csda";
        String advisorID = "d5478261-e50a-4ff9-b8bf-8c03b0280bc2";
        String note = "...";
        int transferCredits = 23;
        JSONArray currentCourses = new JSONArray();
        JSONArray pastCourses = new JSONArray();
        User newUser = application.createStudentAccount(userID, firstName, middleName, lastName, age, email, password, major, classification, 
            transferCredits, advisorID, note, currentCourses, pastCourses);
        if(newUser == null){
            System.out.println("Failed to create account.");
        }else {
            System.out.println("Successfully created account for " + newUser.getFirstName());
        }
    }

    public void scenario5(){
        System.out.println("\nScenario 5");
        //Successfully create an advisor, not an admin
        System.out.println("Creating a new account...");
        String userID = "plfdgksamdf-avdfa-fded";
        String firstName = "Lee";
        String middleName = "Robert";
        String lastName = "Mo";
        String age = "47";
        String email = "molee@email.sc.edu";
        String password = "safesecurepass";
        ArrayList<String> studentsSupervising = new ArrayList<String>();
        boolean admin = false;
        User newUser = application.createAdvisorAccount(userID, firstName, middleName, lastName, age, email, password, studentsSupervising, admin);
        
        if(newUser == null){
            System.out.println("Failed to create account.");

        }else {
            System.out.println("Successfully created account for " + newUser.getFirstName());
        }
    }

    public void scenario6() {
        /*if(!application.login(1, "jlDoe@email.sc.edu", "password1")){
            System.out.println("Sorry we couldn't login."); //login failed
            return;
        }
        System.out.println("John Doe is now logged in");*/ 
        System.out.println("\nScenario 6");

        //for testing
        // ArrayList<Course> cList = application.getClasses();
        // for (Course l : cList) {
        //     System.out.println("Class!");
        //     System.out.println(l.getCourseID());
        // }
        
        System.out.println("Searching for data on CSCE146");
        Course c = application.getClass("CSCE146");
        if (c == null) {
            System.out.println("Class not found :(");
            return;
        }
        System.out.println("Getting details on CSCE146:\n" + c.getDescription());
        // System.out.println("Getting availability of CSCE146:\n" + c.getAvailability());
        // System.out.println("These are the prerequisites of CSCE146:\n" + c.getPrereqsToString());
    }

    public void demoscenario1(){
        System.out.println("\nScenario 1");

    }

    public void demoscenario2(){
        System.out.println("\nScenario 2");
        System.out.println("Creating a new account...");
        ArrayList<String> studentsSupervising = new ArrayList<String>();
        User newuser = application.createAdvisorAccount("asifkk-vsfmmmsc-lafd023", "Osbert", "Will", "Odden", "34", "oddeno@email.sc.edu", "oddenpassword", studentsSupervising, false);

        if(newuser == null){
            System.out.println("Failed to create a new account");
            return;
        } else{
            System.out.println("Successfully created a new account for...\n" + newuser.getFirstName() + " " + newuser.getLastName());
        }
        
        System.out.println("\nLogging in...");
        //THIS WILL GIVE AN ERROR unless DataWriter append in savestudents and saveadvisors is removed
        if(!application.login(2, "oddeno@email.sc.edu", "oddenpassword")){
            System.out.println("Sorry we couldn't login."); //login failed
            return;
        }
        System.out.println(newuser.getFirstName() + " " + newuser.getLastName() + " is now logged in");

        //Need to add advisorID to student's json
        System.out.println("\nAdding student to supervising list...");
        if(!application.addStudentList("asifkk-vsfmmmsc-lafd023", "0a119e07-a0aa-435e-9b9d-21e5b91b1c39")){
            System.out.println("Could not add student."); //failed
            return;
        } else{
            System.out.println("Successfully added student to supervising list.");
        }

        System.out.println("\nPrinting student's past courses...");
        application.getPastClasses("0a119e07-a0aa-435e-9b9d-21e5b91b1c39");

        //Editing advisor note
        if(!application.editAdvisorNote("0a119e07-a0aa-435e-9b9d-21e5b91b1c39", "Consider taking Stats as your Application area.")){
            System.out.println("\nCould not edit advisor note."); //failed
            return;
        } else{
            System.out.println("\nSuccessfully edited advisor note.");
            System.out.println("Showing student's advisor note...");
            application.getAdvisorNote("0a119e07-a0aa-435e-9b9d-21e5b91b1c39");
        }
    }

    public static void main(String[] args){
        UI applicationInterface = new UI();
        applicationInterface.run();
    }
}
