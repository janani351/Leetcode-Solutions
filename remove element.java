class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0; // Pointer to place the next valid element

        // Iterate through all elements with a second pointer (implicit 'i' in the loop)
        for (int i = 0; i < nums.length; i++) {
            // If the current element is not the value to remove
            if (nums[i] != val) {
                // Place the valid element at the 'k' position
                nums[k] = nums[i];
                // Move the 'k' pointer forward
                k++;
            }
        }
        
        // 'k' is the number of elements not equal to 'val'
        return k;
    }
}
