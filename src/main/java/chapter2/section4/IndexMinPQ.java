package chapter2.section4;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class IndexMinPQ<T extends Comparable<T>> {
  int size;
  T[] values;
  int[] keys;
  int[] pm;

  public IndexMinPQ(int capacity) {
    values = (T[]) new Comparable[capacity + 1];
    keys = new int[capacity + 1];
    pm = new int[capacity + 1];

    for (int i = 1; i <= capacity; i++) pm[i] = -1;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean contains(int keyIndex) {
    return pm[keyIndex] != -1;
  }

  public void insert(int keyIndex, T value) {
    if (contains(keyIndex))
      throw new IllegalArgumentException("Index " + keyIndex + " already exists.");

    if (size == values.length - 1) return;

    size++;
    pm[keyIndex] = size;
    keys[size] = keyIndex;
    values[keyIndex] = value;

    swim(size);
  }

  public T delMin() {
    if (isEmpty()) return null;

    int keyToBeRemoved = keys[1];
    T minValue = values[keyToBeRemoved];
    deleteKey(keyToBeRemoved);

    return minValue;
  }

  public T deleteKey(int keyIndex) {
    if (!contains(keyIndex)) return null;

    T value = values[keyIndex];
    values[keyIndex] = null;

    int removedElementPosition = pm[keyIndex];
    swap(removedElementPosition, size);

    keys[size] = 0;
    size--;

    sink(removedElementPosition);
    swim(removedElementPosition);
    pm[keyIndex] = -1;

    return value;
  }

  private void swim(int k) {
    while (k > 1) {
      int parentIndex = k / 2;
      if (greater(k, parentIndex)) break;
      swap(k, parentIndex);
      k = parentIndex;
    }
  }

  private void sink(int k) {
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

  private boolean greater(int i, int j) {
    return values[keys[i]].compareTo(values[keys[j]]) >= 0;
  }

  private void swap(int i, int j) {
    int temp = keys[i];
    keys[i] = keys[j];
    keys[j] = temp;

    pm[keys[i]] = i;
    pm[keys[j]] = j;
  }

  public static void main(String[] args) {
    IndexMinPQ<Integer> pq = new IndexMinPQ<>(5);
    pq.insert(1, 2);
    pq.insert(2, 10);
    pq.insert(3, 4);
    pq.insert(4, 1);
    pq.insert(5, 1);

    StdOut.println("Values: " + Arrays.toString(pq.values));
    StdOut.println("Keys: " + Arrays.toString(pq.keys));
    StdOut.println("PM: " + Arrays.toString(pq.pm));

    StdOut.println("Max value: " + pq.delMin() + " - Expected: 1");
    StdOut.println("Max value: " + pq.delMin() + " - Expected: 1");
    StdOut.println("Max value: " + pq.delMin() + " - Expected: 2");
    StdOut.println("Max value: " + pq.delMin() + " - Expected: 4");
    StdOut.println("Max value: " + pq.delMin() + " - Expected: 10");
  }
}
