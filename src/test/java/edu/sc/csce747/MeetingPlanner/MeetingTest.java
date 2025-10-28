package edu.sc.csce747.MeetingPlanner;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class MeetingTest {
	// Add test methods here. 
    // You are not required to write tests for all classes.

    @Test
    public void placeholder_passes() {
        assertTrue(true);
    }

    @Test
    public void testToString_containsRoomAndDescriptionAndAttendees() {
        ArrayList<Person> attendees = new ArrayList<Person>();
        attendees.add(new Person("Alice"));
        attendees.add(new Person("Bob"));
        Room room = new Room("2A01");
        Meeting m = new Meeting(5, 10, 9, 11, attendees, room, "Sprint Planning");
        String s = m.toString();
        assertTrue(s.contains("2A01"));
        assertTrue(s.contains("Sprint Planning"));
        assertTrue(s.contains("Alice"));
        assertTrue(s.contains("Bob"));
    }

    @Test
    public void testAddAndRemoveAttendee() {
        ArrayList<Person> attendees = new ArrayList<Person>();
        Room room = new Room("2A01");
        Meeting m = new Meeting(5, 10, 9, 11, attendees, room, "Sync");
        Person charlie = new Person("Charlie");
        m.addAttendee(charlie);
        assertTrue(m.getAttendees().contains(charlie));
        m.removeAttendee(charlie);
        assertFalse(m.getAttendees().contains(charlie));
    }
}
