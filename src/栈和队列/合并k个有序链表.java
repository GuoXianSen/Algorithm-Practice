package 栈和队列;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: SoftExam
 * @description:
 * @author: 郭寅之(Clay_Guo)
 * @create: 2025/11/6 23:00
 **/
public class 合并k个有序链表 {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }
        // System.out.println(queue);
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;
            // 关键在于每一轮获取的node的next节点加入队列，保证每次获取的都是最小的节点
            if (node.next != null) queue.offer(node.next);
        }
        return dummy.next;
    }
}


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