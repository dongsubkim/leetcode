class Solution {
    public boolean judgeSquareSum(int c) {
        for(long a = 0; a * a <= c; a++) {
            int b = c - (int) (a * a);
            if (bs(0, b, b)) {
                return true;
            }
        }
        return false;
    }
    
    boolean bs(long left, long right, int n) {
        if (left > right) return false;
        long mid = left + (right - left) / 2;
        if (mid * mid == n) return true;
        if (mid * mid > n) {
            return bs(left, mid-1, n);
        }
        return bs(mid+1, right, n);
    }
}