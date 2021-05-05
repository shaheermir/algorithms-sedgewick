package algoexpert.dp.unbounded.problems;

import edu.princeton.cs.algs4.StdOut;

public class CoinsChangeBottomUp {
  public static int numberOfWaysToMakeChange(int[] coins, int targetChange) {
    int[][] ways = new int[coins.length + 1][targetChange + 1];

    // when targetChange is 0, there is always 1 way to achieve it, an empty set.
    for (int i = 0; i < ways.length; i++) ways[i][0] = 1;

    for (int i = 1; i <= coins.length; i++) {
      for (int j = 1; j <= targetChange; j++) {
        int value = coins[i - 1];
        if (value > j) {
          ways[i][j] = ways[i - 1][j];
        } else {
          int include = ways[i][j - value];
          int skip = ways[i - 1][j];
          ways[i][j] = include + skip;
        }
      }
    }

    return ways[coins.length][targetChange];
  }

  public static void main(String[] args) {
    int[] coins = {1, 2, 3};
    int targetChange = 5;

    StdOut.println(numberOfWaysToMakeChange(coins, targetChange) + " Expected 5");
    StdOut.println(numberOfWaysToMakeChange(coins, 4) + " Expected 4");
    StdOut.println(numberOfWaysToMakeChange(new int[] {2, 5, 3, 6}, 10) + " Expected 5");
  }
}
