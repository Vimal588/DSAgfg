import java.util.*;

class Solution {
    public List<List<Integer>> displayList(Node head) {

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> forward = new ArrayList<>();
        List<Integer> backward = new ArrayList<>();

        Node temp = head;
        Node tail = null;

        // Forward traversal
        while (temp != null) {
            forward.add(temp.data);
            tail = temp;
            temp = temp.next;
        }

        // Backward traversal
        temp = tail;

        while (temp != null) {
            backward.add(temp.data);
            temp = temp.prev;
        }

        ans.add(forward);
        ans.add(backward);

        return ans;
    }
}