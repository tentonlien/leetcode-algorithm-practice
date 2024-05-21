import java.util.ArrayList;
import java.util.List;

public class LeetCode22 {
    List<String> results = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        gen("", n, 0);
        return results;
    }

    void gen(String result, int left, int right) {
        if (left == 0 && right == 0) {
            results.add(result);
            return;
        }
        if (left > 0) {
            gen(result + "(", left - 1, right + 1);
        }
        if (right > 0) {
            gen(result + ")", left, right - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode22().generateParenthesis(3));
    }
}
