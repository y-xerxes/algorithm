package list;

import java.util.ArrayList;
import java.util.List;

public class ZConvert {
    private static String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i=0; i<Math.min(s.length(), numRows); i++) {
            rows.add(new StringBuilder());
        }

        boolean down = false;
        int curRow = 0;
        for (char c: s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows-1) {
                down = !down;
            }
            curRow += down ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb: rows) {
            result.append(sb);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        String result = convert(s, 1);
        System.out.println(result);
    }
}
