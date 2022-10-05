package com.company;
//Problem link: https://leetcode.com/problems/rotate-list/

//Github account link: https://github.com/Sudhi27Krishna


public class rotate_list {
    public static void main(String[] args) {

    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        int length = 0;
        ListNode dummy = head;
        for(int i=0;dummy != null;i++){
            length++;
            dummy = dummy.next;
        }
        ListNode newHead = head;
        ListNode temp = head;
        for(int i=0;i<(k%length);i++){
            newHead = reverseList(temp);
            temp = newHead;
            newHead = reverseList(newHead.next);
            temp.next = newHead;
        }
        return temp;
    }
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
}
