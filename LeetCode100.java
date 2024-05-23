import common.TreeNode;

public class LeetCode100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        if (p.val != q.val) {
            return false;
        }
        boolean b1 = isSameTree(p.left, q.left);
        boolean b2 = isSameTree(p.right, q.right);
        return b1 && b2;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode100().isSameTree(
                new TreeNode(1, new TreeNode(2), new TreeNode(3)),
                new TreeNode(1, new TreeNode(2), new TreeNode(3))
        ));
    }
}
