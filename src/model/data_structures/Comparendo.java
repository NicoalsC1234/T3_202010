package model.data_structures;

import java.util.Date;

public class Comparendo implements Comparable<Comparendo> {
	
	public int OBJECTID;

	public Date FECHA_HORA;
	
	public String MEDIO_DETE;
	
	public String CLASE_VEHI;
	
	public String TIPO_SERVI;
	
	public String INFRACCION;
	
	public String DES_INFRAC;
	
	public String LOCALIDAD;
	
	public double longitud;
	
	public double latitud;

	public int getOBJECTID() {
		return OBJECTID;
	}

	public Date getFECHA_HORA() {
		return FECHA_HORA;
	}

	public String getMEDIO_DETE() {
		return MEDIO_DETE;
	}

	public String getCLASE_VEHI() {
		return CLASE_VEHI;
	}

	public String getTIPO_SERVI() {
		return TIPO_SERVI;
	}

	public String getINFRACCION() {
		return INFRACCION;
	}

	public String getDES_INFRAC() {
		return DES_INFRAC;
	}

	public String getLOCALIDAD() {
		return LOCALIDAD;
	}

	public double getLongitud() {
		return longitud;
	}

	public double getLatitud() {
		return latitud;
	}


	@Override
	public int compareTo(Comparendo comparendo) {
		// TODO Auto-generated method stub
		
		if(FECHA_HORA.equals(comparendo.getFECHA_HORA())) 
		{
			if (OBJECTID < comparendo.getOBJECTID()) return 1;
			else return -1;
		}
		else return FECHA_HORA.compareTo(comparendo.getFECHA_HORA());
	}
	
	
	
	
}
