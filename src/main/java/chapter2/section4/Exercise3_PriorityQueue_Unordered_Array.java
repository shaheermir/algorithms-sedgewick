package chapter2.section4;

import edu.princeton.cs.algs4.StdOut;
import util.ArrayUtil;

public class Exercise3_PriorityQueue_Unordered_Array<T extends Comparable<T>> {
  private T[] pq;
  private int size;

  public Exercise3_PriorityQueue_Unordered_Array(int capacity) {
    pq = (T[]) new Comparable[capacity];
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void insert(T item) {
    if (size == pq.length) throw new RuntimeException("PQ is full.");
    pq[size++] = item;
  }

  public T delMax() {
    if (isEmpty()) throw new RuntimeException("PQ is empty.");

    int maxValueIndex = 0;
    for (int i = 1; i < size; i++) {
      if (ArrayUtil.more(pq[i], pq[maxValueIndex])) maxValueIndex = i;
    }

    ArrayUtil.swap(pq, maxValueIndex, size - 1);

    T maxValue = pq[size - 1];
    pq[size - 1] = null;
    size--;
    return maxValue;
  }

  public static void main(String[] args) {
    Exercise3_PriorityQueue_Unordered_Array<Integer> pq =
        new Exercise3_PriorityQueue_Unordered_Array<>(5);

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
