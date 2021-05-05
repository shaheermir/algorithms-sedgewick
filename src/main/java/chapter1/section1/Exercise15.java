package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise15 {
  public static int[] histogram(int[] a, int m) {
    int[] histogram = new int[m];
    for (int i = 0; i < a.length; i++) {
      int index = a[i];
      if (index < m) histogram[index]++;
    }
    return histogram;
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 4, 4};
    int[] histogramA = histogram(a, 5);

    StdOut.println("Array: " + Arrays.toString(a));
    StdOut.println("Histogram: " + Arrays.toString(histogramA));
  }
}
