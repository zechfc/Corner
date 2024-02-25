import java.util.ArrayList;

public class UserList {
    private static UserList userList;
    private static ArrayList<User> users;
    private static ArrayList<User> students;

    private UserList(){
        users = new ArrayList<User>();
        students = new ArrayList<User>();
    }

    public static UserList getInstance(){
        if (userList == null){
            userList = new UserList();
        }
        return userList;
    }

    public User getUser(String userID){
        return new User(userID, null, null, null, null, null);
    }

    public User getUser(String userName, String password){
        //Checks each user in users array list
        for(User user : users){
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

    public void addUser(User user){
        user = new User(null, null, null, null);
    }
}
