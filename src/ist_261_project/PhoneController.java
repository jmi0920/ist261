/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ist_261_project;

import java.util.LinkedList;

/**
 *
 * @author Josh
 */
public class PhoneController {
    
    public LinkedList<Phone> phoneList;
    public PhoneList list;
    
    public LinkedList<Phone> getPhoneDetails( LinkedList<Phone> phoneList, int index, int addingPhoneDialog){
        
        PhoneDetailView view = new PhoneDetailView(phoneList, index, addingPhoneDialog);
        
        return phoneList; 
    }
    
    public void getPhoneTable(LinkedList<Phone> phoneList){
        PhoneTable table = new PhoneTable(phoneList);
    }
}
