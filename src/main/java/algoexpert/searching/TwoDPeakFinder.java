package algoexpert.searching;

public class TwoDPeakFinder {
  public static int findPeak(int[][] a) {
    int n = a[0].length - 1;

    int leftCol = 0;
    int rightCol = a[0].length - 1;

    while (leftCol <= rightCol) {
      int midCol = (leftCol + rightCol) / 2;

      int maxIndex = findMaxInColumn(a, midCol);

      if (midCol > 0 && a[maxIndex][midCol] <= a[maxIndex][midCol - 1]) {
        rightCol = midCol - 1;
      } else if (midCol < n && a[maxIndex][midCol] <= a[maxIndex][midCol + 1]) {
        leftCol = midCol + 1;
      } else {
        return a[maxIndex][midCol];
      }
    }

    return -1;
  }

  // returns the row index of the max for the column in question
  private static int findMaxInColumn(int[][] a, int col) {
    int maxIndex = 0;
    int maxVal = a[0][col];

    for (int i = 0; i < a.length; i++)
      if (a[i][col] > maxVal) {
        maxVal = a[i][col];
        maxIndex = i;
      }

    return maxIndex;
  }

  public static void main(String[] args) {
    int[][] a = {
      {10, 8, 10, 10},
      {14, 13, 12, 11},
      {15, 9, 11, 21},
      {16, 17, 19, 20}
    };

    System.out.println(findMaxInColumn(a, 3));
  }
}
