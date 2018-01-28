package SwipeDaddy;
public class Food {
	private String name;
	private boolean vegetarian;
	private boolean vegan;
	private boolean glutenfree;
	private boolean breakfast;
	private boolean lunch;
	private boolean dinner;
	public Food(String name, boolean vegetarian, boolean vegan, boolean glutenfree, boolean breakfast, boolean lunch, boolean dinner) {
		this.name = name;
		this.vegetarian = vegetarian;
		this.vegan = vegan;
		this.glutenfree = glutenfree;
		this.breakfast = breakfast;
		this.lunch = lunch;
		this.dinner = dinner;
	}
	public String getExtraInfo() {
		String str = "";
		if (vegetarian) {
			str += "Vegetarian, ";
		}
		if (vegan) {
			str += "Vegan, ";
		}
		if (glutenfree) {
			str += "Gluten-free, ";
		}
		str = str.substring(0, str.length() - 2);
		return str;
	}
	public String getName() { 
		return name;
	}
	public boolean isBreakfast() {
		return breakfast;
	}
	public boolean isLunch() {
		return lunch;
	}
	public boolean isDinner() {
		return dinner;
	}
}
