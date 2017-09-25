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
public class ApplePhone extends Phone{
    private String iOSVersion;
    // 1 = Lightning
    // 2 = 30-pin 
    private int chargerType;
    
    public ApplePhone(String newModel, String newManufacturer, 
            double newPrice, String verison, int newChargerType){
        super(newModel, newManufacturer, newPrice);
        
        iOSVersion = verison;
        chargerType = newChargerType;
        
    }    
    
    public void setAndroidVersion(String newVersion){
        iOSVersion = newVersion;
    }
    
    public String getChargerString(){
        String charger = "";
        if (this.chargerType == 1)
             charger = "Lightning Bolt";
        else if (this.chargerType == 2)
            charger = "30-Pin";
        return charger;
    }
    
    public int getChargerId(){
        return chargerType;
    }
    
    public String getPhoneDetails(){
        return(
                "Phone Info" +
                "\nModel: " + getModel() +
                "\nManufacturer: " + getManufacturer() +
                "\nAndroid Version: " + iOSVersion +
                "\nCharger Type: " + getChargerString()+
                "\nPrice: $" + currency.format(getPrice()) +
                "\nFeatures: " + getFeatures()
                );
    }
}
