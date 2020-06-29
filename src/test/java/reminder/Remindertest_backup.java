package reminder;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import reminderPojo.Reminder;

@RunWith(MockitoJUnitRunner.class)
public class Remindertest_backup {

	@Mock
	private GooogleCalendarSync calsyncMock;

	@InjectMocks
	private ReminderHelper helper;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void createReminderwithallvalidparam() {
		Reminder reminder = new Reminder("Breakfast", "Health", LocalDateTime.now().plusHours(1));
		Map<String, Object> responseMap = new ReminderHelper().createReminder(reminder, calsyncMock);
		assertEquals(responseMap.get("message"), "created Successfully");
	}

	@Test
	public void createReminderNamevalueasEmptyString() {

		Reminder reminder = new Reminder("", "Health", LocalDateTime.now().plusHours(1));
		Map<String, Object> responseMap = new ReminderHelper().createReminder(reminder, calsyncMock);
		List<Reminder> reminderList = (List<Reminder>) responseMap.get("reminderList");
		assertEquals("Default", reminderList.get(0).getName());
	}

	@Test
	public void createReminderNamevalueasNull() {

		Reminder reminder = new Reminder(null, "Health", LocalDateTime.now().plusHours(1));
		Map<String, Object> responseMap = new ReminderHelper().createReminder(reminder, calsyncMock);
		List<Reminder> reminderList = (List<Reminder>) responseMap.get("reminderList");
		assertEquals("Default", reminderList.get(0).getName());
	}

	@Test
	public void addEventToGoogleCalendar() {

		Reminder reminder = new Reminder("BreakFirst", "Health", LocalDateTime.now().plusHours(1));
		when(calsyncMock.addEventtoGcal(any(Reminder.class))).thenReturn(true);

		Map<String, Object> responseMap = new ReminderHelper().createReminder(reminder, calsyncMock);
		List<Reminder> reminderList = (List<Reminder>) responseMap.get("reminderList");
		assertEquals(true, reminderList.get(0).getGcalFlag());
	}

	@Test
	public void createReminderInvalidDateparam() {
		Reminder reminder = new Reminder("Breakfast", "once", LocalDateTime.of(2018, Month.APRIL, 20, 12, 30, 00));
		Map<String, Object> responseMap = new ReminderHelper().createReminder(reminder, calsyncMock);
		assertEquals(responseMap.get("message"), "reminder can not be set on past date");
	}

}
