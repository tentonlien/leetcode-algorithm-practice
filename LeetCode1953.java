/**
 * @author Tenton Lien
 * Failed
 */
public class LeetCode1953 {

    int max = 0;
    public long numberOfWeeks(int[] milestones) {
        doTask(milestones, -1, 0);
        return max;
    }

    void doTask(int[] milestones, int prevPos, int day) {
        for (int i = 0; i < milestones.length; i ++) {
            System.out.print(milestones[i] + ", ");
        }
        System.out.println();
        boolean flag = true;
        for (int i = 0; i < milestones.length; i ++) {
            if (milestones[i] > 0 && prevPos != i) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("break");
            return;
        }
        for (int i = 0; i < milestones.length; i ++) {
            if (prevPos == i || milestones[i] == 0) {
                continue;
            }
            milestones[i] --;
            doTask(milestones, i, day + 1);
            max = Math.max(day + 1, max);
            milestones[i] ++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode1953().numberOfWeeks(new int[]{1,2,3}));
        System.out.println(new LeetCode1953().numberOfWeeks(new int[]{5,2,1}));
        System.out.println(new LeetCode1953().numberOfWeeks(new int[]{9,3,6,8,2,1}));
    }
}
