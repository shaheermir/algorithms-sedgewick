package chapter3.section4;

import edu.princeton.cs.algs4.StdOut;

public class LinearProbingHashST<Key, Value> {
  private int size;
  private int M;
  private Key[] keys;
  private Value[] values;

  public LinearProbingHashST(int M) {
    this.M = M;
    keys = (Key[]) new Object[M];
    values = (Value[]) new Object[M];
  }

  public LinearProbingHashST() {
    this(16);
  }

  public boolean contains(Key key) {
    return get(key) != null;
  }

  private int hash(Key key) {
    return (key.hashCode() & 0x7fffffff) % M;
  }

  private void resize(int newSize) {
    LinearProbingHashST<Key, Value> tempHashTable = new LinearProbingHashST<>(newSize);

    for (int i = 0; i < M; i++) {
      if (keys[i] != null) {
        tempHashTable.put(keys[i], values[i]);
      }
    }

    keys = tempHashTable.keys;
    values = tempHashTable.values;
    size = tempHashTable.size;
    M = tempHashTable.M;
  }

  public void put(Key key, Value value) {
    if (size == M / 2) resize(2 * M);

    //    int i;
    //    for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
    //      if (keys[i].equals(key)) {
    //        values[i] = value;
    //        return;
    //      }
    //    }
    int x = 1;
    int keyHash = hash(key);
    int i = keyHash;

    while (keys[i] != null) {
      if (keys[i].equals(key)) {
        values[i] = value;
        return;
      }

      i = (keyHash + probe(x++)) % M;
    }
    ///

    keys[i] = key;
    values[i] = value;
    size++;
  }

  public Value get(Key key) {
    for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
      if (keys[i].equals(key)) return values[i];
    }
    return null;
  }

  public void delete(Key key) {
    if (!contains(key)) return;

    int i = hash(key);
    while (!key.equals(keys[i])) {
      i = (i + 1) % M;
    }
    keys[i] = null;
    values[i] = null;

    i = (i + 1) % M;
    while (keys[i] != null) {
      Key keyToRedo = keys[i];
      Value valueToRedo = values[i];
      keys[i] = null;
      values[i] = null;
      size--;

      put(keyToRedo, valueToRedo);
      i = (i + 1) % M;
    }

    size--;
    if (size > 0 && size <= M / 8) resize(M / 2);
  }

  private int probe(int x) {
    int LINEAR_CONSTANT = 1;
    return LINEAR_CONSTANT * x;
  }

  public static void main(String[] args) {
    LinearProbingHashST<Character, Integer> hashTable = new LinearProbingHashST<>(2);

    String test = "SEARCHEXAMPLE";
    char[] c = test.toCharArray();

    for (int i = 0; i < c.length; i++) {
      hashTable.put(c[i], i);
    }

    StdOut.println(hashTable.get('S'));
    StdOut.println(hashTable.get('E'));
    StdOut.println(hashTable.get('A'));
    StdOut.println(hashTable.get('R'));
    StdOut.println(hashTable.get('C'));
    StdOut.println(hashTable.get('H'));

    StdOut.println();
    StdOut.println(hashTable.M);
    StdOut.println(hashTable.size);
  }
}
