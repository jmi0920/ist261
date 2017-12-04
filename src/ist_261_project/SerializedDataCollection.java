/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ist_261_project;

/**
 * @author Josh
 */
public class SerializedDataCollection {
    private PhoneList list_p;
    private CarrierList list_c;
    private PlanList list_plan;
    
    public SerializedDataCollection() {
        list_p = new PhoneList();
        list_c = new CarrierList();
        list_plan = new PlanList();
    }
    
    public PhoneList getPhoneList(){
        return list_p;
    }
    
    public CarrierList getCarrierList(){
        return list_c;
    }
    
    public PlanList getPlanList(){
        return list_plan;
    }
    
    public void savePhoneList(){
        list_p.writeFile();
    }
}
