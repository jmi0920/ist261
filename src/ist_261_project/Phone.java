/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist_261_project;

import java.util.Random;

/**
 *
 * @author Joshua Irwin
 */

public class Phone {
    private String model = "";
    private String manufacturer = "";
    private float price = 0;
    
    //Final int that gets set upon phone creation, cannot be edited.
    final private int phone_id;
    private Random random = new Random();
    
    public Phone(String newModel, String newManufacturer, float newPrice){
        this.model = newModel;
        this.manufacturer = newManufacturer;
        this.price = newPrice;
        
        // Generates unique id for each phone, would prefer incremental id
        // if possible.
        this.phone_id = random.nextInt(1000) + 1;
    }

    public String getModel(){
        return model;
    }

    public String getManufacturer(){
        return manufacturer;
    }

    public float getPrice(){
        return price;
    }

    public int getPhoneID(){
        return phone_id;
    }
    
    public void setModel(String newModel){
        model = newModel;
    }
    
    public void setManufacturer(String newManuf){
        manufacturer = newManuf;
    }
    
    public void setPrice(float newPrice){
        price = newPrice;
    }
    

}



