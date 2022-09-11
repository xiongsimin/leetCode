import java.util.PriorityQueue;

/**
 * ((No javadoc))
 *
 * @author xiongsimin
 * @date 2022/9/11
 * 给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
 *
 * 请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
 *
 * 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 *
 * 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：mat =
 * [[1,1,0,0,0],
 * [1,1,1,1,0],
 * [1,0,0,0,0],
 * [1,1,0,0,0],
 * [1,1,1,1,1]],
 * k = 3
 * 输出：[2,0,3]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 2
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 2
 * 行 4 -> 5
 * 从最弱到最强对这些行排序后得到 [2,0,3,1,4]
 * 示例 2：
 *
 * 输入：mat =
 * [[1,0,0,0],
 *  [1,1,1,1],
 *  [1,0,0,0],
 *  [1,0,0,0]],
 * k = 2
 * 输出：[0,2]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 1
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 1
 * 从最弱到最强对这些行排序后得到 [0,2,3,1]
 *  
 *
 * 提示：
 *
 * m == mat.length
 * n == mat[i].length
 * 2 <= n, m <= 100
 * 1 <= k <= m
 * matrix[i][j] 不是 0 就是 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/the-k-weakest-rows-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KWeakestRows {
    public static int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] combatEffectiveness = new int[m][2];
        for (int i = 0; i < m; i++) {
            int left = 0;
            int right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (mat[i][mid] == 0) {
                    right = mid - 1;
                } else if (mat[i][mid] == 1) {
                    left = mid + 1;
                }
            }
            combatEffectiveness[i][0] = right + 1;
            combatEffectiveness[i][1] = i;
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] < o2[0]) {
                return -1;
            } else if (o1[0] > o2[0]) {
                return 1;
            } else {
                if (o1[1] < o2[1]) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        for (int i = 0; i < combatEffectiveness.length; i++) {
            heap.offer(combatEffectiveness[i]);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll()[1];
        }
        return res;

    }

    public static void main(String[] args) {
        int[] res = KWeakestRows.kWeakestRows(new int[][]{{1, 0, 0, 0}, {1, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 0}}, 2);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }
}
