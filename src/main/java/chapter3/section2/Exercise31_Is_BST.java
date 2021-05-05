package chapter3.section2;

import edu.princeton.cs.algs4.StdOut;

public class Exercise31_Is_BST<Key extends Comparable<Key>, Value> {

  public boolean isBST(BinarySearchTree<Key, Value>.Node root) {
    return isBST(root, null, null);
  }

  public boolean isBST(
      BinarySearchTree<Key, Value>.Node node, Comparable<Key> min, Comparable<Key> max) {

    if (node == null) return true;

    if (min != null && min.compareTo(node.key) >= 0) return false;
    if (max != null && max.compareTo(node.key) <= 0) return false;

    return isBST(node.left, min, node.key) && isBST(node.right, node.key, max);
  }

  public static void main(String[] args) {
    BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>();

    BinarySearchTree<Integer, Integer>.Node root = tree.new Node(5, 5, 1);
    root.left = tree.new Node(4, 4, 1);
    root.right = tree.new Node(5, 6, 1);

    Exercise31_Is_BST<Integer, Integer> tester = new Exercise31_Is_BST<>();
    StdOut.println(tester.isBST(root));
  }
}
