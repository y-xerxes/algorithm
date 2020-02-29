package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int i=0,j=0; i<length; i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(map.get(s.charAt(i)), j);
            }
            map.put(s.charAt(i), i+1);
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "qwvawsrew";
    }
}
