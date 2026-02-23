from collections import deque
from typing import Optional


class MyStack:
    """
    Implementation of a stack using two queues.
    The stack follows LIFO (Last In First Out) principle.
    """
  
    def __init__(self):
        """Initialize two empty queues for stack implementation."""
        self.queue_main = deque()  # Main queue that maintains stack order
        self.queue_temp = deque()  # Temporary queue used during push operation
  
    def push(self, x: int) -> None:
        """
        Push element x onto stack.
        Strategy: Add new element to temp queue, then move all elements from main queue
        to temp queue, finally swap the queues to maintain stack order.
      
        Args:
            x: Integer element to be pushed onto the stack
        """
        # Add new element to temporary queue
        self.queue_temp.append(x)
      
        # Move all existing elements from main queue to temporary queue
        while self.queue_main:
            self.queue_temp.append(self.queue_main.popleft())
      
        # Swap queues so main queue has elements in stack order (newest first)
        self.queue_main, self.queue_temp = self.queue_temp, self.queue_main
  
    def pop(self) -> int:
        """
        Remove and return the element on top of the stack.
      
        Returns:
            The top element of the stack
        """
        # Remove and return the first element (which is the last pushed element)
        return self.queue_main.popleft()
  
    def top(self) -> int:
        """
        Get the top element without removing it.
      
        Returns:
            The top element of the stack
        """
        # Return the first element without removing it
        return self.queue_main[0]
  
    def empty(self) -> bool:
        """
        Check whether the stack is empty.
      
        Returns:
            True if stack is empty, False otherwise
        """
        return len(self.queue_main) == 0


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()