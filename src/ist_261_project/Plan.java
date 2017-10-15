/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ist_261_project;

import java.util.LinkedList;

/**
 *
 * @author Joshua Irwin
 */

//TODO: All records should be written to txt file
public class Plan {
    
    private String name = "";
    private double price = 0;
    private LinkedList<Option> options;
    private String description;

    public Plan(String newName, double newPrice, String newDescription){
        this.name = newName;
        this.price = newPrice;
        this.options = new LinkedList<Option>();
        this.description = newDescription;
    }
    
    public String getOptionsToString(){
        if(options.size() > 0){
            StringBuilder optionsString = new StringBuilder();
            for(int i = 0; i < options.size(); i++){
                Option x =(Option)options.get(i);
                if(i == 0)
                    optionsString.append(x.getName());
                else 
                    optionsString.append(", " + x.getName());
            }
            return optionsString.toString();
        }
        else
            return "N/A";
    }
    
    public Plan(String newName, double newPrice){
        this.name = newName;
        this.price = newPrice;
        this.description = "";
        this.options = new LinkedList<Option>();
    }

    public void addOption(Option newOption){
        options.add(newOption);
    }
    
    public String getDescription(){
        return description;
    }
    
    public String getName(){
        return name;
    }
    
    public double getPrice(){
        return price;
    }
    
    public void setDescription(String newDescription){
        description = newDescription;
    }
    
    public void setName(String newName){
        name = newName;
    }
    
    public void setPrice(double newPrice){
        price = newPrice;
    }
    
    public LinkedList getOptions(){
        return options;
    }
    
    //Why is this here?
    public String removeOptionByName(String optionName){
        checking_loop:
        if(options.size() > 0){
            for (int i = 0; i < options.size(); i++){
                Option x =(Option)options.get(i);
                if(x.getName() == optionName){
                    options.remove(i);
                    break checking_loop;
                }
            }
            return ("No Option matched input name");
        }
        else
            return("No Options To Remove");
        
        return ("Option Removed");
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