class Solution {
    public int minOperations(String s) {
        char[] nums = s.toCharArray();
        int N = s.length();

        int res1 = 0, res2 = 0;
        
        for (int i = 0; i < N; i++) {
            int v = nums[i] - '0';
            if (v != i % 2) res1++;
            if (v != ((i+1) % 2)) res2++;
        }
        
        if (res1 > res2) return res2;
        return res1;
        
    }
}