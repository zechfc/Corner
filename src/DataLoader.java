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
				
				if (Usertype.equalsIgnoreCase("student")) {
					
					JSONObject StudentJSON = (JSONObject)userListJSON.get(i);
					UUID advisorid = (UUID)StudentJSON.get(ADVISOR_ID);
					Major major = (Major)StudentJSON.get(MAJOR);
					String classification = (String)StudentJSON.get(CLASSIFICATION);
					String fall = (String)StudentJSON.get(FALL);
					String summer = (String)StudentJSON.get(SUMMER);
					String spring = (String)StudentJSON.get(SPRING);
					String advisorNote = (String)StudentJSON.get(ADVISOR_NOTE);
					String currentYear = (String)StudentJSON.get(CURRENT_YEAR);
					int transferCredits = (int)StudentJSON.get(TRANSFER_CREDITS);
					new Student(Userid, email, firstName, middleName, lastName, Usertype, age, password, major, classification, advisorNote, currentYear, transferCredits);
				
				}
				if (Usertype.equalsIgnoreCase("advisor")) {
					
					JSONObject AdvisorJSON = (JSONObject)userListJSON.get(i);
					UUID userid = (UUID)AdvisorJSON.get(ADVISOR_ID); //or should this be userID?
					ArrayList<Student> studentList = (ArrayList<Student>)AdvisorJSON.get(STUDENT_LIST);
					
					new Advisor(studentList, Userid, firstName, middleName, lastName, age, email, Usertype, password);

				}

				
				users.add(new User(Userid, email, firstName,middleName, lastName, age, password, Usertype));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
