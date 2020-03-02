package tree;

import java.util.Arrays;

public class BinaryHeap {
    private static void sort(int[] nums) {
        for (int i=nums.length/2-1; i>=0; i--) {
            adjustHeap(nums, i, nums.length);
        }
    }

    private static void adjustHeap(int[] nums, int i, int length) {
        int temp = nums[i];
        for (int k=2*i+1; k<nums.length; k=2*k+1) {
            if (k+1 < length && nums[k] > nums[k+1]) {
                k++;
            }
            if (nums[i] < nums[k]) {
                break;
            } else {
                nums[i] = nums[k];
                i = k;
            }
            nums[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
