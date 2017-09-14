/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist_261_project;

/**
 *
 * @author Joshua Irwin
 */
public class TestHarness {
    // Testing Phone.java and Carrier.java
    
    public TestHarness() {
        String divider = "---------------------\n";
        
        //Begin Phone Tests
        System.out.println("Beginning Phone Class Tests.\n");
        System.out.println("Creating New Phone");
        Phone testPhone = new Phone("iPhone X", "Apple", 1000.00);
        if (testPhone != null){
            System.out.println("Phone Created");
            System.out.println(divider);
            System.out.println(testPhone.getInfoString());

            System.out.println(divider);
            System.out.println("Creating Features");
            Feature testFeature0 = new Feature("Facial Recognition", "Security");
            Feature testFeature1 = new Feature("Wireless Charging", "Battery");
            System.out.println(testFeature0.featureInfoString());
            System.out.println(testFeature1.featureInfoString());
            
            System.out.println(divider); 
            System.out.println("Adding Features to phone");
            testPhone.addFeature(testFeature0);
            testPhone.addFeature(testFeature1);
            System.out.println(testPhone.getInfoString());
            
            System.out.println(divider);
            System.out.println("Removing Feature, Facial Recognition");
            testPhone.removeFeatureByName("Facial Recognition");
            System.out.println(testPhone.getInfoString());
            
            System.out.println(divider);
            System.out.println("Creating Second Phone");
            Phone testPhone2 = new Phone("G6", "LG", 600.00);
             if (testPhone2 != null){
                 System.out.println("Phone Created");
                 System.out.println(divider);
                 System.out.println(testPhone2.getInfoString());
                 
                 System.out.println(divider);
                 System.out.println("Comparing Phones");
                 System.out.println(divider);
                 System.out.println(testPhone.compare2PhoneString(testPhone2));
                 System.out.println("\nPhone Class Tests Completed successfully.");
                 System.out.println(divider);
             }
             
             else{
                 System.out.println("Test Failed");
             }
        }
        else{
            System.out.println("Test Failed");
        }
        
        //Begin Carrier Tests
        
    }
}
