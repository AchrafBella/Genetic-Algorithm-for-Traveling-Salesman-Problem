package pack;

import java.util.ArrayList;
import java.util.Random;

public class Population extends ArrayList<Tour> {
	
	static Random r = new Random();
	
	/***
	 * generation the population where each individual is a possible rout 
	 * @param cities
	 * @param population_size
	 * @return
	 */
	
	public Population Population(ArrayList<City> cities, int  population_size) {
		for(int i = 0 ; i<population_size ; i++) {
			this.add((new Tour()).generat_tour(cities));
		}
		return this;
	}
	/***
	 *  we are going to take the top of the popualtion for the crossover process
	 * @param top
	 * @return
	 */
	public Population Selection(int top) {
		this.fitness_population();
		this.sort(Tour.sort());
		Population population_top = new Population();
		
		for(int i =0 ; i< top ; i++) {
			population_top.add(this.get(i));
			this.remove(this.get(i));
		}
		return population_top;
	}
	
	/**
	 * take a list of the top and merge it the other liste to get a new one 
	 * @param population_top
	 * @return
	 */
	public Population Croissement(Population population_top) {
		
		Population children = new Population();
		
		for(int i=0 ; i<population_top.size() ; i++) {
			Tour parent1 = population_top.get(r.nextInt(population_top.size()));
			Tour parent2 = population_top.get(r.nextInt(population_top.size()));
			children.add(beerd(parent1, parent2));
		}
		this.addAll(children);
			return this;
		}
	
	  public Population mutate(Population pop, double d) {
		  Tour tour = pop.get(r.nextInt(pop.size()));
	         for(int i=0; i < tour.size(); i++){
	             if(Math.random() < d){
	                 int j = (int) (tour.size() * Math.random());

	                City city1 = tour.get(i);
	                City city2 = tour.get(j);
	                
	                tour.set(j, city1);
	                tour.set(i, city2);
	            }
	        }
	         return this;
	    }
	  
	/***
	 * sort the list to get the first element which is the fittest
	 * @return
	 */
	public Tour fittest() {
		this.sort(Tour.sort());
		this.fitness_population();
		return this.get(0);
	}
	
	public String toString() {
		String s ="";
		for(Tour t : this) {
			s += t.toString()+'\n';
		}
		return s;
	}
	/***
	 *  based on two routes we are going to merge cities with making sure we dont add a city more than once 
	 * @param parent1
	 * @param parent2
	 * @return
	 */

	private Tour beerd(Tour parent1 , Tour parent2) {
		
		int startPos = (int) (Math.random() * parent1.size());
        int endPos = (int) (Math.random() * parent1.size());
        
        int start = Math.min(startPos, endPos);
        int end = Math.max(startPos, endPos);
        
        Tour kid = new Tour();
        
        for(int i=start ; i<endPos ; i++) {	
        	kid.add(parent1.get(i));
        }
        
        for(int i=0 ; i<parent2.size() ; i++) {	
        	if(!kid.contains(parent2.get(i))){
        		kid.add(parent2.get(i));
        	}
        }
        kid.calcule_fitness();
        return kid;
	}
	/***
	 * to get the fitness of all the population
	 */
	
	private void fitness_population() {
		for(Tour t : this) {
			t.calcule_fitness();
		}
	}
	
}
