import java.util.Arrays;

public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int[] result = new int[]{-1, -1};
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                result[0] = result[1] = mid;
                break;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (result[0] == -1) {
            return result;
        }
        while (result[0] > 0 && nums[result[0] - 1] == target) {
            result[0] --;
        }
        while (result[1] < nums.length - 1 && nums[result[1] + 1] == target) {
            result[1] ++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode34().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }
}
