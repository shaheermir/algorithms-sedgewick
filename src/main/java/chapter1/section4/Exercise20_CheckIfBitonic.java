package chapter1.section4;

public class Exercise20_CheckIfBitonic {

  public static boolean checkIfBitnoic(int[] a) {

    int i, j;
    for (i = 1; i < a.length; i++) {
      if (a[i - 1] < a[i]) continue;
      if (a[i - 1] >= a[i]) break;
    }

    // loop quit at last element,
    if (i == a.length - 1) return true;
    else if (i == a.length) return false;

    for (j = i + 1; j < a.length; j++) {
      if (a[j] < a[j - 1]) continue;
      else return false;
    }

    // we reach this line if and when we find the element following a peak.
    // the ascent has been completed, now we must check for the descent.

    return true;
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5, 4, 3, 2, 1};
    int[] b = {1, 100, 99, 98, 97, 96, 95, 50, 40, 30, 20, 10};
    int[] c = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 100, 99};
    int[] d = {-3, 9, 7, 20, 17, 5, 1};
    int[] e = {1, 2, 3, 4, 5};

    System.out.println(checkIfBitnoic(a) + " Expected true");
    System.out.println(checkIfBitnoic(b) + " Expected true");
    System.out.println(checkIfBitnoic(c) + " Expected true");
    System.out.println(checkIfBitnoic(d) + " Expected false");
    System.out.println(checkIfBitnoic(e) + " Expected false");
  }
}
