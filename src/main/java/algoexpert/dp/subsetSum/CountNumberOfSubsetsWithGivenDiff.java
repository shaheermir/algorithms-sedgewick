package algoexpert.dp.subsetSum;

import edu.princeton.cs.algs4.StdOut;

/**
 * Given a list and a target difference, this program finds the number of subsets such that the
 * difference of their sums equals the targetDiff.
 *
 * <p>TargetSum On leetcode can be reduced down to exactly this.
 *
 * <p>Example - a: [1, 1, 2, 3] targetDiff = 1 [1, 1, 2] - [3] = 1 [3, 1] - [1, 2] = 1 [3, 1] - [1,
 * 2] = 1 Result = 3
 */
public class CountNumberOfSubsetsWithGivenDiff {
  public static int countNumberOfSubsetsWithGivenDifference(int[] a, int diff) {
    int range = 0;
    for (int n : a) range += n;

    int sum1 = (range + diff) / 2;
    return count(a, sum1, a.length - 1, 0);
  }

  private static int count(int[] a, int targetSum, int n, int pairs) {
    if (targetSum == 0) return pairs + 1;
    if (n < 0) return pairs;

    int value = a[n];
    if (value > targetSum) return count(a, targetSum, n - 1, pairs);

    int included = count(a, targetSum - value, n - 1, pairs);
    int skipped = count(a, targetSum, n - 1, pairs);

    return included + skipped;
  }

  public static void main(String[] args) {
    int[] a = {1, 1, 2, 3};
    StdOut.println(countNumberOfSubsetsWithGivenDifference(a, 2));

    StdOut.println(countNumberOfSubsetsWithGivenDifference(new int[] {1, 1, 1, 1, 1}, 3));
  }
}
