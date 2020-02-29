package num;

public class IsPalindrome {
    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int first = 0;
        int last = s.length()-1;
        while (first <= last) {
            if (s.charAt(first) == s.charAt(last)) {
                first++;
                last--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int x = 12321;
        boolean result = isPalindrome(x);
        System.out.println(result);
    }
}
