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
public class AccountTest {
    
    public AccountTest() {
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
     * Test of getfName method, of class Account.
     */
    @Test
    public void testGetfName() {
        System.out.println("getfName");
        Account instance = new Account("Bruno", "Menezes", 
                "bmenezes@mail.umw.edu", "bmen", "bmen", 4);
        String expResult = "Bruno";
        String result = instance.getfName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setfName method, of class Account.
     */
    @Test
    public void testSetfName() {
        System.out.println("setfName");
        String fName = "bruno";
        Account instance = new Account("Bruno", "Menezes", 
                "bmenezes@mail.umw.edu", "bmen", "bmen", 4);
        instance.setfName(fName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getlName method, of class Account.
     */
    @Test
    public void testGetlName() {
        System.out.println("getlName");
        Account instance = new Account("Bruno", "Menezes", 
                "bmenezes@mail.umw.edu", "bmen", "bmen", 4);
        String expResult = "Menezes";
        String result = instance.getlName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setlName method, of class Account.
     */
    @Test
    public void testSetlName() {
        System.out.println("setlName");
        String lName = "menezes";
        Account instance = new Account("Bruno", "Menezes", 
                "bmenezes@mail.umw.edu", "bmen", "bmen", 4);
        instance.setlName(lName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class Account.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Account instance = new Account("Bruno", "Menezes", 
                "bmenezes@mail.umw.edu", "bmen", "bmen", 4);
        String expResult = "bmenezes@mail.umw.edu";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class Account.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "bmenezes";
        Account instance = new Account("Bruno", "Menezes", 
                "bmenezes@mail.umw.edu", "bmen", "bmen", 4);
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getuName method, of class Account.
     */
    @Test
    public void testGetuName() {
        System.out.println("getuName");
        Account instance = new Account("Bruno", "Menezes", 
                "bmenezes@mail.umw.edu", "bmen", "bmen", 4);
        String expResult = "bmen";
        String result = instance.getuName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setuName method, of class Account.
     */
    @Test
    public void testSetuName() {
        System.out.println("setuName");
        String uName = "Bmen";
        Account instance = new Account("Bruno", "Menezes", 
                "bmenezes@mail.umw.edu", "bmen", "bmen", 4);
        instance.setuName(uName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class Account.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Account instance = new Account("Bruno", "Menezes", 
                "bmenezes@mail.umw.edu", "bmen", "bmen", 4);
        String expResult = "bmen";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class Account.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "Bmen";
        Account instance = new Account("Bruno", "Menezes", 
                "bmenezes@mail.umw.edu", "bmen", "bmen", 4);
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class Account.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Account instance = new Account("Bruno", "Menezes", 
                "bmenezes@mail.umw.edu", "bmen", "bmen", 4);
        int expResult = 4;
        int result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setType method, of class Account.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        int type = 2;
        Account instance = new Account("Bruno", "Menezes", 
                "bmenezes@mail.umw.edu", "bmen", "bmen", 4);
        instance.setType(type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toFileString method, of class Account.
     */
    @Test
    public void testToFileString() {
        System.out.println("toFileString");
        Account instance = new Account("Bruno", "Menezes", 
                "bmenezes@mail.umw.edu", "bmen", "bmen", 4);
        String expResult = "";
        String result = instance.toFileString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Account.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Account instance = new Account("Bruno", "Menezes", 
                "bmenezes@mail.umw.edu", "bmen", "bmen", 4);
        String expResult = "Bruno" + " " + "Menezes" + " " + 
                "bmenezes@mail.umw.edu" + " " + "bmen"
                + " " + "bmen" + " " + 4;
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
