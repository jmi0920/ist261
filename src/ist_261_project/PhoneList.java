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
public class PhoneList implements Serializable{
    
    private LinkedList<Phone> phoneLinkedList = new LinkedList<Phone>();
    private String phoneListFileName = "PhoneList.ser";
    
    public PhoneList() {
        
        this.readFile();
        if(phoneLinkedList.isEmpty() || phoneLinkedList == null){
            this.createTestPhones();
            this.writeFile();
            this.readFile();
        }
    }
    
    public LinkedList<Phone> getList(){
        return phoneLinkedList;
    }
    
    public Phone getFromList(int i){
        return phoneLinkedList.get(i);
    }
    
    public void readFile(){
        FileInputStream fileInput = null;
        ObjectInputStream objectIn = null;
        
        try{
            fileInput = new FileInputStream(phoneListFileName);
            objectIn = new ObjectInputStream(fileInput);
            phoneLinkedList = (LinkedList)objectIn.readObject();
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
            fileOutput = new FileOutputStream(phoneListFileName);
            objectOut = new ObjectOutputStream(fileOutput);
            objectOut.writeObject(phoneLinkedList);
            objectOut.close();
        }
        
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    public void createTestPhones(){
        for(int i = 0; i <5; i++){
           phoneLinkedList.add(new Phone("TestModel_"+i, "TestManufacturer_"+i, 10));
        }
    }
}

