package LinkedList;
import java.util.Scanner;
/*
Merge Two Sorted Linkedlist
1. Merge two sorted linkedlists and return head of a sorted linkedlist. The list should be made by splicing together the nodes of the first two lists
2. Both list are sorted in increasing order.
Input Format
1->2->6->7->15->24->null
-1->0->6->17->25->null
Output Format
-1->0->1->2->6->6->7->15->17->24->25->null
Sample input:
2
4
1 5
1 3 6 10
Sample output:
1 1 3 5 6 10 2

Time complexity : O(n+m) where n is length of 1st list and m is length of 2nd list.
Space complexity : O(1)
 */
public class MergeTwoSortedLinkedList {
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

    private static ListNode mergeTwoSortedList(ListNode head1, ListNode head2){
        if(head1==null || head2==null){
            return head1!=null?head1:head2;
        }
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        ListNode cur1 = head1;
        ListNode cur2 = head2;

        while(cur1!=null && cur2!=null){
            if(cur1.val < cur2.val){
                prev.next = cur1;
                cur1 = cur1.next;
            }
            else{
                prev.next = cur2;
                cur2 = cur2.next;
            }
            prev = prev.next;
        }

        prev.next = cur1!=null?cur1:cur2;

        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        ListNode dummy1 = new ListNode(-1);
        ListNode prev1 = dummy1;
        ListNode dummy2 = new ListNode(-1);
        ListNode prev2 = dummy2;

        while(n1-- > 0){
            prev1.next = new ListNode(sc.nextInt());
            prev1 = prev1.next;
        }
        while(n2-- > 0){
            prev2.next = new ListNode(sc.nextInt());
            prev2 = prev2.next;
        }

        ListNode head1 = dummy1.next;
        ListNode head2 = dummy2.next;
        ListNode mergedHead = mergeTwoSortedList(head1, head2);
        printNodes(mergedHead);
    }
}
