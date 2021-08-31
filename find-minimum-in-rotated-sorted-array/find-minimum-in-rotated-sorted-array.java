class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (nums[left] < nums[mid]) {
                if (nums[mid] < nums[right]) return nums[left];
                else left = mid;
            } else {
                right = mid;
            }
        }
        return Math.min(nums[left], nums[right]);
    }
}