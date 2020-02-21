 package controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.data_structures.Comparendo;
import model.logic.Modelo;
import view.View;

public class Controller <T extends Comparable<T>>{

	private Modelo modelo;
	
	private View view;
	
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}
	
	 public void run() throws InputMismatchException {

	        try {

	            Scanner reader = new Scanner(System.in);

	            boolean end = false;



	            while (!end) {

	                view.printMenu();

	                int option = reader.nextInt();

	                switch (option) {



	                    case 1:
	              
	                    	modelo.cargarDatos();
	                    	view.printMessage("Se ha creado");
	                    	int numero = modelo.darTamano();
	                    	view.printMessage("El numero de datos leidos es : " + numero);
	                    	Comparendo buscado = (Comparendo) modelo.MostrarCompMayorOBJECTID();
	                    	view.printMessage("Los datos del comparendo son " + buscado.OBJECTID + ", " + buscado.FECHA_HORA + ", " + buscado.INFRACCION + ", " + buscado.CLASE_VEHI + ", " + buscado.TIPO_SERVI + " y " + buscado.LOCALIDAD);
	                    	view.printMessage("El miramax esta delimitado por las latitudes, " + modelo.darMinimax()[3] + " y " + modelo.darMinimax()[2] + ", y las longitudes " + modelo.darMinimax()[0] + " y " + modelo.darMinimax()[1]);
	                    	break;
	                 
	                    	           
	                } 
	            }
	        }
	                
	            
	            catch (InputMismatchException e) {

	            run();

	        }

	    }

	 }