package algoexpert.dp.knapsack;

import edu.princeton.cs.algs4.StdOut;

public class ZeroOneKnapsackBottomUp {

  public static int knapsack(int[] weights, int[] values, int maxWeight) {
    int[][] profits = new int[weights.length + 1][maxWeight + 1];

    for (int i = 0; i < weights.length + 1; i++)
      for (int j = 0; j < maxWeight + 1; j++) profits[i][j] = 0;

    for (int i = 1; i < profits.length; i++) {
      for (int j = 1; j < profits[0].length; j++) {

        int capacity = j;
        int weight = weights[i - 1];
        int value = values[i - 1];

        if (weight > capacity) {
          profits[i][j] = profits[i - 1][j];
        } else {
          int profitIfIncluded = value + profits[i - 1][j - weight];
          int profitIfSkipped = profits[i - 1][j];

          profits[i][j] = Math.max(profitIfIncluded, profitIfSkipped);
        }
      }
    }

    print(profits);
    return profits[weights.length][maxWeight];
  }

  static void print(int[][] grid) {
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[r].length; c++) System.out.print(grid[r][c] + " ");
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int[] weights = {2, 3, 6, 7};
    int[] values = {1, 4, 5, 6};
    int maxWeight = 10;

    StdOut.println(knapsack(weights, values, maxWeight));
  }
}
