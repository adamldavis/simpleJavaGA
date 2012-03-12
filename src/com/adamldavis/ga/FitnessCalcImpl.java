/** Copyright 2012, Adam L. Davis */
package com.adamldavis.ga;

/**
 * @author Adam Davis
 * 
 */
public class FitnessCalcImpl implements FitnessCalculator {

	byte[] solution = new byte[64];

	/* Public methods */
	public void setSolution(byte[] newSolution) {
		solution = newSolution;
	}

	// To make it easier we can use this method to set our candidate solution
	// with string of 0s and 1s
	void setSolution(String newSolution) {
		solution = new byte[newSolution.length()];
		for (int i = 0; i < newSolution.length(); i++) {
			String character = newSolution.substring(i, i + 1);
			if (character.contains("0") || character.contains("1")) {
				solution[i] = Byte.parseByte(character);
			} else {
				solution[i] = 0;
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.adamldavis.ga.FitnessCalc#getFitness(com.adamldavis.ga.Individual)
	 */
	@Override
	public int getFitness(Individual individual) {
		int fitness = 0;
		// Loop through our individuals genes and compare them to our cadidates
		for (int i = 0; i < individual.size() && i < solution.length; i++) {
			if (individual.getGene(i) == solution[i]) {
				fitness++;
			}
		}
		return fitness;
	}

	// Get optimum fitness
	/* (non-Javadoc)
	 * @see com.adamldavis.ga.FitnessCalc#getMaxFitness()
	 */
	@Override
	public int getMaxFitness() {
		return solution.length;
	}
}
