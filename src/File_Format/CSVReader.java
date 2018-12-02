package File_Format;

import java.io.BufferedReader;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import Algorithms.MultiCSV;
import GIS.Meta_data;

public class CSVReader {

//    public static void main(String[] args)
//    {
//    	String sDirName = "C:\\data\\";
//    	MultiCSV multCsv = new MultiCSV(sDirName);
//    	ArrayList<File> fl = multCsv.getFiles(sDirName);
//    	ArrayList<String[] > al = null;
//    	String [] csvFiles={"WigleWifi_20171201110209.csv"};
//    	String [] kmlFiles= new String[csvFiles.length];
//    	for (int idx=0;idx<csvFiles.length;idx++ ) {
//    		 String csvFile  = csvFiles[idx];
//    		 String kmlFile =  csvFile.split("[.]")[0]+".kml";
//    		 kmlFiles[idx] = kmlFile;
//    		 al = ReadFile(sDirName+csvFile);
//		}
//    
//    	//kmlFiles
//    	for (String sKmlFile : kmlFiles) {
//    		 
//        	csv2kml.writeFileKML(al,sDirName+sKmlFile);
//		}		
//    }
	public static ArrayList<String[] > ReadFile(String csvFileName)
    {
		ArrayList<String[]> m_arr =new ArrayList<>();
		
        String csvFile = csvFileName;//"output.csv";
        String line = "";
        String cvsSplitBy = ",";
        int count=0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
        {
        	
            while ((line = (br.readLine())) != null) 
            {
            	count++;
            	
            	 while (((br.readLine())) != null && count>1) 
            	 {
            	
                String[] userInfo = line.split(cvsSplitBy);
                m_arr.add(userInfo);
//                
//                String MAC=userInfo[0];
//                String SSID=userInfo[1];
//                String Capabilities= userInfo[2];
//                String timesTamp=userInfo[3];
//                String Channel=userInfo[4];
//                String RSSI=userInfo[5];
//                String AltitudeMeters=userInfo[8];
//                String AccuracyMeters= userInfo[9];
//                String Type=userInfo[10];
//  
            }
            }

        } catch (IOException e) 
        {
            e.printStackTrace();
        }
        return m_arr;
    }

}