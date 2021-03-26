package LinkedList;
import java.util.Scanner;
/*
Segregate Even And Odd Nodes In A Link List
Given a singly linklist, modify the list such that all the even numbers appear before all the odd numbers in the modified list.
The order of appearance of numbers within each segregation should be same as that in the original list.
Sample Input:
12
1 3 2 4 5 6 7 18 19 21 22 24
Sample Output:
2 4 6 18 22 24 1 3 5 7 19 21
Time complexity: O(n)
Space complexity: O(1)
*/
public class SegregateOddEvenNodes {
    private static class ListNode{
        int val=0;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }

    private static void printNodes(ListNode head){
        ListNode prev = head;
        while(prev != null){
            System.out.print(prev.val+" ");
            prev = prev.next;
        }
        System.out.println();
    }

    private static void segregate(ListNode head){
        if(head==null || head.next==null){
            printNodes(head);
            return;
        }
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);
        ListNode oddptr = odd;
        ListNode evenptr = even;
        ListNode cur = head;

        while(cur != null){
            if(cur.val % 2 == 0){
                evenptr.next = cur;
                evenptr = evenptr.next;
            }
            else{
                oddptr.next = cur;
                oddptr = oddptr.next;
            }
            cur = cur.next;
        }
        oddptr.next = null;
        evenptr.next = odd.next;
        printNodes(even.next);
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
        segregate(head);
    }
}
