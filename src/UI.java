import java.util.ArrayList;
import java.util.Scanner;

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
        scenario5(); //Advisor (not an admin) account created success scenario
        scenario5();
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

        if(!application.getAdvisorNote("d5478261-e50a-4ff9-b8bf-8c03b0280bc2")){
            System.out.println("Failed to get advisor note.");
        }
        System.out.println("Advisor note retrieved");

        if(!application.editAdvisorNote("Student recommended to take CSCE247")){
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

        int i = 1;
        String email = "definitelyrealemail@gmail.com";
        String firstName = "Isaac";
        String middleName = "Andrew";
        String lastName = "Mayernik";
        String age = "20";
        String password = "lol987";
        String major = "CS";
        String concentration = "None";
        boolean admin = false;
        String userID = "esnfaslkdfmlsakmdf";
        int transferCredits = 48;
        String advisorID = "d5478261-e50a-4ff9-b8bf-8c03b0280bc2";
        User newUser = application.createAccount(i, userID, firstName, middleName, lastName, age, email, password, 
            major, concentration, null, admin, transferCredits, advisorID);
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
        int i = 1;
        String email = "jlDoe@email.sc.edu";
        String firstName = "Jane";
        String middleName = "Lauren";
        String lastName = "Doe";
        String age = "19";
        String password = "sAfEpassword";
        String concentration = "None";
        String major = "CIS";
        boolean admin = false;
        String userID = "sflkve-dfsfde34fsdfv-csda";
        String advisorID = "d5478261-e50a-4ff9-b8bf-8c03b0280bc2";
        int transferCredits = 23;
        User newUser = application.createAccount(i, userID, firstName, middleName, lastName, age, email, password, 
            major, concentration, null, admin, transferCredits, advisorID);
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
        int i = 2;
        String userID = "plfdgksamdf-avdfa-fded";
        String firstName = "";
        String middleName = "";
        String lastName = "";
        String age = "";
        String email = "";
        String password = "";
        ArrayList<Student> studentsSupervising = new ArrayList<Student>();
        boolean admin = false;
        User newUser = application.createAccount(i, userID, firstName, middleName, lastName, age, email, password, null, null, studentsSupervising, admin, 0, null);
        if(newUser == null){
            System.out.println("Failed to create account.");

        }else {
            System.out.println("Successfully created account for " + newUser.getFirstName());
        }
    }

    public void scenario5() {
        /*if(!application.login(1, "jlDoe@email.sc.edu", "password1")){
            System.out.println("Sorry we couldn't login."); //login failed
            return;
        }
        System.out.println("John Doe is now logged in");*/ 
        ArrayList<Course> cList = application.getClasses();
        for (Course l : cList) {
            System.out.println("Class!");
            System.out.println(l.getCourseID());
        }
        System.out.println("Searching for data on CSCE146");
        Course c = application.getClass("CSCE146");
        if (c == null) {
            System.out.println("Class not found :(");
            return;
        }
        System.out.println("Getting details on CSCE146:\n" + c.getDescription());
        System.out.println("Getting availability of CSCE146:\n" + c.getAvailability());
        System.out.println("These are the prerequisites of CSCE146:\n" + c.getPrereqsToString());
    }

    public void scenario5() {
        /*if(!application.login(1, "jlDoe@email.sc.edu", "password1")){
            System.out.println("Sorry we couldn't login."); //login failed
            return;
        }
        System.out.println("John Doe is now logged in");*/ 
        ArrayList<Course> cList = application.getClasses();
        for (Course l : cList) {
            System.out.println("Class!");
            System.out.println(l.getCourseID());
        }
        System.out.println("Searching for data on CSCE146");
        Course c = application.getClass("CSCE146");
        if (c == null) {
            System.out.println("Class not found :(");
            return;
        }
        System.out.println("Getting details on CSCE146:\n" + c.getDescription());
        System.out.println("Getting availability of CSCE146:\n" + c.getAvailability());
        System.out.println("These are the prerequisites of CSCE146:\n" + c.getPrereqsToString());
    }

    public static void main(String[] args){
        UI applicationInterface = new UI();
        applicationInterface.run();
    }
}
