import java.util.ArrayList;

import javax.xml.crypto.Data;

public class UserList {
    private static UserList userList;
    private  ArrayList<User> users;
    private  ArrayList<User> students;

    private UserList(){
        users = Database.getUsers();
        //users = new ArrayList<User>();
        //students = new ArrayList<User>();
    }

    public static UserList getInstance(){
        if (userList == null){
            userList = new UserList();
        }
        return userList;
    }

    public User getUser(String userID){
        if(!haveUser(userID)) return null;
        return new User(userID, null, null, null, null, null);
    }

    public void setUser(){
        
    }

    public void editUser(String user){

    }

    public boolean haveUser(String userName){
        return true;
    }
}
