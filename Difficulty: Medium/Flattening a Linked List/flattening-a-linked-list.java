import java.util.PriorityQueue;

class Solution {

    public Node flatten(Node head) {

        if (head == null) {
            return null;
        }

        // Min heap based on node data
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.data, b.data)
        );

        // Add heads of all linked lists
        Node temp = head;

        while (temp != null) {
            pq.add(temp);
            temp = temp.next;
        }

        Node dummy = new Node(0);
        Node tail = dummy;

        // Merge all lists
        while (!pq.isEmpty()) {

            Node current = pq.poll();

            // Add current node to flattened list
            tail.bottom = current;
            tail = current;

            // Current node's next list connection is not needed
            current.next = null;

            // Add next node from same list
            if (current.bottom != null) {
                pq.add(current.bottom);
            }
        }

        return dummy.bottom;
    }
}