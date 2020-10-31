package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;
	
	/* Instancia de la Vista*/
	private View view;
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}
		
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		Integer dato = 0;
		Integer respuesta = 0;

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			Scanner entradaEscaner = new Scanner (System.in);
			switch(option){
			
			
				case 1:
					try{
					view.printMessage("---------\nCargando...");
					long startTime =System.currentTimeMillis();
					modelo.cargaDatos();
					long endTime =System.currentTimeMillis();
					long delta = endTime-startTime;
					view.printMessage("---------\nArchivo Cargado tiempo de carga: " + delta + " milisegundo");
					break;
					}catch(Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				case 2: 
					try{
						view.printMessage("ingrese la fecha(formato: YYY-MM-DD):"); 
						String nombreCompa=entradaEscaner.nextLine();
						DateFormat fechaHora2 = new SimpleDateFormat("yyyy-MM-dd");
						view.printMessage(modelo.R1BSt(fechaHora2.parse(nombreCompa)));
						break;
						}catch(Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
				case 3: 
					try{
						view.printMessage("ingrese la fecha(formato: YYY-MM-DD"); 
						String nombreCompa=entradaEscaner.nextLine();
						DateFormat fechaHora2 = new SimpleDateFormat("yyyy-MM-dd");
						view.printMessage(modelo.R2(fechaHora2.parse(nombreCompa)));
						break;
						}catch(Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				case 4: 
					try{
						view.printMessage("ingrese fecha inicial(formato: YYY-MM-DD)"); 
						String fechaInicial=entradaEscaner.nextLine();
						view.printMessage("ingrese fecha final(formato: YYY-MM-DD)"); 
						String fechaFinal=entradaEscaner.nextLine();
						DateFormat fechaHora2 = new SimpleDateFormat("yyyy-MM-dd");
						view.printMessage(modelo.R3(fechaHora2.parse(fechaInicial), fechaHora2.parse(fechaFinal)));
						break;
						}catch(Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				case 5: 
					try{
						view.printMessage("ingrese fecha inicial(formato: YYY-MM-DD)"); 
						String fechaInicial=entradaEscaner.nextLine();
						view.printMessage("ingrese fecha final(formato: YYY-MM-DD)"); 
						String fechaFinal=entradaEscaner.nextLine();
						DateFormat fechaHora2 = new SimpleDateFormat("yyyy-MM-dd");
						view.printMessage(modelo.R4(fechaHora2.parse(fechaInicial), fechaHora2.parse(fechaFinal)));
						view.printMessage(modelo.R45(fechaHora2.parse(fechaInicial), fechaHora2.parse(fechaFinal)));
						break;
						}catch(Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				case 6: 
					try{
						view.printMessage("ingrese hora inicial(formato:HH-MM)"); 
						String fechaInicial=entradaEscaner.nextLine();
						view.printMessage("ingrese hora final(formato: HH-MM)"); 
						String fechaFinal=entradaEscaner.nextLine();
						LocalTime localTime = LocalTime.parse(fechaInicial, DateTimeFormatter.ofPattern("HH:mm"));
						LocalTime localTime2 = LocalTime.parse(fechaFinal, DateTimeFormatter.ofPattern("HH:mm"));
						view.printMessage(modelo.R5(localTime, localTime2));
						break;
						}catch(Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			
				
				case 7: 
					fin=true;
					break;
				
				default: 
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
			}
		}
		
	}	
}
