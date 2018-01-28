package SwipeDaddy;
public class Person {
	private String name;
	private String info;
	private int level;
	
	public Person(String name, String info, int level) {
		this.name = name;
		this.level = level;
		this.info = info;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public String getInfo() {
		return info;
	}
	public void setLevel(int level) {
		this.level = level;
	}
}
