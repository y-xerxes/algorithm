package sort;

import java.util.Arrays;

public class Quick {

    private static int[] sort(int[] nums, int left, int right) {
        if (left < right) {
            int partition = partition(nums, left, right);
            sort(nums, left, partition-1);
            sort(nums, partition+1, right);
        }
        return nums;
    }

    private static int partition(int[] nums, int left, int right) {
        int index = left+1;

        for (int x=index; x<=right; x++) {
            if (nums[x] < nums[left]) {
                int temp = nums[index];
                nums[index] = nums[x];
                nums[x] = temp;
                index++;
            }
        }

        int temp1 = nums[left];
        nums[left] = nums[index-1];
        nums[index-1] = temp1;

        return index-1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 2, 4};
        int[] result = sort(nums, 0, 4);
        System.out.println(Arrays.toString(result));
    }
}
