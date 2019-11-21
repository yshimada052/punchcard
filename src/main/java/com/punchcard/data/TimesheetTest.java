package com.punchcard.data;

import com.punchcard.beans.*;
import com.punchcard.service.*;

public class TimesheetTest {
	public static void main(String[] args) {
		TimesheetDAO ts = new TimesheetDAO();
		ts.findTimesheetById(1);
	}
}
