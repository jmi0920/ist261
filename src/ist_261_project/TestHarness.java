/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist_261_project;

import java.util.ArrayList;

/**
 *
 * @author Joshua Irwin
 */
public abstract class TestHarness implements PrintDetails{
    // Testing Phone.java and Carrier.java
    
    public TestHarness() {
        String divider = "---------------------\n";
       
        //Begin Phone Tests
        System.out.println("Beginning Phone Class Tests.\n");
        System.out.println("Creating New Phone");
        Phone testPhone = new Phone("iPhone X", "Apple", 1000.00);
        Phone testPhone2 = new Phone("Pixel 2", "Google", 900.00);
        if (testPhone != null){
            System.out.println("Phone Created");
            System.out.println(divider);
            System.out.println(testPhone.getPhoneDetails());

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
            System.out.println(testPhone.getPhoneDetails());
            
            System.out.println(divider);
            System.out.println("Removing Feature, Facial Recognition");
            testPhone.removeFeatureByName("Facial Recognition");
            System.out.println(testPhone.getPhoneDetails());
            
            System.out.println(divider);
            System.out.println("Creating Second Phone");
            testPhone2.setModel("G6");
            testPhone2.setManufacturer("LG");
            testPhone2.setPrice(600);
            
             if (testPhone2 != null){
                 System.out.println("Phone Created");
                 System.out.println(divider);
                 System.out.println(testPhone2.getPhoneDetails());
                 
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
         System.out.println("Beginning Carrier Class Tests.\n");
         System.out.println("Creating New Carrier");
         System.out.println(divider); 
         Carrier testCarrier = new Carrier("T-Mobile");
         if(testCarrier != null){
             System.out.println("Carrier " + testCarrier.getName() + " Created");
             
             System.out.println(divider);
             System.out.println("Creating Plans");
             Plan testPlan0 = new Plan("1 Line", 20.00);
             Plan testPlan1 = new Plan("4 Lines", 60.00);
             
             if (testPlan0 != null && testPlan1 != null){
                 System.out.println("plans created");
                 System.out.println(divider); 
                 
                 System.out.println("Adding plans to Carrier");
                 testCarrier.addPlan(testPlan0);
                 testCarrier.addPlan(testPlan1);
                 if (testCarrier.getPlans().size() > 0)
                 {
                    System.out.println("Plans Added");
                    System.out.println(divider); 
                    System.out.println("Plans: " + testCarrier.getPlansToString());
                 }
                 
                 else
                     System.out.println("Test Failed");
             }
             
             System.out.println("Adding Phones To Carrier");
             testCarrier.addPhone(testPhone);
             testCarrier.addPhone(testPhone2);
             
             if(testCarrier.getPhones().size() > 0)
             {
                System.out.println("Available phones at " +
                        testCarrier.getName() + ": "
                        + testCarrier.getPhonesToString());
             }
             else{
                 System.out.println("Test Failed");
             }
             
             System.out.println("Adding Options to Carrier Plans");
             Option testOption0 = new Option("1 GB", 15.00);
             Option testOption1 = new Option("4 GB", 40.00);
             testPlan0.addOption(testOption0);
             testPlan0.addOption(testOption1);
             
             if(testPlan0.getOptions().size() > 0){
                 System.out.println("Options Added");
                 System.out.println("Options: " + testPlan0.getOptionsToString());
                 
                 System.out.println(divider);
                 System.out.println("Removing Option");
                 testPlan0.removeOptionByName("1 GB");
                 System.out.println(divider);
                 System.out.println("Option Removed");
                 System.out.println("Options: " + testPlan0.getOptionsToString());
                 System.out.println(divider);
             }
         }
         System.out.println("Comparing Two Phones \n");
         System.out.println(testPhone.compare2PhoneString(testPhone2));
         
         testClassHierarchy();
         System.out.println(divider);
         System.out.println("Testing Interface");
         testInterface();
         
         
    
    }
    
    public void testInterface(){
        ApplePhone iPhone4 = new ApplePhone("Iphone 4", "Apple", 100.00,
            "iOS4", 2);
        AndroidPhone pixel = new AndroidPhone("Pixel 2", "Google", 1000.00,
                 "Oreo", 2);
        
        ArrayList<PrintDetails> print = new ArrayList<PrintDetails>();
        
        
        print.add(iPhone4);
        print.add(pixel);

    }
    
    public void testClassHierarchy(){
        String divider = "---------------------\n";
        ArrayList<Phone> phones = new ArrayList<Phone>();
        OtherPhone windowsPhone = new OtherPhone("Lumia 950", "Microsoft",
                 209.99, "Windows 10", 3,  1);
        ApplePhone iPhone4 = new ApplePhone("Iphone 4", "Apple", 100.00,
            "iOS4", 2);
        Phone superClass = new Phone("Galaxy 8", "Samsung", 800.00);
        AndroidPhone pixel = new AndroidPhone("Pixel 2", "Google", 1000.00,
                 "Oreo", 2);
        
        phones.add(windowsPhone);
        phones.add(iPhone4);
        phones.add(superClass);
        phones.add(pixel);
        
        System.out.println("\nSub classes created");
        System.out.println(divider);
        
        for(int i = 0; i < phones.size(); i++){
            System.out.println(phones.get(i).getPhoneDetails());
            System.out.println(divider);
        }
    }
}