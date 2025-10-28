package edu.sc.csce747.MeetingPlanner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

public class CalendarTest {
    // Add test methods here. 
    // You are not required to write tests for all classes.
    
    @Test
    public void testAddMeeting_holiday() {
        // Create Midsommar holiday
        Calendar calendar = new Calendar();
        // Add to calendar object.
        try {
            Meeting midsommar = new Meeting(6, 26, "Midsommar");
            calendar.addMeeting(midsommar);
            // Verify that it was added.
            Boolean added = calendar.isBusy(6, 26, 0, 23);
            assertTrue("Midsommar should be marked as busy on the calendar",added);
        } catch(TimeConflictException e) {
            fail("Should not throw exception: " + e.getMessage());
        }
    }

    @Test
    public void testAddMeeting_validTimeslot() {
        Calendar calendar = new Calendar();
        try {
            Meeting standup = new Meeting(3, 15, 9, 10);
            calendar.addMeeting(standup);
            assertTrue(calendar.isBusy(3, 15, 9, 10));
            assertFalse(calendar.isBusy(3, 15, 11, 12));
        } catch (TimeConflictException e) {
            fail("Should not throw exception: " + e.getMessage());
        }
    }

    @Test(expected = TimeConflictException.class)
    public void testAddMeeting_invalidDay_throws() throws TimeConflictException {
        Calendar calendar = new Calendar();
        Meeting invalid = new Meeting(2, 35, 9, 10); // Feb 35
        calendar.addMeeting(invalid);
    }

    @Test(expected = TimeConflictException.class)
    public void testAddMeeting_invalidMonth_throws() throws TimeConflictException {
        Calendar calendar = new Calendar();
        Meeting invalid = new Meeting(13, 10, 9, 10); // Month 13
        calendar.addMeeting(invalid);
    }

    @Test(expected = TimeConflictException.class)
    public void testAddMeeting_invalidNegativeHour_throws() throws TimeConflictException {
        Calendar calendar = new Calendar();
        Meeting invalid = new Meeting(5, 10, -1, 10);
        calendar.addMeeting(invalid);
    }

    @Test(expected = TimeConflictException.class)
    public void testAddMeeting_endBeforeStart_throws() throws TimeConflictException {
        Calendar calendar = new Calendar();
        Meeting invalid = new Meeting(5, 10, 15, 10);
        calendar.addMeeting(invalid);
    }

    @Test
    public void testIsBusy_detectsOverlapBoundaries() {
        Calendar calendar = new Calendar();
        try {
            calendar.addMeeting(new Meeting(7, 20, 10, 12));
            assertTrue(calendar.isBusy(7, 20, 10, 11)); // starts inside
            assertTrue(calendar.isBusy(7, 20, 11, 12)); // ends inside
            // Implementation treats boundaries as inclusive; 12-13 overlaps 10-12
            assertTrue(calendar.isBusy(7, 20, 12, 13));
        } catch (TimeConflictException e) {
            fail("Should not throw exception: " + e.getMessage());
        }
    }

    @Test
    public void testDecemberAllowed_validCase() {
        Calendar calendar = new Calendar();
        try {
            calendar.addMeeting(new Meeting(12, 1, 9, 10));
            assertTrue(calendar.isBusy(12, 1, 9, 10));
        } catch (TimeConflictException e) {
            fail("December should be a valid month: " + e.getMessage());
        }
    }
}
