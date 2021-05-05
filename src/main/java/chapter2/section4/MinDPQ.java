package chapter2.section4;

import edu.princeton.cs.algs4.StdOut;

public class MinDPQ<T extends Comparable<T>> {
  private T[] pq;
  private int size;
  private int d;

  private MinDPQ(int degree, int capacity) {
    d = Math.max(2, degree);
    capacity = Math.max(d, capacity);
    pq = (T[]) new Comparable[capacity];
  }

  private int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void insert(T item) {
    if (size == pq.length) throw new RuntimeException("PQ is full");
    pq[size++] = item;
    swim(size - 1);
  }

  public T delMin() {
    if (isEmpty()) return null;
    T minVal = pq[0];
    swap(0, size - 1);
    pq[size - 1] = null;
    size--;
    sink(0);
    return minVal;
  }

  private void swap(int i, int j) {
    T temp = pq[i];
    pq[i] = pq[j];
    pq[j] = temp;
  }

  private void swim(int k) {
    while (k > 0) {
      int parent = getParentIndex(k);
      if (greater(k, parent)) break;
      swap(k, parent);
      k = parent;
    }
  }

  private void sink(int k) {
    while (true) {
      // extra overhead in terms of memory, should b pretty easy to get around this, but
      // i was just too lazy
      int[] childIndices = getChildIndices(k);
      int child = childIndices[0];

      for (int childIndex : childIndices) {
        if (childIndex < size && !greater(childIndex, child)) child = childIndex;
      }

      if (child >= size || greater(child, k)) break;
      swap(k, child);
      k = child;
    }
  }

  private int[] getChildIndices(int parentIndex) {
    int[] childIndices = new int[d];
    for (int i = 1; i <= d; i++) {
      childIndices[i - 1] = (parentIndex * d) + i;
    }
    return childIndices;
  }

  private int getParentIndex(int childIndex) {
    return (childIndex - 1) / d;
  }

  private boolean greater(int i, int j) {
    return pq[i].compareTo(pq[j]) >= 0;
  }

  public static void main(String[] args) {
    MinDPQ<Integer> pq = new MinDPQ<>(2, 20);
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
