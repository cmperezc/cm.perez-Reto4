package model.data_structures;

import java.util.ArrayList;
import java.util.List;

public class InfoVertice {
	public static double LatI=-73.99132694999997;
	public static double LatF=-74.39470032000003;
	public static double LonF=4.836643219999985;
	public static double LonI=3.819966340000008;
	public static double LatMedia=LatI+(LatF-LatI)/2;
	public static double LonMedia=LonI+(LonF-LonI)/2;
	public double Latitud;
	public double Longitud;
	public int Zona;
	public int comparendos;
	public Estacion e;
	List<Comparendo> comparendo = new ArrayList<Comparendo>();
	
	
	public InfoVertice(double pLatitud,double pLongitud){
		Latitud=pLatitud;
		Longitud=pLongitud;
		if(Latitud>=LatMedia){
			if(Longitud>=LonMedia){
				Zona=1;
			}else{
				Zona=3;
			}
		}else{
			if(Longitud>=LonMedia){
				Zona=2;
			}else{
				Zona=4;
			}
		}
	}
	public double darLatitud(){
		return Latitud;
	}
	
	public double darLongitud(){
		return Longitud;
	}
	public int darZona(){
		return Zona;
	}
	public int darComparendos(){
		return comparendos;
	}
	public void sumarComparendos(int Psuma){
		comparendos+=Psuma;
	}
	public void sumaCom(){
		comparendos++;
	}
	public List<Comparendo> darComparendo(){
		return comparendo;
	}
	public void agregarCOmparendo(Comparendo pc){
		comparendo.add(pc);
		sumaCom();
	}
	public Estacion darEstacion(){
		return e;
	}
	public void SetEstacion(Estacion pE){
		e=pE;
	}
}
