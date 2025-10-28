package edu.sc.csce747.MeetingPlanner;

import static org.junit.Assert.*;
import org.junit.Test;

public class TimeConflictExceptionTest {

    @Test
    public void testMessageIsPropagated() {
        TimeConflictException ex = new TimeConflictException("Conflict");
        assertEquals("Conflict", ex.getMessage());
    }
}


