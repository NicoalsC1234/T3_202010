package model.data_structures;

public class ListaEncadenada <T extends Comparable <T>>{
	private Nodo primero;

	private int largo;


	public ListaEncadenada(){
		largo = 0;

		primero = null;

	}

	public T buscar(int i)
	{
		Nodo nodo = primero;
		int contador = 0;
		while(nodo != null)
		{
			if(i == nodo.g)
			{
				return (T) nodo;
			}
			nodo = nodo.darSiguiente();
			contador ++;
		}
		return null;
	}

	public T eliminar(int i)
	{
		Nodo nodo = primero;
		int contador = 0;
		T retorno = null;
		if(i == 0)
		{
			primero = nodo.darSiguiente();
			largo --;
			retorno = buscar(i);
		}
		else
		{
			while(nodo != null)
			{
				if(i == contador+1)
				{
					nodo.cambiarSiguiente(nodo.darSiguiente().darSiguiente());
					largo --;
					retorno = buscar(i);
					break;
				}
				nodo = nodo.darSiguiente();
				contador ++;
			}
		}
		
		return retorno;
		
		
	}

	public void agregar(T dato)
	{
		Nodo nodo = primero;
		Nodo nuevo = new Nodo(dato);
		while(nodo.darSiguiente() != null)
		{
			nodo = nodo.darSiguiente();
		}
		nodo.cambiarSiguiente(nuevo);
		largo ++;
	}
	
	public int darLargo()
	{
		return largo;
	}

}
