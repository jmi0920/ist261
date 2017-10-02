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
public class PhoneList {
    
    LinkedList<Phone> phoneLinkedList;

    public PhoneList() {
        
        phoneLinkedList = new LinkedList<Phone>();

        Phone lg_g6 = new Phone("G6", "LG", 500.00);
        Phone iPhone_x = new Phone("iPhone X", "Apple", 1000.00);
        Phone iPhone_8 = new ApplePhone("iPhone 8", "Apple", 900.00 , "iOS 10", 1);
        Phone nexus_4 = new Phone("Nexus 4", "LG", 76.95);
        Phone iPhone_7 = new Phone("iPhone 7", "Apple", 649.99);
        Phone galaxy_note_8 = new Phone("Galaxy Note 8", "Samsung", 930.00);
        Phone galaxy_s8 = new Phone("Galaxy S8", "Samsung", 750.00);
        Phone aristo = new Phone("Aristo", "LG", 150.00);
        Phone go_flip = new OtherPhone("GO FLIP", "Alcatel", 75.00, "1.1 GHz Dual-Core Processor", 1 , 3);
        
        
        phoneLinkedList.add(lg_g6);
        phoneLinkedList.add(iPhone_8);
        phoneLinkedList.add(iPhone_x);
        phoneLinkedList.add(nexus_4);
        phoneLinkedList.add(iPhone_7);
        phoneLinkedList.add(galaxy_note_8);
        phoneLinkedList.add(galaxy_s8);
        phoneLinkedList.add(aristo);
        phoneLinkedList.add(go_flip);
    }
    
    public LinkedList<Phone> getList(){
        return phoneLinkedList;
    }
    
    public Phone getFromList(int i){
        return phoneLinkedList.get(i);
    }
}

