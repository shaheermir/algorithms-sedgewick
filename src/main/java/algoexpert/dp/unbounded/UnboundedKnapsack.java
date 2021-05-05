package algoexpert.dp.unbounded;

import edu.princeton.cs.algs4.StdOut;

public class UnboundedKnapsack {
  /**
   * Unbounded Knapsack - maximize profits while not going over bags capacity. Because this is
   * unbounded, u can add the same item more than once.
   *
   * @param weights
   * @param values
   * @param maxWeight
   * @return
   */
  public static int knapsack(int[] weights, int[] values, int maxWeight) {
    return maximizeValueInKnapsack(weights, values, maxWeight, weights.length - 1);
  }

  private static int maximizeValueInKnapsack(int[] weights, int[] values, int maxWeight, int n) {
    if (n < 0 || maxWeight == 0) return 0;

    if (weights[n] > maxWeight) return maximizeValueInKnapsack(weights, values, maxWeight, n - 1);

    int included = values[n] + maximizeValueInKnapsack(weights, values, maxWeight - weights[n], n);
    int skipped = maximizeValueInKnapsack(weights, values, maxWeight, n - 1);

    return Math.max(included, skipped);
  }

  public static void main(String[] args) {
    int maxWeight = 100;
    int[] values = {1, 30};
    int[] weights = {1, 50};

    StdOut.println(knapsack(weights, values, maxWeight) + " Expected 100");
  }
}
