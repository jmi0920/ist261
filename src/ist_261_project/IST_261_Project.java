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
public class IST_261_Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Testing 
        Phone testPhone = new Phone("G6", "LG", 600.00);
        Feature testFeature = new Feature("64GB Storage", 25.00, "Storage");
        Feature testFeature2 = new Feature("1700 mAH Battery", 75.00, "Battery");
        testPhone.addFeature(testFeature);
        testPhone.addFeature(testFeature2);
        Phone testPhone2 = new Phone("G5", "LG", 300.00);
        //testPhone2.addFeature(testFeature2);
        System.out.println(testPhone.getInfoString());
        System.out.println("");
        System.out.println(testPhone2.getInfoString());
        System.out.println("");
        System.out.println("Cheaper Phone: " + 
                testPhone.getCheaperPhoneModel(testPhone2));
        System.out.println("");
        System.out.println(testPhone.compare2PhoneString(testPhone, testPhone2));
        System.out.println("");
        System.out.println(testPhone.removeFeatureByName("64GB Storage"));
        System.out.println("");
        System.out.println(testPhone.compare2PhoneString(testPhone, testPhone2));
        
    }
    
}
