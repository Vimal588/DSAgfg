class Solution {
    public ArrayList<Integer> printList(Node head) {

        ArrayList<Integer> ans = new ArrayList<>();

        Node temp = head;

        while (temp != null) {
            ans.add(temp.data);
            temp = temp.next;
        }

        return ans;
    }
}