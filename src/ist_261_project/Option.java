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

public class Option {
    private String name = "";
    private float price = 0;
    
    public Option(String newName, float newPrice){
        this.name = newName;
        this.price = newPrice;
    }
    
    public String getName(){
        return name;
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
}