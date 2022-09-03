import java.util.HashSet;
import java.util.Set;

/**
 * ((No javadoc))
 *
 * @author xiongsimin
 * @date 2022/9/3
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 *
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 *
 * 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 *
 *  
 *
 * 示例：
 *
 * 输入：[[1,2], [2,3], [3,4]]
 * 输出：2
 * 解释：最长的数对链是 [1,2] -> [3,4]
 *  
 *
 * 提示：
 *
 * 给出数对的个数在 [1, 1000] 范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-length-of-pair-chain
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindLongestChain {
    // 暴力解法
    public int findLongestChain(int[][] pairs) {
        int res = 0;
        int curPos = -1;
        Set<Integer> usedSet = new HashSet<>();
        for (int i = 0; i < pairs.length; i++) {
            int minRight = Integer.MAX_VALUE;
            int minRightPos = 0;
            // 找出右值最小的数对
            for (int j = 0; j < pairs.length; j++) {
                if (usedSet.contains(j)) {
                    continue;
                }
                if (pairs[j][1] < minRight) {
                    minRightPos = j;
                    minRight = pairs[j][1];
                }
            }
            usedSet.add(minRightPos);
            if (curPos == -1 || pairs[minRightPos][0] > pairs[curPos][1]) {
                curPos = minRightPos;
                res++;
            }

        }
        return res;
    }
}
