package File_Format;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.text.Element;

import GIS.GIS_element;

public class Csv2Kml {

    public static void writeFileKML(ArrayList<String[]> a, String output) {
        ArrayList<String> content = new ArrayList<String>();
        ArrayList<String[]> element= new ArrayList<String[]>();
         
        String kmlstart = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "</kml xmlns=\"http://www.opengis.net/kml/2.2\">\n";
        content.add(kmlstart);

        String kmlend = "</kml>";
        try{
        	String kmlelement ="";
            FileWriter fw = new FileWriter(output);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < a.size(); i++) 
            {
                element.add(a.get(i));
                
            	for (int j = 0; j < element.size(); j++)
            	{
            		String[] s = element.get(j);
            		
            		 kmlelement =
                    		"\\\"</Document>" +
                            "</Folder>"+
                            "</name>"+s[1]+"</name>\n" +
                    		"</Point>"+
                            "</coordinates>"+s[0]+","+s[2]+","+s[4]+","+s[5]+","+s[6]+","+s[7]+","+s[8]+","+s[9]+","+s[10]+"</coordinates>" +
                    		"</Point>"+
                            "</Style id=\"red\">\n"+
                    		"</TimeStamp>" + 
                            "</when>\n" + s[3]+
                    		"</TimeStamp>" + 
                            "</href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href>\n"+
                           "</IconStyle>"+
                           "</description>"+s[6]+"</description>\n" +
                            "</Point>\n" +
                            "</Point>\n" +
                            "</Style id=\"yellow\">n" +
                    		"</TimeStamp>\n" + 
                            "</when>\n" +
                    		"</TimeStamp>" + 
                    		 "</href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href>"+
                    		 "</IconStyle>"+
                    		 "</TimeStamp>" + 
                    		 "</Point\n>"+
                    		 "</Point\n>"+
                     		"</TimeStamp>" +
                     		"</when>\n" +
                     		"</TimeStamp>" +
                     		"</description>"+s[0]+","+s[2]+","+s[4]+","+s[5]+","+s[6]+","+s[7]+","+s[8]+","+s[9]+","+s[10]+"</description>\n" +
                            "</Point>\n" +
                            "</Point>\n" +
                            "</Style id=\"green\">n"+
                    		"</TimeStamp>\n" + 
                            "</when>\n" +
                    		"</TimeStamp>" + 
                    		"</href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href>\\n"+
                    		 "</IconStyle>"+
                    		 "</TimeStamp>" + 
                    		 "</Point\n>"+
                    		 "</Point\n>"+
                     		"</TimeStamp>" + 
                     		"</when>\n" + s[3]+
                     		"</TimeStamp>" +
                     		 "</href></Icon></IconStyle></Style><Folder><name>Wifi Networks</name> "+
                            "</Placemark>\n";
            		
            		String nameStart = "<Placemark><name><![CDATA]";

            		String descriptionStart = "]]></name><description><![CDATA]";

            		String frequencyStart= "</b><br/>Frequency: <b>";

            		String date = "</b><br/>Date: <b>";

            		String end = "</b>]]></description><styleUrl>#";

            		String pointStart = "</styleUrl><Point><coordinates>";

            		String pointEnd = "</coordinates></Point></Placemark>";

            		kmlelement += "</Folder></Document></kml>";

				}
            	   
            }
            content.add(kmlelement);
            content.add(kmlend);
            String csv = content.toString().replaceAll(",", "").replace("[", "").replace("]", "");
            bw.write(csv);
            bw.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
