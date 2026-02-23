from typing import List
from itertools import pairwise

class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        """
        Check if the array contains any duplicate elements.
      
        Args:
            nums: List of integers to check for duplicates
          
        Returns:
            True if any value appears at least twice, False otherwise
        """
        # Sort the array so duplicate elements will be adjacent
        sorted_nums = sorted(nums)
      
        # Check each pair of consecutive elements for equality
        # pairwise() creates sliding window pairs: (a[0], a[1]), (a[1], a[2]), ...
        # any() returns True if at least one pair has equal elements
        return any(a == b for a, b in pairwise(sorted_nums))