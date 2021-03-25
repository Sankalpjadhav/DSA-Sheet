package LinkedList;
import java.util.Scanner;
/*
Unfold Of Linkedlist
Given a singly linkedlist : l0 -> ln -> l1 -> ln-1 -> l2 -> ln-2 -> l3 -> ln-3 -> .....
reorder it :  l0 -> l1 -> l2 -> l3 -> l4 -> l5 -> l6 ..... -> ln-1 -> ln
for more information watch video.
Input Format
1->7->2->6->3->5->4->null
Output Format
1->2->3->4->5->6->7->null

Sample Input:
n = 9
5
1
1
4
4
6
6
9
9
Sample Output:
5 1 4 6 9 9 6 4 1
Time Complexity: O(n)
Space Complexity: O(1)
 */
public class UnfoldLinkedList {
    private static class ListNode{
        int val = 0;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }
    private static void printNodes(ListNode head){
        ListNode ptr = head;
        while(ptr!=null){
            System.out.print(ptr.val+" ");
            ptr = ptr.next;
        }
    }
    private static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        ListNode forward = null;

        while(cur!=null){
            //Backup
            forward = cur.next;
            //Links
            cur.next = prev;
            //Move
            prev = cur;
            cur = forward;
        }
        return prev;
    }

    private static void unfold(ListNode head){
        if(head==null || head.next==null){
            printNodes(head);
            return;
        }
        ListNode first = head;
        ListNode secondHead = head.next;
        ListNode second = secondHead;
        ListNode forward = null;

        while(second!=null && second.next!=null){
            forward = second.next;
            first.next = forward;
            first = first.next;
            second.next = forward.next;
            second = second.next;
        }
        first.next = null; // Important point: Consider even length linkedlist to get the answer for this step
        secondHead = reverse(secondHead);
        first.next = secondHead;
        printNodes(head);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        while(n-- > 0){
            prev.next = new ListNode(sc.nextInt());
            prev = prev.next;
        }
        ListNode head = dummy.next;
        unfold(head);
    }
}
