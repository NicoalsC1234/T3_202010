package model.logic;
import java.io.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;

public class Lectura {

	private Type type;
	
	private String path;
	
	
	
	
	public Lectura()
	{
		path = "./data/comparendos_dei_2018_small.geojson";
		
	}
	
	public void leerJson()
	{
		try
		{
		Gson gson = new Gson();
		
		JsonReader reader = new JsonReader(new FileReader(path));
		
		Type json= gson.fromJson(reader, Type.class);
		
		  
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			
			
		}
	}
}
