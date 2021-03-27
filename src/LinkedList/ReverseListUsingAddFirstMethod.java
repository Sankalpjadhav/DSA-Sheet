package LinkedList;
import java.util.Scanner;
/*
Reverse a linkedlist
This method is used in various problems.
Sample Input:
8
1 2 3 4 5 6 7 8
Sample Output:
8 7 6 5 4 3 2 1

Time complexity : O(n)
Space complexity : O(1)
 */
public class ReverseListUsingAddFirstMethod {
    private static class ListNode{
        int val=0;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }
    private static void printNodes(ListNode head){
        ListNode prev = head;
        while(prev!=null){
            System.out.print(prev.val+" ");
            prev = prev.next;
        }
    }
    static ListNode newHead = null;
    static ListNode newTail = null;
    private static void addFirst(ListNode node){
        if(newHead==null && newTail==null){
            newHead = node;
            newTail = node;
        }
        else{
            node.next = newHead;
            newHead = node;
        }
    }

    private static ListNode reverse(ListNode head){
        ListNode current = head;
        while(current!=null){
            ListNode forward = current.next;
            current.next = null;
            addFirst(current);
            current  = forward;
        }

        return newHead;
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
