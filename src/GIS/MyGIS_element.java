package GIS;

import Geom.Geom_element;
import GIS.Meta_data;
import Geom.Point3D;
import Coords.MyCoords;
import Coords.coords_converter;
import Geom.Geom_element;

import java.sql.Timestamp;

import javax.xml.crypto.Data;
import File_Format.CSVReader;
import Algorithms.MultiCSV;


/**
 * This interface represents a GIS element with geometric representation and meta data such as:
 * Orientation, color, string, timing...
 * @author Efrat cohen and Odelia Hochman
 *
 */
public class MyGIS_element implements GIS_element {
	
	private Point3D geom;
	private MyMeta_data data;

	public String[] ToStringArr()
	{
		String[] arrGisStrs = new String[11];

			arrGisStrs[0]=this.data.getMAC();
			arrGisStrs[1]=this.data.GetSSID();
			arrGisStrs[2]=this.data.getCapabilities();
		    arrGisStrs[3]= Long.toString(this.data.getUTC()) ;
		    arrGisStrs[4]=this.data.getChannel();
		    arrGisStrs[5]=this.data.getRSSI();
		    arrGisStrs[6]= Double.toString(this.geom.x()) ;
		    arrGisStrs[7]= Double.toString(this.geom.y()) ;
		    arrGisStrs[8]= Double.toString(this.geom.z()) ;
		    arrGisStrs[9]=this.data.getAccuracyMeters();
		    arrGisStrs[10]=this.data.getType();
		    
		return arrGisStrs;//ToStringArr();  
	}
	
	
	public MyGIS_element(String [] stringsOfGisElem) 
	{
		
	
		   this.data = new MyMeta_data(stringsOfGisElem);
		  
		   this.geom = new Point3D(stringsOfGisElem);	 
	   
	}

	
	@Override
	public Geom_element getGeom()
	{
		
		return this.geom;
	}

	@Override
	public Meta_data getData() 
	{
		return this.data;
	}
	
	
	@Override
	public void translate(Point3D vec)
	{
		geom=(new MyCoords().add(geom,vec));
	}

}
