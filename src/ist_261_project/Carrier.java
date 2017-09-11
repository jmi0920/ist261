/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist_261_project;

import java.util.Random;
import java.util.ArrayList;
/**
 *
 * @author Joshua Irwin
 */
public class Carrier {
    private String name = "";
    private ArrayList availablePhones;
    private ArrayList availablePlans;
    
    //Final int that gets set upon phone creation, cannot be edited.
    final private int carrier_id;
    private Random random = new Random();
    
    public Carrier(String newName){
        this.name = newName;
        this.carrier_id = random.nextInt(1000) + 1;
    }
    
    public String getName(){
        return name;
    }
    
    public int getCarrierID(){
        return carrier_id;
    }
    
    public ArrayList getAvailablePhones(){
        return availablePhones;
    }

    public ArrayList getAvailablePlans(){
        return availablePlans;
    }

    public void addPlan(Plan newPlan){
        availablePlans.add(newPlan);
    }
    
    public void addPhone(Phone newPhone){
        availablePhones.add(newPhone);
    }
    
}



