package string;

public class LongestPalindrome {

    // method1
    private static String longestPalindromeM1(String s) {
        if (s == null || s.length()<1) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i=0; i<s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len-1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end+1);
    }
    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    // method2
    private static String longestPalindromeM2(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        int maxLen = 0;
        int start = 1;
        for (int i=0; i<s.length(); i++) {
            for (int j=0; j<=i; j++) {
                if (i - j < 2) {
                    isPalindrome[j][i] = (s.charAt(j) == s.charAt(i));
                } else {
                    isPalindrome[j][i] = (s.charAt(j) == s.charAt(i)) && isPalindrome[j+1][i-1];
                }
                if (isPalindrome[j][i] && i - j + 1 > maxLen) {
                    maxLen = i - j + 1;
                    start = j;
                }
            }
        }
        return s.substring(start, start+maxLen);
    }

    public static void main(String[] args) {
        String s = "java";
        String ps = longestPalindromeM2(s);
        System.out.println(ps);
    }
}
