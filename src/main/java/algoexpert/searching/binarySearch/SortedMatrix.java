package algoexpert.searching.binarySearch;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

// TODO:
public class SortedMatrix {

  // O(m * log n)  where m is number of rows, and n is number of cols or length of rows.
  public static int[] searchInSortedMatrix(int[][] a, int target) {
    for (int row = 0; row < a.length; row++) {
      int left = 0;
      int right = a[row].length - 1;

      while (left <= right) {
        int mid = (left + right) / 2;
        if (a[row][mid] < target) left = mid + 1;
        else if (a[row][mid] > target) right = mid - 1;
        else return new int[] {row, mid};
      }
    }
    return new int[] {-1, -1};
  }

  // O(N + M)
  public static int[] searchSortedMatrixFaster(int[][] a, int target) {
    int row = 0;
    int col = a[0].length - 1;

    while (row < a.length && col >= 0) {
      int val = a[row][col];

      if (val == target) return new int[] {row, col};

      if (val > target) col--;
      if (val < target) row++;
    }

    return new int[] {-1, -1};
  }

  public static void main(String[] args) {
    int[][] matrix = {
      {1, 4, 7, 12, 15, 1000},
      {2, 5, 19, 31, 32, 1001},
      {3, 8, 24, 33, 35, 1002},
      {40, 41, 42, 44, 45, 1003},
      {99, 100, 103, 106, 128, 1004},
    };
    int[] expected = {3, 3};
    int[] output = searchSortedMatrixFaster(matrix, 44);
    StdOut.println(Arrays.toString(output) + " Expected " + Arrays.toString(expected));
  }
}
