/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist_261_project;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jmi09
 */
public class PhoneTest {
    
    public PhoneTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getInfoString method, of class Phone.
     */
    @Test
    public void testGetInfoString() {
        System.out.println("getInfoString");
        Phone instance = new Phone("G6", "LG", 500.00);
        String expResult = "Phone Info" +
                "\nModel: G6" +
                "\nManufacturer: LG" +
                "\nPrice: $500.00" +
                "\nFeatures: N/A";
        String result = instance.getPhoneDetails();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getModel method, of class Phone.
     */
    @Test
    public void testGetModel() {
        System.out.println("getModel");
        Phone instance = new Phone("G6", "LG", 500.00);
        String expResult = "G6";
        String result = instance.getModel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getManufacturer method, of class Phone.
     */
    @Test
    public void testGetManufacturer() {
        System.out.println("getManufacturer");
        Phone instance = new Phone("G6", "LG", 500.00);
        String expResult = "LG";
        String result = instance.getManufacturer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class Phone.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Phone instance = new Phone("G6", "LG", 500.00);
        double expResult = 500.0;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPhoneID method, of class Phone.
     */
    @Test
    public void testGetPhoneID() {
        System.out.println("getPhoneID");
        Phone instance = new Phone("G6", "LG", 500.00);
        //generated randomly, not sure how to set expResult when random.
        int expResult = instance.getPhoneID();
        int result = instance.getPhoneID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setModel method, of class Phone.
     */
    @Test
    public void testSetModel() {
        System.out.println("setModel");
        String newModel = "G5";
        Phone instance = new Phone("G6", "LG", 500.00);
        instance.setModel(newModel);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setManufacturer method, of class Phone.
     */
    @Test
    public void testSetManufacturer() {
        System.out.println("setManufacturer");
        String newManuf = "Apple";
        Phone instance = new Phone("G6", "LG", 500.00);
        instance.setManufacturer(newManuf);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPrice method, of class Phone.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        double newPrice = 10.0;
        Phone instance = new Phone("G6", "LG", 500.00);
        instance.setPrice(newPrice);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addFeature method, of class Phone.
     */
    @Test
    public void testAddFeature() {
        System.out.println("addFeature");
        Feature newFeature = new Feature("Removable Battery", "Battery");
        Phone instance = new Phone("G6", "LG", 500.00);
        instance.addFeature(newFeature);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getFeatures method, of class Phone.
     */
    @Test
    public void testGetFeatures() {
        System.out.println("getFeatures");
        Phone instance = new Phone("G6", "LG", 500.00);
        Feature newFeature = new Feature("Removable Battery", "Battery");
        instance.addFeature(newFeature);
        String expResult = "Removable Battery";
        String result = instance.getFeatures();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getFeatureName method, of class Phone.
     */
    @Test
    public void testGetFeatureName() {
        System.out.println("getFeatureName");
        Phone instance = new Phone("G6", "LG", 500.00);
        Feature newFeature = new Feature("Removable Battery", "Battery");
        instance.addFeature(newFeature);
        String expResult = "Removable Battery";
        String result = instance.getFeatureName(newFeature);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCheaperPhoneModel method, of class Phone.
     */
    @Test
    public void testGetCheaperPhoneModel() {
        System.out.println("getCheaperPhoneModel");
        Phone instance = new Phone("G6", "LG", 500.00);
        Phone comparedPhone = new Phone("G5", "LG", 200.00);
        String expResult = "LG G5";
        String result = instance.getCheaperPhoneModel(comparedPhone);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of priceDifference method, of class Phone.
     */
    @Test
    public void testPriceDifference() {
        System.out.println("priceDifference");
        Phone instance = new Phone("G6", "LG", 500.00);
        Phone phone2 = new Phone("G5", "LG", 200.00);
        double expResult = 300.0;
        double result = instance.priceDifference(instance, phone2);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of removeFeatureByName method, of class Phone.
     */
    @Test
    public void testRemoveFeatureByName() {
        System.out.println("removeFeatureByName");
        String newString = "Removable Battery";
        Phone instance = new Phone("G6", "LG", 500.00);;
        String expResult = "No Features To Remove";
        String result = instance.removeFeatureByName(newString);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of compare2PhoneString method, of class Phone.
     */
    @Test
    public void testCompare2PhoneString() {
        System.out.println("compare2PhoneString");
        Phone phone2 = new Phone("G5", "LG", 200.00);
        Phone instance = new Phone("G6", "LG", 500.00);
        String expResult = "Phone 1:" +
                "\nModel: G6" +
                "\nManufacture: LG" + 
                "\nPrice: 500.0" + 
                "\nFeatures: N/A" + 
                "\n\nPhone 2:" +
                "\nModel: G5" + 
                "\nManufacture: LG" + 
                "\nPrice: 200.0" + 
                "\nFeatures: N/A" + 
                "\n====================================" +
                "\nCheaper Phone: LG G5" + 
                "\nPrice Difference: 300.0";
        String result = instance.compare2PhoneString(phone2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
