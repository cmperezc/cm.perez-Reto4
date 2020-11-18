package model.data_structures;

import java.util.Iterator;

public class Estacion implements Iterable {
	public String ID;
	public double latitud;
	public double Longitud;
	public String nombre;
	public int vertice;
	public Estacion(String pId,double lat, double lon, String pNombre){
		ID=pId;
		latitud=lat;
		Longitud=lon;
		nombre=pNombre;
		
	}
	public double darLatitud(){
		return latitud;
	}
	public double darLongitud(){
		return Longitud;
	}
	public void cambiarVertice(int pV){
		vertice=pV;
	}
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
