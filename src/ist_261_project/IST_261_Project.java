/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist_261_project;

import java.util.LinkedHashSet;
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
          SerializedDataCollection dataCollection = new SerializedDataCollection();
          
          PhoneList phoneList = dataCollection.getPhoneList();
          LinkedList<Phone> phoneLinkedList = phoneList.getList();
          
          CarrierList carrierList = dataCollection.getCarrierList();
          LinkedList<Carrier> carrierLinkedList = carrierList.getList();
          
          PlanList planList = dataCollection.getPlanList();
          LinkedHashSet<Plan> planLinkedHashSet = planList.getList();
          
          ApplicationHome home = new ApplicationHome(phoneLinkedList, carrierLinkedList, planLinkedHashSet);
    }
}