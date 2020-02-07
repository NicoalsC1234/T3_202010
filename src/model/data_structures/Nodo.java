package model.data_structures;

public class Nodo <T extends Comparable <T>>{

	private  Nodo siguiente;
	
	private  T actual;
	
	public Nodo(T dato)
	{
		siguiente = null;
		
		actual = dato;
		
	}
	
	public Nodo darSiguiente(){
		return siguiente;
	}
	
	public void cambiarSiguiente(Nodo dato)
	{
		siguiente = dato;
	}
	
	public T darActual()
	{
		return actual;
	}
	
	public void cambiarActual(T dato)
	{
		actual = dato;
	}
}
