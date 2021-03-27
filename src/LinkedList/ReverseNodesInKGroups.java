package LinkedList;
import java.util.Scanner;
/*
Reverse Node Of Linkedlist In K Group
1. Given a singly linklist, reverse the nodes of a linked list k at a time and return its modified linkedlist.
2. If number of nodes in multiple of k then it will reverse otherwise it will add inn the end of linkedlist without any change.
Input Format
1->5->2->9->5->14->11->1->10->10->1->3->null
2
Output Format
11->14->5->9->2->5->1->10->10->1->3->null
Sample Input:
12
1 5 2 9 5 14 11 1 10 10 1 3
7
Sample Output:
11 14 5 9 2 5 1 1 10 10 1 3

Time complexity: O(n)
Space complexity: O(1)
*/
public class ReverseNodesInKGroups {
    private static class ListNode{
        int val = 0;
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

    private static int getLength(ListNode head){
        ListNode prev = head;
        int length  = 0;
        while(prev!=null){
            prev = prev.next;
            length++;
        }
        return length;
    }

    static ListNode tempHead = null;
    static ListNode tempTail = null;
    private static void addFirst(ListNode node){
        if(tempHead==null && tempTail==null){
            tempHead = node;
            tempTail = node;
        }
        else{
            node.next = tempHead;
            tempHead = node;
        }
    }

    private static ListNode reverseInKGroups(ListNode head, int k){
        if(head==null || head.next==null || k==0) return head;

        int length = getLength(head);
        ListNode current = head;
        ListNode originalHead = null;
        ListNode originalTail = null;
        while(length>=k){
            int tempK = k;
            while(tempK-- > 0){
                ListNode forward = current.next;
                current.next = null;
                addFirst(current);
                current = forward;
            }

            if(originalHead==null){
                originalHead = tempHead;
                originalTail = tempTail;
            }
            else{
                originalTail.next = tempHead;
                originalTail = tempTail;
            }

            tempHead = null;
            tempTail = null;
            length -= k;
        }
        originalTail.next = current;
        return originalHead;
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
        int k = sc.nextInt();
        head = reverseInKGroups(head, k);
        printNodes(head);
    }
}
