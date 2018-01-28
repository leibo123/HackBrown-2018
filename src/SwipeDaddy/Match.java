package SwipeDaddy;
public class Match {
	private Eater eater;
	private Swiper swiper;
	public Match(Eater eater, Swiper swiper) {
		this.eater = eater;
		this.swiper = swiper;
	}
	public Eater getEater() {
		return eater;
	}
	public Swiper getSwiper() {
		return swiper;
	}
}
