package LinkedList;
import java.util.Scanner;
/*
Merge K Sorted Linkedlist
You are given an array of k linked-lists, each linked-list is sorted in increasing order.
Merge all the linkedlists into one sorted linkedlist and return it.
Input Format
3 sorted linkedlist :
{
    0->0->0->null,
    0->0->1->1->1->2->2->4->null,
    0->0->0->0->5->5->6->null
}
Output Format
after merging them :
0->0->0->0->0->0->0->0->0->1->1->1->2->2->4->5->5->6->null

Time complexity: NKlogK
Space complexity: O(1)
 */
public class MergeKSortedLinkedList {
    public static Scanner sc = new Scanner(System.in);
    private static class ListNode{
        int val = 0;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }

    private static ListNode createList(int m){
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while(m-- > 0){
            prev.next = new ListNode(sc.nextInt());
            prev = prev.next;
        }
        return dummy.next;
    }

    private static void printList(ListNode head){
        ListNode prev = head;
        while(prev!=null){
            System.out.print(prev.val+" ");
            prev = prev.next;
        }
    }

    private static ListNode merge2SortedList(ListNode head1, ListNode head2){
        if(head1 == null || head2 == null) return head1!=null?head1:head2;
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

    private static ListNode mergeKSortedList(ListNode [] list, int startIndex, int endIndex){
        if(startIndex==endIndex){
            return list[startIndex];
        }
        int mid = (startIndex+endIndex)/2;
        ListNode first = mergeKSortedList(list,startIndex,mid);
        ListNode second = mergeKSortedList(list, mid+1,endIndex);

        return merge2SortedList(first,second);
    }

    public static void main(String[] args) {

        int n = sc.nextInt();
        ListNode [] list = new ListNode[n];
        for(int i = 0;i<n;i++){
            int m = sc.nextInt();
            list[i] = createList(m);
        }
        ListNode head = mergeKSortedList(list, 0, list.length-1);
        printList(head);
    }
}
