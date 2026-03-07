package A02_链表;

/**
 * @program: SoftExam
 * @description:
 * @author: 郭寅之(Clay_Guo)
 * @create: 2025/8/3 22:49
 **/
public class 移除链表元素 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(7);
        listNode.next = new ListNode(7);
        listNode.next.next = new ListNode(7);
        listNode.next.next.next = new ListNode(7);
        System.out.println(removeElements(listNode, 7));
    }


    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}