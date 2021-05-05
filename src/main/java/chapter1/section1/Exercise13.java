package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise13 {

  public static int[][] transpose(int[][] mat) {
    int rows = mat.length;
    int cols = mat[0].length;
    int[][] transposed = new int[cols][rows];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        transposed[j][i] = mat[i][j];
      }
    }

    return transposed;
  }

  private static void print(int[][] mat) {
    int rows = mat.length;
    int cols = mat[0].length;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        StdOut.print(mat[i][j] + " ");
      }
      StdOut.println();
    }
  }

  public static void main(String[] args) {
    int[][] matrix = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9},
      {0, 1, 2}
    };
    StdOut.println("Before Transposing");
    print(matrix);

    int[][] transposed = transpose(matrix);

    StdOut.println("After Transposing");
    print(transposed);
  }
}
