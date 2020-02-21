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
import com.sun.corba.se.impl.orbutil.RepositoryIdUtility;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import model.data_structures.Cola;
import model.data_structures.Comparendo;
import model.data_structures.Nodo;


/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo <T> {

	public static String PATH = "./data/comparendos_dei_2018_small (1).geojson";

	public int tamano;

	private Cola cola;

	private Nodo nodo;

	public Nodo<Comparendo> primero;

	public Nodo<Comparendo> ultimo;


	public Modelo()
	{
		cola = new Cola<Comparendo>();
		primero = null;
		ultimo = null;
		tamano = 0;
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
				primero = datos.darPrimero();
				ultimo = datos.darUltimo();
			}

		} catch (FileNotFoundException | ParseException e) {
			e.printStackTrace();
		}
		return datos;	

	}

	public double[] darMinimax()
	{
		double[] mini = new double[4];
		
		if(!cola.esVacio())
		{

			for (int i = 0; i < cola.darTamano(); i++) {
				Comparendo es = (Comparendo) getObj(i);
				double lo1 = es.longitud;
				double la1 = es.latitud;
				double lo2 = es.longitud;
				double la2 = es.latitud;
				if(es.longitud > lo1)
					{
						lo1 = es.longitud;
						mini[0] = lo1;
					}
				if(es.longitud < lo2){
					mini[1] = lo2;
					lo2 = es.longitud;
				}
				if(es.latitud > la1)
					{
						la1 = es.latitud;
						mini[2] = la1;
					}
				if(es.latitud < la2){
					mini[3] = la2;
					la2 = es.latitud;
				}
			}
		}
		return mini;
	}

	public Comparendo MostrarCompMayorOBJECTID()
	{
		Comparendo mayor =  primero.getActual();
		int numMayor = 0;
		if (!cola.esVacio() && mayor != null)
		{
			for (int i = 0; i < cola.darTamano(); i++) {
				Comparendo es = (Comparendo) getObj(i);
				if(es.OBJECTID > mayor.OBJECTID)
				{
					mayor = es;
				}
			}
		}
		return mayor;
	}

	public T getObj(int index)
	{
		int contador = 0;
		Nodo n = (Nodo) primero;
		while(contador < index)
		{
			n = n.getSiguiente();
			contador++;
		}
		return (T) n.getActual();
	}
}



