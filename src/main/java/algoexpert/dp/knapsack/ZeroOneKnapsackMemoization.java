package algoexpert.dp.knapsack;

import edu.princeton.cs.algs4.StdOut;

public class ZeroOneKnapsackMemoization {

  public static int knapsack(int[] weights, int[] values, int maxWeight) {
    int[][] dp = new int[weights.length][maxWeight + 1];

    for (int i = 0; i < weights.length; i++) for (int j = 0; j < maxWeight + 1; j++) dp[i][j] = -1;

    return knapsack(weights, values, maxWeight, weights.length - 1, dp);
  }

  private static int knapsack(int[] weights, int[] values, int maxWeight, int n, int[][] dp) {

    if (n < 0 || maxWeight == 0) return 0;

    if (dp[n][maxWeight] != -1) return dp[n][maxWeight];

    if (weights[n] > maxWeight)
      return dp[n][maxWeight] = knapsack(weights, values, maxWeight, n - 1, dp);

    int profitIfIncluded = values[n] + knapsack(weights, values, maxWeight - weights[n], n - 1, dp);
    int profitIfSkipped = knapsack(weights, values, maxWeight, n - 1, dp);

    return dp[n][maxWeight] = Math.max(profitIfIncluded, profitIfSkipped);
  }

  public static void main(String[] args) {
    int[] weights = {1, 2, 3};
    int[] values = {10, 15, 40};
    int maxWeight = 5;

    StdOut.println(knapsack(weights, values, maxWeight) + " Expected 55");

    int[] weights2 = {1, 1, 1};
    int[] values2 = {10, 20, 30};
    int maxWeight2 = 2;

    StdOut.println(knapsack(weights2, values2, maxWeight2) + " Expected 50");

    int[] weights3 = {2, 70, 30, 69, 100};
    int[] values3 = {1, 70, 30, 69, 69, 100};
    int maxWeight3 = 0;

    StdOut.println(knapsack(weights3, values3, maxWeight3) + " Expected 0");
  }
}
