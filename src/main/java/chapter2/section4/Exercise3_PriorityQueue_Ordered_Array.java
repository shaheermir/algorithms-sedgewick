package chapter2.section4;

import edu.princeton.cs.algs4.StdOut;
import util.ArrayUtil;

public class Exercise3_PriorityQueue_Ordered_Array<T extends Comparable<T>> {

  private T[] pq;
  private int size;

  public Exercise3_PriorityQueue_Ordered_Array(int capactiy) {
    pq = (T[]) new Comparable[capactiy];
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void insert(T item) {
    if (size == pq.length) throw new RuntimeException("PQ is full");

    int i = size - 1;
    while (i >= 0 && ArrayUtil.less(item, pq[i])) {
      pq[i + 1] = pq[i];
      i--;
    }

    pq[i + 1] = item;
    size++;
  }

  public T delMax() {
    if (isEmpty()) {
      throw new RuntimeException("Priority queue underflow");
    }

    T maxValue = pq[size - 1];
    pq[size - 1] = null;
    size--;
    return maxValue;
  }

  public static void main(String[] args) {
    Exercise3_PriorityQueue_Ordered_Array<Integer> pq =
        new Exercise3_PriorityQueue_Ordered_Array<>(5);
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
