/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist_261_project;

import java.util.LinkedList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jmi09
 */
public class PlanTest {
    
    public PlanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getOptionsToString method, of class Plan.
     */
    @Test
    public void testGetOptionsToString() {
        System.out.println("getOptionsToString");
        Plan instance = new Plan("Plan1", 200.00);
        String expResult = "N/A";
        String result = instance.getOptionsToString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addOption method, of class Plan.
     */
    @Test
    public void testAddOption() {
        System.out.println("addOption");
        Option newOption = new Option("2GB", 25.00);
        Plan instance = new Plan("Plan1", 200.00);
        instance.addOption(newOption);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Plan.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Plan instance = new Plan("Plan1", 200.00);;
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Plan.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Plan instance = new Plan("Plan1", 200.00);;
        String expResult = "Plan1";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class Plan.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Plan instance = new Plan("Plan1", 200.00);;
        double expResult = 200.0;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Plan.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String newDescription = "";
        Plan instance = new Plan("Plan1", 200.00);;
        instance.setDescription(newDescription);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Plan.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String newName = "test";
        Plan instance = new Plan("Plan1", 200.00);;
        instance.setName(newName);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPrice method, of class Plan.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        double newPrice = 20.0;
        Plan instance = new Plan("Plan1", 200.00);;
        instance.setPrice(newPrice);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getOptions method, of class Plan.
     */
    @Test
    public void testGetOptions() {
        System.out.println("getOptions");
        Plan instance = new Plan("Plan1", 200.00);;
        LinkedList expResult = new LinkedList<Option>();
        LinkedList result = instance.getOptions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of removeOptionByName method, of class Plan.
     */
    @Test
    public void testRemoveOptionByName() {
        System.out.println("removeOptionByName");
        String optionName = "";
        Plan instance = new Plan("Plan1", 200.00);;
        String expResult = "No Options To Remove";
        String result = instance.removeOptionByName(optionName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of comparePlan2String method, of class Plan.
     */
    @Test
    public void testComparePlan2String() {
        System.out.println("comparePlan2String");
        Plan plan1 = new Plan("Plan1", 200.00);;
        Plan plan2 = new Plan("Plan2", 100.00);;
        String expResult = "Plan 1:" +
                "\nName: Plan1"  +
                "\nPrice: 200.0" + 
                "\nOptions: []" + 
                "\n\n Plan 2:" +
                "\nName: Plan2" + 
                "\nPrice: 100.0" + 
                "\nOptions: []";
        String result = plan1.comparePlan2String(plan1, plan2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
