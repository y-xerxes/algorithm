package dynamic_programming;

public class MaxSubarray {
    public static int maxSubarray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i=1; i<nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i-1]);
        }

        int res = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
