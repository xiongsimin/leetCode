/**
 * ((No javadoc))
 *
 * @author xiongsimin
 * @date 2022/8/30
 */
public class InsertIntoMaxTree {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode parent = null;
        TreeNode cur = root;
        while (cur != null) {
            if (val > cur.val) {
                if (parent == null) {
                    return new TreeNode(val, root, null);
                }
                TreeNode node = new TreeNode(val, cur, null);
                parent.right = node;
                return root;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }
        parent.right = new TreeNode(val);
        return root;
    }

    /*作者：LeetCode-Solution
    链接：https://leetcode.cn/problems/maximum-binary-tree-ii/solution/zui-da-er-cha-shu-ii-by-leetcode-solutio-piv2/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
