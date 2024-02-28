import java.util.ArrayList;
import java.util.UUID;

public class UserList {
    private static UserList users;
    private ArrayList<User> studentList;
    private ArrayList<User> arrayList;

    private UserList(){
        studentList = DataLoader.getStudents();
        arrayList = DataLoader.getAdvisors();
    }

    public static UserList getInstance(){
        if (users == null){
            users = new UserList();
        }
        return users;
    }

    public boolean haveUser(String email){
        for(User user : userList )  {
            if(user.getUserName().equals(email)){
                return true;
            }
    }
    return false;

    }
    public User getUser(String email){
        for(User user : userList )  {
            if(user.getUserName().equals(email)){
                return user;
            }

        }   
        return null;
    }
    
    //need this one

    public ArrayList<User> getUsers(){
       
        return userList;
    }


    public User getVerfiedUser(String userName, String password){
        //Checks each user in users array list
        for(User user : userList){
            if(user.getUserName().equals(userName) && user.getPassword().equals(password)){
                return user;
            } //checks if usernames are equals and passwords are equal
        }
        return null;
    }

    public void setUser(){
        
    }

    public void editUser(String user){

    }
//
//
//    //method for adding to the JSON
//    public void addUser(UUID uuid, String email, String firstName, String middleName, String lastName, String age, String password){
//        userList.add(new User(uuid, email, firstName, middleName, lastName, age, password));
//        DataWriter.saveUsers();
//
//    }

    public void removeStudent(Student student){
        //Calls data writer to remove Student from system
    }
}

