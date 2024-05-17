public class LeetCode6 {
    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        if (s.length() <= numRows || numRows == 1) {
            return s;
        }
        int max = 2 * (numRows - 1);
        int step = max;
        for (int i = 0; i < numRows; i ++) {
            int k = i;

            if (i != 0 && i + 1 != numRows) {
                step = step - 2;
            } else {
                step = 2 * (numRows - 1);
            }
            int tmp = step;
            while (k < s.length()) {
                sb.append(s.charAt(k));
                k += step;
                if (step != max) {
                    step = max - step;
                }
            }
            step = tmp;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode6().convert("PAYPALISHIRING", 3));  // PAHNAPLSIIGYIR
        System.out.println(new LeetCode6().convert("PAYPALISHIRING", 4));  // PINALSIGYAHRPI
        System.out.println(new LeetCode6().convert("A", 1));  // A
        System.out.println(new LeetCode6().convert("AB", 1));  // AB
    }
}

//3 -> 0 4 8, 1 3 5 7, 2, 6, 10 -> 4, 2 2, 4
//4 -> 0 6 12, 1 5 7 11 13,  6 -> 4 2, 2 4,
//5 -> 0 8, 1 7 9,  8, 6 2
//
//x       x
//x     x x
//x   x   x
//x x     x
//x       x