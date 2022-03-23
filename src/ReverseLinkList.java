public class ReverseLinkList {
    public static ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode reversed = reverseList(head.next) ;
        ListNode first = head;
        ListNode second = head.next;
        second.next = first;
        first.next = null;
        return reversed;

    }
    public static ListNode iterativeReverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next= prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public static void main(String[] args){
        ListNode five = new ListNode(5, null);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);
        //ListNode result = reverseList(one);
        ListNode iterativeResult = iterativeReverseList(one);
//        while(result!=null){
//            System.out.println(result.val);
//            result = result.next;
//        }
        while(iterativeResult!=null){
            System.out.println(iterativeResult.val);
            iterativeResult = iterativeResult.next;
        }

    }
}
