package sort;

import java.util.Arrays;

public class Selection {
    private static int[] sort(int[] nums) {

        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
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
