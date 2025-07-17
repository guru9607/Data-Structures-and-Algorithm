public class A3_MiddleOfLinkedList {
    static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6};
        ListNode head = LinkedListUtils.arrayToList(arr);
        ListNode middle = middleNode(head);
        System.out.println(middle.val);
    }

}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}