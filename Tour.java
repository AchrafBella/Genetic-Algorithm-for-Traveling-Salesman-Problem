package pack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Tour extends ArrayList<City> {
	// each individual here us a tour 
	private int distance = 0;
	private double fitness  = 0;
	
	public Tour generat_tour(ArrayList<City> cities) {
		for(int i=0 ; i<cities.size() ; i++) {
			this.add(i, cities.get(i));
		}
		Collections.shuffle(this);
		this.distance = 0;
		return this;
	}

	private double calcule_distance() {
		if(this.distance == 0) {
			int  distance_tour = 0;
			for(int i=0 ; i<this.size() ;i++) {
				City from = this.get(0);
				City to   = null;
				if(i+1 < this.size()) {
					to = this.get(i+1);
					}else {
						to = this.get(0);
						}
			distance_tour += from.distance(to);
		}
		this.distance = distance_tour;}
		return distance;
	}
	
	public double calcule_fitness() {
		if(this.fitness == 0) {
			this.fitness = 1/(this.calcule_distance());

		}
		return this.fitness;
	}
	
	public static Comparator<Tour> sort(){
		return (t1, t2) ->{
			if(t1.fitness > t2.fitness) {
				return -1;
			}if(t1.fitness < t2.fitness) {
				return 1;
			}
			return 0;
		};		
	}
		
	public String toString() {
		String s = "";
		for(City c : this) {
			s += c.toString()+"|";
		}
		return s+" fitness: "+fitness+" distance: "+distance;
	}
	
}