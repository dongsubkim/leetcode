class Solution {
    
    public int[] minOperations(String boxes) {
        int N = boxes.length();
        int[] res = new int[N];
        int left = 0, right = 0;
        
        for(int i = 1; i < N; i++) {
            if (boxes.charAt(i) == '1') {
                right++;
                res[0] += i;
            }
        }

        if (boxes.charAt(0) == '1') left++;

        for(int i = 1; i < N; i++) {
            res[i] = res[i-1] - right + left;
            
            if (boxes.charAt(i) == '1') {
                left++;
                right--;
            }
        }
        return res;
    }

}