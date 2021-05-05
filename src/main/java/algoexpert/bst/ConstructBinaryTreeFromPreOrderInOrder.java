package algoexpert.bst;

import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/
 *
 * <p>preoder gives us the root. look up that root in inorder array. everything to left is left
 * subtree, right is right subtree.
 */
public class ConstructBinaryTreeFromPreOrderInOrder {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  int preorderIndex;
  Map<Integer, Integer> inorderIndexMap;

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    preorderIndex = 0;
    inorderIndexMap = new HashMap<>();

    for (int i = 0; i < inorder.length; i++) {
      inorderIndexMap.put(inorder[i], i);
    }

    return arrayToTree(preorder, inorder, 0, preorder.length - 1);
  }

  /**
   * @param left - lower bound of inorder array
   * @param right - upper bound of inorder array
   */
  private TreeNode arrayToTree(int[] preorder, int[] inorder, int left, int right) {
    if (left > right) return null;

    int rootValue = preorder[preorderIndex++];
    TreeNode root = new TreeNode(rootValue);

    root.left = arrayToTree(preorder, inorder, left, inorderIndexMap.get(rootValue) - 1);
    root.right = arrayToTree(preorder, inorder, inorderIndexMap.get(rootValue) + 1, right);
    return root;
  }

  private static void printPreorder(TreeNode node) {
    if (node == null) return;
    StdOut.print(node.val + " ");
    printPreorder(node.left);
    printPreorder(node.right);
  }
}
