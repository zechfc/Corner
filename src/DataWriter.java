import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {

	public static void saveStudents() {
		StudentList studentList/*users*/ = StudentList.getInstance();
		ArrayList<Student> students = studentList.getStudents();
		JSONArray jsonStudents = new JSONArray();

		//creating all the json objects
		for(int i=0; i< students.size(); i++) {
			jsonStudents.add(getStudentJSON(students.get(i)));
		}

		//Write JSON file
		try (FileWriter file = new FileWriter(STUDENT_FILE_NAME)) {
			file.write(jsonStudents.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void saveAdvisors() {
		AdvisorList advisorList/*users*/ = AdvisorList.getInstance();
		ArrayList<Advisor> advisors = advisorList.getAdvisors();
		JSONArray jsonAdvisors = new JSONArray();

		//creating all the json objects
		for(int i=0; i< advisors.size(); i++) {
			jsonAdvisors.add(getAdvisorJSON(advisors.get(i)));
		}

		//Write JSON file
		try (FileWriter file = new FileWriter(ADVISOR_FILE_NAME)) {
			file.write(jsonAdvisors.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static JSONObject getStudentJSON(Student student) {	
		JSONObject studentDetails = new JSONObject();

//		studentDetails.put(ADVISOR_ID, student.getAdvisor());
		studentDetails.put(student.getAdvisorID(), student.getAdvisor());
		studentDetails.put(MAJOR, student.getMajor());
		studentDetails.put(COURSES_PRESENT, student.getCurrentYear());
//		studentDetails.put(FALL, "Fall"); //ENUM
//		studentDetails.put(SPRING, "Spring"); //ENUM
//		studentDetails.put(SPRING, "Spring"); //ENUM
//		studentDetails.put(SUMMER, "Summer"); //ENUM
		studentDetails.put(CLASSIFICATION, "Junior");
		studentDetails.put(NOTES, student.getAdvisorNote());
		studentDetails.put(TRANSFER_CREDITS, student.getTransferCredits());

        return studentDetails;
	}

	public static JSONObject getAdvisorJSON(Advisor advisor) {	
		JSONObject advisorDetails = new JSONObject();
		advisorDetails.put(STUDENT_LIST, advisor.getStudentList());
        return advisorDetails;
	}

	// Users is deprecated


//	public static void saveUsers() {
//		UserList userList/*users*/ = UserList.getInstance();
////		ArrayList<User> users = userList.getUsers();
//		ArrayList<User> users = userList.getUsers();
//		JSONArray jsonUsers = new JSONArray();
//
//		//creating all the json objects
//		for(int i=0; i< users.size(); i++) {
//			jsonUsers.add(getUserJSON(users.get(i), null, null));
//		}
//
//		//Write JSON file
//		try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
//
//			file.write(jsonUsers.toJSONString());
//			file.flush();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	//	public static JSONObject getUserJSON(User user, Student student, Advisor advisor) {
//		JSONObject userDetails = new JSONObject();
//
//		userDetails.put(USER_ID, user.getUserID().toString());
//		userDetails.put(USER_USER_NAME, user.getUserName());
//		userDetails.put(USER_FIRST_NAME, user.getFirstName());
//		userDetails.put(USER_LAST_NAME, user.getLastName());
//		userDetails.put(USER_TYPE, user.getUserType());
//		userDetails.put(USER_MIDDLE_NAME, user.getMiddleName());
//		userDetails.put(USER_PASSWORD, user.getPassword());
//		userDetails.put(USER_AGE, user.getUserAge());
//
//		if (user.getUserType().equalsIgnoreCase("student")) {
//			getStudentJSON(student);
//		}
//
//		if (user.getUserType().equalsIgnoreCase("advisor")) {
//			userDetails.put(ADVISOR_ID, user.getUserID().toString());
//			getAdvisorJSON(advisor);
//		}
//
//        return userDetails;
//	}
	
}
