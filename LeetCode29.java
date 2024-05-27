public class LeetCode29 {
    public int divide(int dividend, int divisor) {
        int result = 0;
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        while (a >= b) {
            a -= b;
            result ++;
        }
        if (result == 0 && dividend != 0 && Math.abs(dividend) > Math.abs(divisor)) {
            return (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) ? Integer.MAX_VALUE - 1: Integer.MIN_VALUE;
        } else {
            return (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) ? result: 0 - result;
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode29().divide(-2147483648, -1));
    }
}
