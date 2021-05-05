package chapter3.section2;

import chapter3.section1.SymbolTable;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class BinarySearchTree<Key extends Comparable<Key>, Value>
    implements SymbolTable<Key, Value> {

  public class Node {
    Key key;
    Value value;
    Node left;
    Node right;
    int size;

    public Node(Key key, Value value, int size) {
      this.key = key;
      this.value = value;
      this.size = size;
    }
  }

  private Node root;

  public int size() {
    return size(root);
  }

  private int size(Node node) {
    if (node == null) return 0;
    return node.size;
  }

  public boolean isEmpty() {
    return size(root) == 0;
  }

  @Override
  public Value get(Key key) {
    return get(root, key);
  }

  private Value get(Node node, Key key) {
    if (node == null || key == null) return null;

    int comparison = key.compareTo(node.key);
    if (comparison < 0) return get(node.left, key);
    else if (comparison > 0) return get(node.right, key);
    else return node.value;
  }

  @Override
  public boolean contains(Key key) {
    return get(key) != null;
  }

  public Key min() {
    if (root == null) throw new NoSuchElementException("BST is empty");
    return min(root).key;
  }

  public Key max() {
    if (root == null) throw new NoSuchElementException("BST is empty");
    return max(root).key;
  }

  private Node min(Node node) {
    if (node.left == null) return node;
    return min(node.left);
  }

  private Node max(Node node) {
    if (node.right == null) return node;
    return max(node.right);
  }

  @Override
  public void put(Key key, Value value) {
    if (key == null) return;
    if (value == null) {
      delete(key);
      return;
    }

    root = put(root, key, value);
  }

  private Node put(Node node, Key key, Value value) {
    if (node == null) return new Node(key, value, 1);

    int comparison = key.compareTo(node.key);

    if (comparison < 0) {
      node.left = put(node.left, key, value);
    } else if (comparison > 0) {
      node.right = put(node.right, key, value);
    } else {
      node.value = value;
    }

    node.size = size(node.left) + 1 + size(node.right);
    return node;
  }

  public Key floor(Key key) {
    if (key == null) throw new IllegalArgumentException("Key cannot be null");

    Node node = floor(root, key);
    if (node == null) return null;
    return node.key;
  }

  private Node floor(Node node, Key key) {
    if (node == null) return null;

    int comparison = key.compareTo(node.key);

    if (comparison == 0) {
      return node;
    } else if (comparison < 0) {
      return floor(node, key);
    } else {
      Node rightNode = floor(node.right, key);
      if (rightNode != null) return rightNode;
      return node;
    }
  }

  public Key ceiling(Key key) {
    if (key == null) throw new IllegalArgumentException("Key cannot be null");

    Node node = ceiling(root, key);
    if (node == null) return null;
    return node.key;
  }

  private Node ceiling(Node node, Key key) {
    if (node == null) return null;

    int comparison = key.compareTo(node.key);

    if (comparison == 0) {
      return node;
    } else if (comparison > 0) {
      return ceiling(node.right, key);
    } else {
      Node leftNode = ceiling(node.left, key);
      if (leftNode != null) return leftNode;
      return node;
    }
  }

  public int rank(Key key) {
    return rank(root, key);
  }

  private int rank(Node node, Key key) {
    if (node == null) return 0;
    int comparison = key.compareTo(node.key);

    if (comparison < 0) {
      return rank(node.left, key);
    } else if (comparison > 0) {
      return size(node.left) + 1 + rank(node.right, key);
    } else {
      return size(node.left);
    }
  }

  public Key select(int index) {
    if (index < 0 || index >= size()) {
      throw new IllegalArgumentException("Index out of bounds");
    }

    return select(root, index).key;
  }

  private Node select(Node node, int index) {
    if (node == null) return null;

    int leftSubtreeSize = size(node.left);

    if (leftSubtreeSize == index) return node;
    else if (leftSubtreeSize > index) return select(node.left, index);
    else return select(node.right, index - 1 - leftSubtreeSize);
  }

  public void deleteMin() {
    if (isEmpty()) return;
    root = deleteMin(root);
  }

  private Node deleteMin(Node node) {
    if (node.left == null) return node.right;

    node.left = deleteMin(node.left);
    node.size = size(node.left) + 1 + size(node.right);
    return node;
  }

  public void deleteMax() {
    if (isEmpty()) return;
    root = deleteMax(root);
  }

  private Node deleteMax(Node node) {
    if (node.right == null) return node.left;

    node.right = deleteMax(node.right);
    node.size = size(node.left) + 1 + size(node.right);
    return node;
  }

  @Override
  public void delete(Key key) {
    if (key == null) return;
    root = delete(root, key);
  }

  private Node delete(Node node, Key key) {
    if (node == null) return null;

    int comparison = key.compareTo(node.key);

    if (comparison < 0) delete(node.left, key);
    else if (comparison > 0) delete(node.right, key);
    else {
      if (node.left == null) return node.right;
      if (node.right == null) return node.left;

      Node toBeDeleted = node;
      node = min(node.right);
      node.right = deleteMin(toBeDeleted.right);
      node.left = toBeDeleted.left;
    }
    node.size = size(node.left) + 1 + size(node.right);
    return node;
  }

  @Override
  public Iterable<Key> keys() {
    return keys(min(), max());
  }

  public Iterable<Key> keys(Key low, Key high) {
    if (low == null || high == null) throw new IllegalArgumentException("Key cannot be null");
    Queue<Key> q = new Queue<>();
    keys(root, q, low, high);
    return q;
  }

  private void keys(Node node, Queue<Key> q, Key low, Key high) {
    if (node == null) return;

    int lowComparison = low.compareTo(node.key);
    int highComparison = high.compareTo(node.key);

    if (lowComparison < 0) keys(node.left, q, low, high);

    if (lowComparison <= 0 && highComparison >= 0) q.enqueue(node.key);

    if (highComparison > 0) keys(node.right, q, low, high);
  }

  public static void main(String[] args) {
    BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>();
    tree.put(15, 15);
    tree.put(10, 10);
    tree.put(20, 20);
    tree.put(8, 8);
    tree.put(12, 12);
    tree.put(16, 16);
    tree.put(25, 25);
    tree.put(13, 13);
    tree.put(14, 14);
    tree.put(7, 7);
    tree.put(11, 11);

    for (Integer i : tree.keys(5, 16)) StdOut.println(i);
  }
}
