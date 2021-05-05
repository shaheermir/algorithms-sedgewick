package chapter2.section4.playground;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MaxPQ<T extends Comparable<T>> {
  private T[] heap;
  private int size;

  public MaxPQ(int capacity) {
    this.heap = (T[]) new Comparable[capacity + 1];
  }

  public MaxPQ(T[] a) {
    size = a.length;
    heap = (T[]) new Comparable[a.length + 1];

    for (int i = 0; i < a.length; i++) heap[i + 1] = a[i];

    for (int k = size / 2; k >= 1; k--) {
      sink(k);
    }
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean contains(T val) {
    return indexOf(val) != -1;
  }

  public void insert(T item) {
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

    return maxValue;
  }

  // O(log(n))
  public T removeAt(int i) {
    i++;
    if (isEmpty() || i < 1 || i > size) {
      return null;
    }

    T value = heap[i];
    if (i == size) {
      size--;
      return value;
    }

    swap(i, size);
    heap[size] = null;
    size--;

    T valueToBeHeapified = heap[i];
    sink(i);
    if (heap[i] == valueToBeHeapified) swim(i);

    return value;
  }

  // O(n)
  public boolean remove(T val) {
    if (val == null) return false;
    int indexToBeRemoved = indexOf(val);
    if (indexToBeRemoved != -1) {
      // removeAt does i++ to account for 1 indexing, so we counter that here
      removeAt(indexToBeRemoved - 1);
      return true;
    }
    return false;
  }

  private int indexOf(T val) {
    for (int i = 1; i <= size; i++) {
      if (heap[i].compareTo(val) == 0) return i;
    }
    return -1;
  }

  private void sink(int k) {
    while (true) {
      int leftChild = 2 * k;
      int rightChild = (2 * k) + 1;
      int largerChild = leftChild;

      if (rightChild <= size && !less(rightChild, leftChild)) largerChild = rightChild;

      if (leftChild > size || greater(k, largerChild)) break;

      swap(k, largerChild);
      k = largerChild;
    }
  }

  private void swim(int k) {
    while (k > 1) {
      int parentIndex = k / 2;
      if (less(parentIndex, k)) {
        swap(k, parentIndex);
        k = parentIndex;
      } else {
        break;
      }
    }
  }

  private void swap(int i, int j) {
    T temp = heap[i];
    heap[i] = heap[j];
    heap[j] = temp;
  }

  private boolean less(int i, int j) {
    return heap[i].compareTo(heap[j]) <= 0;
  }

  private boolean greater(int i, int j) {
    return heap[i].compareTo(heap[j]) >= 0;
  }

  public static void main(String[] args) {
    MaxPQ<Integer> pq = new MaxPQ<>(5);
    pq.insert(2);
    pq.insert(10);
    pq.insert(4);
    pq.insert(1);
    pq.insert(99);

    StdOut.println("Max value: " + pq.delMax() + " - Expected: 99");
    StdOut.println("Max value: " + pq.delMax() + " - Expected: 10");
    StdOut.println("Max value: " + pq.delMax() + " - Expected: 4");
    StdOut.println("Max value: " + pq.delMax() + " - Expected: 2");
    StdOut.println("Max value: " + pq.delMax() + " - Expected: 1");

    StdOut.println("\nTesting Heapify");
    Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    MaxPQ<Integer> pq2 = new MaxPQ<>(a);

    StdOut.println(Arrays.toString(pq2.heap));

    Integer x = pq2.removeAt(9); // remove 2
    StdOut.println(x);

    pq2.remove(5);

    StdOut.println("Max value: " + pq2.delMax() + " - Expected: 10");
    StdOut.println("Max value: " + pq2.delMax() + " - Expected: 9");
    StdOut.println("Max value: " + pq2.delMax() + " - Expected: 8");
    StdOut.println("Max value: " + pq2.delMax() + " - Expected: 7");
    StdOut.println("Max value: " + pq2.delMax() + " - Expected: 6");
    //    StdOut.println("Max value: " + pq2.delMax() + " - Expected: 5");
    StdOut.println("Max value: " + pq2.delMax() + " - Expected: 4");
    StdOut.println("Max value: " + pq2.delMax() + " - Expected: 3");
    //    StdOut.println("Max value: " + pq2.delMax() + " - Expected: 2");
    StdOut.println("Max value: " + pq2.delMax() + " - Expected: 1");
  }
}
