import java.util.ArrayList;
import java.util.List;

/**
 * ((No javadoc))
 *
 * @author xiongsimin
 * @date 2022/8/28
 * 给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，用以表示树的 格式化布局 。构造此格式化布局矩阵需要遵循以下规则：
 *
 * 树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
 * 矩阵的列数 n 应该等于 2height+1 - 1 。
 * 根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。
 * 对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2height-r-1] ，右子节点放置在 res[r+1][c+2height-r-1] 。
 * 继续这一过程，直到树中的所有节点都妥善放置。
 * 任意空单元格都应该包含空字符串 "" 。
 * 返回构造得到的矩阵 res 。
 *
 *  
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2]
 * 输出：
 * [["","1",""],
 *  ["2","",""]]
 * 示例 2：
 *
 *
 * 输入：root = [1,2,3,null,4]
 * 输出：
 * [["","","","1","","",""],
 *  ["","2","","","","3",""],
 *  ["","","4","","","",""]]
 *  
 *
 * 提示：
 *
 * 树中节点数在范围 [1, 210] 内
 * -99 <= Node.val <= 99
 * 树的深度在范围 [1, 10] 内
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/print-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PrintTree {
    public static List<List<String>> printTree(TreeNode root) {
        int height = deep(root) - 1;
        int m = height + 1;
        int n = (1 << (height + 1)) - 1;
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<String> line = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                line.add("");
            }
            res.add(line);
        }
        restruct(root, res, 0, n / 2, height);
        return res;
    }

    static int deep(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(deep(node.left), deep(node.right));
    }

    static void restruct(TreeNode node, List<List<String>> res, int r, int c, int height) {
        if (node == null) {
            return;
        }
        res.get(r).set(c, String.valueOf(node.val));
        restruct(node.left, res, r + 1, c - (1 << (height - r - 1)), height);
        restruct(node.right, res, r + 1, c + (1 << height - r - 1), height);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        List<List<String>> lists = PrintTree.printTree(root);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.print(s+",");
            }
            System.out.println();
        }
    }
}
