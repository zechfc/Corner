import java.util.ArrayList;

public class UserList {
    private static UserList users;
    private  ArrayList<User> userList;
    // not sure we need this private  ArrayList<User> students;

    private UserList(){
        userList = DataLoader.getUsers();
        //users = new ArrayList<User>();
        //students = new ArrayList<User>();
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

    public ArrayList<User> getUsers(){
       
        return userList;
    }


    public User getUser(String userName, String password){
        //Checks each user in users array list
        for(User user : userList){
            if(user.getUsername().equals(userName) && user.getPassword().equals(password)){
                return user;
            } //checks if usernames are equals and passwords are equal
        }
        return null;
    }

    public void setUser(){
        
    }

    public void editUser(String user){

    }


    //method for adding to the JSON
    public void addUser(String firstName, String middleName, String lastName, String UserID, String age, String email, String userType){
        userList.add(new User(UserID, firstName, lastName, age, email, userType, userType, userType));
        DataWriter.saveUsers();

    }


