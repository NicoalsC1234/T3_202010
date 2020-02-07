package model.logic;

import model.data_structures.ListaEncadenada;
import model.data_structures.Nodo;


public class Modelo<T extends Comparable<T>> {
	
	private ListaEncadenada <T> datos;
	

	public Modelo()
	{
		datos = new ListaEncadenada();
	}
	

	public void agregar(T dato)
	{	
		datos.agregar(dato);
	}
	
	
	public T buscar(Integer i)
	{
		return datos.buscar(i);
	}
	
	
	public T eliminar(Integer i)
	{
		return datos.eliminar(i);
	}


}
