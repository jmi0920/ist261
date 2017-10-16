/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist_261_project;

import java.util.LinkedList;

/**
 *
 * @author Joshua Irwin
 */
public class IST_261_Project {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args){
          // TestHarness is to test Phone and Carrier functions, however through
          // functions will also test some features of Option, Plan and Feature
          // Classes.

          PhoneList p_list = new PhoneList();
          CarrierList c_list = new CarrierList();
          
          LinkedList<Phone> phoneList = p_list.getList();
          LinkedList<Carrier> carrierList = c_list.getList();
          
          ApplicationHome home = new ApplicationHome(phoneList, carrierList);
           
    }
}