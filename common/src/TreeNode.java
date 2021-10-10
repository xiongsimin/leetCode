/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode original = new TreeNode(8);
        /*original.left = new TreeNode(4);
        original.right = new TreeNode(3);
        original.right.left = new TreeNode(6);
        original.right.right = new TreeNode(19);
        TreeNode cloned = original;
        System.out.println(solution.getTargetCopy(original, cloned, new TreeNode(3)).val);*/
        original.right = new TreeNode(6);
        original.right.right = new TreeNode(5);
        original.right.right.right = new TreeNode(4);
        original.right.right.right.right = new TreeNode(3);
        original.right.right.right.right.right = new TreeNode(2);
        original.right.right.right.right.right.right = new TreeNode(1);
        TreeNode cloned = original;
//        System.out.println(solution.getTargetCopy(original, cloned, new TreeNode(4)).val);
    }
}
