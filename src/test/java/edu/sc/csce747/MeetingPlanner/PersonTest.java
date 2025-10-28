package edu.sc.csce747.MeetingPlanner;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class PersonTest {
	// Add test methods here. 
    // You are not required to write tests for all classes.

    @Test
    public void testAddMeeting_conflictPropagatesMessage() {
        Person p = new Person("Dana");
        Room r = new Room("R1");
        ArrayList<Person> attendees = new ArrayList<Person>();
        try {
            p.addMeeting(new Meeting(4, 5, 10, 12, attendees, r, "M1"));
            // Add overlapping
            try {
                p.addMeeting(new Meeting(4, 5, 11, 13, attendees, r, "M2"));
                fail("Expected TimeConflictException");
            } catch (TimeConflictException e) {
                assertTrue(e.getMessage().contains("Conflict for attendee Dana"));
            }
        } catch (TimeConflictException e) {
            fail("Unexpected: " + e.getMessage());
        }
    }

    @Test
    public void testAgendaPrinting_nonEmpty() {
        Person p = new Person("Eve");
        Room r = new Room("R2");
        ArrayList<Person> attendees = new ArrayList<Person>();
        try {
            p.addMeeting(new Meeting(3, 3, 9, 10, attendees, r, "Morning"));
            String agenda = p.printAgenda(3);
            assertTrue(agenda.contains("Agenda for 3"));
        } catch (TimeConflictException e) {
            fail("Unexpected: " + e.getMessage());
        }
    }
}
