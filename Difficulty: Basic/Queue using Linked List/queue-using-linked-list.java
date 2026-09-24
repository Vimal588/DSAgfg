// Node class
class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

// Queue class
class myQueue {

    Node front;
    Node rear;

    public myQueue() {
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(int x) {

        Node newNode = new Node(x);

        // Queue is empty
        if (rear == null) {
            front = rear = newNode;
            return;
        }

        // Insert at rear
        rear.next = newNode;
        rear = newNode;
    }

    public void dequeue() {

        // Queue is empty
        if (isEmpty()) {
            return;
        }

        // Remove front
        front = front.next;

        // Queue became empty
        if (front == null) {
            rear = null;
        }
    }

    public int getFront() {

        // Queue is empty
        if (isEmpty()) {
            return -1;
        }

        return front.data;
    }

    public int size() {

        int size = 0;
        Node temp = front;

        while (temp != null) {
            size++;
            temp = temp.next;
        }

        return size;
    }
}
