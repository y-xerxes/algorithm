package list;

public class FindMedianSortedArrays {

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int k = 0;
        for (int i: nums1) {
            result[k++] = i;
        }
        for (int i: nums2) {
            result[k++] = i;
        }
        sort(result, 0, result.length-1);
        return result.length % 2 == 0 ? (float)(result[result.length/2] + result[result.length/2-1]) / 2 : result[result.length/2];
    }

    private static void sort(int[] result, int left, int right) {
        if (left < right) {
            int partition = partition(result, left, right);
            sort(result, left, partition - 1);
            sort(result, partition + 1, right);
        }
    }

    private static int partition(int[] result, int left, int right) {
        int index = left + 1;
        for (int i=index; i<=right; i++) {
            if (result[i] < result[left]) {
                int temp = result[index];
                result[index] = result[i];
                result[i] = temp;
                index++;
            }
        }
        int temp1 = result[left];
        result[left] = result[index-1];
        result[index-1] = temp1;

        return index-1;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 1};
        int[] nums2 = {6, 5, 4};
        double res = findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }
}
