/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ist_261_project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedHashSet;

/**
 *
 * @author Josh
 */
public class PlanList implements Serializable{
    private LinkedHashSet<Plan> planList = new LinkedHashSet<Plan>();
    private String planListFileName = "PlanList.ser";
    
    public PlanList(){
        
        this.readFile();
        if(planList.isEmpty() || planList == null){
            this.createTestPlan();
            this.writeFile();
            this.readFile();
        }
    }
    
    public LinkedHashSet<Plan> getList(){
        return planList;
    }
    
        
    public void readFile(){
        FileInputStream fileInput = null;
        ObjectInputStream objectIn = null;
        
        try{
            fileInput = new FileInputStream(planListFileName);
            objectIn = new ObjectInputStream(fileInput);
            planList = (LinkedHashSet<Plan>)objectIn.readObject();
            objectIn.close();
        }
        
        catch(IOException ex){
            ex.printStackTrace();
        }
        
        catch(ClassNotFoundException ex){
        ex.printStackTrace();
        }
    }
    
    public void writeFile(){
        FileOutputStream fileOutput = null;
        ObjectOutputStream objectOut = null;
        
        try{
            fileOutput = new FileOutputStream(planListFileName);
            objectOut = new ObjectOutputStream(fileOutput);
            objectOut.writeObject(planList);
            objectOut.close();
        }
        
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    // public Plan(String newName, Phone newPhone, Carrier newCarrier, double newPrice)
    public void createTestPlan(){
        for(int i = 0; i <5; i++){
           planList.add(new Plan("TestPlan_"+i, new Phone("model" + i, "manufacture" + i, 999.99), new Carrier("carrier" + i), 999.99 ));
        }
    }

}
