import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ((No javadoc))
 *
 * @author xiongsimin
 * @date 2022/9/18
 * 给你一个大小为 n x n 二进制矩阵 grid 。最多 只能将一格 0 变成 1 。
 *
 * 返回执行此操作后，grid 中最大的岛屿面积是多少？
 *
 * 岛屿 由一组上、下、左、右四个方向相连的 1 形成。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: grid = [[1, 0], [0, 1]]
 * 输出: 3
 * 解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
 * 示例 2:
 *
 * 输入: grid = [[1, 1], [1, 0]]
 * 输出: 4
 * 解释: 将一格0变成1，岛屿的面积扩大为 4。
 * 示例 3:
 *
 * 输入: grid = [[1, 1], [1, 1]]
 * 输出: 4
 * 解释: 没有0可以让我们变成1，面积依然为 4。
 *  
 *
 * 提示：
 *
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 500
 * grid[i][j] 为 0 或 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/making-a-large-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestIsland {
    int N;
    int[][] tag = null;
    ;
    int[][] islandNo = null;

    public int largestIsland(int[][] grid) {
        int[][] offset = new int[][]{{0, 0, -1, 1}, {1, -1, 0, 0}};
        N = grid.length;
        tag = new int[N][N];
        islandNo = new int[N][N];
        int ans = 0;

        Map<Integer, Integer> area = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int t = i * N + j + 1;
                if (grid[i][j] == 1) {
                    int sq = dfs(grid, i, j, t);
                    area.put(t, sq);
                    ans = Math.max(ans, sq);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> connected = new HashSet<>();
                    int z = 1;
                    int k = 0;
                    while (k < 4) {
                        int x = i + offset[0][k];
                        int y = j + offset[1][k];
                        if (x >= N || x < 0 || y < 0 || y >= N || grid[x][y] == 0 || connected.contains(islandNo[x][y])) {
                            k++;
                            continue;
                        }
                        z += area.get(islandNo[x][y]);
                        connected.add(islandNo[x][y]);
                        k++;
                    }
                    ans = Math.max(ans, z);
                }
            }
        }
        return ans;
    }

    int dfs(int[][] grid, int x, int y, int t) {
        if (x < 0 || y < 0 || x >= N || y >= N || grid[x][y] == 0 || tag[x][y] == 1) {
            return 0;
        }
        tag[x][y] = 1;
        islandNo[x][y] = t;
        return 1 + dfs(grid, x, y + 1, t) + dfs(grid, x, y - 1, t) + dfs(grid, x - 1, y, t) + dfs(grid, x + 1, y, t);
    }

    public static void main(String[] args) {
        LargestIsland largestIsland = new LargestIsland();
        int a = largestIsland.largestIsland(new int[][]{{1, 0}, {0, 1}});
        System.out.println(a);
    }
}
