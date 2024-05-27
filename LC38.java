public class LC38 {
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i ++) {
            result = calc(result);
        }
        return result;
    }

    String calc(String s) {
        if (s.length() == 1) {
            return "1" + s.charAt(0);
        }
        int i = 1;
        String result = "";
        char prev = s.charAt(0);
        int count = 1;
        while (i < s.length()) {
            if (s.charAt(i) == prev) {
                count ++;
            } else {
                result += String.valueOf(count) + prev;
                prev = s.charAt(i);
                count = 1;
            }
            i ++;
        }
        result += String.valueOf(count) + prev;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LC38().countAndSay(4));
        System.out.println(new LC38().countAndSay(1));
        System.out.println(new LC38().countAndSay(30));
    }
}
