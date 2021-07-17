package org.leetcode;

import org.util.IoUtil;
import org.util.Node;

/**
 * @author duanweidong
 * @version 2021/7/17 15:36
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        Node l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(3);
        l1.next.next.next = new Node(4);

        Node l2 = new Node(1);
        l2.next = new Node(3);
        l2.next.next = new Node(4);
        Node l4 = mergeTwoLists(l1, l2);
        IoUtil.print(l4);
    }

    public static Node mergeTwoLists(Node l1, Node l2) {
        Node dummy = new Node();
        Node curr = dummy;
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 != null) {
            curr.next = l2;
        }
        if (l2 != null) {
            curr.next = l1;
        }
        return dummy.next;
    }
}
