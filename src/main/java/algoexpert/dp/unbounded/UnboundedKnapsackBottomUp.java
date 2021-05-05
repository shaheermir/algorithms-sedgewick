package algoexpert.dp.unbounded;

import edu.princeton.cs.algs4.StdOut;

public class UnboundedKnapsackBottomUp {

  public static int knapsack(int[] weights, int[] values, int maxWeight) {
    // this is really just a 2d arary accumulated into 1d. all the rows have been accumulated.
    int[] dp = new int[maxWeight + 1];

    for (int i = 0; i <= maxWeight; i++) {
      for (int j = 0; j < weights.length; j++) {

        int capacity = i;
        int weight = weights[j];
        int value = values[j];

        if (weight <= capacity) {
          int included = value + dp[capacity - weight];
          int skipped = dp[i];

          dp[i] = Math.max(included, skipped);
        }
      }
    }

    return dp[maxWeight];
  }

  public static void main(String[] args) {
    int maxWeight = 100;
    int[] values = {1, 30};
    int[] weights = {1, 50};

    StdOut.println(knapsack(weights, values, maxWeight) + " Expected 100");
  }
}
