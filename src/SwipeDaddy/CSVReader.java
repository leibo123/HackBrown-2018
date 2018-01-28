package SwipeDaddy;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CSVReader {

	public static Map<Date, List<Food>> parseOptions(String filename) {
		Map<Date, List<Food>> foodmap = new HashMap<>();
		filename = "/data.csv";
		 BufferedReader br = null;
		 String line = "";
		 String cvsSplitBy = ",";
		 try {
			 Date d = new Date();
			 br = new BufferedReader(new FileReader(filename));
			 List<Food> foods = new ArrayList<>();
	            while ((line = br.readLine()) != null) {
	                // use comma as separator
	            	String[] l = line.split(cvsSplitBy);
	            	DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	            	try {
	        			d = df.parse(l[0]);
	        		} catch (ParseException e) {
	        			e.printStackTrace();
	        		}
	            	Food f = new Food(l[1], Boolean.parseBoolean(l[2]), Boolean.parseBoolean(l[3]),
	            			Boolean.parseBoolean(l[4]), Boolean.parseBoolean(l[5]), 
	            			Boolean.parseBoolean(l[6]), Boolean.parseBoolean(l[7]));
	            	foods.add(f);
	            }
	            foodmap.put(d, foods);
	            
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
		 return foodmap;
	    }
}
