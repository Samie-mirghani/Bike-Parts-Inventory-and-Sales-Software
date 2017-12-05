/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class PartLocationTest {
    
    public PartLocationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPartName method, of class PartLocation.
     */
    @Test
    public void testGetPartName() {
        System.out.println("getPartName");
        PartLocation instance = new PartLocation("Saddle", 20, "Loc");
        String expResult = "Saddle";
        String result = instance.getPartName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPartName method, of class PartLocation.
     */
    @Test
    public void testSetPartName() {
        System.out.println("setPartName");
        String partName = "Handle";
        PartLocation instance = new PartLocation("Saddle", 20, "Loc");;
        instance.setPartName(partName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQty method, of class PartLocation.
     */
    @Test
    public void testGetQty() {
        System.out.println("getQty");
        PartLocation instance = new PartLocation("Saddle", 20, "Loc");;
        int expResult = 20;
        int result = instance.getQty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addQty method, of class PartLocation.
     */
    @Test
    public void testAddQty() {
        System.out.println("addQty");
        int qty = 20;
        PartLocation instance = new PartLocation("Saddle", 20, "Loc");;
        instance.addQty(qty);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocation method, of class PartLocation.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        PartLocation instance = new PartLocation("Saddle", 20, "Loc");;
        String expResult = "Loc";
        String result = instance.getLocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLocation method, of class PartLocation.
     */
    @Test
    public void testSetLocation() {
        System.out.println("setLocation");
        String location = "Loc2";
        PartLocation instance = new PartLocation("Saddle", 20, "Loc");;
        instance.setLocation(location);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of decreaseQty method, of class PartLocation.
     */
    @Test
    public void testDecreaseQty() {
        System.out.println("decreaseQty");
        int qty = 10;
        PartLocation instance = new PartLocation("Saddle", 20, "Loc");;
        int expResult = 10;
        int result = instance.decreaseQty(qty);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
