package algoexpert.bst;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.List;

public class ReconstructFromPreOrderTraversal {
  int rootIndex;

  static class BST {
    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
      this.value = value;
    }
  }

  public BST reconstructBst(List<Integer> preOrderTraversalValues) {
    rootIndex = 0;
    return reconstructBSTFromRange(Integer.MIN_VALUE, Integer.MAX_VALUE, preOrderTraversalValues);
  }

  public BST reconstructBSTFromRange(int lowerBound, int upperBound, List<Integer> values) {
    if (rootIndex == values.size()) return null;

    int rootValue = values.get(rootIndex);
    if (!inRange(rootValue, lowerBound, upperBound)) return null;

    rootIndex++;
    BST left = reconstructBSTFromRange(lowerBound, rootValue, values);
    BST right = reconstructBSTFromRange(rootValue, upperBound, values);

    BST node = new BST(rootValue);
    node.left = left;
    node.right = right;
    return node;
  }

  public boolean inRange(int val, int lowerBound, int upperBound) {
    return val < upperBound && val >= lowerBound;
  }

  private static void printPreorder(BST node) {
    if (node == null) return;
    StdOut.print(node.value + " ");
    printPreorder(node.left);
    printPreorder(node.right);
  }

  public static void main(String[] args) {
    ReconstructFromPreOrderTraversal program = new ReconstructFromPreOrderTraversal();
    List<Integer> preorder = Arrays.asList(10, 4, 2, 1, 5, 17, 19, 18);
    BST root = program.reconstructBst(preorder);
    printPreorder(root);
  }
}
