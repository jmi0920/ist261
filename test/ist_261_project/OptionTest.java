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
public class OptionTest {
    
    public OptionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getName method, of class Option.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Option instance = new Option("testOption", 200.0);
        String expResult = "testOption";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Option.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Option instance = new Option("testOption", 200.0);;
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class Option.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Option instance = new Option("testOption", 200.0);;
        double expResult = 200.0;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Option.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String newName = "newName";
        Option instance = new Option("testOption", 200.0);;
        instance.setName(newName);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPrice method, of class Option.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        double newPrice = 20.0;
        Option instance = new Option("testOption", 200.0);;
        instance.setPrice(newPrice);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Option.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String newDescription = "Description";
        Option instance = new Option("testOption", 200.0);;
        instance.setDescription(newDescription);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
