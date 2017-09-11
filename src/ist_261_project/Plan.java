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

//TODO: All records should be written to txt file
public class Plan {
    
    private String name = "";
    private double price = 0;
    private ArrayList options;
    private String description;

    public Plan(String newName, double newPrice, String newDescription){
        this.name = newName;
        this.price = newPrice;
        this.options = new ArrayList<Option>();
        this.description = newDescription;
    }

    public void addOption(Option newOption){
        options.add(newOption);
    }
    
    public String getName(){
        return name;
    }
    
    public double getPrice(){
        return price;
    }
    
    public ArrayList getOptions(){
        return options;
    }
    
    public void setName(String newName){
        name = newName;
    }
    
    public void setPrice(double newPrice){
        price = newPrice;
    }
    
    public String comparePlan2String (Plan plan1, Plan plan2){
        return (
                "Plan 1:" +
                "\nName: " + plan1.name +
                "\nPrice: " + plan1.price +
                "\nOptions: " + plan1.getOptions() +
                "\n\n Plan 2:" +
                "\nName: " + plan2.name +
                "\nPrice: " + plan2.price +
                "\nOptions: " + plan2.getOptions());
    }
}