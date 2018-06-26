Feature  : Create Reminder App



Scenario : Create Reminder with valid parameter
    Given user select create reminder 
    When  user enter parameter reminder name , type and date 
    then return response reminder created successfully 
    
 Scenario : Create Reminder with valid parameter
                  Given user select create reminder 
                  When  user missed to enter reminder name , 
		   Then assign default name and 
                  then return response reminder created successfully
                  
 Scenario : Create Reminder with valid parameter
            Given user select create reminder 
            When  user missing enter name and type but has valid future date .
            Then create reminder with default name and type and  return response reminder created successfully 
                  
 Scenario : Create Reminder with valid parameter
 			Given user select create reminder 
 			When  user missed to enter reminder name , 
 			Then assign default name and then return response reminder created successfully
 Scenario : notify to google calendar 
 		   Given user successfully created the reminder 
 		   Then add event in google calendar 
 		   then return response g-cal sync successfully .
 	

     
    
 Scenario : Create Reminder with invalid parameter
    		    Given user select create reminder 
    			When  user enter parameter reminder name , type and and invalid  date ie a past date 
    			then return response reminder can not be set on past date .
    
    
 
 