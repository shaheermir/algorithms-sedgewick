package chapter1.section4;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

public class Exercise12 {
  public static int[] findIntersection(int[] a, int[] b) {
    ArrayList<Integer> intersection = new ArrayList<>();

    int i = 0;
    int j = 0;
    int previousMatch = Integer.MIN_VALUE;

    while (i < a.length && j < b.length) {
      if (a[i] < b[j]) i++;
      else if (a[i] > b[j]) j++;
      else {
        if (a[i] != previousMatch) {
          previousMatch = a[i];
          intersection.add(a[i]);
        }
        i++;
        j++;
      }
    }

    int[] intersectionArray = new int[intersection.size()];

    for (int n = 0; n < intersectionArray.length; n++) {
      intersectionArray[n] = intersection.get(n);
    }

    return intersectionArray;
  }

  public static void main(String[] args) {
    int[] array1 = {0, 1, 2, 2, 5, 6, 6, 8, 25, 25};
    int[] array2 = {-2, 0, 1, 2, 2, 2, 3, 4, 5, 10, 20, 25, 25};

    StdOut.print("Elements: ");
    StdOut.println(Arrays.toString(findIntersection(array1, array2)));
    StdOut.println("\nExpected: 0 1 2 5 25");
  }
}
