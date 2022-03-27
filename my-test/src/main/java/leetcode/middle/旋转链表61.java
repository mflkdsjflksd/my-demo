package leetcode.middle;

import leetcode.数据结构.ListNode;
import org.junit.Test;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/26 21:42
 */
public class 旋转链表61 {

    @Test
    public void test() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        rotateRight(listNode, 1);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int length = 0;
        ListNode temp = head, res;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        if (k == length) {
            return head;
        }
        k = length - k % length;

        temp = head;
        while (k-- > 1) {
            temp = temp.next;
        }
        res = temp.next;
        temp.next = null;
        temp = res;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        return res;
    }
}
