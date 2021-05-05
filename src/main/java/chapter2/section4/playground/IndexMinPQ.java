package chapter2.section4.playground;

import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class IndexMinPQ<T extends Comparable<T>> {
  private int size;
  private T[] items;
  private int[] keys;
  private int[] pm; // position map array - maps keys to their indices in the keys array

  public IndexMinPQ(int capacity) {
    items = (T[]) new Comparable[capacity + 1];
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

  public T delMin() {
    if (isEmpty()) return null;
    int keyToBeRemoved = keys[1];
    return delKey(keyToBeRemoved);
  }

  public void update(int key, T item) {
    if (!contains(key)) throw new NoSuchElementException("Unable to find any item with key " + key);

    items[key] = item;
    int indexToHeapify = pm[key];
    sink(indexToHeapify);
    swim(indexToHeapify);
  }

  public T delKey(int key) {
    if (!contains(key)) return null;

    int indexToBeRemoved = pm[key];
    T itemToBeRemoved = items[key];

    swap(indexToBeRemoved, size--);

    sink(indexToBeRemoved);
    swim(indexToBeRemoved);

    items[key] = null;
    keys[size + 1] = -1; // not really needed, but nice to restore things back to initial state.
    pm[key] = -1;

    return itemToBeRemoved;
  }

  public boolean contains(int key) {
    return pm[key] != -1;
  }

  public T valueOf(int key) {
    if (!contains(key)) return null;
    return items[key];
  }

  public void insert(int key, T item) {
    if (contains(key)) throw new IllegalArgumentException("Key " + key + " already exists");

    keys[++size] = key;
    pm[key] = size;
    items[key] = item;
    swim(size);
  }

  private void swim(int k) {
    while (k > 1) {
      int parentIndex = k / 2;
      if (greater(k, parentIndex)) break;
      swap(k, parentIndex);
      k = parentIndex;
    }
  }

  public void sink(int k) {
    while (true) {
      int left = (2 * k);
      int right = (2 * k) + 1;
      int smallerChild = left;

      if (right <= size && !greater(right, left)) smallerChild = right;

      if (smallerChild > size || greater(smallerChild, k)) break;

      swap(k, smallerChild);
      k = smallerChild;
    }
  }

  private void swap(int i, int j) {
    int temp = keys[i];
    keys[i] = keys[j];
    keys[j] = temp;

    pm[keys[i]] = i;
    pm[keys[j]] = j;
  }

  private boolean greater(int i, int j) {
    return items[keys[i]].compareTo(items[keys[j]]) >= 0;
  }

  public static void main(String[] args) {
    IndexMinPQ<Integer> pq = new IndexMinPQ<>(6);

    pq.insert(1, 2);
    pq.insert(2, 10);
    pq.insert(3, 4);
    pq.insert(6, 7);
    pq.insert(4, 1);
    pq.insert(5, 1);

    StdOut.println();
    StdOut.println("Max value: " + pq.delMin() + " - Expected: 1");

    pq.update(5, -1);

    StdOut.println("Max value: " + pq.delMin() + " - Expected: -1");
    StdOut.println("Max value: " + pq.delMin() + " - Expected: 2");
    StdOut.println("Max value: " + pq.delMin() + " - Expected: 4");
    StdOut.println("Deleting Key 6: " + pq.delKey(6) + " - Expected: 7");
    StdOut.println("Max value: " + pq.delMin() + " - Expected: 10");
  }
}
