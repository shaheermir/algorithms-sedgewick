package algoexpert.dp.unbounded.problems;

import edu.princeton.cs.algs4.StdOut;

public class CoinsChangeBottomUpLessSpace {
  // I need to review this.
  public static int numberOfWaysToMakeChange(int[] coins, int targetChange) {
    int[] ways = new int[targetChange + 1];
    ways[0] = 1;

    for (int i = 0; i < coins.length; i++) {
      for (int j = coins[i]; j <= targetChange; j++) {
        ways[j] = ways[j] + ways[j - coins[i]];
      }
    }

    return ways[targetChange];
  }

  public static void main(String[] args) {
    int[] coins = {1, 2, 3};
    int targetChange = 5;

    StdOut.println(numberOfWaysToMakeChange(coins, targetChange) + " Expected 5");
    StdOut.println(numberOfWaysToMakeChange(coins, 4) + " Expected 4");
    StdOut.println(numberOfWaysToMakeChange(new int[] {2, 5, 3, 6}, 10) + " Expected 5");
  }
}
