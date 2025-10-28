package edu.sc.csce747.MeetingPlanner;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class RoomTest {
	// Add test methods here. 
    // You are not required to write tests for all classes.

    @Test
    public void testAddMeeting_conflictPropagatesMessage() {
        Room r = new Room("2A02");
        ArrayList<Person> attendees = new ArrayList<Person>();
        try {
            r.addMeeting(new Meeting(6, 6, 10, 12, attendees, r, "M1"));
            try {
                r.addMeeting(new Meeting(6, 6, 11, 13, attendees, r, "M2"));
                fail("Expected TimeConflictException");
            } catch (TimeConflictException e) {
                assertTrue(e.getMessage().contains("Conflict for room 2A02"));
            }
        } catch (TimeConflictException e) {
            fail("Unexpected: " + e.getMessage());
        }
    }

    @Test
    public void testPrintAgenda_includesHeader() {
        Room r = new Room("2A03");
        ArrayList<Person> attendees = new ArrayList<Person>();
        try {
            r.addMeeting(new Meeting(8, 8, 9, 10, attendees, r, "Morning"));
            String agenda = r.printAgenda(8);
            assertTrue(agenda.contains("Agenda for 8"));
        } catch (TimeConflictException e) {
            fail("Unexpected: " + e.getMessage());
        }
    }
}
