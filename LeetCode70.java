import java.util.HashMap;
import java.util.Map;

/**
 * @author Tenton Lien
 */
public class LeetCode70 {
    Map<Integer, Integer> memo = new HashMap<>();

    public int climbStairs(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int val = climbStairs(n - 1) + climbStairs(n - 2);
        memo.put(n, val);
        return val;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode70().climbStairs(2));  // 2
        System.out.println(new LeetCode70().climbStairs(3));  // 3
        System.out.println(new LeetCode70().climbStairs(5));
        System.out.println(new LeetCode70().climbStairs(44));
        System.out.println(new LeetCode70().climbStairs(45));
    }
}
