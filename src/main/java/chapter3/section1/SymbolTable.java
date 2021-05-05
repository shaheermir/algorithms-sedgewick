package chapter3.section1;

public interface SymbolTable<Key, Value> {

  void put(Key key, Value value);

  Value get(Key key);

  boolean contains(Key key);

  void delete(Key key);

  Iterable<Key> keys();
}
