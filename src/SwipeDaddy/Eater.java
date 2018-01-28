package SwipeDaddy;

import java.util.ArrayList;
import java.util.List;

public class Eater {
	private Person person;
	private List<DiningHall> preferences;
	private int time;
	private String comments;
	
	public Eater(Person p, List<DiningHall> pref, int time, String comments) {
		this.person = p;
		this.preferences = pref;
		this.time = time;
		this.comments = comments;
	}
	public Eater(String name, List<DiningHall> pref) {
		this.person = new Person(name, "", 0);
		this.preferences = pref;
		this.time = 0;
		this.comments = "";
	}
	public Eater(String name, List<DiningHall> pref, int level, String info, String comments) {
		this.person = new Person(name, info, level);
		this.preferences = pref;
		this.time = 0;
		this.comments = comments;
	}
	public String getName() {
		return person.getName();
	}
	public String getPreferences() {
		String str = "";
		if (preferences.isEmpty()) {
			return "No preference";
		}
		else {
			for (DiningHall d : preferences) {
				str += d.getName() + ", ";
			}
			return str.substring(0, str.length()-2);
		}
		
	}
	public String getComments() {
		return comments;
	}
	public int getLevel() {
		return person.getLevel();
	}
	public String getInfo() {
		return person.getInfo();
	}
}
