/* structure of link list node
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
*/
class Solution {
    public boolean isEven(Node head) {
        // code here
       Node temp = head;
       int n = 0;
       while(temp!=null){
           n++;
           temp = temp.next;
       }
       if(n%2==0){
           return true;
       }
       return false;
    }
}