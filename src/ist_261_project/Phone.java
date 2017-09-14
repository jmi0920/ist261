/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist_261_project;

import java.util.Random;
import java.util.LinkedList;
import java.text.DecimalFormat;

/**
 *
 * @author Joshua Irwin
 */

//TODO: All records should be written to txt file
public class Phone {
    private String model = "";
    private String manufacturer = "";
    private double price = 0;
    public LinkedList features;
    
    //Forces 2 decimal place accuracy
    DecimalFormat currency = new DecimalFormat("#.00"); 
    
    //Final int that gets set upon phone creation, cannot be edited.
    final private int phone_id;
    private Random random = new Random();
    
    public Phone(String newModel, String newManufacturer, double newPrice){
        this.model = newModel;
        this.manufacturer = newManufacturer;
        this.price = newPrice;
        this.features = new LinkedList<Feature>();
        
        // Generates unique id for each phone, would prefer incremental id
        // if possible.
        this.phone_id = random.nextInt(1000) + 1;
    }
    
    public String getInfoString(){
        return(
                "Phone Info" +
                "\nModel: " + getModel() +
                "\nManufacturer: " + getManufacturer() +
                "\nPrice: $" + currency.format(getPrice()) +
                "\nFeatures: " + getFeatures());
    }

    public String getModel(){
        return model;
    }

    public String getManufacturer(){
        return manufacturer;
    }

    public double getPrice(){
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
    
    public void setPrice(double newPrice){
        price = newPrice;
    }
    
    public void addFeature(Feature newFeature){
        features.add(newFeature);
    }
    
    public String getFeatures(){
        if(features.size() > 0){
            StringBuilder featureString = new StringBuilder();
            for(int i = 0; i < features.size(); i++){
                Feature x =(Feature)features.get(i);
                if(i == 0)
                    featureString.append(x.getName());
                else 
                    featureString.append(", " + x.getName());
            }
            return featureString.toString();
        }
        else
            return "N/A";
    }
    
    public String getFeatureName(Feature currentFeature){
        return currentFeature.getName();
    }
    
    public String getCheaperPhoneModel(Phone comparedPhone){
        if(this.price < comparedPhone.price){
            return (this.manufacturer + " " + this.model);
        }
        else
            return (comparedPhone.manufacturer + " " + comparedPhone.model);
    }
    
    public double priceDifference(Phone phone1, Phone phone2){
        //Preforming check so user is never presented with a negative number
        if (phone2.price > phone1.price){
             return phone2.price - phone1.price;
        }
        else
            return phone1.price - phone2.price;
    }
    
    public String removeFeatureByName(String newString){
        checking_loop:
        if(features.size() > 0){
            for (int i = 0; i < features.size(); i++){
                Feature x =(Feature)features.get(i);
                if(x.getName() == newString){
                    features.remove(i);
                    break checking_loop;
                }
            }
            return ("No Feature matched input name");
        }
        else
            return("No Features To Remove");
        
        return ("Feature Removed");
    }
    
    public String compare2PhoneString (Phone phone2){
        return (
                "Phone 1:" +
                "\nModel: " + this.getModel() +
                "\nManufacture: " + this.getManufacturer() +
                "\nPrice: " + this.getPrice() +
                "\nFeatures: " + this.getFeatures() +
                "\n\nPhone 2:" +
                "\nModel: " + phone2.getModel() +
                "\nManufacture: " + phone2.getManufacturer() +
                "\nPrice: " + phone2.getPrice() +
                "\nFeatures: " + phone2.getFeatures() +
                "\n====================================" +
                "\nCheaper Phone: " + this.getCheaperPhoneModel(phone2) +
                "\nPrice Difference: " + priceDifference(this, phone2));
    }
}


