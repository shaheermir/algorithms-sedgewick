package chapter2.practice;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Merge {
  public static void sort(int[] a) {
    int[] aux = new int[a.length];
    mergeSort(a, aux, 0, a.length - 1);
  }

  private static void mergeSort(int[] a, int[] aux, int left, int right) {
    if (left >= right) return;

    int middle = (left + right) / 2;

    mergeSort(a, aux, left, middle);
    mergeSort(a, aux, middle + 1, right);

    merge(a, aux, left, middle, right);
  }

  private static void merge(int[] a, int[] aux, int left, int mid, int right) {
    for (int i = left; i <= right; i++) aux[i] = a[i];

    int leftIndex = left;
    int rightIndex = mid + 1;
    int arrayIndex = left;

    while (leftIndex <= mid && rightIndex <= right) {
      if (aux[leftIndex] <= aux[rightIndex]) {
        a[arrayIndex] = aux[leftIndex];
        leftIndex++;
      } else {
        a[arrayIndex] = aux[rightIndex];
        rightIndex++;
      }
      arrayIndex++;
    }

    while (leftIndex <= mid) {
      a[arrayIndex] = aux[leftIndex];
      leftIndex++;
      arrayIndex++;
    }
    while (rightIndex <= right) {
      a[arrayIndex] = aux[rightIndex];
      rightIndex++;
      arrayIndex++;
    }
  }

  public static boolean isSorted(int[] a) {
    for (int i = 1; i < a.length; i++) {
      if (a[i] < a[i - 1]) return false;
    }
    return true;
  }

  public static void main(String[] args) {

    int[] a = {10, 9, 8, 8, 7, 6, 3, 3, -1, 2, 1, 18, -3, 6, 11};
    sort(a);
    assert isSorted(a);
    StdOut.println(Arrays.toString(a));

    int[] b = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    sort(b);
    assert isSorted(b);
    StdOut.println(Arrays.toString(b));

    int[] c = {1, 2, 3, 4, 5, 6, 8, 7};
    sort(c);
    assert isSorted(c);
    StdOut.println(Arrays.toString(c));
  }
}
