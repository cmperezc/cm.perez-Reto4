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

import model.data_structures.BST;

import model.data_structures.RedBlackBST;

import model.data_structures.listaDoble;
import model.data_structures.Ayuda.Cola;

/**
 * Definicion del modelo del mundo
 *
 */


public class Modelo {


	public static String uno = "./data/201801-1-citibike-tripdata.csv";
	public static String dos = "./data/201801-2-citibike-tripdata.csv";
	public static String tres = "./data/201801-3-citibike-tripdata.csv";
	public static String cuatro = "./data/201801-4-citibike-tripdata.csv";

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
					String[] atributos = lineaActual.split(",") ;
					accidents accidentes = new accidents(atributos[0]);
					id=atributos[0];
					accidentes.setSource(atributos[1]);
					if(!atributos[2].equals(""))
						accidentes.setTMC(Double.parseDouble(atributos[2]));
					if(!atributos[3].equals(""))
						accidentes.setSeverity(Double.parseDouble(atributos[3]));
					DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					if(!atributos[4].equals(""))
						accidentes.setStart_Time(fechaHora.parse(atributos[4]));
					if(!atributos[5].equals(""))
						accidentes.setEnd_Time(fechaHora.parse(atributos[5]));
					if(!atributos[6].equals(""))
						accidentes.setStart_Lat(Double.parseDouble(atributos[6]));
					if(!atributos[7].equals(""))
						accidentes.setStart_Lng(Double.parseDouble(atributos[7]));
					if(!atributos[8].equals(""))
						accidentes.setEnd_Lat(Double.parseDouble(atributos[8]));
					if(!atributos[9].equals(""))
						accidentes.setEnd_Lng(Double.parseDouble(atributos[9]));
					if(!atributos[10].equals(""))
						accidentes.setDistance(Double.parseDouble(atributos[10]));
					accidentes.setDescription(atributos[11]);
					if(!atributos[12].equals(""))
						accidentes.setNumber(Double.parseDouble(atributos[12]));
					accidentes.setStreet(atributos[13]);
					accidentes.setSide(atributos[14]);
					accidentes.setCity(atributos[15]);
					accidentes.setCounty(atributos[16]);
					accidentes.setState(atributos[17]);
					accidentes.setZipcode(atributos[18]);
					accidentes.setCountry(atributos[19]);
					accidentes.setTimezone(atributos[20]);
					accidentes.setAirport_Code(atributos[21]);
					if(!atributos[22].equals(""))
						accidentes.setWeather_Timestamp(fechaHora.parse(atributos[22]));
					if(!atributos[23].equals(""))
						accidentes.setTemperature(Double.parseDouble(atributos[23]));
					if(!atributos[24].equals(""))
						accidentes.setWind_Chill(Double.parseDouble(atributos[24]));
					if(!atributos[25].equals(""))
						accidentes.setHumidity(Double.parseDouble(atributos[25]));
					if(!atributos[26].equals(""))
						accidentes.setPressure(Double.parseDouble(atributos[26]));
					if(!atributos[27].equals(""))
						accidentes.setVisibility(Double.parseDouble(atributos[27]));
					accidentes.setWind_Direction(atributos[28]);
					if(!atributos[29].equals(""))
						accidentes.setWind_Speed(Double.parseDouble(atributos[29]));
					if(!atributos[30].equals(""))
						accidentes.setPrecipitation(Double.parseDouble(atributos[30]));
					accidentes.setWeather_Condition(atributos[31]);
					accidentes.setAmenity(Boolean.parseBoolean(atributos[32]));
					accidentes.setBump(Boolean.parseBoolean(atributos[33]));
					accidentes.setCrossing(Boolean.parseBoolean(atributos[34]));
					accidentes.setGive_Way(Boolean.parseBoolean(atributos[35]));
					accidentes.setJunction(Boolean.parseBoolean(atributos[36]));
					accidentes.setNo_Exit(Boolean.parseBoolean(atributos[37]));
					accidentes.setRailway(Boolean.parseBoolean(atributos[38]));
					accidentes.setRoundabout(Boolean.parseBoolean(atributos[39]));
					accidentes.setStation(Boolean.parseBoolean(atributos[40]));
					accidentes.setStop(Boolean.parseBoolean(atributos[41]));
					accidentes.setTraffic_Calming(Boolean.parseBoolean(atributos[42]));
					accidentes.setTraffic_Signal(Boolean.parseBoolean(atributos[43]));
					accidentes.setTurning_Loop(Boolean.parseBoolean(atributos[44]));
					if (atributos.length>45) {
						accidentes.setSunrise_Sunset(atributos[45]);
						accidentes.setCivil_Twilight(atributos[46]);
						accidentes.setNautical_Twilight(atributos[47]);
						accidentes.setAstronomical_Twilight(atributos[48]);
					}
					DateFormat fechaHora2 = new SimpleDateFormat("yyyy-MM-dd");
					DateFormat hora = new SimpleDateFormat("HH:mm:ss"); 
					LocalTime localTime = LocalTime.parse(atributos[4].split(" ")[1], DateTimeFormatter.ofPattern("HH:mm:ss"));

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




		System.out.println("numero de accidentes:"+contador + "llaves" + arbolR2.size()+"altura"+arbolR2.height()+"min:"+arbolR2.min()+"max:"+arbolR2.max()+"CON BST");

	}

	
	
	 
}
