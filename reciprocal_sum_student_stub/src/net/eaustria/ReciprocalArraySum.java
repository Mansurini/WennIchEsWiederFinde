/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.eaustria;

/**
 *
 * @author bmayr
 */


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * Class wrapping methods for implementing reciprocal array sum in parallel.
 */
public final class ReciprocalArraySum  {

    private ReciprocalArraySum() {

    }

    /**
     * Sequentially compute the sum of the reciprocal values for a given array.
     *
     * @param input Input array
     * @return The sum of the reciprocals of the array input
     */
    protected static double seqArraySum(final double[] input) {
        double sum = 0;

        ReciprocalArraySumTask task = new ReciprocalArraySumTask(0, input.length-1, input);
        sum = task.join();
       return sum;
    }
  

    /**
     * This class stub can be filled in to implement the body of each task
     * created to perform reciprocal array sum in parallel.
     */
    private static class ReciprocalArraySumTask extends RecursiveTask<Double> {
        /**
         * Starting index for traversal done by this task.
         */
        private final int startIndexInclusive;
        /**
         * Ending index for traversal done by this task.
         */
        private final int endIndexExclusive;
        /**
         * Input array to reciprocal sum.
         */
        private final double[] input;
        /**
         * Intermediate value produced by this task.
         */
        private double value;
        
        private static int SEQUENTIAL_THRESHOLD = 50000;

        /**
         * Constructor.
         * @param setStartIndexInclusive Set the starting index to begin
         *        parallel traversal at.
         * @param setEndIndexExclusive Set ending index for parallel traversal.
         * @param setInput Input values
         */
        ReciprocalArraySumTask(final int setStartIndexInclusive,
                final int setEndIndexExclusive, final double[] setInput) {
            this.startIndexInclusive = setStartIndexInclusive;
            this.endIndexExclusive = setEndIndexExclusive;
            this.input = setInput;
        }

        /**
         * Getter for the value produced by this task.
         * @return Value produced by this task
         */
        public double getValue() {
            return value;
        }

        @Override
        protected Double compute() {
            Double a = 0.0;
            Double b = 0.0;

            if (startIndexInclusive - endIndexExclusive == 0) {
                return 1/input[0];
            } else if (startIndexInclusive - endIndexExclusive == -1) {
                return 1/input[startIndexInclusive] + 1/input[endIndexExclusive];
            } else {
                int startR = startIndexInclusive;
                int endR = endIndexExclusive/2;
                int startL = endR + 1;
                int endL = endIndexExclusive;
                ReciprocalArraySumTask rechts = new ReciprocalArraySumTask(startR, endR, input);
                ReciprocalArraySumTask links = new ReciprocalArraySumTask(startL, endL, input);
                invokeAll(rechts, links);
                a = rechts.join();
                b = links.join();
                return a + b;
            }


        }

    }

  

    /**
     * TODO: Extend the work you did to implement parArraySum to use a set
     * number of tasks to compute the reciprocal array sum. 
     *
     * @param input Input array
     * @param numTasks The number of tasks to create
     * @return The sum of the reciprocals of the array input
     */
    protected static double parManyTaskArraySum(final double[] input,
            final int numTasks) {
        double sum = 0;
       // ToDo: Start Calculation with help of ForkJoinPool
       
       return sum;
    }
}

