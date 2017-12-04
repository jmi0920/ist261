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
 * @author Josh
 */
public class PlanController {
    
    public LinkedHashSet<Plan> planList;
    public PlanList list;

    public void getPlanTable(LinkedList<Phone> phoneList, LinkedList<Carrier> carrierList, LinkedHashSet<Plan> planList){
        PlanTable table = new PlanTable(phoneList, carrierList, planList);
    }
}
