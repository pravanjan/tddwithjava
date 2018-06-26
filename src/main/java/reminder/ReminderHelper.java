package reminder;

import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import reminderPojo.Reminder;

public class ReminderHelper {
	private List<Reminder> reminderList = new ArrayList<Reminder>();
	
	public Map<String,Object> createReminder(Reminder reminder, GooogleCalendarSync gcalsync) {
		
		Map<String,Object> responseMap = new HashMap<>();
		Long milisencodreminder = reminder.getLocaldate().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		Long currentMili = Instant.now().toEpochMilli();
		
		if(reminder.getName() == null || reminder.getName().isEmpty()) {
			reminder.setName("Default");
		}
		
		System.out.println(milisencodreminder+"  "+currentMili);
		
		if(milisencodreminder > currentMili) {
			if(gcalsync.addEventtoGcal(reminder)) {
				reminder.setGcalFlag(true);
			}
			reminderList.add(reminder);
			responseMap.put("reminderList",reminderList );
			responseMap.put("message", "created Successfully");
		}
		else {
			responseMap.put("reminderList", null);
			responseMap.put("message", "reminder can not be set on past date");
		}
		
		return responseMap;
		
		
	}

}
