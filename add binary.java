public class Solution {
    public String addBinary(String a, String b) {
        // Use StringBuilder for efficient string concatenation/building
        StringBuilder sb = new StringBuilder();
        // Initialize pointers to the last index of each string
        int i = a.length() - 1;
        int j = b.length() - 1;
        // Initialize carry to 0
        int carry = 0;

        // Loop continues as long as there are bits to process in either string or there is a carry
        while (i >= 0 || j >= 0 || carry == 1) {
            // Add the current bits and carry
            // (a.charAt(i--) - '0') converts the character '0' or '1' to its integer value
            if (i >= 0) {
                carry += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                carry += b.charAt(j) - '0';
                j--;
            }

            // Append the current bit of the sum (carry % 2) to the result string
            sb.append(carry % 2);

            // Update the carry for the next iteration (carry / 2)
            carry /= 2;
        }

        // The result is built from right to left, so it needs to be reversed
        return sb.reverse().toString();
    }
}
