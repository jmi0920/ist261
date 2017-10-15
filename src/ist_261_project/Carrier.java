/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist_261_project;

import java.util.Random;
import java.util.LinkedList;
/**
 *
 * @author Joshua Irwin
 */

//TODO: All records should be written to txt file
public class Carrier {
    private String name = "";
    private LinkedList<Phone> availablePhones;
    private LinkedList<Plan> availablePlans;
    
    //Final int that gets set upon phone creation, cannot be edited.
    final private int carrier_id;
    final private Random random = new Random();
    
    public Carrier(String newName){
        this.name = newName;
        
        // Generates unique id for each phone, would prefer incremental id
        // if possible.
        this.carrier_id = random.nextInt(1000) + 1;
        this.availablePhones = new LinkedList<Phone>();
        this.availablePlans = new LinkedList<Plan>();
    }
   
    public LinkedList getPlans(){
        return availablePlans;
    }
    
    public LinkedList getPhones(){
        return availablePhones;
    }
    
    public String getPlansToString(){
       if(availablePlans.size() > 0){
           StringBuilder planString = new StringBuilder();
           for(int i = 0; i < availablePlans.size(); i++){
               Plan x =(Plan)availablePlans.get(i);
               if(i == 0)
                   planString.append(x.getName());
               else 
                   planString.append(", " + x.getName());
           }
           return planString.toString();
       }
       else
           return "N/A";
    }
    
    public String getPhonesToString(){
        if(availablePlans.size() > 0){
           StringBuilder PhoneString = new StringBuilder();
           for(int i = 0; i < availablePhones.size(); i++){
               Phone x =(Phone)availablePhones.get(i);
               if(i == 0)
                   PhoneString.append(x.getManufacturer() + " " + x.getModel());
               else 
                   PhoneString.append(", " + x.getManufacturer() + " " + x.getModel());
           }
           return PhoneString.toString();
        }
        else
            return "N/A";
    }
     
    public String getName(){
        return name;
    }
    
    public int getCarrierID(){
        return carrier_id;
    }
    
    public LinkedList getAvailablePhones(){
        return availablePhones;
    }
    
    // Remove From availablePhones Function

    public LinkedList getAvailablePlans(){
        return availablePlans;
    }

    // Remove From availablePlans Function

    public void addPlan(Plan newPlan){
        availablePlans.add(newPlan);
    }
    
    public void addPhone(Phone newPhone){
        availablePhones.add(newPhone);
    }
}



