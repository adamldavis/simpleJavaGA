/** Copyright 2012, Adam L. Davis */
package com.adamldavis.ga;

/**
 * Defines a single generation. Default population size is 100.
 * 
 * @author Adam Davis
 * @see Algorithm
 * @see Individual
 */
public class Population {

	public static int defaultPopSize = 100;

	FitnessCalculator fitnessCalculator;

	Individual[] individuals;

	/**
	 * Constructor using defaultPopSize and initialize=false.
	 */
	public Population() {
		this(null, defaultPopSize, false);
	}

	/**
	 * Constructor using defaultPopSize and initialize=true.
	 */
	public Population(FitnessCalculator fitnessCalculator) {
		this(fitnessCalculator, defaultPopSize, true);
	}

	/**
	 * Constructor using populationSize and initialize=false.
	 */
	public Population(int populationSize) {
		this(null, populationSize, false);
	}

	// Create a population
	public Population(FitnessCalculator fitnessCalculator, int populationSize,
			boolean initialise) {
		this.fitnessCalculator = fitnessCalculator;
		individuals = new Individual[populationSize];
		// Initialise population
		if (initialise) {
			// Loop and create individuals
			for (int i = 0; i < size(); i++) {
				Individual newIndividual = new Individual(fitnessCalculator);
				newIndividual.generateIndividual();
				saveIndividual(i, newIndividual);
			}
		}
	}

	public FitnessCalculator getFitnessCalculator() {
		return fitnessCalculator;
	}

	public Individual getFittest() {
		Individual fittest = individuals[0];
		// Loop through individuals to find fittest
		for (int i = 0; i < size(); i++) {
			if (fittest.getFitness() <= getIndividual(i).getFitness()) {
				fittest = getIndividual(i);
			}
		}
		return fittest;
	}

	/* Getters */
	public Individual getIndividual(int index) {
		return individuals[index];
	}

	// Save individual
	public void saveIndividual(int index, Individual indiv) {
		individuals[index] = indiv;
	}

	public void setFitnessCalculator(FitnessCalculator fitnessCalculator) {
		this.fitnessCalculator = fitnessCalculator;
	}

	/* Public methods */
	// Get population size
	public int size() {
		return individuals.length;
	}
}
