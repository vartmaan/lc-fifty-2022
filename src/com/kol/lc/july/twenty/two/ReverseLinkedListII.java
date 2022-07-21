package com.kol.lc.july.twenty.two;

import com.kol.lc.common.ListNode;

public class ReverseLinkedListII {

    public static void main(String[] args) {
       ReverseLinkedListII ob = new ReverseLinkedListII();
       ob.testReverseLinkedListII();
    }

    public void testReverseLinkedListII() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);

        int left = 2;
        int right = 4;

        ListNode res = reverseBetween(root,left,right);

        while(res != null) {
            System.out.print(" "+res.val );
            res = res.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(head == null) {
            return null;
        }

        ListNode curr = head;
        ListNode prev = null;

        int i = 1;

        for(; i < left; i++) {
            prev = curr;
            curr=curr.next;
        }

        ListNode currBeforeReverse = curr;
        ListNode prevR = null;
        ListNode next = null;

        for(; i <= right; i++) {
            next = curr.next;
            curr.next = prevR;
            prevR = curr;
            curr = next;
        }

        currBeforeReverse.next = curr;
        if(prev != null) {
            prev.next = prevR;
        }else{
            head = prevR;
        }

        return head;
    }
}
