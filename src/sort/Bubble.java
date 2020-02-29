package sort;

import java.util.Arrays;

public class Bubble {
    private static int[] sort(int[] nums) {

        for (int i=0; i<nums.length; i++) {

            boolean flag = true;

            for (int j=0; j<nums.length-1; j++) {
                if (nums[j + 1] < nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;

                    flag = false;
                }
            }

            if (flag) {
                break;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 5, 4};
        int[] result = sort(nums);
        System.out.println(Arrays.toString(result));
    }
}
