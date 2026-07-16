// Last updated: 7/16/2026, 4:07:35 PM
class Solution {
    public boolean isPowerOfTwo(int n) {

        // Powers of two are always positive
        if (n < 1) {
            return false;
        }

        // Keep dividing by 2 while possible
        while (n % 2 == 0) {
            n /= 2;
        }

        // If we end up at 1, n was a power of two
        return n == 1;
    }
}