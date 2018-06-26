package reminderPojo;


import java.time.LocalDateTime;

public class Reminder {

    private String name = "";
    private String type = "";
    private LocalDateTime  localdate =  LocalDateTime.now();
    private Boolean gcalFlag  = false ;

    public Reminder(String taskName ,String  taskType,LocalDateTime date ){
        this.name = taskName ;
        this.type = taskType ;
        this.localdate =date ;
      }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDateTime getLocaldate() {
		return localdate;
	}

	public void setLocaldate(LocalDateTime localdate) {
		this.localdate = localdate;
	}

	public Boolean getGcalFlag() {
		return gcalFlag;
	}

	public void setGcalFlag(Boolean gcalFlag) {
		this.gcalFlag = gcalFlag;
	}
	

    
	

  
  


}
