package model.logic;


public class citiBike {
	
	

	private String tripduration;

	private String starttime;
	
	private String stoptime;

	private double startStationId;

	private String startStationName;

	private double startStationLatitude;

	private double startStationLongitude;

	private double endStationId;

	private String endStationName;

	private double endStationLatitude;

	private double endStationLongitude;

	private double bikeid;

	private String usertype;

	private double birthYear;

	private double gender;
	
	public citiBike(String tripduration) {
		this.tripduration = tripduration;
		
	}

	public String getTripduration() {
		return tripduration;
	}

	public void setTripduration(String tripduration) {
		this.tripduration = tripduration;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getStoptime() {
		return stoptime;
	}

	public void setStoptime(String stoptime) {
		this.stoptime = stoptime;
	}

	public double getStartStationId() {
		return startStationId;
	}

	public void setStartStationId(double d) {
		this.startStationId = d;
	}

	public String getStartStationName() {
		return startStationName;
	}

	public void setStartStationName(String startStationName) {
		this.startStationName = startStationName;
	}

	public double getStartStationLatitude() {
		return startStationLatitude;
	}

	public void setStartStationLatitude(double startStationLatitude) {
		this.startStationLatitude = startStationLatitude;
	}

	public double getStartStationLongitude() {
		return startStationLongitude;
	}

	public void setStartStationLongitude(double startStationLongitude) {
		this.startStationLongitude = startStationLongitude;
	}

	public double getEndStationId() {
		return endStationId;
	}

	public void setEndStationId(double endStationId) {
		this.endStationId = endStationId;
	}

	public String getEndStationName() {
		return endStationName;
	}

	public void setEndStationName(String endStationName) {
		this.endStationName = endStationName;
	}

	public double getEndStationLatitude() {
		return endStationLatitude;
	}

	public void setEndStationLatitude(double endStationLatitude) {
		this.endStationLatitude = endStationLatitude;
	}

	public double getEndStationLongitude() {
		return endStationLongitude;
	}

	public void setEndStationLongitude(double endStationLongitude) {
		this.endStationLongitude = endStationLongitude;
	}

	public double getBikeid() {
		return bikeid;
	}

	public void setBikeid(double bikeid) {
		this.bikeid = bikeid;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public double getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(double birthYear) {
		this.birthYear = birthYear;
	}

	public double getGender() {
		return gender;
	}

	public void setGender(double gender) {
		this.gender = gender;
	}


}
