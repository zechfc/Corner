import java.util.ArrayList;
import java.util.UUID;

public class AdvisorList {
    private static AdvisorList Advisors;
    private  ArrayList<Advisor> AdvisorList;
    // not sure we need this private  ArrayList<Advisor> students;

    private AdvisorList(){
        AdvisorList = DataLoader.getAdvisors();
        //Advisors = new ArrayList<Advisor>();
        //students = new ArrayList<Advisor>();
    }

    public static AdvisorList getInstance(){
        if (Advisors == null){
            Advisors = new AdvisorList();
        }
        return Advisors;
    }

    public boolean haveAdvisor(String email){
        for(Advisor Advisor : AdvisorList )  {
            if(Advisor.getEmail().equals(email)){
                return true;
            }
        }
        return false;

    }
 
    //need this one
    public ArrayList<Advisor> getAdvisors(){
        return AdvisorList;
    }

    public Advisor getVerfiedAdvisor(String email, String password){
        //Checks each Advisor in Advisors array list
        for(Advisor Advisor : AdvisorList){
            if(Advisor.getEmail().equals(email) && Advisor.getPassword().equals(password)){
                return Advisor;
            } //checks if Advisornames are equals and passwords are equal
        }
        return null;
    }

    public void setAdvisor(){
        
    }

    public void editAdvisor(String Advisor){

    }

    //method for adding to the JSON
    public void addAdvisor(String userId, ArrayList<Student> studentsSupervising, String email, String firstName, String middleName, 
        String lastName, String age, Boolean admin, String password){
        AdvisorList.add(new Advisor(userId,studentsSupervising, email, firstName, middleName, lastName, age, admin, password));
        DataWriter.saveAdvisors();

    }

    public void removeStudent(Student student){
        //Calls data writer to remove Student from system
    }

    public Advisor getAdvisor(String email){
        for(Advisor advisor : AdvisorList){
            if(advisor.getEmail().equals(email)){
                return advisor;
            }
        }
        return null;
    }

}

