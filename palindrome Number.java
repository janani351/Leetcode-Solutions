class Solution {
    public boolean isPalindrome(int x) {
        // Handle edge cases:
        // 1. Negative numbers are not palindromes.
        // 2. Numbers ending in 0 (but are not 0 themselves, like 10) are not palindromes
        //    because the reversed number would start with a 0.
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // When the loop finishes, we have either an even or odd number of digits.
        // For an even number, x and revertedNumber will be equal.
        // For an odd number, the middle digit (which doesn't affect the palindrome check)
        // is in revertedNumber (e.g., if x = 121, x becomes 1 and revertedNumber becomes 21).
        // We can ignore the middle digit by dividing revertedNumber by 10.
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
