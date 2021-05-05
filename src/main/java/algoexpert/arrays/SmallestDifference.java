package algoexpert.arrays;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class SmallestDifference {

  // O(nlog(n) + mlog(m))  --> due to the sorting. the actual iteration through arrays is negligible
  // compared to sort for large data sets.
  // O(1) space
  public static int[] smallestDifference(int[] a, int[] b) {
    Arrays.sort(a);
    Arrays.sort(b);

    int[] smallestPair = new int[2];
    int currentSmallestDiff = Integer.MAX_VALUE;

    int i = 0, j = 0;

    while (i < a.length && j < b.length) {
      int firstNum = a[i];
      int secondNum = b[j];
      int difference = Math.abs(firstNum - secondNum);

      if (firstNum < secondNum) {
        i++;
      } else if (firstNum > secondNum) {
        j++;
      } else {
        return new int[] {firstNum, secondNum};
      }

      if (difference < currentSmallestDiff) {
        currentSmallestDiff = difference;
        smallestPair[0] = firstNum;
        smallestPair[1] = secondNum;
      }
    }

    return smallestPair;
  }

  public static void main(String[] args) {

    int[] a = {-1, 5, 10, 20, 28, 3};
    int[] b = {26, 134, 135, 15, 17};
    StdOut.println(Arrays.toString(smallestDifference(a, b)));
  }
}
