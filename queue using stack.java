class MyQueue {

    // Stack for incoming elements (LIFO)

    private Deque<Integer> inputStack = new ArrayDeque<>();

    // Stack for outgoing elements (converts to FIFO order)

    private Deque<Integer> outputStack = new ArrayDeque<>();


    /**

     * Initialize the queue data structure

     */

    public MyQueue() {

    }


    /**

     * Push element x to the back of queue

     * Time Complexity: O(1)

     * @param x the element to be added to the queue

     */

    public void push(int x) {

        inputStack.push(x);

    }


    /**

     * Remove and return the element from the front of queue

     * Time Complexity: Amortized O(1)

     * @return the front element of the queue

     */

    public int pop() {

        transferElements();

        return outputStack.pop();

    }


    /**

     * Get the front element without removing it

     * Time Complexity: Amortized O(1)

     * @return the front element of the queue

     */

    public int peek() {

        transferElements();

        return outputStack.peek();

    }


    /**

     * Check whether the queue is empty

     * Time Complexity: O(1)

     * @return true if the queue is empty, false otherwise

     */

    public boolean empty() {

        return inputStack.isEmpty() && outputStack.isEmpty();

    }


    /**

     * Transfer elements from input stack to output stack when needed

     * This reverses the order of elements, converting LIFO to FIFO

     * Only transfers when output stack is empty to maintain queue order

     */

    private void transferElements() {

        // Only transfer if output stack is empty

        if (outputStack.isEmpty()) {

            // Move all elements from input stack to output stack

            while (!inputStack.isEmpty()) {

                outputStack.push(inputStack.pop());

            }

        }

    }

}


/**

 * Your MyQueue object will be instantiated and called as such:

 * MyQueue obj = new MyQueue();

 * obj.push(x);

 * int param_2 = obj.pop();

 * int param_3 = obj.peek();

 * boolean param_4 = obj.empty();

 */
