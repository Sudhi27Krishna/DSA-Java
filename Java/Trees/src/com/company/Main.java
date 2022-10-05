package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
    }
    // In-Order Traversal (Left-Root-Right)
    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<Integer>();
        }

        ArrayList<Integer> ans = new ArrayList<Integer>(inorderTraversal(root.left));
        ans.add(root.val);
        ans.addAll(inorderTraversal(root.right));

        return ans;
    }
    //   Iterative using stack
    public static ArrayList<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (true){
            if(node != null){
                stack.push(node);
                node = node.left;
            }else{
                if(stack.isEmpty()){
                    break;
                }
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return list;
    }
    // Pre-Order Traversal (Root-Left-Right)
    public static void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
//            ArrayList<Integer> list = new ArrayList<Integer>();
//            return list;
            return new ArrayList<>();
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(root.val);
        ans.addAll(preorderTraversal(root.left));
        ans.addAll(preorderTraversal(root.right));

        return ans;
    }
//   Iterative using stack
public static ArrayList<Integer> preorderTraversal2(TreeNode root) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    if(root == null){
        return list;
    }
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
    while (!stack.isEmpty()){
        root = stack.pop();
        list.add(root.val);
        if(root.right != null){
            stack.push(root.right);
        }
        if(root.left != null){
            stack.push(root.left);
        }
    }
    return list;
}
    // Post-Order Traversal (Left-Right-Root)
    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            ArrayList<Integer> list = new ArrayList<Integer>();
            return list;
        }

        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.addAll(postorderTraversal(root.left));
        ans.addAll(postorderTraversal(root.right));
        ans.add(root.val);

        return ans;
    }
//    Iterative using two stack
public static ArrayList<Integer> postorderTraversal2(TreeNode root) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    if(root == null){
        return list;
    }
    Stack<TreeNode> stack1 = new Stack<TreeNode>();
    Stack<TreeNode> stack2 = new Stack<TreeNode>();

    stack1.push(root);
    while(!stack1.isEmpty()){
        root = stack1.pop();
        stack2.push(root);
        if(root.left != null){
            stack1.push(root.left);
        }
        if(root.right != null){
            stack1.push(root.right);
        }
    }
    while (!stack2.isEmpty()){
        list.add(stack2.pop().val);
    }
    return list;
}
//    All three traversals in one stack at the same time
public void ThreeInOne(TreeNode root){
    ArrayList<Integer> pre = new ArrayList<Integer>();
    ArrayList<Integer> in  = new ArrayList<Integer>();
    ArrayList<Integer> post = new ArrayList<Integer>();

    Stack<Pair> stack = new Stack<Pair>();
    stack.push(new Pair(root,1));

    if(root == null){
        return;
    }

    while (!stack.isEmpty()){
        Pair it = stack.pop();

        if(it.num == 1){
            pre.add(it.node.val);
            it.num++;
            stack.push(it);

            if(it.node.left != null){
                stack.push(new Pair(it.node.left,1));
            }
        }
        else if(it.num == 2){
            in.add(it.node.val);
            it.num++;
            stack.push(it);

            if(it.node.right != null){
                stack.push(new Pair(it.node.right,1));
            }
        }else{
            post.add(it.node.val);
        }
    }
}
//    Level Order Traversal
    public List<List<Integer>> levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wraplist = new LinkedList<List<Integer>>();
        if(root == null){
            return wraplist;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for (int i = 0; i < levelNum; i++) {
                if(queue.peek().left != null){
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right != null){
                    queue.offer(queue.peek().right);
                }
                subList.add(queue.poll().val);
            }
            wraplist.add(subList);
        }
        return wraplist;
    }
    // Maximum depth of a binary tree TC: O(N), SC: O(N)
    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(1 + maxDepth(root.left),1 + maxDepth(root.right));
    }
    // To check if a tree is balanced i.e. Math.abs(lh - rh) <= 1 , TC: O(N), SC: O(N)
    public static boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
    public static int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int lh = height(root.left);
        if(lh == -1) return -1;
        int rh = height(root.right);
        if(rh == -1) return -1;

        if(Math.abs(lh - rh) > 1){
            return -1;
        }

        return 1 + Math.max(rh,lh);
    }
    // Diameter of a binary tree: longest path b/w any two nodes
    public static int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        height(root,diameter);
        return diameter[0];
    }
    public static int height(TreeNode root, int[] diameter){
        if(root == null){
            return 0;
        }

        int lh = height(root.left,diameter);
        int rh = height(root.right,diameter);

        diameter[0] = Math.max(diameter[0], lh + rh);

        return 1 + Math.max(rh,lh);
    }
    // Binary Tree Maximum Path Sum
    public static int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE; // doesn't work without this. ???
        height2(root,maxSum);
        return maxSum[0];
    }
    public static int height2(TreeNode root, int[] maxSum){
        if(root == null){
            return 0;
        }

        int leftSum = Math.max(0,height2(root.left,maxSum)); // math.max 0 for neglecting negative node values
        int rightSum = Math.max(0,height2(root.right,maxSum)); // math.max 0 for neglecting negative node values

        maxSum[0] = Math.max(maxSum[0], leftSum + rightSum + root.val);  // the curve path sum

        return root.val + Math.max(leftSum, rightSum); // to choose the path
    }
    //  Same Tree
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null){
            return (p == q);
        }
        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    //
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        boolean flag = true;

        if(root == null){
            return ans;
        }

        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> sub = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if(queue.peek().left != null){
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right != null){
                    queue.offer(queue.peek().right);
                }
                if(flag){
                    sub.add(queue.poll().val);
                }else{
                    sub.add(0,queue.poll().val);
                }
            }
            flag = !flag;
            ans.add(sub);
        }
        return ans;
    }
    // Boundary traversal TC: 0(N) SC: O(N)
    public static boolean isLeaf(TreeNode root){
        return (root.left == null) && (root.right == null);
    }
    public static void leftBound(TreeNode root, ArrayList<Integer> res){
        TreeNode cur = root.left;
        while(cur != null){
            if(isLeaf(cur) == false){
                res.add(cur.val);
            }
            if(cur.left != null){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
    }
    public static void rightBound(TreeNode root, ArrayList<Integer> res){
        TreeNode cur = root.right;
        Stack<Integer> st = new Stack<>();
        while(cur != null){
            if(!isLeaf(cur)){
                st.push(cur.val);
            }
            if(cur.right != null){
                cur = cur.right;
            }else{
                cur = cur.left;
            }
        }
        while(!st.isEmpty()){
            res.add(st.pop());
        }
    }
    public static void addLeaves(TreeNode root,ArrayList<Integer> res){
        if (isLeaf(root)) {
            res.add(root.val);
            return;
        }
        if (root.left != null) addLeaves(root.left, res);
        if (root.right != null) addLeaves(root.right, res);
    }
    public static ArrayList < Integer > printBoundary(TreeNode node) {
        ArrayList < Integer > ans = new ArrayList < Integer > ();
        if (!isLeaf(node)) ans.add(node.val);
        leftBound(node, ans);
        addLeaves(node, ans);
        rightBound(node, ans);
        return ans;
    }
    // Vertical Order Traversal of a Binary Tree
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap< Integer, TreeMap< Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<Tuple>();
        q.offer(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;

            if(!map.containsKey(x)){
                map.put(x, new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.val);

            if(node.left != null){
                q.offer(new Tuple(node.left,y+1,x-1));
            }
            if(node.right != null){
                q.offer(new Tuple(node.right,y+1,x+1));
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for(TreeMap< Integer, PriorityQueue<Integer>> ys : map.values()){
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes : ys.values()){
                while (!nodes.isEmpty()){
                    list.get(list.size()-1).add(nodes.poll());
                }
            }
        }
        return list;
    }
    // Top view of a tree
    public static ArrayList<Integer> topView(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair it = q.remove();
            int hd = it.num;
            TreeNode temp = it.node;
            if(map.get(hd) == null){
                map.put(hd,temp.val);
            }
//            map.putIfAbsent(hd,temp.val);
            if(temp.left != null){
                q.add(new Pair(temp.left,hd-1));
            }
            if(temp.right != null)
            {
                q.add(new Pair(temp.right,hd+1));
            }
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            list.add(entry.getValue());
        }
        return list;
    }
    // Bottom View of a binary tree
    public static ArrayList<Integer> bottomView(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Queue<Pair> q = new LinkedList<>();
        Map<Integer,Integer> map = new TreeMap<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            Pair it = q.poll();
            TreeNode node = it.node;
            int bd = it.num;
            map.put(bd, node.val);
            if(node.left != null) q.offer(new Pair(node.left,bd-1));
            if(node.right != null) q.offer(new Pair(node.right,bd+1));
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            list.add(entry.getValue());
        }
        return list;
    }
    // Binary Tree Right Side View
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Queue<Pair> q = new LinkedList<>();
        Map<Integer,Integer> map = new TreeMap<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            Pair it = q.poll();
            TreeNode node = it.node;
            int bd = it.num;
            map.put(bd, node.val);
            if(node.left != null) q.offer(new Pair(node.left,bd+1));
            if(node.right != null) q.offer(new Pair(node.right,bd+1));
//          OR
//            map.putIfAbsent(bd, node.val);
//            if(node.right != null) q.offer(new Pair(node.right,bd+1));
//            if(node.left != null) q.offer(new Pair(node.left,bd+1));

        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            list.add(entry.getValue());
        }
        return list;
    }
    // Recursive approach
    public List<Integer> rightView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }

        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);

    }
    // Symmetric Tree
    public static boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricHelp(root.left,root.right);
    }

    private static boolean isSymmetricHelp(TreeNode left, TreeNode right) {
        if(left == null || right == null) return left == right;

        if(left.val != right.val) return false;

        return isSymmetricHelp(left.left,right.right) && isSymmetricHelp(left.right,right.left);
    }
    // Print Root to Node Path in Binary Tree
    public static ArrayList<Integer> nodePath(TreeNode root, int B){
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        getPath(root,list,B);
        return list;
    }
    public static boolean getPath(TreeNode root,ArrayList<Integer> arr,int x){
        if(root == null) return false;

        arr.add(root.val);
        if(root.val == x) return true;

        if(getPath(root.left,arr,x) || getPath(root.right,arr,x)) return true;

        arr.remove(arr.size()-1);
        return false;
    }
    // Lowest Common Ancestor of a Binary Tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left == null){
            return right;
        }
        else if(right == null){
            return left;
        }
        else{
            return root;
        }
    }
    // Maximum Width of Binary Tree
    public static int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int first = 0, last = 0;
            int size = q.size();
            int min = q.peek().num;
            for (int i = 0; i < size; i++) {
                int cur_id = q.peek().num - min;
                TreeNode node = q.poll().node;
                if(i == 0) first = cur_id;
                if(i == size-1) last = cur_id;
                if(node.left != null) q.offer(new Pair(node.left,2*cur_id + 1));
                if(node.right != null) q.offer(new Pair(node.right,2*cur_id + 2));
            }
            ans = Math.max(ans,last - first + 1);
        }
        return ans;
    }
    // Children Sum Property in Binary Tree
    public static void changeTree(TreeNode  root) {
        if(root == null) return;

        int child = 0;
        if(root.left != null) child += root.left.val;
        if(root.right != null) child += root.right.val;

        if(child >= root.val){
            root.val = child;
        }else{
            if(root.left != null) root.left.val = root.val;
            if(root.right != null)  root.right.val = root.val;
        }

        changeTree(root.left);
        changeTree(root.right);

        int total = 0;
        if(root.left != null) total += root.left.val;
        if(root.right != null) total += root.right.val;
        if(root.left != null || root.right != null) root.val = total;
    }
    // All Nodes Distance K in Binary Tree
    private void markParents(TreeNode root, Map<TreeNode, TreeNode> parent_track, TreeNode target) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if(current.left != null) {
                parent_track.put(current.left, current);
                queue.offer(current.left);
            }
            if(current.right != null) {
                parent_track.put(current.right, current);
                queue.offer(current.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent_track = new HashMap<>();
        markParents(root, parent_track, root);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(target);
        visited.put(target, true);
        int curr_level = 0;
        while(!queue.isEmpty()) { /*Second BFS to go upto K level from target node and using our hashtable info*/
            int size = queue.size();
            if(curr_level == k) break;
            curr_level++;
            for(int i=0; i<size; i++) {
                TreeNode current = queue.poll();
                if(current.left != null && visited.get(current.left) == null) {
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }
                if(current.right != null && visited.get(current.right) == null ) {
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }
                if(parent_track.get(current) != null && visited.get(parent_track.get(current)) == null) {
                    queue.offer(parent_track.get(current));
                    visited.put(parent_track.get(current), true);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            result.add(current.val);
        }
        return result;
    }
    // Count Complete Tree Nodes
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int lh = lefHeight(root);
        int rh = rightHeight(root);

        if(lh == rh){
            double ans = (2<<lh) - 1;
            return (int)ans;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);

    }
    public int lefHeight(TreeNode root){
        int count = 0;
        while(root.left != null){
            count++;
            root = root.left;
        }
        return count;
    }
    public int rightHeight(TreeNode root){
        int count = 0;
        while(root.right != null){
            count++;
            root = root.right;
        }
        return count;
    }
    // Construct Binary Tree from Preorder and Inorder Traversal
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i],i);
        }
        TreeNode root = buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inMap);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[]
            inorder, int inStart, int inEnd, Map < Integer, Integer > inMap){
        if(preEnd < preStart || inEnd < inStart) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preorder,preStart+1,preStart+numsLeft,inorder,inStart,inRoot-1,inMap);
        root.right = buildTree(preorder,preStart+numsLeft+1,preEnd,inorder,inRoot+1,inEnd,inMap);

        return root;
    }
    //  Construct Binary Tree from Inorder and Postorder Traversal
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
        for (int i=0;i<inorder.length;++i)
            hm.put(inorder[i], i);
        return buildTreePostIn(inorder, 0, inorder.length-1, postorder, 0,
                postorder.length-1,hm);
    }

    private TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe,
                                     HashMap<Integer,Integer> hm){
        if (ps>pe || is>ie) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int ri = hm.get(postorder[pe]);
        TreeNode leftchild = buildTreePostIn(inorder, is, ri-1, postorder, ps, ps+ri-is-1, hm);
        TreeNode rightchild = buildTreePostIn(inorder,ri+1, ie, postorder, ps+ri-is, pe-1, hm);
        root.left = leftchild;
        root.right = rightchild;
        return root;
    }
    // Serialize and Deserialize Binary Tree
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                sb.append("n ");
                continue;
            }
            sb.append(node.val).append(" ");
            q.offer(root.left);
            q.offer(root.right);
        }
        return sb.toString();
    }
    public TreeNode deserialize(String data) {
        if(data == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.offer(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if(values[i] != "n"){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.offer(left);
            }
            if(values[++i] != "n"){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.offer(right);
            }
        }
        return root;
    }

//    public TreeNode connect(TreeNode root) {
//
//    }
}


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Pair{
    TreeNode node;
    int num;

    public Pair(TreeNode root, int i) {
        this.node = root;
        this.num = i;
    }
}
class Tuple{
    TreeNode node;
    int col;
    int row;

    public Tuple(TreeNode node, int col, int row) {
        this.node = node;
        this.col = col;
        this.row = row;
    }
}
//    Queue<Node> queue = new LinkedList<Node>();
//    List<List<Node>> wraplist = new LinkedList<List<Node>>();
//        if(root == null){
//                return wraplist;
//                }
//                queue.offer(root);
//                while (!queue.isEmpty()){
//                int levelNum = queue.size();
//                List<Node> subList = new LinkedList<Node>();
//        for (int i = 0; i < levelNum; i++) {
//        if(queue.peek().left != null){
//        queue.offer(queue.peek().left);
//        }
//        if(queue.peek().right != null){
//        queue.offer(queue.peek().right);
//        }
//        subList.add(queue.poll());
//        }
//        wraplist.add(subList);
//        }
//        return wraplist;