package ca.ubc.cpsc210.tpd.clock;


public class AlarmClock extends Clock {
	private int alarmHrs;
	private int alarmMins;
	private boolean alarmOn;
	private boolean isAlarmSounding;
	
	// EFFECTS: time has been set to 00:00:00,
	// alarm time is 00:00, alarm is off and is not sounding
	public AlarmClock() {
		super();
		alarmHrs = 0;
		alarmMins = 0;
		alarmOn = false;
		isAlarmSounding = false;
	}
	
	public int getAlarmHrs() {
		return alarmHrs;
	}
	
	public int getAlarmMins() {
		return alarmMins;
	}
	
	// REQUIRES: 0 <= hrs < 24, 0 <= mins < 60; time is in 24hr format
	// MODIFIES: this
	// EFFECTS: alarm has been set to given time and alarm is on
	public void setAlarmTime(int hrs, int mins) {
		alarmHrs = hrs;
		alarmMins = mins;
		alarmOn = true;
	}
	
	// MODIFIES: this
	// EFFECTS: if isOn is true, alarm is on; otherwise alarm is off and alarm is not sounding
	public void setAlarm(boolean isOn) {
		alarmOn = isOn;
		
		if (!alarmOn)
			isAlarmSounding = false;
	}
	
	// EFFECTS: returns true if alarm is on, false otherwise
	public boolean isAlarmOn() {
		return alarmOn;
	}
	
	// EFFECTS: returns true if alarm is sounding, false otherwise
	public boolean isSounding() {
		return isAlarmSounding;
	}
	
	// MODIFIES: this
	// EFFECTS: time on clock is advanced by 1 second; if alarm is set and time on clock
	// matches alarm time, alarm is turned on
	@Override
	public void tick() {
		super.tick();
		
		if (alarmOn && clockMatchesAlarm()) {
			isAlarmSounding = true;
		}
	}
 
	// EFFECTS: returns true if time on clock matches alarm time.
    private boolean clockMatchesAlarm(){
	    return alarmHrs == getHours() && alarmMins == getMinutes() && getSeconds() == 0;
    }
}
