import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.HashMap;

public class DataLoader extends DataConstants {

	public static ArrayList<Student> getStudents() {
		ArrayList<Student> studentList = new ArrayList<Student>();
		HashMap<String, Course> courseMap = new HashMap<String, Course>();
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

				JSONArray pastCoursesJSON = (JSONArray) studentJSON.get(COURSES_PAST);
				ArrayList<Course> pastCourses = new ArrayList<Course>();
				for(int j = 0; j < pastCoursesJSON.size(); j++){
					JSONObject pastCourse = (JSONObject) pastCoursesJSON.get(j);
					String courseCode = (String) pastCourse.get(COURSE_ID);
					String grade = (String) pastCourse.get(GRADE);
					String semester = (String) pastCourse.get(SEMESTER);
					int year = ((Long) pastCourse.get(YEAR)).intValue();
					Course course = courseMap.get(courseCode);
					if(course != null){
						pastCourses.add(new Course(course.getPrereqs(), course.getCourseID(), course.getCourseSubject(), course.getCourseNumber(), course.getCourseName(), course.getDescription(), course.getAvailability(), course.getCourseCredits(), semester, year));
					}else {
						System.err.println("Course not found for code: " + courseCode);
					}
				}
				
				JSONArray currentCoursesJSON = (JSONArray) studentJSON.get(COURSES_PRESENT);
				ArrayList<Course> currentCourses = new ArrayList<Course>();
				for(int j = 0; j < currentCourses.size(); j++){
					JSONObject currentCourse = (JSONObject) currentCoursesJSON.get(j);
					String courseCode = (String) currentCourse.get(COURSE_ID);
					String grade = (String) currentCourse.get(GRADE);
					String semester = (String) currentCourse.get(SEMESTER);
					int year = ((Long) currentCourse.get(YEAR)).intValue();
					Course course = courseMap.get(courseCode);
					if(course != null){
						currentCourses.add(new Course(course.getPrereqs(), course.getCourseID(), course.getCourseSubject(), course.getCourseNumber(), course.getCourseName(), course.getDescription(), course.getAvailability(), course.getCourseCredits(), semester, year));
					}
				}

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
				String courseID = (String) courseJSON.get(COURSE_ID);
				String courseSubject = (String) courseJSON.get(COURSE_SUBJECT);
				String courseNumber = (String) courseJSON.get(COURSE_NUMBER);
				String courseName = (String) courseJSON.get(COURSE_NAME);
				String courseDescription = (String) courseJSON.get(COURSE_DESCRIPTION);
				boolean courseAvailability = (boolean) courseJSON.get(COURSE_AVAILABILITY);
				double courseCredits = ((double) courseJSON.get(COURSE_CREDITS));
				String semester = (String) courseJSON.get(SEMESTER);
				int year = ((Long) courseJSON.get(YEAR)).intValue();
				double passingGrade;
				if (courseJSON.get(COURSE_PASSING_GRADE) != null) {
					passingGrade = (double)((long) courseJSON.get(COURSE_PASSING_GRADE));
				}
				else {
					passingGrade = 0;
				}
				classlist.add(new Course(cc, courseID, courseSubject, courseNumber, courseName, courseDescription, courseAvailability, 
					courseCredits, semester, year));
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
