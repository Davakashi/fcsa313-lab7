package edu.sc.csce747.MeetingPlanner;

import static org.junit.Assert.*;
import org.junit.Test;

public class PlannerInterfaceTest {
    // Minimal non-interactive assertion: instance creation shouldn't throw
    @Test
    public void testPlannerInterfaceConstructs() {
        PlannerInterface pi = new PlannerInterface();
        assertNotNull(pi);
    }
}


