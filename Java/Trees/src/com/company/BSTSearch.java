package com.company;
import java.util.*;

public class BSTSearch {
    public static void main(String[] args) {

    }
    // Search in BST
    public static TreeNode bstSearch(TreeNode root, int item){
        while(root != null && root.val != item){
            root = item < root.val ? root.left : root.right;
        }
        return root;
    }
    // Insert a node in BST
    public static TreeNode insertNode(TreeNode root, int item){
        if(root == null){
            return new TreeNode(item);
        }
        TreeNode cur = root;
        while(true){
            if(item <= cur.val){
                if(cur.left != null){
                    cur = cur.left;
                }else{
                    cur.left = new TreeNode(item);
                    break;
                }
            }else{
                if(cur.right != null){
                    cur = cur.right;
                }else{
                    cur.right = new TreeNode(item);
                    break;
                }
            }
        }
        return root;
    }
    // Delete a node in BST
    public static TreeNode deleteNode(TreeNode root, int key){
        if(root == null){
            return root;
        }
        if(root.val == key){
            return helper(root);
        }
        TreeNode dummy = root;
        while(root != null){
            if(key <= root.val){
                if(root.left != null && root.left.val == key){
                    root.left = helper(root.left);
                    break;
                }else{
                    root = root.left;
                }
            }else{
                if(root.right != null && root.right.val == key){
                    root.right = helper(root.right);
                    break;
                }else{
                    root = root.right;
                }
            }
        }
        return dummy;
    }

    private static TreeNode helper(TreeNode root) {
        if(root.left == null){
            return root.right;
        }
        if(root.right == null){
            return root.left;
        }
        TreeNode RChild = root.right;
        TreeNode lastRight = findlastRight(root.left);
        lastRight.right = RChild;

        return root.left;
    }

    private static TreeNode findlastRight(TreeNode root) {
        if(root.right == null){
            return root;
        }
        return findlastRight(root.right);
    }
// InOrder Successor
    public static TreeNode inorderSuccesor(TreeNode root, TreeNode p){
        TreeNode successor = null;
        while(root != null){
            if(p.val >= root.val){
                root = root.right;
            }else{
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }
    // InOrder Predecessor
    public static TreeNode inorderPredecesor(TreeNode root, TreeNode p){
        TreeNode predecessor = null;
        while(root != null){
            if(p.val <= root.val){
                root = root.left;
            }else{
                predecessor = root;
                root = root.right;
            }
        }
        return predecessor;
    }
}


