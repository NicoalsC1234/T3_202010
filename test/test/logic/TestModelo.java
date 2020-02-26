package test.logic;

import static org.junit.Assert.*;
import model.logic.Modelo;
import view.View;

import org.junit.Before;
import org.junit.Test;

public class TestModelo {
	
	private Modelo modelo;
	
	
	
	public void setUp1() {
		
		modelo= new Modelo();
		
	}

	public void testModelo()
	{
		
	}
	
	public void testShell()
	{
		int[] a = null;
		int[] b = null;
	 
		for(int i = 0; i < 1000; i++)
		{
			a[i] = (int)Math.random();
		}
		for(int i = 0; i < 1000; i--)
		{
			a[i] = (int)Math.random();
		}
		
		Comparable copia_Comparendos [ ] = modelo.copiarComparendos();
		modelo.shellSort( copia_Comparendos );
		long startTime = System.currentTimeMillis(); 
		long endTime = System.currentTimeMillis(); 
		long duration = endTime - startTime; 
		View.printMessage("Tiempo de ordenamiento shell: " + duration + " milisegundos");
		
		//* Falta
		
		
	}
	
	public void testMerge()
	{
		//* Falta
		
		Comparable copia_Comparendos [ ] = modelo.copiarComparendos();
		modelo.mergeSort( copia_Comparendos );
		long startTime = System.currentTimeMillis(); 
		long endTime = System.currentTimeMillis(); 
		long duration = endTime - startTime; 
		View.printMessage("Tiempo de ordenamiento merge: " + duration + " milisegundos");
	}
	
	public void testQuick()
	{
		//* Falta
		
		Comparable copia_Comparendos [ ] = modelo.copiarComparendos();
		modelo.quickSort( copia_Comparendos );
		long startTime = System.currentTimeMillis(); 
		long endTime = System.currentTimeMillis(); 
		long duration = endTime - startTime; 
		View.printMessage("Tiempo de ordenamiento: " + duration + " milisegundos");
	}

}
