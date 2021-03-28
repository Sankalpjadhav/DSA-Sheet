package LinkedList;
import java.util.Scanner;
/*
Subtract Two Linkedlist
1. You are give two single linkedlist of digits.
2. The most significant digit comes first and each of their nodes contain a single digit. Subtract the two numbers and return it as a linked list.
3. You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Input Format
1->2->3->4->5->6->7->null
7->8->9->null
Output Format
1->2->3->3->7->7->8->null
Time Complexity: O(n) since bigger number is been traversed.
Space Complexity: O(1)
 */
public class SubstractTwoLinkedList {
    private static class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }

    private static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;

        while(cur!=null){
            // Backup
            next = cur.next;
            // Link
            cur.next = prev;
            // Move
            prev = cur;
            cur = next;
        }

        return prev;
    }
    private static void printNodes(ListNode head){
        ListNode prev = head;
        while(prev!=null){
            System.out.print(prev.val+" ");
            prev = prev.next;
        }
    }
    private static ListNode subtract(ListNode list1, ListNode list2){
        if(list2==null) return list1;

        if(list1==null){
            list2.val = -list2.val;
            return list2;
        }

        list1 = reverse(list1);
        list2 = reverse(list2);
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        int borrow = 0;
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while(cur1!=null){
            int difference = borrow + cur1.val - (cur2!=null?cur2.val:0);
            if(difference < 0){
                borrow = -1;
                difference += 10;
            }
            else{
                borrow = 0;
            }
            cur.next = new ListNode(difference);
            cur = cur.next;
            cur1 = cur1.next;
            if(cur2!=null){
                cur2 = cur2.next;
            }
        }
        return reverse(head.next);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ListNode dummy1 = new ListNode(-1);
        ListNode prev1 = dummy1;
        ListNode dummy2 = new ListNode(-1);
        ListNode prev2 = dummy2;

        while(n-- > 0){
            prev1.next = new ListNode(sc.nextInt());
            prev1 = prev1.next;
        }

        while(m-- > 0){
            prev2.next = new ListNode(sc.nextInt());
            prev2 = prev2.next;
        }

        ListNode list1 = dummy1.next;
        ListNode list2 = dummy2.next;
        ListNode result = subtract(list1, list2);
        printNodes(result);
    }
}
