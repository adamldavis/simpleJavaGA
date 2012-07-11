/** Copyright 2012, Adam L. Davis */
package com.adamldavis.ga;

import java.util.Random;

/**
 * @author Adam Davis
 * 
 */
public class GaTest {

	public static void main(String[] args) {

		// Set a candidate solution
		byte[] solution = new byte[Individual.defaultGeneLength];
		new Random().nextBytes(solution);
		System.out.println("solution=");
		for (int i = 0; i < solution.length; i++)
			System.out.print(solution[i] + ",");
		System.out.println();

		final FitnessCalcImpl fitnessCalc = new FitnessCalcImpl();
		fitnessCalc.setSolution(solution);

		// Create an initial population
		Individual.setDefaultGeneLength(64);
		Population myPop = new Population(fitnessCalc, 50, true);

		// Evolve our population until we reach an optimum solution
		int generationCount = 0;
		while (myPop.getFittest().getFitness() < fitnessCalc.getMaxFitness()) {
			generationCount++;
			System.out.println("Generation: " + generationCount + " Fittest: "
					+ myPop.getFittest().getFitness());
			myPop = Algorithm.evolvePopulation(myPop);
		}
		System.out.println("Solution found!");
		System.out.println("Generation: " + generationCount);
		System.out.println("Genes:");
		System.out.println(myPop.getFittest());

	}
}
