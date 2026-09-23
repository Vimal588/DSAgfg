class myStack {
     
     int[] arr;
     int size;
     int top;
     
     
    public myStack(int n) {
        // Define Data Structures
        size = n;
        arr = new int[n];
        top = -1;
        
    }

    public boolean isEmpty() {
        // check if the stack is empty
        if(top== -1){
            return true;
        }
        return false;
    }

    public boolean isFull() {
        // check if the stack is full
        if(top == size-1){
            return true;
        }
        return false;
    }

    public void push(int x) {
        // Inserts x at the top of the stack
          if(isFull()){
            return ;
        }
        top++;
        arr[top] = x;
    }

    public void pop() {
        // Removes an element from the top of the stack
        if(isEmpty()){
            return;
        }
        int val = arr[top];
        top--;
        
    }

    public int peek() {
        // Returns the top element of the stack
        if (isEmpty()) {
                    return -1;
                }

                return arr[top];
    }
}