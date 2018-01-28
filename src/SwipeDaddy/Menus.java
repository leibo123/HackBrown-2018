package SwipeDaddy;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Menus {
	public static DiningHall ratty = new DiningHall("Sharpe Refectory");
	public static DiningHall vdub = new DiningHall("Verney-Woolley");
	public static DiningHall jos = new DiningHall("Josaih's");
	public static DiningHall andrews = new DiningHall("Andrews");
	public static DiningHall blueroom = new DiningHall("Blue Room");
	public static DiningHall ivyroom = new DiningHall("Ivy Room");
	
	public Menus() {
		ratty.setOptions(CSVReader.parseOptions("/data.csv"));
	}
	

}
