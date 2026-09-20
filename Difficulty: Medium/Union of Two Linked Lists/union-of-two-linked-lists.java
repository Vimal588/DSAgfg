/* Linked List Node Structure
class Node {
    public int data;
    public Node next;

    public Node(int x) {
        data = x;
        next = null;
    }

}*/

class Solution {
    public Node makeUnion(Node head1, Node head2) {
        // code here
        HashSet<Integer> set = new HashSet<>();

                Node dummy = new Node(0);
                Node tail = dummy;

                // First linked list
                Node temp = head1;

                while (temp != null) {

                    if (!set.contains(temp.data)) {
                        set.add(temp.data);

                        tail.next = new Node(temp.data);
                        tail = tail.next;
                    }

                    temp = temp.next;
                }

                // Second linked list
                temp = head2;

                while (temp != null) {

                    if (!set.contains(temp.data)) {
                        set.add(temp.data);

                        tail.next = new Node(temp.data);
                        tail = tail.next;
                    }

                    temp = temp.next;
                }

                return dummy.next; 
        
    }  
}