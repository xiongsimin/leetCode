/**
 * ((No javadoc))
 *
 * @author xiongsimin
 * @date 2022/9/4
 * 给定一个二叉树的 root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。
 *
 * 两个节点之间的路径长度 由它们之间的边数表示。
 *
 *  
 *
 * 示例 1:
 *
 *
 *
 * 输入：root = [5,4,5,1,1,5]
 * 输出：2
 * 示例 2:
 *
 *
 *
 * 输入：root = [1,4,5,4,4,5]
 * 输出：2
 *  
 *
 * 提示:
 *
 * 树的节点数的范围是 [0, 104] 
 * -1000 <= Node.val <= 1000
 * 树的深度将不超过 1000 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-univalue-path
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestUnivaluePath {
    int res = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return res;
    }

    int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int childLeft = dfs(node.left);
        int childRight = dfs(node.right);
        int left = 0, right = 0;
        if (node.left != null && node.left.val == node.val) {
            left = childLeft + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            right = childRight + 1;
        }
        res = Math.max(res, left + right);
        return Math.max(left, right);
    }
}
