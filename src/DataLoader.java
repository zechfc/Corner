import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class DataLoader extends DataConstants{
	
	public static ArrayList<Student> getStudents() {
		ArrayList<User> users = new ArrayList<User>();
		
		try {
			FileReader reader = new FileReader(STUDENT_FILE_NAME);
			JSONParser parser = new JSONParser();	
			JSONArray studentListJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < studentListJSON.size(); i++) {
				JSONObject studentJSON = (JSONObject)studentListJSON.get(i);
				UUID Userid = UUID.fromString((String)studentJSON.get(USER_ID));
				String email = (String)studentJSON.get(USER_USER_NAME);
				String firstName = (String)studentJSON.get(USER_FIRST_NAME);
				String middleName = (String)studentJSON.get(USER_MIDDLE_NAME);
				String lastName = (String)studentJSON.get(USER_LAST_NAME);
				String age = ((String)studentJSON.get(USER_AGE));
				String password = (String)studentJSON.get(USER_PASSWORD);
				
				Major major = (Major)studentJSON.get(MAJOR);
				String classification = (String)studentJSON.get(CLASSIFICATION);
				String semester = (String)studentJSON.get(SEMESTER);
				String grade = (String)studentJSON.get(GRADE);
				String year = (String)studentJSON.get(YEAR);
				int transferCredits = (int)studentJSON.get(TRANSFER_CREDITS);
				new Student(Userid, email, firstName, middleName, lastName, age, password, major, classification, transferCredits);
						
				users.add(new User(Userid, email, firstName, middleName, lastName, age, password));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<Advisor> getAdvisors(){
		ArrayList<User> users = new ArrayList<User>();

		try{
			FileReader reader = new FileReader(ADVISOR_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray advisorListJSON = (JSONArray)new JSONParser().parse(reader);

			for(int i = 0; i < advisorListJSON.size(); i++){
				JSONObject advisorJSON = (JSONObject)advisorListJSON.get(i);
				UUID Userid = UUID.fromString((String)advisorJSON.get(USER_ID));
				String email = (String)advisorJSON.get(USER_USER_NAME);
				String firstName = (String)advisorJSON.get(USER_FIRST_NAME);
				String middleName = (String)advisorJSON.get(USER_MIDDLE_NAME);
				String lastName = (String)advisorJSON.get(USER_LAST_NAME);
				String age = ((String)advisorJSON.get(USER_AGE));
				String password = (String)advisorJSON.get(USER_PASSWORD);
				boolean admin = ((boolean)advisorJSON.get(ADMIN));
				ArrayList<Student> studentList = (ArrayList<Student>)advisorJSON.get(STUDENT_LIST);
				new Advisor(Userid, studentList, firstName, middleName, lastName, age, email, admin, password);

				users.add(new User(Userid, email, firstName, middleName, lastName, age, password));
			}			
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
