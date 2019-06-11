package sort;

import java.util.Arrays;

public class Insertion {
    private static int[] sort(int[] nums) {

        for (int i=1; i<nums.length; i++) {

            int temp = nums[i];

            int j = i;
            while (j>0 && nums[j-1]>temp) {
                nums[j] = nums[j-1];
                j--;
            }

            nums[j] = temp;
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 5, 4};
        int[] result = sort(nums);
        System.out.println(Arrays.toString(result));
    }
}
