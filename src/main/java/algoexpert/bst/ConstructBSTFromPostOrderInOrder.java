package algoexpert.bst;

import java.util.HashMap;
import java.util.Map;

public class ConstructBSTFromPostOrderInOrder {

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

  int postorderIndex;
  Map<Integer, Integer> inorderIndexMap;

  public TreeNode buildTree(int[] postorder, int[] inorder) {
    postorderIndex = postorder.length - 1;
    inorderIndexMap = new HashMap<>();

    for (int i = 0; i < inorder.length; i++) {
      inorderIndexMap.put(inorder[i], i);
    }

    return arrayToTree(postorder, inorder, 0, postorder.length - 1);
  }

  /**
   * @param left - lower bound of inorder array
   * @param right - upper bound of inorder array
   */
  private TreeNode arrayToTree(int[] preorder, int[] inorder, int left, int right) {
    if (left > right) return null;

    int rootValue = preorder[postorderIndex--];
    TreeNode root = new TreeNode(rootValue);

    root.left = arrayToTree(preorder, inorder, left, inorderIndexMap.get(rootValue) - 1);
    root.right = arrayToTree(preorder, inorder, inorderIndexMap.get(rootValue) + 1, right);
    return root;
  }
}
