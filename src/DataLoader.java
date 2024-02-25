
import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class DataLoader extends DataConstants{
	
	public static ArrayList<User> getUsers() {
		ArrayList<User> users = new ArrayList<User>();
		
		try {
			FileReader reader = new FileReader(USER_FILE_NAME);
			JSONParser parser = new JSONParser();	
			JSONArray userListJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < userListJSON.size(); i++) {
				JSONObject userJSON = (JSONObject)userListJSON.get(i);
				UUID Userid = UUID.fromString((String)userJSON.get(USER_ID));
				String email = (String)userJSON.get(USER_USER_NAME);
				String firstName = (String)userJSON.get(USER_FIRST_NAME);
				String middleName = (String)userJSON.get(USER_MIDDLE_NAME);
				String lastName = (String)userJSON.get(USER_LAST_NAME);
				String Usertype = (String)userJSON.get(USER_TYPE);
				String age = ((String)userJSON.get(USER_AGE));
				String password = (String)userJSON.get(USER_PASSWORD);
				
				users.add(new User(Userid, email, firstName,middleName, lastName, age, password, Usertype));
			}
			
			return users;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
