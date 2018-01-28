package SwipeDaddy;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiningHall {
	private String name;
	private Map<Date, List<Food>> options;
	private Map<Date, List<Food>> breakfast;
	private Map<Date, List<Food>> lunch;
	private Map<Date, List<Food>> dinner;
	public DiningHall(String name) {
		this.name = name;
		options = new HashMap<Date, List<Food>>();
	}
	public void addFoods(Date date, List<Food> foods) {
		options.put(date, foods);
		populateMeals(date);
	}
	public void setOptions(Map<Date, List<Food>> options) {
		this.options = options;
	}
	/**
	 * Creates Maps for breakfast lunch and dinner for a specific day
	 * @param date
	 */
	private void populateMeals(Date date) {
		List<Food> foods = options.get(date);
		List<Food> breakfastlist = new ArrayList<>();
		List<Food> lunchlist = new ArrayList<>();
		List<Food> dinnerlist = new ArrayList<>();
		for (Food food : foods) {
			if (food.isBreakfast()) {
				breakfastlist.add(food);
			}
			else if (food.isLunch()) {
				lunchlist.add(food);
			}
			else if (food.isDinner()) {
				dinnerlist.add(food);
			}
		}
		breakfast.put(date, breakfastlist);
		lunch.put(date, lunchlist);
		dinner.put(date, dinnerlist);
	}
	
	/**
	 * Prints to a String all foods on a given date
	 * @param date a Date to query 
	 * @return a String output of all foods
	 */
	public String getFoods(Date date) {
		List<Food> foods = options.get(date);
		String str = "";
		for (Food food : foods) {
			str += food.getName();
		}
		return str;
	}
	public String getName() {
		return name;
	}
}
