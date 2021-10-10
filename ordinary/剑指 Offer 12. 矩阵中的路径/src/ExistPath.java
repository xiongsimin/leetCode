import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author aries
 * @Data 2021-07-27
 * @Description 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 *  
 * <p>
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * board 和 word 仅由大小写英文字母组成
 *  
 * <p>
 * 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ExistPath {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        int[] visited = new int[m * n];
        for (int i = 0; i < m * n; i++) {
            if (board[i / n][i % n] == word.charAt(0)) {
                if (find(board, i, visited, word, 0, m, n)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean find(char[][] board, int index, int[] visited, String word, int position, int m, int n) {
        if (index < 0 || index >= m * n || visited[index] == 1 || board[index / n][index % n] != word.charAt(position)) {
            return false;
        }
        if (position == word.length() - 1) {
            return true;
        }
        visited[index] = 1;
        if (find(board, index - n, visited, word, position + 1, m, n)
                || find(board, index + n, visited, word, position + 1, m, n)
                || (index % n != 0 && find(board, index - 1, visited, word, position + 1, m, n))
                || (index % n != (n - 1) && find(board, index + 1, visited, word, position + 1, m, n))
        ) {
            return true;
        } else {
            visited[index] = 0;
            return false;
        }
    }

    public static void main(String[] args) {
        /*ExistPath existPath = new ExistPath();
        System.out.println(existPath.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));*/
        int[][] a = {{1, 2}, {2, 3}};
        int[][] b = new int[2][2];
        System.arraycopy(a, 0, b, 0, 2);
        System.out.println(b);
    }
}
