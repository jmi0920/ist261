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
public class AndroidPhone extends Phone{
    public String androidVersion;
    
    // 1 = Micro-USB
    // 2 = USB-C
    private int chargerType;
    
    public AndroidPhone(String newModel, String newManufacturer, 
            double newPrice, String verison, int newChargerType){
        super(newModel, newManufacturer, newPrice);
        
        androidVersion = verison;
        chargerType = newChargerType; 
    }
    
    public void setAndroidVersion(String newVersion){
        androidVersion = newVersion;
    }
    
    public String getChargerString(){
        String charger = "";
        if (this.chargerType == 1)
             charger = "Micro-USB";
        else if (this.chargerType == 2)
            charger = "USB-C";
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
                "\nAndroid Version: " + androidVersion +
                "\nCharger Type: " + getChargerString()+
                "\nPrice: $" + currency.format(getPrice()) +
                "\nFeatures: " + getFeatures()
                );
    }
}
