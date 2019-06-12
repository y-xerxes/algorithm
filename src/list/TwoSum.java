import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int[] result = new int[2];

        for (int i=0; i<=nums.length; i++) {
            if (m.containsKey(target-nums[i])) {
                result[0] = m.get(target-nums[i]);
                result[1] = i;
                return result;
            }
            m.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 5;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
