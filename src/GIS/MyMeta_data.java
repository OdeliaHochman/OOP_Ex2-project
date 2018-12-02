package GIS;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import GIS.Meta_data;
import Geom.Point3D;




public class MyMeta_data implements Meta_data 
{
	private String SSID = "";
	private String MAC = "";
	private String Channel = "";
	private String RSSI = "";
	private String Type = "";
	private String Capabilities = "";
	private String AccuracyMeters = "";
	private String Time = "";
	
	private long duration = (4 * 60 * 60 * 1000);

	
	public MyMeta_data(String[] arrStrGisElem)
	{
		 MAC= arrStrGisElem[0];
		 SSID= arrStrGisElem[1];
		 Capabilities= arrStrGisElem[2];
		 Time= arrStrGisElem[3];
		 Channel= arrStrGisElem[4];
		 RSSI= arrStrGisElem[5];
		 AccuracyMeters=arrStrGisElem[9];
		 Type=arrStrGisElem[10];
		 
	}
		
	/** returns the Universal Time Clock associated with this data; */
	@Override
	public long getUTC()
	{
	  
	//2017-12-01 10:49:08
	SimpleDateFormat newDate = new SimpleDateFormat("YYYY-MM-DD HH:mm:SS", Locale.getDefault());
	
	
	try {
		
		 java.util.Date dt = new Date();
		  dt = newDate.parse(Time);
		
		long timeUtc = duration+dt.getTime();
		return timeUtc;
	}
	catch (ParseException e) 
	{
		e.printStackTrace();
	}
	

     return 0;
	}
	
	public String GetSSID() 
	{
		return this.SSID;
	}

	/**
	 * @return the orientation: yaw, pitch and roll associated with this data;
	 */
	@Override
	public Point3D get_Orientation() 
	{
		
		return null;
	}
	
	public String getType() 
	{
		return this.Type;
	}

	public String getMAC() {
		return this.MAC;
	}
	
	public String getChannel() {
		return this.Channel;
	}

	public String getRSSI() {
		return this.RSSI;
	}
	
	public String getCapabilities() 
	{
		return this.Capabilities;
	}
	
	public String getAccuracyMeters() 
	{
		return this.AccuracyMeters;
	}
	
	/** return a String representing this data */
	@Override
	public String toString() 
	{
		return "SSID:" + SSID +"Capabilities:"+ Capabilities+"Channel:" +Channel + "AccuracyMeters:" + AccuracyMeters+" MAC:" +
	               MAC +"RSSI:"+ RSSI+ "Time:" +Time + "Type:" + Type;
	}

	

	
	

	

	

	

}
