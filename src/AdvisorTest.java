import static
org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AdvisorTest {
     private boolean admin;
    private ArrayList<String> studentsSupervising;

@BeforeEach        
public void AdvisorTest (){

    admin = false;
    studentsSupervising.add("0a119e07-a0aa-435e-9b9d-21e5b91b1c39");
    studentsSupervising.add("513b2857-a10f-4aac-87a8-b094604a3001");

    new Student("0a119e07-a0aa-435e-9b9d-21e5b91b1c39","hillt@email.sc.edu" , "Tawnie", "Bo", "Hill", "20", "password", "cd28e093-e17f-49e2-b11c-163cbf993b26", "Sophomore", 6, null, null, null, null, null);
        
   

}

@Test
void testEvaluate_Valid_ShouldPass(){
Calculator calculator = new Calculator();
int sum = calculator.evaluate("1+2+3");
assertEquals(6, sum);
}
}