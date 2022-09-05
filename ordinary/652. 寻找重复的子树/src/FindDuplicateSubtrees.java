import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ((No javadoc))
 *
 * @author xiongsimin
 * @date 2022/9/5
 * 给定一棵二叉树 root，返回所有重复的子树。
 *
 * 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,2,3,4,null,2,4,null,null,4]
 * 输出：[[2,4],[4]]
 * 示例 2：
 *
 *
 *
 * 输入：root = [2,1,1]
 * 输出：[[1]]
 * 示例 3：
 *
 *
 *
 * 输入：root = [2,2,2,3,null,3,null]
 * 输出：[[2,3],[3]]
 *  
 *
 * 提示：
 *
 * 树中的结点数在[1,10^4]范围内。
 * -200 <= Node.val <= 200
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-duplicate-subtrees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindDuplicateSubtrees {
    Map<String,TreeNode> seria = new HashMap<>();
    Set<TreeNode> repeat = new HashSet<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<>(repeat);
    }
    String dfs(TreeNode node){
        if(node == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(node.val);
        sb.append("(");
        sb.append(dfs(node.left));
        sb.append(")(");
        sb.append(dfs(node.right));
        sb.append(")");
        if(seria.containsKey(sb.toString())){
            repeat.add(seria.get(sb.toString()));
        }else{
            seria.put(sb.toString(),node);
        }
        return sb.toString();
    }
}
