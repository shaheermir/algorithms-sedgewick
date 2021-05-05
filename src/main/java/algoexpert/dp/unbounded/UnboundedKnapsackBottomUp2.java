package algoexpert.dp.unbounded;

import edu.princeton.cs.algs4.StdOut;

public class UnboundedKnapsackBottomUp2 {

  public static int knapsack(int[] weights, int[] values, int maxWeight) {

    int[][] dp = new int[weights.length + 1][maxWeight + 1];

    for (int i = 1; i <= weights.length; i++) {
      for (int j = 1; j <= maxWeight; j++) {
        int capacity = j;
        int weight = weights[i - 1];
        int value = values[i - 1];

        if (weight > capacity) {
          dp[i][j] = dp[i - 1][j];
        } else {
          int included = value + dp[i][j - weight];
          int skipped = dp[i - 1][j];

          dp[i][j] = Math.max(included, skipped);
        }
      }
    }

    return dp[weights.length][maxWeight];
  }

  public static void main(String[] args) {
    int maxWeight = 100;
    int[] values = {1, 30};
    int[] weights = {1, 50};

    StdOut.println(knapsack(weights, values, maxWeight) + " Expected 100");
  }
}
