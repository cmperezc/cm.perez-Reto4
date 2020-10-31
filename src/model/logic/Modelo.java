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


	public static String ARCHIVO = "./data/us_accidents_small.csv";
	public static String anio16 = "./data/us_accidents_dis_2016.csv";
	public static String anio17 = "./data/us_accidents_dis_2017.csv";
	public static String anio18 = "./data/us_accidents_dis_2018.csv";
	public static String anio19 = "./data/us_accidents_dis_2019.csv";
	public static String todo = "./data/US_Accidents_Dec19.csv";
	private RedBlackBST<Date, RedBlackBST<Double, listaDoble<accidents>>> Bst;
	private BST<Date, BST<Double, listaDoble<accidents>>> bst2;
	private RedBlackBST<Date, listaDoble<accidents>> arbolR2;
	private RedBlackBST<Date, RedBlackBST<Double, listaDoble<accidents>>> arbolR5;
	private RedBlackBST<LocalTime, listaDoble<accidents>> arbolR5N;
	private RedBlackBST<llave, listaDoble<accidents>> arbolR6;
	listaDoble<accidents>listaR6=new listaDoble<accidents>();

	public void cargaDatos() {
		listaDoble<String>listaArchivos=new listaDoble<String>();

		//listaArchivos.agregarInicio(anio16);
		//listaArchivos.agregarInicio(anio17);
		//listaArchivos.agregarInicio(anio18);
		//listaArchivos.agregarInicio(anio19);
		listaArchivos.agregarInicio(todo);

		int contador=0;
		Bst = new RedBlackBST<Date, RedBlackBST<Double, listaDoble<accidents>>>();
		bst2= new BST<Date, BST<Double, listaDoble<accidents>>>(); 
		arbolR2 = new RedBlackBST<Date, listaDoble<accidents>>();
		arbolR5 = new RedBlackBST<Date, RedBlackBST<Double, listaDoble<accidents>>>();
		arbolR5N = new RedBlackBST<LocalTime, listaDoble<accidents>>();
		arbolR6 = new RedBlackBST<llave, listaDoble<accidents>>();

		for (int i = 0; i < listaArchivos.darTamaño(); i++) {
			ARCHIVO=listaArchivos.darElemento(i);

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
					llave key = new llave(Double.parseDouble(atributos[6]), Double.parseDouble(atributos[7]));
					DateFormat fechaHora2 = new SimpleDateFormat("yyyy-MM-dd");
					DateFormat hora = new SimpleDateFormat("HH:mm:ss");
					/////////////////////
					BST<Double, listaDoble<accidents>> nuevo = bst2.get(fechaHora2.parse(atributos[4]));

					if (nuevo!=null) {
						listaDoble<accidents> lista = nuevo.get(Double.parseDouble(atributos[3]));
						if (lista!=null) {
							lista.agregarInicio(accidentes);

						}
						else {
							lista = new listaDoble<accidents>();
							lista.agregarInicio(accidentes);
						}
						nuevo.put(Double.parseDouble(atributos[3]), lista);
					}else {
						nuevo=new BST<Double, listaDoble<accidents>>();
						listaDoble<accidents> lista2= new listaDoble<accidents>();
						lista2.agregarInicio(accidentes);
						nuevo.put(Double.parseDouble(atributos[3]), lista2);
					}
					bst2.put(fechaHora2.parse(atributos[4]), nuevo);
					/////////////////////
					RedBlackBST<Double, listaDoble<accidents>> nuevo2 = Bst.get(fechaHora2.parse(atributos[4]));

					if (nuevo2!=null) {
						listaDoble<accidents> lista2 = nuevo2.get(Double.parseDouble(atributos[3]));
						if (lista2!=null) {
							lista2.agregarInicio(accidentes);

						}
						else {
							lista2 = new listaDoble<accidents>();
							lista2.agregarInicio(accidentes);
						}
						nuevo2.put(Double.parseDouble(atributos[3]), lista2);
					}else {
						nuevo2=new RedBlackBST<Double, listaDoble<accidents>>();
						listaDoble<accidents> lista2= new listaDoble<accidents>();
						lista2.agregarInicio(accidentes);
						nuevo2.put(Double.parseDouble(atributos[3]), lista2);
					}
					Bst.put(fechaHora2.parse(atributos[4]), nuevo2);

					////////////////////////////
					listaDoble<accidents> t = arbolR2.get(fechaHora2.parse(atributos[4]));
					if (t == null) {
						t = new listaDoble<accidents>();
					}						
					t.agregarInicio(accidentes);
					arbolR2.put(fechaHora2.parse(atributos[4]), t);


					///////////////////////
					LocalTime localTime = LocalTime.parse(atributos[4].split(" ")[1], DateTimeFormatter.ofPattern("HH:mm:ss"));
					listaDoble<accidents> t2 = arbolR5N.get(localTime);
					if (t2 == null) {
						t2 = new listaDoble<accidents>();
					}						
					t2.agregarInicio(accidentes);
					arbolR5N.put(localTime, t2);		
					////////////////////
					/*
					if (arbolR6.contains(key)) {
						arbolR6.get(key).agregarInicio(accidentes);
					}else {
						listaDoble<accidents> v = new listaDoble<accidents>();
						v.agregarInicio(accidentes);
						arbolR6.put(key, v);

					}
					 */

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


	public String R1BSt(Date fecha) {
		int contador = 0;
		listaDoble<accidents> nueva =new listaDoble<accidents>();
		BST<Double, listaDoble<accidents>> respuesta= bst2.get(fecha);
		for (Double actual : respuesta.keys()) {
			int totalSever=respuesta.get(actual).darTamaño();
			System.out.println("sever:"+actual+"cantidad"+totalSever);
			contador+=totalSever;
		}
		return "el numero de accidentes en la fecha es:"+contador;
	}

	public String R1RBS(Date fecha) {
		int contador = 0;
		listaDoble<accidents> nueva =new listaDoble<accidents>();
		RedBlackBST<Double, listaDoble<accidents>> respuesta= Bst.get(fecha);
		for (Double actual : respuesta.keys()) {
			int totalSever=respuesta.get(actual).darTamaño();
			System.out.println("sever:"+actual+"cantidad"+totalSever);
			contador+=totalSever;
		}
		return "el numero de accidentes en la fecha es:"+contador;
	}
	public String R2(Date fechaFinal) {
		int contador=0;
		int actual=0;
		Date fecha=null;
		listaDoble<accidents>lista=new listaDoble<accidents>();
		for (Date key3 : arbolR2.keys(arbolR2.min(), fechaFinal)) {
			lista = arbolR2.get(key3);
			if (lista.darTamaño()>actual) {
				actual=lista.darTamaño();
				fecha=key3;
			}
			contador+=lista.darTamaño();

		}
		return "el numero de accidens antes de la fecha dada es de:"+contador+"y la fecha con mas accidentes es:"+fecha+"con un numero de accidesnte de:"+actual;
	}

	public String R3(Date fechaInicial, Date fechaFinal) {
		int contador=0;
		int actual=0;
		double s=0;
		RedBlackBST<Double, listaDoble<accidents>> aux = new RedBlackBST<Double, listaDoble<accidents>>();
		// Recorrido por fechas
		for (Date key : arbolR2.keys(fechaInicial, fechaFinal)) {
			// Lista de los accidentes de la fecha = key
			listaDoble<accidents>lista = arbolR2.get(key);
			// Recorrido de accidentes de la fecha actual (key)
			for(accidents accidente: lista) {
				// Lista de accidentes de la severidad del accidente actual
				listaDoble<accidents> listaSeveridad = aux.get(accidente.getSeverity());
				// Si la lista no es nula, agregamos el accidente
				if (listaSeveridad != null) {
					listaSeveridad.agregarInicio(accidente);
				} else { //si la lista es nula, inicializamos la lista y luego añadimos el accidente
					listaSeveridad = new listaDoble<accidents>();
					listaSeveridad.agregarInicio(accidente);
				}
				// Añadimos al arbol aux la lista actualizada
				aux.put(accidente.getSeverity(), listaSeveridad);
				// Contamos la cantidad total de accidentes en el rango de fechas
				contador++;
			}

		}
		// Recorrido por severidad
		for(Double severidad: aux.keys(aux.min(), aux.max())) {
			// Lista de todos los accidentes con la severidad actual 
			listaDoble<accidents> lista = aux.get(severidad);
			// Encontrar la severidad con mayor número de accidentes
			if(lista.darTamaño() > actual) {
				actual = lista.darTamaño();
				s = severidad;
			}
		}
		return "el numero de accidentes antes de la fecha dada es de:"+contador+"y la severidad con mayor numero de accidentes es:"+s+"con un numero de:"+actual;
	}

	public String R4(Date fechaInicial, Date fechaFinal) {
		int contador=0;
		int actual=0;
		String s=null;
		Date fecha=null;
		int actualFecha=0;
		RedBlackBST<String, listaDoble<accidents>> aux = new RedBlackBST<String, listaDoble<accidents>>();
		// Recorrido por fechas
		for (Date key : arbolR2.keys(fechaInicial, fechaFinal)) {
			// Lista de los accidentes de la fecha = key
			listaDoble<accidents>lista = arbolR2.get(key);
			// Recorrido de accidentes de la fecha actual (key)
			for(accidents accidente: lista) {
				// Lista de accidentes de la severidad del accidente actual
				listaDoble<accidents> listaEstado = aux.get(accidente.getState());
				// Si la lista no es nula, agregamos el accidente
				if (listaEstado != null) {
					listaEstado.agregarInicio(accidente);
				} else { //si la lista es nula, inicializamos la lista y luego añadimos el accidente
					listaEstado = new listaDoble<accidents>();
					listaEstado.agregarInicio(accidente);
				}
				// Añadimos al arbol aux la lista actualizada
				aux.put(accidente.getState(), listaEstado);
				// Contamos la cantidad total de accidentes en el rango de fechas
				contador++;
			
			}

			
		}
		// Recorrido por severidad
		for(String state: aux.keys(aux.min(), aux.max())) {
			// Lista de todos los accidentes con la severidad actual 
			listaDoble<accidents> lista = aux.get(state);
			// Encontrar la severidad con mayor número de accidentes
			if(lista.darTamaño() > actual) {
				actual = lista.darTamaño();
				s = state;
			}
		}
		return "el numero de accidens entre las 2 fechas es de:"+contador+" "+ "y el state con mayor numero de accidentes: es"+s+" "+"con un numero de accidentes de:"+actual;
	}
	public String R45(Date fechainicial, Date fechaFinal) {
		int contador=0;
		int actual=0;
		Date fecha=null;
		listaDoble<accidents>lista=new listaDoble<accidents>();
		for (Date key3 : arbolR2.keys(fechainicial, fechaFinal)) {
			lista = arbolR2.get(key3);
			if (lista.darTamaño()>actual) {
				actual=lista.darTamaño();
				fecha=key3;
			}
			contador+=lista.darTamaño();

		}
		return "la fecha con mas accidentes es:"+fecha+"con un numero de accidentes de:"+actual;
	}

	public String R5(LocalTime horaInicial, LocalTime horaFinal) {
		int contador=0;
		int actual=0;
		Double s=null;
		RedBlackBST<Double, listaDoble<accidents>> aux = new RedBlackBST<Double, listaDoble<accidents>>();
		// Recorrido por fechas
		for (LocalTime key : arbolR5N.keys(horaInicial, horaFinal)) {
			// Lista de los accidentes de la fecha = key
			listaDoble<accidents>lista = arbolR5N.get(key);
			// Recorrido de accidentes de la fecha actual (key)
			for(accidents accidente: lista) {
				// Lista de accidentes de la severidad del accidente actual
				listaDoble<accidents> listaEstado = aux.get(accidente.getSeverity());
				// Si la lista no es nula, agregamos el accidente
				if (listaEstado != null) {
					listaEstado.agregarInicio(accidente);
				} else { //si la lista es nula, inicializamos la lista y luego añadimos el accidente
					listaEstado = new listaDoble<accidents>();
					listaEstado.agregarInicio(accidente);
				}
				// Añadimos al arbol aux la lista actualizada
				aux.put(accidente.getSeverity(), listaEstado);
				// Contamos la cantidad total de accidentes en el rango de fechas
				contador++;
			}
		}
		// Recorrido por severidad
		for(Double severity: aux.keys(aux.min(), aux.max())) {
			// Lista de todos los accidentes con la severidad actual 
			listaDoble<accidents> lista = aux.get(severity);
			// Encontrar la severidad con mayor número de accidentes

			System.out.println("severidad:"+severity+":"+"con un tamano de: "+(double)lista.darTamaño()+"y el porcentaje con respecto al total de accidentes es de: "+" "+((double)lista.darTamaño()*100)/(double)contador);

		}
		return "el numero de accidens antes de la fecha dada es de:"+contador;

	}
	
	
	 
}
