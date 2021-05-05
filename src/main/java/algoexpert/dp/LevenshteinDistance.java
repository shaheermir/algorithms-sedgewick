package algoexpert.dp;

import edu.princeton.cs.algs4.StdOut;

public class LevenshteinDistance {
  public static int levenshteinDistance(String s1, String s2) {
    int[][] distances = new int[s1.length() + 1][s2.length() + 1];

    for (int i = 0; i < distances.length; i++) distances[i][0] = i;
    for (int i = 0; i < distances[0].length; i++) distances[0][i] = i;

    for (int i = 1; i < distances.length; i++) {
      for (int j = 1; j < distances[0].length; j++) {
        char a = s1.charAt(i - 1);
        char b = s2.charAt(j - 1);

        if (a == b) {
          distances[i][j] = distances[i - 1][j - 1];
        } else {
          int replace = distances[i - 1][j - 1];
          int delete = distances[i - 1][j];
          int insert = distances[i][j - 1];

          distances[i][j] = 1 + Math.min(replace, Math.min(delete, insert));
        }
      }
    }

    print(distances);
    StdOut.println();
    return distances[s1.length()][s2.length()];
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
    String s1 = "abc";
    String s2 = "yabd";
    StdOut.println(levenshteinDistance(s1, s2) + " Expected 2");
  }
}
