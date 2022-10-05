package com.company;

import java.util.LinkedList;

public class LL {

    private Node head;
    private Node tail;
    private int size;
    public LL() {
        this.size = 0;
    }
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }

        size += 1;
    }
    public void insertLast(int val){
        if(tail == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size += 1;
    }

    public void insert(int val, int index){
        if(index == 0){
            insertFirst(val);
            return;
        }
        if(index == size){
            insertLast(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val,temp.next);
        temp.next = node;

        size++;
    }

    //insert using recursion
    public void insertRec(int val,int index){
        head = insertRecursion(val,index,head);
    }
    private Node insertRecursion(int val, int index, Node node){
        if(index == 0){
            Node temp = new Node(val,node);
            size++;
            return temp;
        }
        node.next = insertRecursion(val,index - 1,node.next);
        return node;
    }

    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return val;
    }

    public Node find(int value){
        Node node = head;
        while (node != null){
            if(node.value == value){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public Node get(int index){
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int deleteLast(){
        if(size <= 1){
            return deleteFirst();
        }
        Node secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        return val;
    }

    public int delete(int index){
        if(index == 0){
            return deleteFirst();
        }
        if(index == size - 1){
            return deleteLast();
        }
        Node prev = get(index - 1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        return val;
    }

    public void display(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
    //remove duplicates from sorted
    public void deletedup(Node head){
        Node node = head;
        while (node.next != null){
            if(node.value == node.next.value){
                node.next = node.next.next;
            }else {
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }

    //merge LL
    public static LL merge(LL first,LL second){
        Node f = first.head;
        Node s = second.head;
        LL ans = new LL();
        while (f != null && s != null){
            if(f.value < s.value){
                ans.insertLast(f.value);
                f = f.next;
            }else{
                ans.insertLast(s.value);
                s = s.next;
            }
        }
        while (f != null){
            ans.insertLast(f.value);
            f = f.next;
        }
        while (s != null){
            ans.insertLast(s.value);
            s = s.next;
        }
        return ans;
    }
    // cycle fast ans slow pointer
    public boolean hasCycle(Node head){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
    // length of circular linked list
    public int cycleLength(Node head){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                // calculate the length
                Node temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                }while (temp != slow);
                return length;
            }
        }
        return 0;
    }
    // detect cycle starting point
    public Node detect(Node head){
        int length = 0;
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                length = cycleLength(slow);
                break;
            }
        }
        // find the start node
        Node f = head;
        Node s = head;

        while(length > 0){
            s = s.next;
            length--;
        }
        // now keep moving both pointers forward till they meet which will be at cycle start node
        while (f != s){
            f = f.next;
            s = s.next;
        }
        return s; // or return f
    }

    // happy number
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do{
            slow = findSq(slow);
            fast = findSq(findSq(fast));
        }while (fast != slow);

        if(slow == 1){
            return true;
        }
        return false;
    }
    private int findSq(int n){
        int ans = 0;
        while (n > 0){
            int rem = n % 10;
             ans += rem * rem;
             n = n / 10;
        }
        return ans;
    }
    // bubble sort
    public void bubbleSort(){
        bubbleSort(size - 1,0);
    }

    private void bubbleSort(int r, int c) {
        if(r == 0){
            return;
        }
        if(c < r){
            Node first = get(c);
            Node second = get(c+1);
            if(first.value > second.value){
                if(first == head){
                    head = second;
                    first.next = second.next;
                    second.next = first;
                }else if(second == tail){
                    Node prev = get(c - 1);
                    prev.next = second;
                    tail.next = first;
                    first.next = null;
                    second.next = tail;
                }else {
                    Node prev = get(c - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(r,c+1);
        }else {
            bubbleSort(r-1,0);
        }
    }
    // reversing the linked list using recursion
    public void reverseRecursion(Node node){
        if(node == tail){
            head = tail;
            return;
        }
        reverseRecursion(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }
    // in place reversal of the linked list (iteratve)
    public void reverse(Node head){
        if(size < 2){
            return;
        }
        Node prev = null;
        Node pres = head;
        Node Next = head.next;
        while (pres != null){
            pres.next = prev;
            prev = pres;
            pres = Next;
            if(Next != null){
                Next = Next.next;
            }
        }
        head = prev;
        return;
    }

    private class Node{
       private int value;
       private Node next;

       public Node(int value) {
           this.value = value;
       }

       public Node(int value, Node next) {
           this.value = value;
           this.next = next;
       }
   }
}
