package model.logic;


public class llave implements Comparable<llave> {
	
	private double latitud;
	private double longitud;
	
	public llave(double latitud, double longitud) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	@Override
	public int compareTo(llave o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
