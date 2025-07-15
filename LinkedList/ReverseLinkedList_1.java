// Problem Link: https://leetcode.com/problems/reverse-linked-list/

class ReverseLinkedList_1 {
    
    public ListNode reverseListIterative(ListNode head) {
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseListRecursive(ListNode head) {
        // base case
        if (head == null || head.next == null) return head;

        // faith
        ListNode newHead = reverseListRecursive(head.next);

        // implementation details
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/*

Think of the linked list as a train of carriages.
Each carriage (node) is connected to the next one.

- The function travels to the very last carriage (node) by calling itself recursively.
- When it reaches the last carriage, it says: “You are now the engine (new head)!”
- As the recursion unwinds, each carriage tells the one behind it:
  “Hey, you’re now behind me, so I’ll point my next pointer back to you!”
- To avoid a loop, each carriage also disconnects its old forward link (head.next = null).

Step-by-step for list 1 → 2 → 3:

Go to the end:
    Call stack: 
        reverse(1) → reverse(2) → reverse(3)
    At node 3 (base case):
        Return 3 (new head)
    Unwinding:
        Node 2: 2.next.next = 2 (so 3 → 2), 2.next = null
        Node 1: 1.next.next = 1 (so 2 → 1), 1.next = null
        Now the list is 3 → 2 → 1


 */                                                             