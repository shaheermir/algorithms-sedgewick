package chapter1.section4;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

public class Exercise12 {
  public static void main(String[] args) {
    int[] array1 = {0, 1, 2, 2, 5, 6, 6, 8, 25, 25};
    int[] array2 = {-2, 0, 1, 2, 2, 2, 3, 4, 5, 10, 20, 25, 25};

    StdOut.print("Elements: ");
    StdOut.println(Arrays.toString(findIntersection(array1, array2)));
    StdOut.println("\nExpected: 0 1 2 5 25");
  }

  public static int[] findIntersection(int[] a, int[] b) {

    int i = 0;
    int j = 0;
    ArrayList<Integer> intersection = new ArrayList<>();
    Integer previousMatch = null;

    while (i < a.length && j < b.length) {

      if (a[i] < b[j]) i++;
      else if (a[i] > b[j]) j++;
      else {
        // ensuring we don't add duplicates.
        if (previousMatch == null || previousMatch != a[i]) {
          previousMatch = a[i];
          intersection.add(a[i]);
        }
        i++;
        j++;
      }
    }

    int[] intersectionArray = new int[intersection.size()];
    for (int x = 0; x < intersection.size(); x++) intersectionArray[x] = intersection.get(x);
    return intersectionArray;
  }
}
