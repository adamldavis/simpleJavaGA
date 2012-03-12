package com.adamldavis.ga;

import java.util.Random;

public class Individual {

	static int defaultGeneLength = 64;

	/* Getters and setters */
	/**
	 * Use this if you want to create individuals with different gene lengths
	 */
	public static void setDefaultGeneLength(int length) {
		defaultGeneLength = length;
	}

	// Cache
	private int fitness = 0;

	private byte[] genes = new byte[defaultGeneLength];

	FitnessCalculator fitnessCalculator;

	public Individual(FitnessCalculator fitnessCalculator) {
		super();
		this.fitnessCalculator = fitnessCalculator;
	}

	/** Create a random individual. */
	public void generateIndividual() {
		new Random().nextBytes(genes);
	}

	public int getFitness() {
		if (fitness == 0) {
			fitness = fitnessCalculator.getFitness(this);
		}
		return fitness;
	}

	public byte getGene(int index) {
		return genes[index];
	}

	public void mutateGene(int i) {
		byte[] bb = new byte[1];
		new Random().nextBytes(bb);
		setGene(i, bb[0]);
	}

	public void setGene(int index, byte value) {
		genes[index] = value;
		fitness = 0;
	}

	/* Public methods */
	public int size() {
		return genes.length;
	}

	@Override
	public String toString() {
		StringBuilder geneString = new StringBuilder(getGene(0) + "");

		for (int i = 1; i < size(); i++) {
			geneString.append(",").append(getGene(i));
		}
		return geneString.toString();
	}
}
