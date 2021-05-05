package chapter3.section4;

import edu.princeton.cs.algs4.SequentialSearchST;
import edu.princeton.cs.algs4.StdOut;

public class SeparateChainingHashTableFixedSize<Key, Value> {
  private int M;
  private SequentialSearchST<Key, Value>[] table;

  public SeparateChainingHashTableFixedSize() {
    this(997);
  }

  public SeparateChainingHashTableFixedSize(int M) {
    this.M = M;
    this.table = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
    for (int i = 0; i < M; i++) table[i] = new SequentialSearchST<>();
  }

  private int hash(Key key) {
    return (key.hashCode() & 0x7fffffff) % M;
  }

  public Value get(Key key) {
    int index = hash(key);
    return table[index].get(key);
  }

  public void put(Key key, Value value) {
    int index = hash(key);
    table[index].put(key, value);
  }

  public void delete(Key key) {
    int index = hash(key);
    table[index].delete(key);
  }

  public static void main(String[] args) {
    SeparateChainingHashTableFixedSize<String, Integer> hashTable =
        new SeparateChainingHashTableFixedSize<>();

    hashTable.put("Shaheer", 27);
    hashTable.put("Umais", 25);

    StdOut.println(hashTable.get("Shaheer"));
    StdOut.println(hashTable.get("Umais"));
    StdOut.println(hashTable.get("NonExistentKey"));
  }
}
