package apiRestAssured_ex01_RA_Basic;



//Class name = APITesting003
public class APITesting003 {
 // ============================
 // No Design Pattern (NoBDD)
 // ============================
 // This class shows how steps are written and called directly,
 // without using any framework design pattern (like BDD, POM, etc.).
 // It's a simple approach for learning / demo purpose.

 // Step 1 Method
 public void step1() {
     // Print message to console
     System.out.println("Step 1");
 }

 // Step 2 Method
 public void step2() {
     // Print message to console
     System.out.println("Step 2");
 }

 // Step 3 Method (accepts parameter)
 public void step3(String param1) {
     // Print message to console
     // Currently, it ignores the parameter and always prints "Step 3"
     // Example: If param1 = "raj", output = Step 3
     System.out.println("Step 3");
 }

 // Main method -> Program execution starts here
 public static void main(String[] args) {
     // Create object of APITesting002 class
     APITesting003 np = new APITesting003();

     // Call step1()
     np.step1();   // Output: Step 1
     
     // Call step2()
     np.step2();   // Output: Step 2

     // Call step3() with parameter "raj"
     np.step3("raj"); // Output: Step 3 (ignores parameter)
 }
 /*
 ✅ SUMMARY:
 1. This program shows basic step execution (Step 1 → Step 2 → Step 3).
 2. It follows NoBDD (No design pattern) → direct method calling, no structure.
 3. Useful for learning Rest Assured basics before moving to BDD (Cucumber + Gherkin).
*/
}

