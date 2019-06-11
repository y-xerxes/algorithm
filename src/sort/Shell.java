package sort;

import java.util.Arrays;

public class Shell {
    private static int[] sort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        for (int d=nums.length/2; d>0; d /= 2) {
            for (int i=d; i<nums.length; i++) {
                for (int j=i-d; j>=0; j -= d) {
                    if (nums[j] > nums[j+d]) {
                        int temp = nums[j];
                        nums[j] = nums[j+d];
                        nums[j+d] = temp;
                    }
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 5, 4};
        int[] result = sort(nums);
        System.out.println(Arrays.toString(result));
    }
}
