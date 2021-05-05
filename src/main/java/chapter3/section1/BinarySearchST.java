package chapter3.section1;

import chapter1.section3.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class BinarySearchST<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value> {

  private int size;
  private Key[] keys;
  private Value[] values;

  public BinarySearchST() {
    int capacity = 2;
    this.keys = (Key[]) new Comparable[capacity];
    this.values = (Value[]) new Object[capacity];
  }

  public BinarySearchST(int capacity) {
    capacity = Math.max(2, capacity);
    this.keys = (Key[]) new Comparable[capacity];
    this.values = (Value[]) new Object[capacity];
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  @Override
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

  @Override
  public Value get(Key key) {
    if (key == null) throw new IllegalArgumentException("Key cannot be null");
    if (isEmpty()) return null;

    int index = rank(key);
    if (index < size && keys[index].compareTo(key) == 0) return values[index];

    return null;
  }

  @Override
  public boolean contains(Key key) {
    return get(key) != null;
  }

  @Override
  public void delete(Key key) {
    if (key == null) throw new IllegalArgumentException("Key cannot be null");
    if (isEmpty() || !contains(key)) return;

    int rank = rank(key);
    for (int i = rank; i < size - 1; i++) {
      keys[i] = keys[i + 1];
      values[i] = values[i + 1];
    }

    keys[size - 1] = null;
    values[size - 1] = null;

    if (size > 1 && size == keys.length / 4) {
      resize(keys.length / 2);
    }
  }

  @Override
  public Iterable<Key> keys() {
    return keys(min(), max());
  }

  // Returns the number of keys smaller than the given key.
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

  public Key min() {
    if (isEmpty()) throw new NoSuchElementException("Empty symbol table");
    return keys[0];
  }

  public Key max() {
    if (isEmpty()) throw new NoSuchElementException("Empty symbol table");
    return keys[size - 1];
  }

  public void deleteMin() {
    delete(min());
  }

  public void deleteMax() {
    delete(max());
  }

  public Key select(int k) {
    if (isEmpty() || k >= size)
      throw new IllegalArgumentException("Index " + k + " is higher than size");

    return keys[k];
  }

  public Key ceiling(Key key) {
    int rank = rank(key);
    if (rank == size) return null;
    return keys[rank];
  }

  public Key floor(Key key) {
    if (contains(key)) return key;
    int rank = rank(key);
    if (rank == 0) return null;
    return keys[rank - 1];
  }

  public int size(Key low, Key high) {
    if (low == null || high == null) throw new IllegalArgumentException("Key cannot be null");
    if (high.compareTo(low) < 0) return 0;

    if (contains(high)) return rank(high) - rank(low) + 1;
    return rank(high) - rank(low);
  }

  private void resize(int newSize) {
    Key[] tempKeys = (Key[]) new Comparable[newSize];
    Value[] tempValues = (Value[]) new Object[newSize];

    System.arraycopy(keys, 0, tempKeys, 0, size);
    System.arraycopy(values, 0, tempValues, 0, size);

    keys = tempKeys;
    values = tempValues;
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

    StdOut.println();
    StdOut.println("Rank A: " + st.rank("A"));
    StdOut.println("Rank B: " + st.rank("B"));
    StdOut.println("Rank C: " + st.rank("C"));

    StdOut.println();
    StdOut.println("Floor C: " + st.floor("C"));
    StdOut.println("Ceiling C: " + st.ceiling("C"));

    StdOut.println();
    StdOut.println("Rank D: " + st.rank("D"));
    StdOut.println("Floor D: " + st.floor("D"));
    StdOut.println("Ceiling D: " + st.ceiling("D"));

    StdOut.println();
    StdOut.println("Size from A to X: " + st.size("A", "X"));
  }
}
