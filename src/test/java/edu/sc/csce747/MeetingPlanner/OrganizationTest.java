package edu.sc.csce747.MeetingPlanner;

import static org.junit.Assert.*;
import org.junit.Test;

public class OrganizationTest {
	// Add test methods here. 
    // You are not required to write tests for all classes.

    @Test
    public void testDefaultData_hasEmployeesAndRooms() {
        Organization org = new Organization();
        assertTrue(org.getEmployees().size() >= 1);
        assertTrue(org.getRooms().size() >= 1);
    }

    @Test
    public void testGetRoom_successAndFailure() throws Exception {
        Organization org = new Organization();
        Room existing = org.getRoom("2A01");
        assertEquals("2A01", existing.getID());
        try {
            org.getRoom("NOPE");
            fail("Expected Exception for missing room");
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Requested room does not exist"));
        }
    }

    @Test
    public void testGetEmployee_successAndFailure() throws Exception {
        Organization org = new Organization();
        Person p = org.getEmployee("Greg Gay");
        assertEquals("Greg Gay", p.getName());
        try {
            org.getEmployee("Unknown Person");
            fail("Expected Exception for missing employee");
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Requested employee does not exist"));
        }
    }
}
