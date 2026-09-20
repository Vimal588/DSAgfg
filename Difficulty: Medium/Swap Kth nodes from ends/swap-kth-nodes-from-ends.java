class Solution {
    public Node swapKth(Node head, int k) {

        if (head == null) {
            return head;
        }

        // Find length
        int n = 0;
        Node temp = head;

        while (temp != null) {
            n++;
            temp = temp.next;
        }

        // Not possible
        if (k > n) {
            return head;
        }

        // Same node
        if (2 * k - 1 == n) {
            return head;
        }

        // Find kth node from beginning
        Node first = head;
        Node firstPrev = null;

        for (int i = 1; i < k; i++) {
            firstPrev = first;
            first = first.next;
        }

        // Find kth node from end
        Node second = head;
        Node secondPrev = null;

        for (int i = 1; i <= n - k; i++) {
            secondPrev = second;
            second = second.next;
        }

        // If first node is head
        if (firstPrev == null) {
            head = second;
        } 
        else {
            firstPrev.next = second;
        }

        // If second node is head
        if (secondPrev == null) {
            head = first;
        } 
        else {
            secondPrev.next = first;
        }

        // Swap next pointers
        Node tempNext = first.next;
        first.next = second.next;
        second.next = tempNext;

        return head;
    }
}