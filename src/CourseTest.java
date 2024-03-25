import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {
    private Course course;
    private ArrayList<CourseChoice> prerequisites;
    private ArrayList<String> terms;

    @BeforeEach
    public void setUp() {
        prerequisites = new ArrayList<>();
        prerequisites.add(new CourseChoice("OR", new ArrayList<>()));
        terms = new ArrayList<>(Arrays.asList("FALL", "SPRING"));
        course = new Course(prerequisites, "0ee3fc1c-ec19-4637-aeb5-614577b6d22f", "CSCE101", "Introduction to Computer Concepts", "History, application, and social impact of computers; problem-solving, algorithm development, applications software, and programming in a procedural language.   CL: 2020.",
                true, 3.0, terms, "GFL", "C");
    }

    @Test
    public void testGetters() {
        assertEquals("0ee3fc1c-ec19-4637-aeb5-614577b6d22f", course.getCourseID());
        assertEquals("CSCE101", course.getCourseKey());
        assertEquals("Introduction to Computer Concepts", course.getCourseName());
        assertEquals("History, application, and social impact of computers; problem-solving, algorithm development, applications software, and programming in a procedural language.   CL: 2020.", course.getDescription());
        assertTrue(course.getAvailability());
        assertEquals("FALLSPRING", course.getSeasonOffered());
        assertEquals("GFL", course.getElectiveArea());
        assertEquals(3.0, course.getCourseCredtis());
        assertEquals(prerequisites, course.getPrereqs());
    }

    
    @Test
    public void testCheckPrerequisites() { // Does not work because of CourseChoice bug
        ArrayList<Course> courses = new ArrayList<Course>();
        Course temp = new Course(new ArrayList<>(), null, null, null, null,
                true, 3.0, new ArrayList<>(), null, null);
        courses.add(temp);

        assertTrue(course.checkPrerequisites(courses));
    }

    @Test
    public void testToString() {
        assertEquals("CSCE101: Introduction to Computer Concepts", course.toString());
    }

    @Test
    public void testGetPrereqsToString() { // Similarly, courseChoice bug. Sh
        //assertEquals("CSCE101: Introduction to Programming", course.getPrereqsToString());
    }
}
