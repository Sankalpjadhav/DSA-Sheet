package LinkedList;
import java.util.Scanner;
/*
Reverse A Linkedlist
You have given a pointer to the head node of a linked list, the task is to reverse the linked list.
We need to reverse the list by changing the links between nodes.
Input Format
1->2->3->4->5->6->7->null
Output Format
7->6->5->4->3->2->1->null
Sample Input
7
1 2 3 4 5 6 7
Sample Output
7 6 5 4 3 2 1

Time complexity: O(n)
Space complexity: O(1)
*/
public class ReverseALinkedList {
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
            // Backup
            forward = cur.next;
            // Links
            cur.next = prev;
            // Move
            prev = cur;
            cur = forward;
        }

        return prev;
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
        head = reverse(head);
        printNodes(head);
    }
}
