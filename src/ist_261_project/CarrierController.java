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
public class CarrierController {
    
    public LinkedList<Carrier> carrierList;
    public CarrierList list;
    
    public void getCarrierTable(LinkedList<Phone> phoneList, LinkedList<Carrier> carrierList){
        CarrierTable table = new CarrierTable(phoneList, carrierList);
    }
}
