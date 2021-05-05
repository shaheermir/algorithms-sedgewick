package chapter2.section4;

import edu.princeton.cs.algs4.StdOut;

public class MaxPQ<T extends Comparable<T>> {
  private T[] pq;
  private int size;

  public MaxPQ(int capacity) {
    pq = (T[]) new Comparable[capacity + 1];
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void insert(T item) {
    pq[++size] = item;
    swim(size);
  }

  public T delMax() {
    T max = pq[1];
    swap(1, size);
    pq[size] = null;
    size--;
    sink(1);
    return max;
  }

  private boolean less(int i, int j) {
    return pq[i].compareTo(pq[j]) < 0;
  }

  private void swap(int i, int j) {
    T temp = pq[i];
    pq[i] = pq[j];
    pq[j] = temp;
  }

  private void swim(int k) {
    while (k > 1 && less(k / 2, k)) {
      swap(k, k / 2);
      k = k / 2;
    }
  }

  private void sink(int k) {
    while (2 * k <= size) {
      int j = 2 * k;
      if (j < size && less(j, j + 1)) j++; // find the index of the bigger child
      if (!less(k, j)) break; // break if that child is small than k node value
      swap(k, j);
      k = j;
    }
  }

  public static void main(String[] args) {
    MaxPQ<Integer> pq = new MaxPQ<>(5);
    pq.insert(2);
    pq.insert(10);
    pq.insert(4);
    pq.insert(1);
    pq.insert(1);

    StdOut.println("Max value: " + pq.delMax() + " - Expected: 10");
    StdOut.println("Max value: " + pq.delMax() + " - Expected: 4");
    StdOut.println("Max value: " + pq.delMax() + " - Expected: 2");
    StdOut.println("Max value: " + pq.delMax() + " - Expected: 1");
    StdOut.println("Max value: " + pq.delMax() + " - Expected: 1");
  }
}
