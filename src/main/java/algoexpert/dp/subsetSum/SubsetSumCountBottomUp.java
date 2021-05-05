package algoexpert.dp.subsetSum;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class SubsetSumCountBottomUp {

  public static int subsetSumCount(int[] a, int sum) {
    int[][] numberOfSubsets = new int[a.length + 1][sum + 1];

    // when targetSum is 0, we can always have 1 empty
    for (int i = 0; i < a.length + 1; i++) numberOfSubsets[i][0] = 1;

    for (int i = 1; i < a.length + 1; i++) {
      for (int j = 1; j < sum + 1; j++) {

        int value = a[i - 1];
        int capacity = j;

        if (value > capacity) {
          numberOfSubsets[i][j] = numberOfSubsets[i - 1][j];
        } else {
          int included = numberOfSubsets[i - 1][j - value];
          int skipped = numberOfSubsets[i - 1][j];
          numberOfSubsets[i][j] = included + skipped;
        }
      }
    }

    return numberOfSubsets[a.length][sum];
  }

  public static void main(String[] args) {
    int[] a = {2, 3, 5, 6, 8, 10};
    int targetSum = 10;

    StdOut.println("Array: " + Arrays.toString(a));
    StdOut.println("Target Sum : " + targetSum);
    StdOut.println("Sets that add up to 10: [2, 3, 5]  [2, 8]  [10]");

    StdOut.println("Actual " + subsetSumCount(a, targetSum) + " Expected 3");
  }
}
