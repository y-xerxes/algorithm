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

    private static int partition(int[] nums, int s, int e) {
        int pivot = nums[s];
        int left = s;
        int right = e;
        while(left != right) {
            while(left < right && nums[right] > pivot) {
                right--;
            }
            while(left < right && nums[left] <= pivot) {
                left++;
            }
            if (left < right) {
                int p = nums[left];
                nums[left] = nums[right];
                nums[right] = p;
            }
        }

        nums[s] = nums[left];
        nums[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 2, 4};
        int[] result = sort(nums, 0, 4);
        System.out.println(Arrays.toString(result));
    }
}
