/**
 * Definition for a binary tree node.
 * public class FlattenBinaryTreeToLL {
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
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }
  
    // Using Stack
    public void flatten2(TreeNode root) {
          if(root == null) return;
          Stack<TreeNode> st = new Stack<>();
          st.push(root);
          while(!st.isEmpty()){
              TreeNode cur = st.pop();
              if (cur.right != null) {
                  st.push(cur . right);
              }
              if (cur.left != null) {
                  st.push(cur.left);
              }
              if (!st.isEmpty()) {
                  cur.right = st.peek();
              }
              cur.left = null;
          }
      }

    // Using Morris Traversal
    public void flatten(TreeNode root) {
          TreeNode cur = root;
          while (cur!=null)
          {
            if(cur.left!=null)
            {
              TreeNode pre = cur.left;
              while(pre.right!=null)
              {
                pre = pre.right;
              }
              pre.right = cur.right;
              cur.right = cur.left;
              cur.left = null;
            }
            cur = cur.right;
          }
      }
}
