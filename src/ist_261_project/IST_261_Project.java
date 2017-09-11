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
        Phone testPhone2 = new Phone("G5", "LG", 300.00);
        System.out.println(testPhone.getInfoString());
        System.out.println("");
        System.out.println(testPhone2.getInfoString());
        System.out.println("");
        System.out.println("Cheaper Phone: " + 
                testPhone.getCheaperPhoneModel(testPhone2));
        System.out.println("");
        System.out.println(testPhone.compare2PhoneString(testPhone, testPhone2));
    }
    
}
