import java.util.*;

class myStack {

    Queue<Integer> q = new LinkedList<>();
    Queue<Integer> q1 = new LinkedList<>();

    void push(int x) {
        // Insert x at the top of the stack

        // Move all existing elements to q1
        while (!q.isEmpty()) {
            q1.add(q.remove());
        }

        // Add new element first
        q.add(x);

        // Move elements back to q
        while (!q1.isEmpty()) {
            q.add(q1.remove());
        }
    }

    void pop() {
        // Remove top element

        if (q.isEmpty()) {
            return;
        }

        q.remove();
    }

    int top() {
        // Return top element

        if (q.isEmpty()) {
            return -1;
        }

        return q.peek();
    }

    int size() {
        return q.size();
    }
}