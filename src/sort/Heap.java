package sort;

import java.util.Arrays;

public class Heap {
    private static void sort(int[] nums) {
        for (int i=nums.length/2-1; i>=0; i--) {
            adjustHeap(nums, i, nums.length);
        }

        for (int j=nums.length-1; j>=0; j--) {
            int temp = nums[0];
            nums[0] = nums[j];
            nums[j] = temp;
            adjustHeap(nums, 0, j);
        }
    }

    private static void adjustHeap(int[] nums, int i, int length) {
        int temp = nums[i];
        for (int k=2*i+1; k<nums.length; k=2*k+1) {
            if (k+1 < length && nums[k] < nums[k+1]) {
                k++;
            }
            if (nums[i] < nums[k]) {
                nums[i] = nums[k];
                i = k;
            } else {
                break;
            }
            nums[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 5, 4};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
