// link => https://leetcode.com/problems/leaf-similar-trees/description/

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
class Solution {
    
    ArrayList<Integer> list1 = new ArrayList<>();
    ArrayList<Integer> list2 = new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        traverse(root1, list1);
        traverse(root2, list2);

        return (list1.equals(list2));
    }

    public void traverse(TreeNode root, ArrayList<Integer> list){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            list.add(root.val);
        }

        traverse(root.left,list);
        traverse(root.right,list);
    }
}
