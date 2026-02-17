class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Stack to maintain elements in decreasing order from top to bottom
        Deque<Integer> stack = new ArrayDeque<>();
      
        // Get array lengths
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
      
        // HashMap to store the next greater element for each number in nums2
        // Key: number from nums2, Value: its next greater element
        Map<Integer, Integer> nextGreaterMap = new HashMap<>(nums2Length);
      
        // Traverse nums2 from right to left to find next greater elements
        for (int i = nums2Length - 1; i >= 0; i--) {
            int currentNum = nums2[i];
          
            // Pop elements from stack that are smaller than current number
            // These cannot be the next greater element for current number
            while (!stack.isEmpty() && stack.peek() < currentNum) {
                stack.pop();
            }
          
            // If stack is not empty, top element is the next greater element
            if (!stack.isEmpty()) {
                nextGreaterMap.put(currentNum, stack.peek());
            }
          
            // Push current number to stack for processing future elements
            stack.push(currentNum);
        }
      
        // Build result array by looking up next greater elements for nums1
        int[] result = new int[nums1Length];
        for (int i = 0; i < nums1Length; i++) {
            // Get next greater element from map, default to -1 if not found
            result[i] = nextGreaterMap.getOrDefault(nums1[i], -1);
        }
      
        return result;
    }
}
