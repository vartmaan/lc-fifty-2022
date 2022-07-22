package com.kol.lc.july.twenty.two;

/**
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 */

import com.kol.lc.common.ListNode;

public class PartitionList {

    public ListNode partition(ListNode head, int x) {

        ListNode dummy1= new ListNode();
        ListNode dummy2 = new ListNode();

        ListNode part1 = dummy1;
        ListNode part2 = dummy2;

        while( head != null) {

            if(head.val < x) {
                part1.next = head;
              //  head=head.next;
                part1=part1.next;
            }else{
                part2.next = head;
             //   head=head.next;
                part2 = part2.next;

            }

            head = head.next;

        }

        part2.next = null;
        part1.next = dummy2.next;
        return dummy1.next;

    }
}
