  package controller;

import java.util.InputMismatchException;
import java.util.Scanner;

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



	                    case 0:
	              
	                    	modelo = new Modelo();
	                    	view.printMessage("Se ha creado");
	                    	break;
	                    	
	                    case 1: 
	                    	
	                    	modelo.cargarDatos();
	                    	view.printMessage("Se han cargado los datos");
	                    	break;
	                    		           
	                } 
	            }
	        }
	                
	            
	            catch (InputMismatchException e) {

	            run();

	        }

	    }

	 }

