/**
 * @author xiongsm
 * @Date 2021-02-25
 * @Description 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 * <p>
 * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 * <p>
 * <p>
 * <p>
 *  
 * @示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 * @示例 2：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 *  
 * @提示： m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 1000
 * 1 <= m * n <= 105
 * -109 <= matrix[i][j] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/transpose-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Transpose {
    public int[][] transpose(int[][] matrix) {
        if (matrix.length == 0) {
            return matrix;
        }
        //转置矩阵行数
        int lineNum = matrix.length;
        //转置矩阵列数
        int rowNum = matrix[0].length;
        //结果
        int[][] ans = new int[rowNum][lineNum];
        int rowCur = 0;
        while (rowCur < rowNum) {
            int lineCur = 0;
            while (lineCur < lineNum) {
                ans[rowCur][lineCur] = matrix[lineCur][rowCur];
                lineCur++;
            }
            rowCur++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Transpose transpose = new Transpose();
        int[][] A = new int[][]{{1,2,3},{4,5,6}};
        int[][] B = transpose.transpose(A);
        System.out.println(B);
    }
}
