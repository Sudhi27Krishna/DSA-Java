// GFG link => https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1

class FlattenLL
{
    Node flatten(Node root)
    {
	    if(root == null) return null;
	    
	    Node head1 = root;
	    Node head2 = flatten(root.next);
	    return merge(head1, head2);
    }
    
    Node merge(Node root1, Node root2){
        Node dummy = new Node(0);
        Node temp = dummy;
        
        while(root1 != null && root2 != null){
            if(root1.data < root2.data){
                temp.bottom = root1;
                root1 = root1.bottom;
            }
            else{
                temp.bottom = root2;
                root2 = root2.bottom;
            }
            temp = temp.bottom;
        }
        
        if(root1 != null) temp.bottom = root1;
        if(root2 != null) temp.bottom = root2;
        
        dummy.bottom.next = null;
        return dummy.bottom;
    }
}
