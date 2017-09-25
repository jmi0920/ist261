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
public class OtherPhone extends Phone{
    public String operatingSystem;
    
    // 1 = Flip Phone
    // 2 = Slide Phone
    // 3 = Windows Phone
    private  int typeId;
    
    //  TODO Research required types
    // 1 = Micro-USB
    // 2 = USB-C
    // 3 = Other
    private int chargerType;
            
    public OtherPhone(String newModel, String newManufacturer, 
            double newPrice, String os, int newTypeId, int newChargerType){
        super(newModel, newManufacturer, newPrice);
        
        operatingSystem = os;
        typeId = newTypeId;
        chargerType = newChargerType;
    }

    public void setTypeId(int newId){
        typeId = newId;
    }
    
    public void setOperatingSystem(String newOS){
        operatingSystem = newOS;
    }
    
    public void setChargerType(int chargerId){
        chargerType = chargerId;
    }
    
    public String getOperatingSystem(){
        return operatingSystem;
    }
    
    public int getTypeId(){
        return typeId;
    }
    
    public int getChargerType(){
        return chargerType;
    }
    
    public String getChargerString(){
        String charger = "";
        if (this.chargerType == 1)
             charger = "Micro-USB";
        else if (this.chargerType == 2)
            charger = "USB-C";
        else if (this.chargerType == 3)
            charger = "Other";
        return charger;
    }
    
    public String getTypeString(){
        String type = "";
        if(typeId == 1)
            type = "Flip";
        else if (typeId == 2)
            type = "Slide";
        else if (typeId == 3)
            type = "Windows Phone";
        return type;
    }
    
     public String getPhoneDetails(){
        return(
                "Phone Info" +
                "\nType: "  + getTypeString() + 
                "\nModel: " + getModel() +
                "\nManufacturer: " + getManufacturer() +
                "\nOS: " + operatingSystem +
                "\nCharger Type: " + getChargerString()+
                "\nPrice: $" + currency.format(getPrice()) +
                "\nFeatures: " + getFeatures()
                );
     }
}
