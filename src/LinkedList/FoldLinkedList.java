package LinkedList;
import java.util.Scanner;
/*
Fold Of Linkedlist
Given a singly linkedlist : l0 -> l1 -> l2 -> l3 -> l4 -> l5 -> l6 ..... -> ln-1 -> ln
reorder it : l0 -> ln -> l1 -> ln-1 -> l2 -> ln-2 -> l3 -> ln-3 -> .....
Sample Input
10
5
1
4
6
9
9
6
4
1
5
Sample Output
5 5 1 1 4 4 6 6 9 9

Time complexity: O(n)
Space complexity: O(1)
*/
public class FoldLinkedList {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode midNode(ListNode head){
        if(head == null || head.next==null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode forward = null;

        while(cur!=null){
            forward = cur.next; //Backup
            cur.next = prev; //Link

            prev = cur;
            cur = forward;
        }
        return prev;
    }

    public static void fold(ListNode head){
        if(head == null || head.next==null){
            return ;
        }

        ListNode mid =  midNode(head);
        ListNode newHead = mid.next;
        mid.next = null;

        newHead = reverse(newHead);

        ListNode cur1 = head;
        ListNode cur2 = newHead;
        ListNode forward1 = null;
        ListNode forward2 = null;

        while(cur1!=null && cur2!=null){
            //Backup
            forward1 = cur1.next;
            forward2 = cur2.next;

            //Link
            cur1.next = cur2;
            cur2.next = forward1;

            //Move
            cur1 = forward1;
            cur2 = forward2;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = dummy.next;
        fold(head);
        printList(head);
    }
}
