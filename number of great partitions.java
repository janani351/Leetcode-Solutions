class Solution {
    private static final int MOD = (int) 1e9 + 7;

    public int countPartitions(int[] nums, int k) {
        // Calculate the total sum of all elements
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
      
        // If total sum is less than 2k, no valid partition exists
        // Both partitions need sum >= k, so total must be >= 2k
        if (totalSum < k * 2) {
            return 0;
        }
      
        int n = nums.length;
      
        // dp[i][j] represents the number of ways to select elements from first i elements
        // such that their sum equals j
        long[][] dp = new long[n + 1][k];
        dp[0][0] = 1; // Base case: one way to get sum 0 with 0 elements
      
        // Total number of possible partitions (2^n)
        long totalPartitions = 1;
      
        // Process each element
        for (int i = 1; i <= n; i++) {
            int currentNum = nums[i - 1];
          
            // Each element can go to either partition, so multiply by 2
            totalPartitions = totalPartitions * 2 % MOD;
          
            // Update dp table for all possible sums less than k
            for (int sum = 0; sum < k; sum++) {
                // Case 1: Don't include current element in this subset
                dp[i][sum] = dp[i - 1][sum];
              
                // Case 2: Include current element if possible
                if (sum >= currentNum) {
                    dp[i][sum] = (dp[i][sum] + dp[i - 1][sum - currentNum]) % MOD;
                }
            }
        }
      
        // Subtract invalid partitions where at least one partition has sum < k
        // dp[n][j] counts subsets with sum j < k
        // Each such subset creates 2 invalid partitions (subset and its complement)
        for (int sum = 0; sum < k; sum++) {
            totalPartitions = (totalPartitions - dp[n][sum] * 2 % MOD + MOD) % MOD;
        }
      
        return (int) totalPartitions;
    }
}
