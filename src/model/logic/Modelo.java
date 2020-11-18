package model.logic;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import model.data_structures.*;
import model.data_structures.DirectedGraph;
import model.data_structures.listaDoble;

/**
 * Definicion del modelo del mundo
 *
 */


public class Modelo {


	public static String uno = "./data/201801-1-citibike-tripdata.csv";
	public static String dos = "./data/201801-2-citibike-tripdata.csv";
	public static String tres = "./data/201801-3-citibike-tripdata.csv";
	public static String cuatro = "./data/201801-4-citibike-tripdata.csv";
	public DirectedGraph grafo;

	public void cargaDatos() {
		listaDoble<String>listaArchivos=new listaDoble<String>();

		listaArchivos.agregarInicio(uno);
		listaArchivos.agregarInicio(dos);
		listaArchivos.agregarInicio(tres);
		listaArchivos.agregarInicio(cuatro);

		int contador=0;
		

		for (int i = 0; i < listaArchivos.darTamaño(); i++) {
			String ARCHIVO=listaArchivos.darElemento(i);

			String id=null;

			File archivo1 = new File (ARCHIVO);


			FileReader fr1 = null;
			int lineas = 0;
			try {



				fr1 = new FileReader (archivo1);

				BufferedReader br1 = new BufferedReader (fr1);


				String lineaActual = br1.readLine();

				while ((lineaActual=br1.readLine())!=null) {
					contador++;
					DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String[] atributos = lineaActual.split(",") ;
					citiBike bike = new citiBike(atributos[0]);
					id=atributos[0];
					bike.setStarttime(atributos[1]);
					bike.setStoptime(atributos[2]);
					bike.setStartStationId(Double.parseDouble(atributos[3]));
					bike.setStartStationName(atributos[4]);
					bike.setStartStationLatitude(Double.parseDouble(atributos[5]));
					bike.setStartStationLongitude(Double.parseDouble(atributos[6]));
					bike.setEndStationId(Double.parseDouble(atributos[7]));
					bike.setEndStationName(atributos[8]);
					bike.setEndStationLatitude(Double.parseDouble(atributos[9]));
					bike.setEndStationLongitude(Double.parseDouble(atributos[10]));
					bike.setBikeid(Double.parseDouble(atributos[11]));
					bike.setUsertype(atributos[12]);
					bike.setBirthYear(Double.parseDouble(atributos[13]));
					bike.setGender(Double.parseDouble(atributos[14]));
					
					 Double cos= haversine.distance(Double.parseDouble(atributos[5]),Double.parseDouble(atributos[6]),Double.parseDouble(atributos[9]),Double.parseDouble(atributos[10]));
					 Vertex<K, V>


					
				}


			}catch (Exception e) {
				System.out.println("error fatal:"+e.getMessage() );
			}
			finally {
				try {
					if(null!=fr1) {
						fr1.close();
					}
				}
				catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}




		System.out.println(contador);

	}

	
	
	 
}
