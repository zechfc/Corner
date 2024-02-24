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

    public void setUser(){
        
    }

    public void editUser(String user){

    }
}
