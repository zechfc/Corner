import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class UI {
    private Scanner scanner;
    private Application application;

    UI(){
        scanner = new Scanner(System.in);
        application = new Application();
    }

    public void run(){
        scenario1(); //Login scenario
        scenario2(); //Create account scenario
    }

    public void scenario1(){
        //Login scenario
        System.out.println();
    
        System.out.println("Type student or advisor for what you are");
        application.checkUser("student");
        System.out.println("User is a student");
    
        if(!application.login(1, "jlDoe@email.sc.edu", "password1")){
            System.out.println("Sorry we couldn't login."); //login failed
            return;
        }
        System.out.println("John Doe is now logged in");

        Advisor advisor = application.getAdvisor("d5478261-e50a-4ff9-b8bf-8c03b0280bc2");
        if(advisor == null){
            System.out.println("Sorry advisor not found.");
        }
        System.out.println("Advisor is in the system");
        System.out.println("\nMark Stevens is your advisor");

        if(!application.getAdvisorNote("d5478261-e50a-4ff9-b8bf-8c03b0280bc2")){
            System.out.println("Failed to get advisor note.");
        }
        System.out.println("Advisor note retrieved");

        if(!application.editAdvisorNote("Student recommended to take CSCE247")){
            System.out.println("Failed to edit advisor note.");
        }
        System.out.println("Advisor note edited");
    }

    public void scenario2(){
        //Create account scenario
        System.out.println("\nCreating a new account...");

        int i = 1;
        String email = "definitelyrealemail@gmail.com";
        String firstName = "Isaac";
        String middleName = "Andrew";
        String lastName = "Mayernik";
        String age = "20";
        String password = "lol987";
        String advisor = "temp person";
        String major = "CS";
        String concentration = "temp";
        ArrayList<Student> studentsSupervising = null;
        boolean admin = false;
        String uuid = "esnfaslkdfmlsakmdf";
        long transferCredits = 48;
        User newUser = application.createAccount(i, uuid, firstName, middleName, lastName, age, email, password, 
            advisor, major, concentration, studentsSupervising, admin, transferCredits);
        if(newUser == null){
            System.out.println("Failed to create account.");
        }
        System.out.println("Successfully created account for " + newUser.getFirstName());
    }

    public static void main(String[] args){
        UI applicationInterface = new UI();
        applicationInterface.run();
    }
}
