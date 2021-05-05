package algoexpert.dp.knapsack;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class KnapsackAlgoExpert {
  public static List<List<Integer>> knapsackProblem(int[][] items, int maxWeight) {
    List<Integer> totalValue = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    int[][] profits = new int[items.length + 1][maxWeight + 1];

    for (int i = 1; i < items.length + 1; i++) {
      for (int j = 1; j < maxWeight + 1; j++) {
        int capacity = j;
        int weight = getWeight(items, i - 1);
        int value = getValue(items, i - 1);

        if (weight > capacity) {
          profits[i][j] = profits[i - 1][j];
        } else {
          int profitIfIncluded = value + profits[i - 1][j - weight];
          int profitIfSkipped = profits[i - 1][j];

          profits[i][j] = Math.max(profitIfIncluded, profitIfSkipped);
        }
      }
    }

    List<Integer> finalItems = findWhichItemsWereAdded(items, profits);
    totalValue.add(profits[items.length][maxWeight]);
    result.add(totalValue);
    result.add(finalItems);
    return result;
  }

  private static List<Integer> findWhichItemsWereAdded(int[][] items, int[][] profits) {
    List<Integer> result = new ArrayList<>();

    int i = profits.length - 1;
    int j = profits[0].length - 1;

    while (i >= 1) {
      int profitAbove = profits[i - 1][j];
      int profit = profits[i][j];

      // if item was added, then go [1 row above, weight - this items weight]
      if (profit > profitAbove) {
        result.add(i - 1);
        j = j - getWeight(items, i - 1);
        i--;
      } else {
        i--;
      }
    }
    return result;
  }

  private static int getWeight(int[][] items, int i) {
    return items[i][1];
  }

  private static int getValue(int[][] items, int i) {
    return items[i][0];
  }

  public static void main(String[] args) {
    // {value, weight}
    int[][] items = {
      {1, 2},
      {4, 3},
      {5, 6},
      {6, 7}
    };
    int maxWeight = 10;
    StdOut.println(knapsackProblem(items, maxWeight));
  }
}
