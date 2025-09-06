package apiRestAssured_ex01_RA_Basic;



//Example of Builder Pattern Design Pattern in Java
public class APITesting004_BuilderPatternDesignPattern {

 // ============================
 // Step 1 Method
 // ============================
 // Returns the current object (this) so that methods can be chained
 public APITesting004_BuilderPatternDesignPattern step1() {
     System.out.println("Step 1");
     return this;  // Returning current object
 }

 // ============================
 // Step 2 Method
 // ============================
 // Also returns "this" to support chaining
 public APITesting004_BuilderPatternDesignPattern step2() {
     System.out.println("Step 2");
     return this;  // Returning current object
 }

 // ============================
 // Step 3 Method
 // ============================
 // Accepts a parameter, still returns "this" for chaining
 public APITesting004_BuilderPatternDesignPattern step3(String param1) {
     System.out.println("Step 3 with param: " + param1);
     return this;  // Returning current object
 }

 // ============================
 // Main Method (Execution)
 // ============================
 public static void main(String[] args) {
     // Create an object of the class
     APITesting004_BuilderPatternDesignPattern bp = new APITesting004_BuilderPatternDesignPattern();

     // Chaining method calls using Builder Pattern
     // Instead of calling separately like bp.step1(); bp.step2(); bp.step3();
     // We chain them together:
     bp.step1()
       .step2()
       .step3("pramod");
 }
}

/*
✅ SUMMARY:
1. This program demonstrates the Builder Pattern Design Pattern.
2. Each method returns the same object (this), enabling method chaining.
3. This style improves readability and avoids repetitive object calls.
4. Example:
   No Builder Pattern → 
      bp.step1();
      bp.step2();
      bp.step3("pramod");
   With Builder Pattern → 
      bp.step1().step2().step3("pramod");
*/
