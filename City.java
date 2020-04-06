package pack;

public class City {
	// les coordonnes de la ville 
	private int x;
	private int y;
	
	// constructeur avec parametres
	public City(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	// constructeur de copie 
	public City(City c) {
		this(c.x, c.y);
	}
	// constructeur sans parametres
	public City() {
	}
	/***
	 * les getters et les setters 
	 * @return
	 */
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "City [x=" + x + ", y=" + y + "]";
	}
	
	/***
	 * la distance euclidienne par rapport une ville 
	 * @param c
	 * @return
	 */
	public double distance(City c) {
		
		double x_distance = Math.abs(this.getX() - c.getX());
		double y_distance = Math.abs(this.getY() - c.getY());
						
		return Math.sqrt(x_distance*x_distance + y_distance*y_distance);
	}
}