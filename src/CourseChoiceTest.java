import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class CourseChoiceTest {
    private CourseChoice courseChoice;
    private ArrayList<Course> courses;

    @BeforeEach
    public void setUp() {
        courses = new ArrayList<>();
        Course csce145 = new Course(new ArrayList<>(), "0ee3fc1c-ec19-4637-aeb5-614577b6d22f", "CSCE101", "Introduction to Computer Concepts", "History, application, and social impact of computers; problem-solving, algorithm development, applications software, and programming in a procedural language.   CL: 2020.",
                true, 3.0, new ArrayList<>(), "GFL", "C");
        Course emptyCourse = new Course(new ArrayList<>(), "", "", "", "",
                true, 3.0, new ArrayList<>(), "", "");
        courses.add(csce145);
        courses.add(emptyCourse); // Testing with empty course

        ArrayList<String> courseIDs = new ArrayList<String>();
        courseIDs.add("0ee3fc1c-ec19-4637-aeb5-614577b6d22f");
        courseChoice = new CourseChoice("AND", courseIDs);
        courseChoice.linkFromUUIDRelatedClasses(courses);
    }

    @Disabled
    @Test
    public void testLinkFromUUIDRelatedClasses() {
        // Method is actually called in set-up, see above. Not sure how to verify worked exactly though
        System.out.println(courseChoice);
        // If this prints any course it works
        // Also this method cannot be called more than once so maybe that's a bug?
    }

    @Test
    public void testCheckPrerequisites() {
        Course csce145 = new Course(new ArrayList<>(), "0ee3fc1c-ec19-4637-aeb5-614577b6d22f", "CSCE101", "Introduction to Computer Concepts", "History, application, and social impact of computers; problem-solving, algorithm development, applications software, and programming in a procedural language.   CL: 2020.",
                true, 3.0, new ArrayList<>(), "GFL", "C");
        // Need to redeclare this, not sure why
        ArrayList<Course> coursesTaken = new ArrayList<>();
        assertFalse(courseChoice.checkPrerequisites(coursesTaken));

        Course math115 = new Course(new ArrayList<>(), "84b21549-16e9-4117-978c-39a43fb665b2", "MATH115", "Precalculus Mathematics", "",
                true, 3.0, new ArrayList<>(), "", "");
        coursesTaken.add(math115);

        assertTrue(csce145.checkPrerequisites(coursesTaken));
    }

    @Test
    public void testGetCoursesToString() {
        String expected = "All courses listed below must be completed: \n" +
                "CSCE101: Introduction to Computer Concepts\n";
        assertEquals(expected, courseChoice.getCoursesToString());
    }
}
