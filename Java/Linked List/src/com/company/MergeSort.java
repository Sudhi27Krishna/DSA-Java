package com.company;

import java.util.LinkedList;

public class MergeSort {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left,right);
    }
    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }
    public ListNode getMid(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }
    //reverse the list II
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }
        // skip the first left-1 nodes
        ListNode current = head;
        ListNode prev = null;
        for (int i = 0; current!= null && i < left-1; i++) {
            prev = current;
            current = current.next;
        }
        ListNode last = prev;
        ListNode newEnd = current;

        // reverse between left and right
        ListNode Next = current.next;
        for (int i = 0; current!= null && i < right-left+1; i++) {
            current.next = prev;
            prev = current;
            current = Next;
            if(Next != null){
                Next = Next.next;
            }
        }
        if(last != null){
            last.next = prev;
        }else {
            head = prev;
        }
        newEnd.next = current;
        return head;
    }
    //Reverse Linked List
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        if(head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode pres = head;
        ListNode Next = head.next;
        while (pres != null){
            pres.next = prev;
            prev = pres;
            pres = Next;
            if(Next != null){
                Next = Next.next;
            }
        }
        head = prev;
        return head;
    }
    // Palindrome Linked List
    public boolean isPalindrome(ListNode head) {
        ListNode mid = getMid(head);
        ListNode headSecond = reverseList(mid);
        ListNode rereverseHead = headSecond;
        // compare both the halves
        while (head != null && headSecond != null){
            if(head.val != headSecond.val){
                break;
            }else {
                head = head.next;
                headSecond = headSecond.next;
            }
        }
        reverseList(rereverseHead);

        if(head == null || headSecond == null){
            return true;
        }
        return false;
    }
    //middle of the list
    public ListNode middleNode(ListNode head) {
        int length = 1;
        ListNode ans = head;
        while(ans.next != null){
            length++;
            ans = ans.next;
        }
        ListNode res = head;
        int mid = length / 2;
        if(length % 2 != 0){
            while(mid > 0){
                res = res.next;
                mid--;
            }
            return res;
        }else{
            while(mid > 0){
                res = res.next;
                mid--;
            }
            return res;
        }
    }
    // Reorder List
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode mid = middleNode(head);
        ListNode hs = reverseList(mid);
        ListNode hf = head;
        // rearrange
        while(hs != null && hf != null){
            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;
            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }
        if(hf != null){
            hf.next = null;
        }
    }
    // Reverse Nodes in k-Group
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1 || head == null){
            return head;
        }

        ListNode current = head;
        ListNode prev = null;
        while (true){
            ListNode last = prev;
            ListNode newEnd = current;

            ListNode Next = current.next;
            for (int i = 0; current!= null && i < k; i++) {
                current.next = prev;
                prev = current;
                current = Next;
                if(Next != null){
                    Next = Next.next;
                }
            }
            if(last != null){
                last.next = prev;
            }else {
                head = prev;
            }
            newEnd.next = current;

            if(current == null){
                break;
            }

            prev = newEnd;
        }
        return head;
    }
}
 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; this.next = null; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
