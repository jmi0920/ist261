/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ist_261_project;

import java.util.ArrayList;

/**
 *
 * @author Joshua Irwin
 */

public class Plan {
    
    private String name = "";
    private float price = 0;
    private ArrayList options;

    public Plan(String newName, float newPrice){
        this.name = newName;
        this.price = newPrice;
    }

    public void addOption(Option newOption){
        options.add(newOption);
    }
    
    public String getName(){
        return name;
    }
    
    public float getPrice(){
        return price;
    }
    
    public ArrayList getOptions(){
        return options;
    }
    
    public void setName(String newName){
        name = newName;
    }
    
    public void setPrice(float newPrice){
        price = newPrice;
    }
}