package model.logic;

import java.util.Date;

public class citiBike {
	
	

	private int tripduration;

	private Date starttime;
	
	private Date stoptime;

	private int startStationId;

	private String startStationName;

	private int startStationLatitude;

	private int startStationLongitude;

	private int endStationId;

	private String endStationName;

	private int endStationLatitude;

	private int endStationLongitude;

	private int bikeid;

	private String usertype;

	private int birthYear;

	private int gender;
	
	public citiBike(int tripduration, Date starttime, Date stoptime, int startStationId, String startStationName,
			int startStationLatitude, int startStationLongitude, int endStationId, String endStationName,
			int endStationLatitude, int endStationLongitude, int bikeid, String usertype, int birthYear, int gender) {
		super();
		this.tripduration = tripduration;
		this.starttime = starttime;
		this.stoptime = stoptime;
		this.startStationId = startStationId;
		this.startStationName = startStationName;
		this.startStationLatitude = startStationLatitude;
		this.startStationLongitude = startStationLongitude;
		this.endStationId = endStationId;
		this.endStationName = endStationName;
		this.endStationLatitude = endStationLatitude;
		this.endStationLongitude = endStationLongitude;
		this.bikeid = bikeid;
		this.usertype = usertype;
		this.birthYear = birthYear;
		this.gender = gender;
	}

	public int getTripduration() {
		return tripduration;
	}

	public void setTripduration(int tripduration) {
		this.tripduration = tripduration;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getStoptime() {
		return stoptime;
	}

	public void setStoptime(Date stoptime) {
		this.stoptime = stoptime;
	}

	public int getStartStationId() {
		return startStationId;
	}

	public void setStartStationId(int startStationId) {
		this.startStationId = startStationId;
	}

	public String getStartStationName() {
		return startStationName;
	}

	public void setStartStationName(String startStationName) {
		this.startStationName = startStationName;
	}

	public int getStartStationLatitude() {
		return startStationLatitude;
	}

	public void setStartStationLatitude(int startStationLatitude) {
		this.startStationLatitude = startStationLatitude;
	}

	public int getStartStationLongitude() {
		return startStationLongitude;
	}

	public void setStartStationLongitude(int startStationLongitude) {
		this.startStationLongitude = startStationLongitude;
	}

	public int getEndStationId() {
		return endStationId;
	}

	public void setEndStationId(int endStationId) {
		this.endStationId = endStationId;
	}

	public String getEndStationName() {
		return endStationName;
	}

	public void setEndStationName(String endStationName) {
		this.endStationName = endStationName;
	}

	public int getEndStationLatitude() {
		return endStationLatitude;
	}

	public void setEndStationLatitude(int endStationLatitude) {
		this.endStationLatitude = endStationLatitude;
	}

	public int getEndStationLongitude() {
		return endStationLongitude;
	}

	public void setEndStationLongitude(int endStationLongitude) {
		this.endStationLongitude = endStationLongitude;
	}

	public int getBikeid() {
		return bikeid;
	}

	public void setBikeid(int bikeid) {
		this.bikeid = bikeid;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}


}
