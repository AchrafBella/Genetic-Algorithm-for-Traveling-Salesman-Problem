package pack;

import java.util.ArrayList;
import java.util.Collections;

public class Demo {
	public static void main(String[] a) {

		ArrayList<City> cities = new ArrayList<City>();
		
		City city = new City(0, 0);
        cities.add(city);
        City city2 = new City(780,0);
        cities.add(city2);
        City city3 = new City(320, 0);
        cities.add(city3);
        City city4 = new City(580, 0);
        cities.add(city4);
        City city5 = new City(480, 0);
        cities.add(city5);
        City city6 = new City(660, 0);
        cities.add(city6);
        City city7 = new City(220, 0);
        cities.add(city7);
        
        GeneticAlgorithm GA = new GeneticAlgorithm();
        
        GA.evolution(cities, 8, 4, 20000, 0.5);
        
        
       
		
		
		
		
		
		
		
		
	}

}
