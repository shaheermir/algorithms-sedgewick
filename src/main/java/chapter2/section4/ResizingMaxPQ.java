package chapter2.section4;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ResizingMaxPQ<T extends Comparable<T>> {
  private T[] heap;
  private int size;

  public ResizingMaxPQ() {
    heap = (T[]) new Comparable[2];
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void insert(T item) {
    if (size == heap.length - 1) resize(heap.length * 2);
    heap[++size] = item;
    swim(size);
  }

  public T delMax() {
    if (isEmpty()) throw new NoSuchElementException("PQ is empty.");

    T maxValue = heap[1];
    swap(1, size);
    heap[size] = null;
    size--;
    sink(1);

    if (size == heap.length / 4) {
      resize(heap.length / 2);
    }

    return maxValue;
  }

  private void swim(int k) {
    while (k > 1) {
      int parent = k / 2;
      if (less(k, parent)) break;
      swap(k, parent);
      k = parent;
    }
  }

  public void sink(int k) {
    while (true) {
      int left = k * 2;
      int right = (k * 2) + 1;
      int largerChild = left;

      if (right <= size && !less(right, left)) largerChild = right;

      if (largerChild > size || less(largerChild, k)) break;

      swap(k, largerChild);
      k = largerChild;
    }
  }

  private boolean less(int i, int j) {
    return heap[i].compareTo(heap[j]) <= 0;
  }

  private boolean greater(int i, int j) {
    return heap[i].compareTo(heap[j]) >= 0;
  }

  private void swap(int i, int j) {
    T temp = heap[i];
    heap[i] = heap[j];
    heap[j] = temp;
  }

  private void resize(int n) {
    T[] a = (T[]) new Comparable[n];
    //    StdOut.println(Arrays.toString(heap));
    for (int i = 1; i <= size; i++) {
      //      StdOut.println(i);
      a[i] = heap[i];
    }
    //    System.arraycopy(heap, 1, a, 1, size);
    heap = a;
  }

  public static void main(String[] args) {
    ResizingMaxPQ<Integer> pq = new ResizingMaxPQ<>();
    pq.insert(10);
    pq.insert(2);
    pq.insert(4);
    pq.insert(1);
    pq.insert(99);

    StdOut.println("Max value: " + pq.delMax() + " - Expected: 99");
    StdOut.println("Max value: " + pq.delMax() + " - Expected: 10");
    StdOut.println("Max value: " + pq.delMax() + " - Expected: 4");
    StdOut.println("Max value: " + pq.delMax() + " - Expected: 2");
    StdOut.println("Max value: " + pq.delMax() + " - Expected: 1");

    StdOut.println();
    StdOut.println(Arrays.toString(pq.heap));

    pq.insert(10);
    pq.insert(2);
    pq.insert(4);
    pq.insert(1);
    pq.insert(99);

    StdOut.println();
    StdOut.println("Max value: " + pq.delMax() + " - Expected: 99");
    StdOut.println("Max value: " + pq.delMax() + " - Expected: 10");
    StdOut.println("Max value: " + pq.delMax() + " - Expected: 4");
    StdOut.println("Max value: " + pq.delMax() + " - Expected: 2");
    StdOut.println("Max value: " + pq.delMax() + " - Expected: 1");

    StdOut.println();
    StdOut.println(Arrays.toString(pq.heap));
  }
}
