class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
        """
        Find the maximum sum of min(a_i, b_i) for all pairs in the array.
      
        Strategy: Sort the array and take every alternate element starting from index 0.
        This ensures we pair smallest with second smallest, third smallest with fourth smallest, etc.
        This maximizes the sum since we're always choosing the smaller element from each optimal pair.
      
        Args:
            nums: List of integers to form pairs
          
        Returns:
            Maximum possible sum of minimum elements from all pairs
        """
        # Sort the array in ascending order
        nums.sort()
      
        # Sum every alternate element starting from index 0 (elements at even indices)
        # nums[::2] creates a slice with step 2, giving us elements at indices 0, 2, 4, ...
        return sum(nums[::2])