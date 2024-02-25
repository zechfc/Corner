	
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
	
	
	public static void saveUsers() {
		UserList userList/*users*/ = UserList.getInstance();
		ArrayList<User> users = userList.getUsers();
		JSONArray jsonUsers = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< users.size(); i++) {
			jsonUsers.add(getUserJSON(users.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
 
            file.write(jsonUsers.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	
	
	public static JSONObject getUserJSON(User user) {	
		JSONObject userDetails = new JSONObject();
		userDetails.put(USER_ID, user.getUserID().toString());
		userDetails.put(USER_USER_NAME, user.getUserName());
		userDetails.put(USER_FIRST_NAME, user.getFirstName());
		userDetails.put(USER_LAST_NAME, user.getLastName());
		userDetails.put(USER_TYPE, user.getUserType());
		userDetails.put(USER_MIDDLE_NAME, user.getMiddleName());
		userDetails.put(USER_PASSWORD, user.getPassword());
		userDetails.put(USER_AGE, user.getUserAge());


        
        return userDetails;
	}
}
