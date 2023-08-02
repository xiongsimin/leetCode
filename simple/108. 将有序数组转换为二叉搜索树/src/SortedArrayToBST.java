package src;

/**
 * ((No javadoc))
 *
 * @author xiongsimin
 * @date 2023/8/3
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = getRoot(nums, 0, nums.length - 1);
        return root;
    }

    TreeNode getRoot(int[] nums, int L, int R) {
        if (L > R) {
            return null;
        }
        int mid = (L + R) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = getRoot(nums, L, mid - 1);
        root.right = getRoot(nums, mid + 1, R);
        return root;
    }
}
