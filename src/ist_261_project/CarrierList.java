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
public class CarrierList {
    LinkedList<Carrier> carrierList;
    
    public CarrierList(){
        carrierList = new LinkedList<Carrier>();
        
        Carrier verizon = new Carrier("Verizon");
        Carrier tMobile = new Carrier("T-Mobile");
        Carrier sprint = new Carrier("Sprint");
        Carrier aTT = new Carrier("AT&T");
        
        carrierList.add(verizon);
        carrierList.add(tMobile);
        carrierList.add(sprint);
        carrierList.add(aTT);
    }
    
    public LinkedList<Carrier> getList(){
        return carrierList;
    }
}
