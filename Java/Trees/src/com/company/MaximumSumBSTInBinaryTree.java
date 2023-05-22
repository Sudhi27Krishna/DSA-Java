// Leetcode link => https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/description/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTNode{
    boolean isBST;
    int max_val;
    int min_val;
    int sum;

    BSTNode(boolean isBST, int max_val, int min_val, int sum){
        this.isBST = isBST;
        this.max_val = max_val;
        this.min_val = min_val;
        this.sum = sum;
    }
}
class MaximumSumBSTInBinaryTree {
    int maxSum = 0;
    int MAX = Integer.MIN_VALUE;
    int MIN = Integer.MAX_VALUE;
    public int maxSumBST(TreeNode root) {
        fun(root);
        return maxSum;
    }

    private BSTNode fun(TreeNode root){
        if(root == null) return new BSTNode(true, MAX, MIN, 0);

        BSTNode leftChild = fun(root.left);
        BSTNode rightChild = fun(root.right);
        BSTNode rootNode;
        if(leftChild.isBST && rightChild.isBST && leftChild.max_val < root.val &&
        root.val < rightChild.min_val){
            rootNode = new BSTNode(
                true,
                Math.max(root.val, rightChild.max_val),
                Math.min(root.val, leftChild.min_val),
                leftChild.sum + rightChild.sum + root.val
            );
        }
        else{
            rootNode = new BSTNode(
                false,
                Math.max(root.val, rightChild.max_val),
                Math.min(root.val, leftChild.min_val),
                Math.max(leftChild.sum, rightChild.sum)
            );
        }

        maxSum = Math.max(maxSum, rootNode.sum);
        return rootNode;
    }
}
