import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants {

	public static ArrayList<Student> getStudents() {
		ArrayList<Student> studentList = new ArrayList<Student>();
		
		try {
			FileReader reader = new FileReader(STUDENT_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray studentListJSON = (JSONArray) new JSONParser().parse(reader);

			for (int i = 0; i < studentListJSON.size(); i++) {
				JSONObject studentJSON = (JSONObject) studentListJSON.get(i);
				String userID = (String) studentJSON.get(USER_ID);
				String email = (String) studentJSON.get(USER_USER_NAME);
				String firstName = (String) studentJSON.get(USER_FIRST_NAME);
				String middleName = (String) studentJSON.get(USER_MIDDLE_NAME);
				String lastName = (String) studentJSON.get(USER_LAST_NAME);
				String age = ((String) studentJSON.get(USER_AGE));
				String password = (String) studentJSON.get(USER_PASSWORD);
				String major = (String) studentJSON.get(MAJOR);
				String classification = (String) studentJSON.get(CLASSIFICATION);
				int transferCredits = ((Long) studentJSON.get(TRANSFER_CREDITS)).intValue();
				JSONArray pastCourses = (JSONArray) studentJSON.get(COURSES_PAST);
				JSONArray currentCourses = (JSONArray) studentJSON.get(COURSES_PRESENT);

				String advisorID = (String) studentJSON.get(ADVISOR_ID);
				String advisorNote = (String) studentJSON.get(NOTES);
				studentList.add(new Student(userID, email, firstName, middleName, lastName, age,
					password, major, classification, transferCredits, currentCourses, pastCourses, advisorID, advisorNote));
			}


			return studentList;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<Advisor> getAdvisors() {
		ArrayList<Advisor> advisorList = new ArrayList<Advisor>();

		try {
			FileReader reader = new FileReader(ADVISOR_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray advisorListJSON = (JSONArray) new JSONParser().parse(reader);

			for (int i = 0; i < advisorListJSON.size(); i++) {
				JSONObject advisorJSON = (JSONObject) advisorListJSON.get(i);
				String userid = (String) advisorJSON.get(USER_ID);
				String email = (String) advisorJSON.get(USER_USER_NAME);
				String firstName = (String) advisorJSON.get(USER_FIRST_NAME);
				String middleName = (String) advisorJSON.get(USER_MIDDLE_NAME);
				String lastName = (String) advisorJSON.get(USER_LAST_NAME);
				String age = ((String) advisorJSON.get(USER_AGE));
				String password = (String) advisorJSON.get(USER_PASSWORD);
				boolean admin = ((boolean) advisorJSON.get(ADMIN));
				ArrayList<String> studentList = (ArrayList<String>) advisorJSON.get(STUDENT_LIST);
				advisorList.add(
						new Advisor(userid, studentList, firstName, middleName, lastName, age, email, admin, password));
			}

			return advisorList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public static ArrayList<Major> getMajor() {
		ArrayList<Major> majorList = new ArrayList<Major>();

		try {
			FileReader reader = new FileReader(MAJORS_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray majorListJSON = (JSONArray) new JSONParser().parse(reader);

			for (int i = 0; i < majorListJSON.size(); i++) {
				JSONObject majorJSON = (JSONObject) majorListJSON.get(i);
				String majorid = (String) majorJSON.get(MAJOR_ID);
				String name = (String) majorJSON.get(MAJOR_NAME);
				String description = (String) majorJSON.get(DESCRIPTION);
				long totalHoursProgramRequirements = (long) majorJSON.get(TOTAL_PROGRAM_REQ_HOURS);
				long totalHours = (long) majorJSON.get(TOTAL_HOURS);
				long carolinaHours = ((long) majorJSON.get(CAROLINA_HOURS));
				long majorHours = ((long) majorJSON.get(MAJOR_REQUIRMENTS_HOURS));

				ArrayList<Course> programRequirements = (ArrayList<Course>) majorJSON.get(PROGRAM_REQUIREMENTS);
				ArrayList<Course> carolinaCore = (ArrayList<Course>) majorJSON.get(CAROLINA_CORE);
				ArrayList<Course> majorRequirements = (ArrayList<Course>) majorJSON.get(MAJOR_REQUIRMENTS);

				majorList.add(
				new Major(programRequirements, carolinaCore, majorRequirements, majorid, description, carolinaHours, majorHours, totalHoursProgramRequirements, totalHours));
			}

			return majorList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<Course> getCourses() {
		ArrayList<Course> classlist = new ArrayList<Course>();
		try {
			FileReader reader = new FileReader(COURSE_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray courseListJSON = (JSONArray) new JSONParser().parse(reader);
			for (int i = 0; i < courseListJSON.size(); i++) {
				JSONObject courseJSON = (JSONObject) courseListJSON.get(i);
				JSONArray jsonArray = (JSONArray) courseJSON.get(COURSE_PREREQS);
				ArrayList<CourseChoice> cc = new ArrayList<CourseChoice>();
				for (int j = 0; jsonArray != null && j < jsonArray.size(); j++) {
					JSONObject courseChoiceJSON = (JSONObject) jsonArray.get(j);
					String requireType = (String) courseChoiceJSON.get(COURSE_PREREQ_REQUIRETYPE);
					ArrayList<String> courseIDList = (ArrayList<String>) courseChoiceJSON.get(COURSE_ID);
					cc.add(new CourseChoice(requireType, courseIDList));
				}
				String courseid = (String) courseJSON.get(COURSE_ID);
				String coursekey = (String) courseJSON.get(COURSE_KEY);
				String courseName = (String) courseJSON.get(COURSE_NAME);
				String courseDescription = (String) courseJSON.get(COURSE_DESCRIPTION);
				boolean courseAvailability = (boolean) courseJSON.get(COURSE_AVAILABILITY);
				double courseCredits = ((double) courseJSON.get(COURSE_CREDITS));
				ArrayList<String> term = (ArrayList<String>) courseJSON.get(COURSE_TERM);
				String electiveArea = courseJSON.get(COURSE_ELECTIVE_AREA) != null ? (String)courseJSON.get(COURSE_ELECTIVE_AREA) : null;
				double passingGrade = (courseJSON.get(COURSE_PASSING_GRADE) != null) ? passingGrade = (double)((long) courseJSON.get(COURSE_PASSING_GRADE)) : 0;

				classlist.add(new Course(cc, courseid, coursekey, courseName, courseDescription, courseAvailability, courseCredits, term, electiveArea, passingGrade));
			}
			for (Course c : classlist) {
				//System.out.println(c.getCourseName());
				for (CourseChoice cc : c.getPrereqs()) {
					cc.linkFromUUIDRelatedClasses(classlist);
				}
			}
			return classlist;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
