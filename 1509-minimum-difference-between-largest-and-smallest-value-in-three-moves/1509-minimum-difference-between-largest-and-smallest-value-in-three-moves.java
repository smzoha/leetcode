class Solution {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) return 0;

        Arrays.sort(nums);

        int result = Integer.MAX_VALUE;

        for (int l = 0, r = nums.length - 4; r < nums.length; l++, r++) {
            result = Math.min(result, nums[r] - nums[l]);
        }

        return result;
    }
}