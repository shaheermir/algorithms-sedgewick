package chapter2.section4;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise19_HeapConstruction<T extends Comparable<T>> {
  private int size;
  private T[] pq;

  // MinPQ
  public Exercise19_HeapConstruction(T[] a) {
    size = a.length;
    pq = (T[]) new Comparable[size + 1];

    for (int i = 0; i < a.length; i++) pq[i + 1] = a[i];

    for (int k = size / 2; k >= 1; k--) {
      sink(k);
    }
  }

  public T[] getPQ() {
    return pq;
  }

  private void swap(int i, int j) {
    T temp = pq[i];
    pq[i] = pq[j];
    pq[j] = temp;
  }

  private void sink(int k) {
    while (2 * k <= size) {
      int j = 2 * k;
      if (j < size && greater(j, j + 1)) j++;

      if (!greater(k, j)) break;

      swap(k, j);
      k = j;
    }
  }

  private boolean greater(int i, int j) {
    return ((Comparable<T>) pq[i]).compareTo(pq[j]) > 0;
  }

  public static void main(String[] args) {
    Integer[] a = {10, 9, 8, 7, 6, 5, 4, 4, 3, 2, 1};
    Exercise19_HeapConstruction<Integer> pq = new Exercise19_HeapConstruction<>(a);

    Comparable<Integer>[] sortedPQ = pq.getPQ();
    StdOut.println(Arrays.toString(sortedPQ));
  }
}
