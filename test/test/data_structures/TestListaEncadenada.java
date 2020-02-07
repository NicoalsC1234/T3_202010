package test.data_structures;

import model.data_structures.ListaEncadenada;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestListaEncadenada {

	private ListaEncadenada listaEncadenada;
	
	
	public void setUp1() {
		listaEncadenada = new ListaEncadenada();
		

		return listaEncadenada;
	}

	public void setUp2() {
		for(int i =0; i< LARGO*2; i++){
			listaEncadenada.agregar(""+i);
		}
	}

	@Test
	public void testArregloDinamico() {
		int i = 1;
		String elemento = "" + i;
		setUp1();
		setUp2();
		
		assertEquals(elemento, listaEncadenada.buscar(i));
		assertEquals(listaEncadenada.buscar(i), listaEncadenada.eliminar(i));
		
	}


}
