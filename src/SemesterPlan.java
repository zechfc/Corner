import org.json.simple.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;

public class SemesterPlan {
    private String studentRequirements;
    protected ArrayList<String> SemesterPlan;

    public SemesterPlan(String major, ArrayList<Course> completedCourses) {
        this.studentRequirements = major;
        this.SemesterPlan = new ArrayList<>();
        // Generate semester plan based on completed courses and major requirements
        generatePlan(Major major, completedCourses);
    }

    // 8 semester plan
    private void generatePlan(Major major, ArrayList<Course> completedCourses) {
        // Logic to generate semester plan based on completed courses and major
        // requirements
        // This can include checking prerequisites, corequisites, and other major
        // requirements
        // and then planning out the upcoming semesters accordingly

        // csce major map is
        Student student = new Student("u123456", "john.doe@example.com", "John", "William", "Doe", "25", "securePassword123",
                "Computer Science", "Senior", 30, new JSONArray(),
                new JSONArray(), "a987654",
                "John is doing well in his courses and is on track to graduate next semester.");
        if(major.equals("Computer Science")){
            // find what year and semester student is in

            StringBuilder sb = new StringBuilder();
            String gradeLevel = student.getClassification();
            String currentSemeser = "";

            major.

        }

        /*
        Semester 1
            ENGL 101: Critical Reading and Composition
            MATH 141: Calculus
                   Prereq: C CC-CMW
                   Prereq: C or better in MATH 112/115/116 or Math placement test score
            CSCE 145: Algorithmic Design I
                   Prereq or Coreq: MATH 111 or 115
            CSCE 190: Computing in the Modern World
                   Prereq or Coreq: CSCE 145, 204, 205, or 206

        Semester 2
               ENGL 102: Rhetoric and Composition
                       Prereq: ENGL 101
               MATH 142: Calculus II
                       Prereq: MATH 141
               CHEM 111: General Chemistry I
                       Prereq: MATH 111/115/122/141 or higher math or Math placement test score
                       Coreq: CHEM 111L (CHEM 111 only)
                       Coreq: MATH 141
                       Prereq or coreq: PHYS 211L (PHYS 211 only)
               CHEM 111L: General Chemistry I Lab
                       Prereq: MATH 111 or 115
                       Prereq or Coreq: CHEM 111 (CHEM 111L only)
                       Prereq or Coreq: PHYS 211 (PHYS 211L only)
               CSCE 146: Algorithmic Design II
                       Prereq: CSCE 145
                       Prereq or Coreq: MATH 122 or 141
               CSCE 215: UNIX/Linux Fundamentals
                       Prereq: CSCE 145

        Semester 3
                CSCE 211: Digital Logic Design
                        Prereq: MATH 141
                CSCE 240: Advanced Programming Techniques
                        Prereq: D in CSCE 215 & CSCE 146
                MATH 374: Discrete Structures
                        Prereq: MATH 142 & CSCE 146
                CHEM 112: General Chemistry II
                        Prereq: CHEM 111 or 141 & MATH 111/115/122/141 or higher math
                        Coreq: CHEM 112L (CHEM 112 only)
                        Coreq: PHYS 211 and MATH 142
                        Coreq: PHYS 212L (PHYS 212 only)
                CHEM 112L: General Chemistry II Lab
                        Prereq: CHEM 111/111L/141
                        Prereq or Coreq: CHEM 112 (CHEM 112L only)
                        Prereq or Coreq: PHYS 212 (PHYS 212L only)
                SPCH 140: Public Communication
                        Coreq: SPCH 145 or SPCH 230
                SPCH 145: Online Public Communication
                        Coreq: SPCH 140 or SPCH 230
                SPCH 230: Business and Professional Speaking
                        Coreq: SPCH 140 or SPCH 145

        Semester 4
                CSCE 212: Intro. to Computer Architecture
                        Prereq: D in CSCE 211 & either CSCE 145 or 206
                CSCE 247: Software Engineering
                        Prereq: CSCE 146
                Laboratory Science Elective
                        See Bulletin listing
                MATH 241: Vector Calculus
                        Prereq: MATH 142
                Carolina Core GSS

        Semester 5
                CSCE 311: Operating Systems
                        Prereq: CSCE 240 & CSCE 210 or 212
                CSCE 330: Programming Language Structures
                        Prereq: CSCE 240; MATH 174 or 374 or 574
                CSCE 350: Data Structures & Algorithms
                        Prereq: CSCE 240; MATH 174 or 374 or 574
                CSCE 390: Prof. Issues in Computer Science Engr.
                        Carolina Core GSS
                ENGL 462: Technical Writing
                        Prereq: ENGL 101 & 102
                ENGL 463: Business Writing
                        Prereq: ENGL 101 & 102
                Application Area Elective
                        See Bulletin listing

        Semester 6
                CSCE 416: Introduction to Computer Networks
                        Prereq: CSCE 146
                CSCE Major Elective
                        See Bulletin listing
                STAT 509: Statistics for Engineers
                        Prereq: MATH 142
                Liberal Arts Elective
                        See Bulletin listing
                Application Area Elective
                        See Bulletin listing
         */
    }

    public ArrayList<String> getStudentReq(String majorReq) {
        // Logic to retrieve specific student requirements based on major
        return new ArrayList<>(); // Placeholder
    }

    public ArrayList<Course> remainingCourses(String input) {
        // Logic to calculate remaining courses based on input
        return new ArrayList<>(); // Placeholder
    }

    public int totalCourses(String input) {
        // Logic to calculate total number of courses based on input
        return 0; // Placeholder
    }

    public ArrayList<String> output(String semesterPlan) {
        // Logic to output semester plan
        return new ArrayList<>(); // Placeholder
    }

    public int progress(double remainingCourses, double totalCourses) {
        // Logic to calculate progress based on remaining and total courses
        return 0; // Placeholder
    }
}
