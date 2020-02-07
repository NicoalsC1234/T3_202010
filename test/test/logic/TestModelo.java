package test.logic;

import static org.junit.Assert.*;
import model.logic.Modelo;

import org.junit.Before;
import org.junit.Test;

public class TestModelo {
	
	private Modelo modelo;
	private static int LARGO = 100;
	
	
	public void setUp1() {
		modelo= new Modelo();
		String dato = "";
	}

	public void setUp2() {
		for(int i =0; i < LARGO;i++){
			modelo.agregar(""+i);
		}
	}

	public void testAgregar() {
		setUp1();
		setUp2();
		
	}

	public void testBuscar() {
		setUp1();
		setUp2();
		for (int i = 0; i < LARGO; i++) {
			assertEquals("", modelo.buscar(i));
		}
	}

	public void testEliminar() {
		setUp1();
		setUp2();
		assertEquals(null, modelo.eliminar(99));
		assertTrue(modelo.eliminar(1).compareTo(1) == 0);
		
	}

}
