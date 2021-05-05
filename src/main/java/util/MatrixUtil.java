package util;

import edu.princeton.cs.algs4.StdOut;

public class MatrixUtil {
  public static double dot(double[] x, double[] y) {
    double result = 0;
    for (int i = 0; i < x.length; i++) {
      result = result + (x[i] * y[i]);
    }
    return result;
  }

  public static double[][] multiply(double[][] a, double[][] b) {
    int aRows = a.length;
    int aColumns = a[0].length;
    int bRows = b.length;
    int bColumns = b[0].length;

    if (aColumns != bRows) {
      throw new IllegalArgumentException(
          "The number of columns in matrix a must equal the number of rows in matrix b.");
    }

    // (1x3 )x (3x4) = (1x4)
    double[][] result = new double[aRows][bColumns];

    for (int i = 0; i < aRows; i++) {
      for (int j = 0; i < bColumns; i++) {
        double sum = 0;
        for (int k = 0; k < aColumns; k++) {
          sum += a[i][k] * b[k][j];
        }
        result[i][j] = sum;
      }
    }
    return result;
  }

  public static double[][] transpose(double[][] matrix) {
    int rows = matrix.length;
    int columns = matrix[0].length;

    double[][] transposed = new double[columns][rows];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        transposed[j][i] = matrix[i][j];
      }
    }
    return transposed;
  }

  public static double[] multiply(double[][] matrix, double[] vector) {
    int matrixRows = matrix.length;
    int matrixColumns = matrix[0].length;

    if (matrixColumns != vector.length) {
      throw new IllegalArgumentException(
          "The number of columns in the matrix must equal the number of rows in vector.");
    }

    double[] result = new double[matrixRows];
    for (int i = 0; i < matrixRows; i++) {
      double sum = 0;
      for (int j = 0; j < matrixColumns; j++) {
        sum += matrix[i][j] * vector[j];
      }
      result[i] = sum;
    }
    return result;
  }

  public static double[] multiply(double[] vector, double[][] matrix) {
    int matrixRows = matrix.length;
    int matrixColumns = matrix[0].length;

    if (vector.length != matrixRows) {
      throw new IllegalArgumentException(
          "Number of columns in the vector must match the number of rows in the matrix.");
    }

    double[] result = new double[matrixColumns];

    for (int i = 0; i < matrixColumns; i++) {
      double sum = 0;
      for (int k = 0; k < matrixRows; k++) {
        sum += vector[k] * matrix[k][i];
      }
      result[i] = sum;
    }
    return result;
  }

  public static void printMatrix(double[][] matrix) {
    int matrixRows = matrix.length;
    int matrixColumns = matrix[0].length;

    for (int i = 0; i < matrixRows; i++) {
      for (int j = 0; j < matrixColumns; j++) {
        StdOut.print(matrix[i][j] + " ");
      }
      StdOut.println();
    }
  }

  public static void printMatrix(int[][] matrix) {
    int matrixRows = matrix.length;
    int matrixColumns = matrix[0].length;

    for (int i = 0; i < matrixRows; i++) {
      for (int j = 0; j < matrixColumns; j++) {
        StdOut.print(matrix[i][j] + " ");
      }
      StdOut.println();
    }
  }
}
