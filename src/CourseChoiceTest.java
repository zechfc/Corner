import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
//import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.util.ArrayList;
import java.util.Arrays;
@TestInstance(Lifecycle.PER_CLASS)
public class CourseChoiceTest {
    private CourseChoice cc;
    private ArrayList<Course> coursesTaken;
    private Course prereq;

        


    @BeforeAll
    public void inital_setup(){
//        {
//            "requireType": "OR",
//                "courseID": [
//            "47c4e89e-9000-4203-ba31-77441dff5028",
//                    "1fe509c2-879d-4f76-9ad8-5f37468fcc66"
//        ]
//        },
//        {
//            "requireType": "AND",
//                "courseID": ["0287575f-710b-4526-aa12-d87e89d9477a"]
//        }

        //checkPrerequisites
        prereq = new Course(new ArrayList<CourseChoice>(),"47c4e89e-9000-4203-ba31-77441dff5028",
                "ACCT404",
                "Accounting Information Systems I",
                "Accounting systems for business decision-making and effective control of the business enterprise.   FS: 06/01/2022.",
                true,
                3.0,
                new ArrayList<>(Arrays.asList("SPRING", "SUMMER", "FALL")),
                null,
                "C");

        // cc = new CourseChoice("3a9b678a-8dcb-4d3c-9269-3a997710fdf8", new ArrayList<String>(){{ add("3a9b678a-8dcb-4d3c-9269-3a997710fdf8"); }});

        // coursesTaken.add(new Course(new ArrayList<CourseChoice>()
        //         ,"3a9b678a-8dcb-4d3c-9269-3a997710fdf8",
        //                 "ACCT475",
        //                 "Integrated Business Processes with Enterprise Systems",
        //         "The integration, configuration, and operation of accounting information within enterprise resource planning and other databases as applied to current business practices.   FS: 02/03/2021.",
        //         true, 3.0,
        //         new ArrayList<>(Arrays.asList("SPRING", "SUMMER", "FALL")),
        //         null, "C"));
    }

    @BeforeEach
    public void setup(){

    }

    //checkConstructor
    @Test
    public void test_CourseChoiceConstructor_Valid() {
    }

    @Test
    public void test_CourseChoiceConstructor_Invalid() {
    }

    //checkPrerequisites
    @Test
    public void test_checkPrerequisites_OR_Valid(){
        ArrayList<Course> courselist = new ArrayList<Course>();
        courselist.add(prereq);
        assertTrue (cc.checkPrerequisites(courselist));

    }

    @Test
    public void test_checkPrerequisites_OR_Invalid(){

    }
    @Test
    public void test_checkPrerequisites_AND_Valid(){

    }

    @Test
    public void test_checkPrerequisites_AND_Invalid(){

    }

    @Test
    public void test_checkPrerequisites_PRE_OR_COREQ_Valid(){

    }

    @Test
    public void test_checkPrerequisites_PRE_OR_COREQ_Invalid(){

    }


    //checkCoreqs
    @Test
    public void test_checkCoreqs_Valid(){

    }

    @Test
    public void test_checkCoreqs_Invalid(){

    }


    //getCoursesToString
    @Test
    public void test_getCoursesToString_OR_Valid(){

    }

    @Test
    public void test_getCoursesToString_OR_Invalid(){

    }

    @Test
    public void test_getCoursesToString_AND_Valid(){

    }

    @Test
    public void test_getCoursesToString_AND_Invalid(){

    }

    @Test
    public void test_getCoursesToString_PRE_OR_COREQ_Valid(){

    }

    @Test
    public void test_getCoursesToString_PRE_OR_COREQ_Invalid(){

    }

    @Test
    public void test_getCoursesToString_COREQ_Valid(){

    }

    @Test
    public void test_getCoursesToString_COREQ_Invalid(){

    }


    @After
    public void teardown(){

    }
}
