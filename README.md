Introduction
------------
A genetic algorithm (GA) is great for finding solutions for complex problems. They're used in engineering to design all sorts of products because they're brilliant at finding just the right materials and the right shapes to create stronger, faster and overall better products. They're also used to design computer algorithms, to schedule tasks, and to solve other optimization problems. Genetic algorithms work by mimicking the way life finds solutions to real world problems using the process of evolution. Although genetic algorithms are capable of solving incredibly complicated problems, they are themselves pretty simple to understand. 

The basic idea is:
1. Initialization - Create an initial population, this population is usually generated randomly and can be any size desired, from just a few individuals to thousands.
2. Evaluation - Each member of the population is then evaluated and we calculate a 'fitness' for that individual. The fitness is calculated by how well it fits our desired requirements. These requirements can be simple, 'faster algorithms are better', or more complex, 'stronger materials are better but they shouldn't be too heavy'.
3. Selection - We want to be constantly improving our populations overall fitness, selection helps us discard bad designs and only keep the best individuals.  There are a few different selection methods but the basic idea is the same, make it easier for fitter individuals to be selected for our next generation.
4. Crossover - During crossover we create new individuals by creating crosses of our selected individuals, we call these our parents. The idea is the combination of these parents will create an even 'fitter' offspring for our next population which inherits the best bits of both individuals.
5. Mutation - We need to add a little bit randomness into our populations' genetics otherwise every combination of solutions we can create would be in our initial population.
6. And repeat! - Now we have our next generation we can start again from step two.

Example Usage
--------------

Create an initial population, then evolve our population until we reach an optimum solution.

		Individual.setDefaultGeneLength(32);
		Population myPop = new Population(fitnessCalc, 50, true);

		while (myPop.getFittest().getFitness() < fitnessCalc.getMaxFitness()) {
			myPop = Algorithm.evolvePopulation(myPop);
		}

FitnessCalculator
-----------------

    public interface FitnessCalculator {

      /** Determines fitness of an Individual. Most important method. */
      int getFitness(Individual individual);

      /** Get optimum fitness. */
      int getMaxFitness();
 
    }
	
License
-------

Copyright 2012, Adam L. Davis. All rights reserved.
Made Available for use under a BSD-style license. See LICENSE