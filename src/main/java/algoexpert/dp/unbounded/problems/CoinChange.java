package algoexpert.dp.unbounded.problems;

import edu.princeton.cs.algs4.StdOut;

public class CoinChange {
  public static int numberOfWaysToMakeChange(int[] coins, int targetChange) {
    return numberOfWaysToMakeChange(coins, targetChange, coins.length - 1, 0);
  }

  private static int numberOfWaysToMakeChange(int[] coins, int maxChange, int n, int numberOfWays) {
    if (maxChange == 0) return numberOfWays + 1;
    if (n < 0) return 0;

    if (coins[n] > maxChange)
      return numberOfWaysToMakeChange(coins, maxChange, n - 1, numberOfWays);

    int include = numberOfWaysToMakeChange(coins, maxChange - coins[n], n, numberOfWays);
    int skip = numberOfWaysToMakeChange(coins, maxChange, n - 1, numberOfWays);

    return include + skip;
  }

  public static void main(String[] args) {
    int[] coins = {1, 2, 3};
    int targetChange = 5;

    StdOut.println(numberOfWaysToMakeChange(coins, targetChange) + " Expected 5");
    StdOut.println(numberOfWaysToMakeChange(coins, 4) + " Expected 4");
    StdOut.println(numberOfWaysToMakeChange(new int[] {2, 5, 3, 6}, 10) + " Expected 5");
  }
}
