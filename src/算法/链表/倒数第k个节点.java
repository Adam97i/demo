package 算法.链表;

import java.io.IOException;
import java.util.Scanner;

/**
 * 返回链表倒数第k个节点 异常返回null
 */

public class 倒数第k个节点 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            ListNode pre = new ListNode(-1, null);
            ListNode cur = pre;
            for (int i = 0; i < n; i++) {
                ListNode node = new ListNode(sc.nextInt());
                cur.next = node;
                cur = cur.next;
            }
            int k = sc.nextInt();

            ListNode head = pre.next;
            if(k==1){
                System.out.println(cur.val);
                continue;
            }
            ListNode fast = head;
            ListNode slow = head;
            for (int i = 0; i < k; i++) {
                fast = fast.next;
            }
            while (fast!=null && fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            System.out.println(slow.next.val);
        }

    }


    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int val) {
            this.val = val;
        }
    }
}