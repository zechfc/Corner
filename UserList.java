import java.util.ArrayList;

public class UserList {
    private static ArrayList<User> userList;
    private static ArrayList<User> studentList;

    private static UserList(){

    }

    public UserList getInstance{
        User u = new User();
        return u;
    }

    public User getUser(String userID){
        return this.userList;
    }

    public void setUser(){
        User u = new User(null, null, null, null, null, null, null);
        return u;
    }

    public void editUser(String userID){
        User u = new User(userID, null, null, null, null, null, null);
        return u;
    }

    public void addUser(String userID){
        return this.studentList;
    }
}
