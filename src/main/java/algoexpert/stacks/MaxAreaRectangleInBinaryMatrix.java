package algoexpert.stacks;

import edu.princeton.cs.algs4.StdOut;

public class MaxAreaRectangleInBinaryMatrix {
  public static int maxAreaRectangleInBinaryMatrix(int[][] a) {
    int rows = a.length;
    int cols = a[0].length;

    int[] vector = new int[cols];
    int[] areasByRow = new int[rows];

    for (int i = 0; i < rows; i++) {
      int[] row = a[i];

      for (int j = 0; j < row.length; j++) {
        if (row[j] == 1) vector[j] = vector[j] + row[j];
        else vector[j] = 0;
      }

      //      StdOut.println();
      //      StdOut.println(i);
      //      StdOut.println(Arrays.toString(vector));

      int area = findMax(MaximumAreaHistogram.maximmumAreaHistogram(vector));
      areasByRow[i] = area;
    }

    return findMax(areasByRow);
  }

  public static int findMax(int[] a) {
    int currentMax = Integer.MIN_VALUE;
    for (int i : a) {
      if (i > currentMax) currentMax = i;
    }
    return currentMax;
  }

  public static void main(String[] args) {
    int[][] a = {
      {0, 1, 1, 0},
      {1, 1, 1, 1},
      {1, 1, 1, 1},
      {1, 1, 0, 0},
    };

    int[][] b = {
      {0, 1, 1},
      {1, 1, 1},
      {0, 1, 1},
    };

    StdOut.println(maxAreaRectangleInBinaryMatrix(a) + " Expected 8");
    StdOut.println(maxAreaRectangleInBinaryMatrix(b) + " Expected 6");
  }
}
