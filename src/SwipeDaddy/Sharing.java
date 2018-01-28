package SwipeDaddy;
import java.util.ArrayList;
import java.util.List;

public class Sharing {
	private List<Swiper> swipers;
	private List<Eater> eaters;
	
	public Sharing() {
		this.swipers = new ArrayList<>();
		this.eaters = new ArrayList<>();
	}
	public void addSwiper(Swiper swiper) {
		swipers.add(swiper);
	}
	public void addEater(Eater eater) {
		eaters.add(eater);
	}
	public void removeSwiper(Swiper swiper) {
		swipers.remove(swiper);
	}
	public void removeEater(Eater eater) {
		eaters.remove(eater);
	}
	public void removeEater(String eater) {
		for (Eater e : eaters) {
			if (e.getName().equals(eater)) {
				eaters.remove(e);
				break;
			}
		}
	}
	public Eater recommendedMatch() {
		return eaters.remove(0);
	}
	/**
	 * Removes the associated eater and swiper from lists and returns a Match pair
	 * @param eater an Eater
	 * @param swiper a Swiper
	 * @return a Match pair 
	 */
	public Match matchFound(Eater eater, Swiper swiper) {
		removeEater(eater);
		removeSwiper(swiper);
		return new Match(eater, swiper);
	}
	
	public List<String> allEaterInfo() {
		List<String> eaterinfo = new ArrayList<>();
		for (Eater eater : eaters) {
			String str = "";
			str += eater.getName() + "- " + eater.getPreferences();
			eaterinfo.add(str);
		}
		return eaterinfo;
	}
	/**
	 * Finds an eater in the list with name and returns it
	 * @param name the name to find
	 * @return an Eater with name
	 */
	public Eater getEater(String name) {
		for (Eater eater : eaters) {
			if (eater.getName().equals(name)) {
				return eater;
			}
		}
		return null;
	}
}
