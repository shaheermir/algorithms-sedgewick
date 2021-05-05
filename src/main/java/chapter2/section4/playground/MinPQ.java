package chapter2.section4.playground;

import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class MinPQ<T extends Comparable<T>> {
  private T[] heap;
  private int size;

  public MinPQ(int capacity) {
    heap = (T[]) new Comparable[capacity + 1];
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void insert(T item) {
    heap[++size] = item;
    swim(size);
  }

  public T delMin() {
    if (isEmpty()) throw new NoSuchElementException("MinPQ is empty.");
    T minValue = heap[1];
    swap(1, size);
    heap[size] = null;
    size--;
    sink(1);
    return minValue;
  }

  public void sink(int k) {
    while (true) {
      int left = 2 * k;
      int right = (2 * k) + 1;
      int smallerChild = left;

      if (right <= size && !greater(right, left)) smallerChild = right;

      if (smallerChild > size || greater(smallerChild, k)) break;

      swap(k, smallerChild);
      k = smallerChild;
    }
  }

  public void swim(int k) {
    while (k > 1) {
      int parentIndex = k / 2;
      if (greater(k, parentIndex)) break;
      swap(k, parentIndex);
      k = parentIndex;
    }
  }

  private boolean greater(int i, int j) {
    return heap[i].compareTo(heap[j]) >= 0;
  }

  private boolean less(int i, int j) {
    return heap[i].compareTo(heap[j]) <= 0;
  }

  private void swap(int i, int j) {
    T temp = heap[i];
    heap[i] = heap[j];
    heap[j] = temp;
  }

  public static void main(String[] args) {
    MinPQ<Integer> pq = new MinPQ<>(7);
    pq.insert(2);
    pq.insert(10);
    pq.insert(4);
    pq.insert(1);
    pq.insert(99);
    pq.insert(1);
    pq.insert(7);

    //    StdOut.println(Arrays.toString(pq.heap));

    StdOut.println("Max value: " + pq.delMin() + " - Expected: 1");
    StdOut.println("Max value: " + pq.delMin() + " - Expected: 1");
    StdOut.println("Max value: " + pq.delMin() + " - Expected: 2");
    StdOut.println("Max value: " + pq.delMin() + " - Expected: 4");
    StdOut.println("Max value: " + pq.delMin() + " - Expected: 7");
    StdOut.println("Max value: " + pq.delMin() + " - Expected: 10");
    StdOut.println("Max value: " + pq.delMin() + " - Expected: 99");
  }
}
