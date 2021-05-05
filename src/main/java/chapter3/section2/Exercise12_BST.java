package chapter3.section2;

public class Exercise12_BST<Key extends Comparable<Key>, Value> {
  private class Node {
    Key key;
    Value value;

    Node left;
    Node right;

    Node(Key key, Value value) {
      this.key = key;
      this.value = value;
    }
  }

  private int size;
  private Node root;

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public Value get(Key key) {
    return get(root, key);
  }

  private Value get(Node node, Key key) {
    if (node == null) return null;
    int comparison = key.compareTo(node.key);

    if (comparison < 0) return get(node.left, key);
    else if (comparison > 0) return get(node.right, key);
    return node.value;
  }

  public boolean contains(Key key) {
    return get(key) != null;
  }

  public Key min() {
    if (root == null) return null;
    return min(root).key;
  }

  private Node min(Node node) {
    if (node.left == null) return node;
    return min(node.left);
  }

  public Key max() {
    if (root == null) return null;
    return max(root).key;
  }

  private Node max(Node node) {
    if (node.right == null) return node;
    return max(node.right);
  }

  public void put(Key key, Value value) {
    if (key == null) throw new IllegalArgumentException("Key cannot be nu");

    root = put(root, key, value);
  }

  private Node put(Node node, Key key, Value value) {
    if (node == null) {
      size++;
      return new Node(key, value);
    }

    int comparison = key.compareTo(node.key);

    if (comparison < 0) node.left = put(node.left, key, value);
    else if (comparison > 0) node.right = put(node.right, key, value);
    else node.value = value;

    return node;
  }

  public void deleteMin() {
    if (root == null) return;
    root = deleteMin(root);
  }

  private Node deleteMin(Node node) {
    if (node == null) return null;

    if (node.left == null) {
      size--;
      return node.right;
    }

    node.left = deleteMin(node.left);
    return node;
  }

  public void deleteMax() {
    if (root == null) return;
    root = deleteMax(root);
  }

  public Node deleteMax(Node node) {
    if (node == null) return null;
    if (node.right == null) {
      size--;
      return node.left;
    }

    node.right = deleteMax(node.right);
    return node;
  }

  public void delete(Key key) {
    if (key == null) throw new IllegalArgumentException("Key cannot be null");
    root = delete(root, key);
  }

  public Node delete(Node node, Key key) {
    if (node == null) return null;

    int comparison = key.compareTo(node.key);

    if (comparison < 0) {
      node.left = delete(node.left, key);
    } else if (comparison > 0) {
      node.right = delete(node.right, key);
    } else {
      size--;

      if (node.left == null) return node.right;
      if (node.right == null) return node.left;

      Node toBeDeleted = node;
      node = min(node.right);
      node.right = deleteMin(toBeDeleted.right);
      node.left = toBeDeleted.left;
    }
    return node;
  }
}
