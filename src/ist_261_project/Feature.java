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

//Class is dealing with phone features, for Plan relationship look at Option
//TODO: All records should be written to txt file
public class Feature {
    private String name = "";
    private double price = 0;
    private String type = "";
    private int type_id = 0;
    private String description = "";
    
    public Feature(String newName, double newPrice, String newType){
        this.name = newName;
        this.price = newPrice;
        this.type = newType;
       
        //Will be set once compared to String type
        this.type_id = 0;
    }
    
    public Feature(Feature existingFeature){
        this.name = existingFeature.name;
        this.price = existingFeature.price;
        this.type = existingFeature.type;
    }
    
    public String getName(){
        return name;
    }
    
    public double getPrice(){
        return price;
    }
    
    public String getType(){
        return type;
    }
    
    public int get_type_id(){
        return type_id;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setName(String newName){
        name = newName;
    }
    
    public void setPrice(double newPrice){
        price = newPrice;
    }
    
    public void setType(String newType){
        type = newType;
    }
    
    public void set_type_id(int new_type_id){
        type_id = new_type_id;
    }
    
    public void setDescription(String newDescription){
            description = newDescription;
    }
    
    public String FeatureInfoString(){
        return(
                "Name: " + name +
                "Type: " + type +
                "Price: " + price);
    }
}
