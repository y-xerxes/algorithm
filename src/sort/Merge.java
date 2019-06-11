package sort;

import java.util.Arrays;

public class Merge {

    private static void sort(int[] nums, int left, int right) {
        int middle = (left + right) / 2;
        if (left < right) {
            sort(nums, left, middle);
            sort(nums, middle+1, right);

            merge(nums, left, middle, right);
        }
    }

    private static void merge(int[] nums, int left, int middle, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = middle + 1;
        int k = 0;
        while(i <= middle && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while(i <= middle) {
            temp[k++] = nums[i++];
        }
        while(j <= right) {
            temp[k++] = nums[j++];
        }

        for (int x=0; x<temp.length; x++) {
            nums[x+left] = temp[x];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 5, 4};
        sort(nums, 0, 4);
        System.out.println(Arrays.toString(nums));
    }
}
