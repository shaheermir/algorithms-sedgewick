package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;
import util.MatrixUtil;

import java.util.Arrays;

public class Exercise33 {
  public static void main(String[] args) {
    double[][] matrix = {
      {-3, 0, 3, 2},
      {1, 7, -1, 9}
    };
    double[] vector = {2, -3, 4, -1};
    double[] vector2 = {1, 2, 3, 4};

    double[][] matrix2 = {
      {-3, 1},
      {0, 7},
      {3, -1},
      {2, 9},
    };

    StdOut.println("Dot Product " + MatrixUtil.dot(vector, vector2));

    double[] result1 = MatrixUtil.multiply(matrix, vector);
    StdOut.println("\nMatrix x Vector " + Arrays.toString(result1));

    double[] result2 = MatrixUtil.multiply(vector, matrix2);
    StdOut.println("Vector x Matrix " + Arrays.toString(result2));

    StdOut.println("\nBefore Transpose");
    MatrixUtil.printMatrix(matrix2);

    StdOut.println("\nAfter Transpose");
    MatrixUtil.printMatrix(MatrixUtil.transpose(matrix2));
  }
}
