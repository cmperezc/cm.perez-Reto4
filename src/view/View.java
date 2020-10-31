package view;

import model.logic.Modelo;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("1. cargar");
			System.out.println("2. Requerimiemt 1");
			System.out.println("3. Requerimiemt 2");
			System.out.println("4. Requerimiemt 3");
			System.out.println("5. Requerimiemt 4");
			System.out.println("6. Requerimiemt 5");
			System.out.println("7. Requerimiemt 6");
			System.out.println("8. exit");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printModelo(Modelo modelo)
		{
			// TODO implementar
		}
}
