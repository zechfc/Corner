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

				//JSONArray pastCoursesJSON = (JSONArray) studentJSON.get(COURSES_PAST);
				ArrayList<Course> pastCourses = (ArrayList<Course>) studentJSON.get(COURSES_PAST);
				// for(int j = 0; j < pastCoursesJSON.size(); j++){
				// 	System.out.println(j);
				// 	JSONObject pastCourse = (JSONObject) pastCoursesJSON.get(j);
				// 	String courseID = (String) pastCourse.get(COURSE_ID);
				// 	String grade = (String) pastCourse.get(GRADE);
				// 	String semester = (String) pastCourse.get(SEMESTER);
				// 	int year = ((Long) pastCourse.get(YEAR)).intValue();
				// }
				
				//JSONArray currentCoursesJSON = (JSONArray) studentJSON.get(COURSES_PRESENT);
				ArrayList<Course> currentCourses = (ArrayList<Course>) studentJSON.get(COURSES_PRESENT);
				// for(int j = 0; j < currentCourses.size(); j++){
				// 	JSONObject currentCourse = (JSONObject) currentCoursesJSON.get(j);
				// 	String courseCode = (String) currentCourse.get(COURSE_ID);
				// 	String grade = (String) currentCourse.get(GRADE);
				// 	String semester = (String) currentCourse.get(SEMESTER);
				// 	int year = ((Long) currentCourse.get(YEAR)).intValue();
				// }

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
				//JSONArray jsonArray = (JSONArray) courseJSON.get(COURSE_PREREQS);
				ArrayList<CourseChoice> cc = new ArrayList<CourseChoice>();
				// for (int j = 0; jsonArray != null && j < jsonArray.size(); j++) {
				// 	JSONObject courseChoiceJSON = (JSONObject) jsonArray.get(j);
				// 	String requireType = (String) courseChoiceJSON.get(COURSE_PREREQ_REQUIRETYPE);
				// 	ArrayList<String> courseIDList = (ArrayList<String>) courseChoiceJSON.get(COURSE_ID);
				// 	cc.add(new CourseChoice(requireType, courseIDList));
				// }
				String courseID = (String) courseJSON.get(COURSE_ID);
				String courseSubject = (String) courseJSON.get(COURSE_SUBJECT);
				String courseNumber = (String) courseJSON.get(COURSE_NUMBER);
				String courseName = (String) courseJSON.get(COURSE_NAME);
				String courseDescription = (String) courseJSON.get(COURSE_DESCRIPTION);
				ArrayList prereqs = (ArrayList) courseJSON.get(COURSE_PREREQS);
				String courseCredits = (String) courseJSON.get(COURSE_CREDITS);
				String semester = (String) courseJSON.get(SEMESTER);
				double passingGrade;
				if (courseJSON.get(COURSE_PASSING_GRADE) != null) {
					passingGrade = (double)((long) courseJSON.get(COURSE_PASSING_GRADE));
				}
				else {
					passingGrade = 0;
				}
				classlist.add(new Course(prereqs, courseID, courseSubject, courseNumber, courseName, courseDescription, 
					courseCredits, semester, 0));
			}
			// for (Course c : classlist) {
			// 	//System.out.println(c.getCourseName());
			// 	for (Course cc : c.getPrereqs()) {
			// 		cc.linkFromUUIDRelatedClasses(classlist);
			// 	}
			// }
			return classlist;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
