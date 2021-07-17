package org.util;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author duanweidong
 * @version 2021/7/17 16:05
 */
public class Node {

    public int val;

    public Node next;

    public Node(int val) {
        this.val = val;
    }

    public Node() {
    }

    public List<Integer> toList() {
        List<Integer> list = new LinkedList<>();
        Node curr = this;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        return Collections.unmodifiableList(list);
    }
}
