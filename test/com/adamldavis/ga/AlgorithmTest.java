package com.adamldavis.ga;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class AlgorithmTest {

	@DataPoint
	public static final Integer small = 10;
	@DataPoint
	public static final Integer medium = 64;
	@DataPoint
	public static final Integer big = 100;

	@Theory
	public void testEvolvePopulation(Integer size) {
		Individual.setDefaultGeneLength(size);
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
		Population myPop = new Population(fitnessCalc, 50, true);

		// Evolve our population until we reach an optimum solution
		int generationCount = 0;
		while (myPop.getFittest().getFitness() < fitnessCalc.getMaxFitness()) {
			generationCount++;
			myPop = Algorithm.evolvePopulation(myPop);
		}
		System.out.println("Solution found!");
		System.out.println("Generation: " + generationCount);
		System.out.println("Genes:");
		assertNotNull(myPop.getFittest());
		assertEquals(solution.length, myPop.getFittest().getGenes().length);
		assertTrue(Arrays.equals(solution, myPop.getFittest().getGenes()));
		System.out.println(myPop.getFittest());
	}

}
