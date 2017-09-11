/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist_261_project;

/**
 *
 * @author Joshua Irwin
 */

//TODO: All records should be written to txt file
//Class is dealing with Plan Options, for Phone relationship look at Feature
public class Option {
    private String name = "";
    private float price = 0;
    private String description = "";
    
    public Option(String newName, float newPrice){
        this.name = newName;
        this.price = newPrice;
    }
    
    public String getName(){
        return name;
    }
    
    public String getDescription(){
        return description;
    }
    
    public float getPrice(){
        return price;
    }
    
    public void setName(String newName){
        name = newName;
    }
    
    public void setPrice(float newPrice){
        price = newPrice;
    }
    
    public void setDescription(String newDescription){
        description = newDescription;
    }
}