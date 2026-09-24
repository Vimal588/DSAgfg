/* Structure of linked list Node
class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}*/

class myStack {
   Node top;
    public myStack() {
        // Initialize your data members
         top = null;
    }

    public boolean isEmpty() {
        // check if the stack is empty
        return top == null;
    }

    public void push(int x) {
        // Adds an element x at the rear of the stack.
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
    }

    public void pop() {
        // Removes the front element of the stack.
          if(isEmpty()){
            return ;
        }
        top = top.next;
    }

    public int peek() {
        // Returns the front element of the stack.
        // If stack is empty, return -1.
        if(isEmpty()){
            return -1;
        }
        return top.data;
    }

    public int size() {
        // Returns the current size of the stack.
      int  size = 0;
        Node temp = top;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        return size;
    }
}
