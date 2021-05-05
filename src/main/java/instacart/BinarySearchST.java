package instacart;

import chapter1.section3.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
  private int size;
  private Key[] keys;
  private Value[] values;

  public BinarySearchST() {
    int capacity = 2;
    this.keys = (Key[]) new Comparable[capacity];
    this.values = (Value[]) new Object[capacity];
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public Value get(Key key) {
    if (key == null) throw new IllegalArgumentException("Key cannot be null");
    if (isEmpty()) return null;

    int rank = rank(key);
    if (rank < size && keys[rank].compareTo(key) == 0) {
      return values[rank];
    }
    return null;
  }

  public boolean contains(Key key) {
    return get(key) != null;
  }

  public void put(Key key, Value value) {
    if (key == null) throw new IllegalArgumentException("Key cannot be null");
    if (value == null) {
      delete(key);
      return;
    }

    int keyIndex = rank(key);
    if (keyIndex < size && keys[keyIndex].compareTo(key) == 0) {
      values[keyIndex] = value;
      return;
    }

    if (size == keys.length) resize(keys.length * 2);

    int rank = keyIndex;
    for (int i = size; i > rank; i--) {
      keys[i] = keys[i - 1];
      values[i] = values[i - 1];
    }

    keys[rank] = key;
    values[rank] = value;
    size++;
  }

  public int rank(Key key) {
    if (key == null) throw new IllegalArgumentException("Key cannot be null");
    int left = 0;
    int right = size - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      int comparison = keys[mid].compareTo(key);
      if (comparison == 0) return mid;
      else if (comparison < 0) left = mid + 1;
      else right = mid - 1;
    }

    return left;
  }

  public void delete(Key key) {
    if (isEmpty() || !contains(key)) return;

    int rank = rank(key);
    for (int i = rank; i < size; i++) {
      keys[i] = keys[i + 1];
      values[i] = values[i + 1];
    }

    keys[size - 1] = null;
    values[size - 1] = null;

    if (size > 1 && size == keys.length / 4) resize(keys.length / 2);

    size--;
  }

  private void resize(int newSize) {
    Key[] tempKeys = (Key[]) new Comparable[newSize];
    Value[] tempValues = (Value[]) new Object[newSize];

    System.arraycopy(keys, 0, tempKeys, 0, size);
    System.arraycopy(values, 0, tempValues, 0, size);

    keys = tempKeys;
    values = tempValues;
  }

  public Key min() {
    if (isEmpty()) throw new NoSuchElementException("Empty symbol table");
    return keys[0];
  }

  public Key max() {
    if (isEmpty()) throw new NoSuchElementException("Empty symbol table");
    return keys[size - 1];
  }

  public Iterable<Key> keys() {
    return keys(min(), max());
  }

  public Iterable<Key> keys(Key low, Key high) {
    if (low == null || high == null) throw new IllegalArgumentException("Key cannot be null");

    Queue<Key> q = new Queue<>();

    int rankLow = rank(low);
    int rankHigh = rank(high);

    for (int i = rankLow; i < rankHigh; i++) {
      q.enqueue(keys[i]);
    }

    if (contains(high)) q.enqueue(keys[rankHigh]);
    return q;
  }

  public static void main(String[] args) {
    String str = "S E A R C H E X A M P L E";
    String[] a = str.split(" ", 0);

    BinarySearchST<String, Integer> st = new BinarySearchST<>();

    StdOut.println(str);
    StdOut.println("Number of distinct letters: 10");

    for (int i = 0; i < a.length; i++) {
      st.put(a[i], i);
    }

    for (String key : st.keys()) {
      StdOut.println("Key " + key + " - Value: " + st.get(key));
    }
  }
}
