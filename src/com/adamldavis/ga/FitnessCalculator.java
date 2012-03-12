package com.adamldavis.ga;

public interface FitnessCalculator {

	/** Determines fitness of an Individual. Most important method. */
	int getFitness(Individual individual);

	/** Get optimum fitness. */
	int getMaxFitness();

}