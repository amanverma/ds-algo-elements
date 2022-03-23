/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class SwapNodes {
    //Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
    public static ListNode swapPairs(ListNode head) {
        if(head ==null || head.next==null){
            return head;
        }
        ListNode second = head.next;
        ListNode first = head;
        ListNode recursedList = swapPairs(second.next);
        first.next = recursedList;
        second.next = first;

        return second;

    }
    public static void main(String[] args){
        ListNode five = new ListNode(5, null);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);
        ListNode result = swapPairs(one);
        while(result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
