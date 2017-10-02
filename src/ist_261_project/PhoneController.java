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
    
    public LinkedList phoneList;
    public PhoneList list;
    
    public PhoneController(){
        list = new PhoneList();
        phoneList = list.getList();
        
        PhoneView view = new PhoneView(phoneList);
    }
}
