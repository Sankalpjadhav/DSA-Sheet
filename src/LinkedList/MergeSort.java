package LinkedList;
import java.util.Scanner;
/*
Mergesort Linkedlist
Given the head of a linked list, return the list after sorting it in increasing order.
Input Format
1->7->2->6->3->5->4->null
Output Format
1->2->3->4->5->6->7->null

Time Complexity : O(nlogn)
Space Complexity : constant space
*/
public class MergeSort {
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
    private static ListNode midNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode merge(ListNode head1, ListNode head2){
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

    private static ListNode mergeSort(ListNode head){
        if(head==null || head.next == null){
            return head;
        }
        ListNode mid = midNode(head);
        ListNode newhead = mid.next;
        mid.next = null;
        ListNode first = mergeSort(head);
        ListNode second = mergeSort(newhead);

        return merge(first,second);
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
        head =  mergeSort(head);
        printNodes(head);
    }
}
