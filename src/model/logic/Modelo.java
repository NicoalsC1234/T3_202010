package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import model.data_structures.Cola;
import model.data_structures.Comparendo;
import model.data_structures.Nodo;


/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo <T> {

	public static String PATH = "./data/comparendos_dei_2018_small.geojson";
	
	public int tamano = 0;
	
	private Cola cola;
	
	private Nodo nodo;
	
	public T primero = null;
	
	public T ultimo = null;
	
	public Modelo()
	{
		cola = new Cola<Comparendo>();
	}
	
	public int darTamano()
	{
		return cola.darTamano();
	}
	
	public void enqueue(String dato)
	{	
		cola.enqueue(dato);
	}
	
	public Nodo darPrimero()
	{
		return cola.darPrimero();
	}
	
	public Nodo darUltimo()
	{
		return cola.darUltimo();
	}
	
	public Nodo dequeue()
	{
		return cola.dequeue();
	}


	public Cola cargarDatos() {

		Cola datos = new Cola();

		JsonReader reader;
		try {
			reader = new JsonReader(new FileReader(PATH));
			JsonElement elem = JsonParser.parseReader(reader);
			JsonArray e2 = elem.getAsJsonObject().get("features").getAsJsonArray();


			SimpleDateFormat parser=new SimpleDateFormat("yyyy/MM/dd");

			for(JsonElement e: e2) {
				Comparendo c = new Comparendo();
				c.OBJECTID = e.getAsJsonObject().get("properties").getAsJsonObject().get("OBJECTID").getAsInt();

				String s = e.getAsJsonObject().get("properties").getAsJsonObject().get("FECHA_HORA").getAsString();	
				c.FECHA_HORA = parser.parse(s); 

				c.MEDIO_DETE = e.getAsJsonObject().get("properties").getAsJsonObject().get("MEDIO_DETE").getAsString();
				c.CLASE_VEHI = e.getAsJsonObject().get("properties").getAsJsonObject().get("CLASE_VEHI").getAsString();
				c.TIPO_SERVI = e.getAsJsonObject().get("properties").getAsJsonObject().get("TIPO_SERVI").getAsString();
				c.INFRACCION = e.getAsJsonObject().get("properties").getAsJsonObject().get("INFRACCION").getAsString();
				c.DES_INFRAC = e.getAsJsonObject().get("properties").getAsJsonObject().get("DES_INFRAC").getAsString();	
				c.LOCALIDAD = e.getAsJsonObject().get("properties").getAsJsonObject().get("LOCALIDAD").getAsString();

				c.longitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(0).getAsDouble();

				c.latitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(1).getAsDouble();

				datos.enqueue(c);
				tamano = datos.darTamano();
				primero = (T)datos.darPrimero();
				ultimo = (T)datos.darUltimo();
			}

		} catch (FileNotFoundException | ParseException e) {
			e.printStackTrace();
		}
		return datos;	

	}
	
	public void MostrarTotalComparendosArchivo()
	{
		int contador = 0;
		
		if (!cola.esVacio())
		{
			for (int i = 0; i < cola.darTamano(); i++) {
				
				if(cola.getObj(i) == "latitud")
				{
					contador++;
				}
					
			}
			
		}
		
		System.out.println("El total de comparendos en el archivo es: " + contador + ".");
	}
	
	
	public void MostrarCompMayorOBJECTID()
	{
		T mayor = null;
		int numMayor = 0;
		if (!cola.esVacio())
		{
			for (int i = 0; i < cola.darTamano(); i++) {
				T es = (T) cola.getObj(i);
				
				if((int)cola.getObj(i) == 1)
				{
					numMayor = (int)cola.getObj(i);
					mayor = (T) es;
					
				}
				if( (int)es > numMayor)
				{
					mayor = (T) es;
					
				}
					
			}
			
			System.out.println("Datos comparendo con mayor OBJECTID: ");
			
		}
		
		
		
		
		
		
		}
	}

