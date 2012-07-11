package com.adamldavis.ga;

/**
 * Defines the fitness of an individual.
 * 
 * @author Adam Davis
 * 
 */
public interface FitnessCalculator {

	/** Determines fitness of an Individual. Most important method. */
	int getFitness(Individual individual);

	/** Get optimum fitness. */
	int getMaxFitness();

}