package algoexpert.dp.knapsack;

import edu.princeton.cs.algs4.StdOut;

public class ZeroOneKnapsack {

  public static int knapsack(int[] weights, int[] values, int maxWeight) {
    return knapsack(weights, values, maxWeight, weights.length - 1);
  }

  private static int knapsack(int[] weights, int[] values, int maxWeight, int n) {

    if (n < 0 || maxWeight == 0) return 0;

    // if item is bigger than maxWeight, skip it and check next item instead.
    if (weights[n] > maxWeight) return knapsack(weights, values, maxWeight, n - 1);

    // if we are good on weight, now we have to decide between two choices
    // 1. total profit if we include this item at n
    // 2. total profit if we skip this item at n
    int profitIfIncluded = values[n] + knapsack(weights, values, maxWeight - weights[n], n - 1);
    int profitIfSkipped = knapsack(weights, values, maxWeight, n - 1);

    return Math.max(profitIfIncluded, profitIfSkipped);
  }

  public static void main(String[] args) {
    int[] weights = {10, 20, 30};
    int[] values = {60, 100, 120};
    int maxWeight = 50;

    //    StdOut.println(knapsack(weights, values, maxWeight));

    int[] weights2 = {1, 1, 1};
    int[] values2 = {10, 20, 30};
    int maxWeight2 = 2;

    StdOut.println(knapsack(weights2, values2, maxWeight2) + " Expected 50");
  }
}
