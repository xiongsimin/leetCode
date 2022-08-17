import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * ((No javadoc))
 *
 * @author xiongsimin
 * @date 2022/8/17
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 * 示例 2：
 *
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * 输出：19
 *  
 *
 * 提示：
 *
 * 树中节点数目在范围 [1, 104] 之间。
 * 1 <= Node.val <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/deepest-leaves-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeepestLeavesSum {
    int maxDeep = 0;
    int sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    public void dfs(TreeNode node, int deep) {
        if (node == null) {
            return;
        }
        if (maxDeep == deep) {
            sum += node.val;
        } else if (maxDeep < deep) {
            maxDeep = deep;
            sum = node.val;
        }
        dfs(node.left, deep + 1);
        dfs(node.right, deep + 1);
    }


    public int deepestLeavesSum1(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return sum;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (queue.size() != 0) {
            sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                sum += poll.val;

                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        DeepestLeavesSum deepestLeavesSum = new DeepestLeavesSum();
        //[1,2,3,4,5,null,6,7,null,null,null,null,8]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(8);
        int i = deepestLeavesSum.deepestLeavesSum1(root);
        System.out.println(i);
    }

}
