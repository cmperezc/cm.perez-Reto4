	package model.data_structures;


import java.util.Comparator;
import java.util.Date;

public class Comparendo implements Comparable{
	private int objectId;
	private Date fecha_hora;
	private String des_infrac;
	private String medio_dete;
	private String clase_vehi;
	private String tipo_servi;
	private String infraccion;
	private String localidad;
	public int V1;
	
	private double latitud;
	private double longitud;
	
	public Comparendo(int objeId, Date fecha, String descripcion, String detencion, String claseVeh, String tipoSer, String codInfraccion, String localidadP, double lonP, double latP)
	{
		objectId = objeId;
		fecha_hora = fecha;
		des_infrac = descripcion;
		medio_dete = detencion;
		clase_vehi = claseVeh;
		tipo_servi = tipoSer;
		infraccion = codInfraccion;
		localidad = localidadP;
		longitud = lonP;
		latitud = latP;
	}
	
	@Override
	public String toString() {
		return "Comparendo [OBJECTID=" + objectId + ", FECHA_HORA=" + fecha_hora + ", DES_INFRAC=" + des_infrac
				+ ", MEDIO_DETE=" + medio_dete + ", CLASE_VEHI=" + clase_vehi + ", TIPO_SERVI=" + tipo_servi
				+ ", INFRACCION=" + infraccion + ", LOCALIDAD=" + localidad + ", latitud=" + latitud + ", longitud="
				+ longitud + "]";
	}
	public void setCoordenadas(double pLat,double pLon,int pv1){
		latitud=pLat;
		longitud=pLon;
		V1=pv1;
		
	}
	

	public int compareTo(Comparendo com) {
		int r=0;
		if(tipo_servi==com.tipo_servi){
			r=com.infraccion.compareTo(infraccion);
		}else{
			if(tipo_servi=="Publico"){
				r=2;
			}else if(com.tipo_servi=="Publico"){
				r=-2;
			}else if(tipo_servi=="Oficial"){
				r=2;
			}else if(com.tipo_servi=="Oficial"){
				r=-2;
			}else if(tipo_servi=="Particular"){
				r=2;
			}else{
				r=-2;
			}
				
		}
		
		return r;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
