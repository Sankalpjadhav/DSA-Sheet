package LinkedList;
import java.util.Scanner;
/*
Given a singly linked list of Integers, determine it is a palindrome or not.
Input Format
1->2->3->4->3->2->1->null
1->2->3->4->2->1->null
Output Format
true
false

Time complexity: O(n)
Space complexity: O(1)
 */
public class Palindrome {
    private static class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
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

    private static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;

        while(cur!=null){
            next = cur.next; // Backup
            cur.next = prev; // Link
            //Move
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private static boolean palindrome(ListNode head){
        if(head == null || head.next == null) return true;

        ListNode mid = midNode(head);
        ListNode newHead = mid.next;
        mid.next = null;

        newHead = reverse(newHead);
        ListNode current1 = head;
        ListNode current2 = newHead;
        while(current2!=null){
            if(current1.val!= current2.val){
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while(n-- > 0){
            prev.next = new  ListNode(sc.nextInt());
            prev = prev.next;
        }
        ListNode head = dummy.next;
        System.out.println("Is palindrome? "+palindrome(head));
    }
}
