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
import java.util.LinkedList;

/**
 *
 * @author Josh
 */
public class CarrierList implements Serializable{
    private LinkedList<Carrier> carrierList = new LinkedList<Carrier>();
    private String carrierListFileName = "CarrierList.ser";
    
    public CarrierList(){
        
        this.readFile();
        if(carrierList.isEmpty() || carrierList == null){
            this.createTestCarrier();
            this.writeFile();
            this.readFile();
        }
    }
    
    public LinkedList<Carrier> getList(){
        return carrierList;
    }
    
        
    public void readFile(){
        FileInputStream fileInput = null;
        ObjectInputStream objectIn = null;
        
        try{
            fileInput = new FileInputStream(carrierListFileName);
            objectIn = new ObjectInputStream(fileInput);
            carrierList = (LinkedList)objectIn.readObject();
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
            fileOutput = new FileOutputStream(carrierListFileName);
            objectOut = new ObjectOutputStream(fileOutput);
            objectOut.writeObject(carrierList);
            objectOut.close();
        }
        
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    public void createTestCarrier(){
        for(int i = 0; i <5; i++){
           carrierList.add(new Carrier("TestCarrier_"+i));
        }
    }
}
