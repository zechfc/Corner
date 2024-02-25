import java.util.Scanner;

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
        if(!application.login("jlDoe@email.sc.edu", "password123")){
            System.out.println("Sorry we couldn't login."); //login failed
            return;
        }
        System.out.println("John Doe is now logged in");

        Advisor advisor = application.getAdvisor();
        if(advisor == null){
            System.out.println("Sorry advisor not found.");
        }
        System.out.println("Advisor is in the system");
        System.out.println("\nMark Stevens is your advisor");

        if(!application.getAdvisorNote("d5478261-e50a-4ff9-b8bf-8c03b0280bc2")){
            System.out.println("Failed to get advisor note.");
        }
        System.out.println("Editing advisor note...");

        if(!application.editAdvisorNote("")){
            System.out.println("");
        }
        System.out.println("");
    }

    public void scenario2(){
        //Create account scenario
        System.out.println("\nCreating a new account...");

        String userName = "mayernii@email.sc.edu";
        String firstName = "Isaac";
        String lastName = "Mayernik";
        String password = "lol987";
        User newUser = application.createAccount(userName, password, firstName, lastName);
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
