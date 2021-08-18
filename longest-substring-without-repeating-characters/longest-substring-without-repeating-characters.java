class Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        int left = 0, right = 0;
        int N = s.length();
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
            
        while (right < N) {
            if (set.contains(chars[right])) {
                set.remove(chars[left++]);
            } else {
                set.add(chars[right++]);
                answer = Math.max(answer, right - left);
            }
        }
        return answer;
    }
}