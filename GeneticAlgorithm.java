package pack;

import java.util.ArrayList;
import java.util.Collections;

public class GeneticAlgorithm {
	
	
	
	public void evolution(ArrayList<City> cities, int pop_size,int top, int epochs, double mutationRate) {
		
		Population pop = new Population();
		
		// generation of individual 
		pop.Population(cities, pop_size);
		// fittest individual 
		System.out.println(" la distance initial "+pop.fittest());
		
		for(int i=0 ; i<epochs ; i++) {
			// algortihme genetic
			Population pop1 = pop.Selection(top);
			Population pop2 = pop.Croissement(pop1);
			Population pop3 = pop.mutate(pop2, 0.5);
		}
		
		System.out.println(" la distance final "+pop.fittest());
	}
	
	
	

}
