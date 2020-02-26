package model.data_structures;

import java.util.Comparator;

public class Cola<T> {

	public Nodo<T> primero; 

	public Nodo<T> ultimo;

	private int tamano;

	public Cola()
	{
		primero = null;
		ultimo = null;
		tamano = 0;
	}

	public Nodo<T> darPrimero()
	{
		return primero;
	}

	public Nodo<T> darUltimo()
	{
		return ultimo;
	}

	public int darTamano() {
		return tamano;
	}

	public boolean esVacio()
	{
		if (tamano != 0)return false;
		else return true;
	}

	public T enqueue(T dato)
	{
		Nodo nuevo = new Nodo (dato);
		if(esVacio())
		{
			primero = nuevo;
			ultimo = nuevo;
			tamano++;
		}
		else 
		{
			ultimo.setSiguiente(nuevo);
			ultimo = nuevo;
			tamano ++;
		}

		return dato;
	}

	public Nodo dequeue()
	{
		Nodo eliminar = primero;
		if(tamano == 1)
		{
			primero = null;
			ultimo = null;
		}
		else if(tamano != 0)
		{
			primero = primero.getSiguiente();
		}

		else return null;
		tamano--;
		return eliminar;
	}
	//* Prueba



}
