package sort;

import java.util.Arrays;

public class Heap {
    public static void heapSort(int[] arr) {
        for (int i=arr.length/2-1; i>=0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        System.out.println(Arrays.toString(arr));
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, i);
        }
    }

    private static void adjustHeap(int[] nums, int i, int length) {
        int temp = nums[i];
        for (int k=2*i+1; k<length; k=2*k+1) {
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
        int[] arr = new int[] {1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
