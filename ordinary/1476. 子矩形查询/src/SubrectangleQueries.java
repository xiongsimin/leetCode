/**
 * @Author aries
 * @Data 2020-11-22
 * @Description 请你实现一个类 SubrectangleQueries ，它的构造函数的参数是一个 rows x cols 的矩形（这里用整数矩阵表示），并支持以下两种操作：
 * <p>
 * 1. updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)
 * <p>
 * 用 newValue 更新以 (row1,col1) 为左上角且以 (row2,col2) 为右下角的子矩形。
 * 2. getValue(int row, int col)
 * <p>
 * 返回矩形中坐标 (row,col) 的当前值。
 *  
 * @示例 1：
 * <p>
 * 输入：
 * ["SubrectangleQueries","getValue","updateSubrectangle","getValue","getValue","updateSubrectangle","getValue","getValue"]
 * [[[[1,2,1],[4,3,4],[3,2,1],[1,1,1]]],[0,2],[0,0,3,2,5],[0,2],[3,1],[3,0,3,2,10],[3,1],[0,2]]
 * 输出：
 * [null,1,null,5,5,null,10,5]
 * 解释：
 * SubrectangleQueries subrectangleQueries = new SubrectangleQueries([[1,2,1],[4,3,4],[3,2,1],[1,1,1]]);
 * // 初始的 (4x3) 矩形如下：
 * // 1 2 1
 * // 4 3 4
 * // 3 2 1
 * // 1 1 1
 * subrectangleQueries.getValue(0, 2); // 返回 1
 * subrectangleQueries.updateSubrectangle(0, 0, 3, 2, 5);
 * // 此次更新后矩形变为：
 * // 5 5 5
 * // 5 5 5
 * // 5 5 5
 * // 5 5 5
 * subrectangleQueries.getValue(0, 2); // 返回 5
 * subrectangleQueries.getValue(3, 1); // 返回 5
 * subrectangleQueries.updateSubrectangle(3, 0, 3, 2, 10);
 * // 此次更新后矩形变为：
 * // 5   5   5
 * // 5   5   5
 * // 5   5   5
 * // 10  10  10
 * subrectangleQueries.getValue(3, 1); // 返回 10
 * subrectangleQueries.getValue(0, 2); // 返回 5
 * @示例 2：
 * <p>
 * 输入：
 * ["SubrectangleQueries","getValue","updateSubrectangle","getValue","getValue","updateSubrectangle","getValue"]
 * [[[[1,1,1],[2,2,2],[3,3,3]]],[0,0],[0,0,2,2,100],[0,0],[2,2],[1,1,2,2,20],[2,2]]
 * 输出：
 * [null,1,null,100,100,null,20]
 * 解释：
 * SubrectangleQueries subrectangleQueries = new SubrectangleQueries([[1,1,1],[2,2,2],[3,3,3]]);
 * subrectangleQueries.getValue(0, 0); // 返回 1
 * subrectangleQueries.updateSubrectangle(0, 0, 2, 2, 100);
 * subrectangleQueries.getValue(0, 0); // 返回 100
 * subrectangleQueries.getValue(2, 2); // 返回 100
 * subrectangleQueries.updateSubrectangle(1, 1, 2, 2, 20);
 * subrectangleQueries.getValue(2, 2); // 返回 20
 *  
 * @提示： 最多有 500 次updateSubrectangle 和 getValue 操作。
 * 1 <= rows, cols <= 100
 * rows == rectangle.length
 * cols == rectangle[i].length
 * 0 <= row1 <= row2 < rows
 * 0 <= col1 <= col2 < cols
 * 1 <= newValue, rectangle[i][j] <= 10^9
 * 0 <= row < rows
 * 0 <= col < cols
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subrectangle-queries
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//思路一：暴力更新--适用于数组较小且更新（次updateSubrectangle）次数多的情况
public class SubrectangleQueries {
    int[][] rectangle;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                rectangle[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return rectangle[row][col];
    }
}
//思路二：不对原矩阵进行更新，记录历史更新，优先从历史更新记录中取值--适用于数组较大且更新次数少，查询次数多的情况，根据题意最多有500次更新和查询，而数组大小最大100，最多需要更新10000次，相比之下此种思路更契合题意

class SubrectangleQueries1 {
    int[][] rectangle;
    int[][] historyUpdate = new int[500][5];
    int updateTimes = -1;

    public SubrectangleQueries1(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        updateTimes++;
        historyUpdate[updateTimes][0] = row1;
        historyUpdate[updateTimes][1] = col1;
        historyUpdate[updateTimes][2] = row2;
        historyUpdate[updateTimes][3] = col2;
        historyUpdate[updateTimes][4] = newValue;
    }

    public int getValue(int row, int col) {
        //在最近的一次更新中找
        for (int i = updateTimes; i >= 0; i--) {
            //如果在历史更新矩阵中，直接取更新值
            if (row >= historyUpdate[i][0] && row <= historyUpdate[i][2] && col >= historyUpdate[i][1] && col <= historyUpdate[i][3]) {
                return historyUpdate[i][4];
            }
        }
        //没在历史更新范围内，直接返回原矩阵中该位置的值
        return rectangle[row][col];
    }

    public static void main(String[] args) {
        int[][] rectangle = new int[][]{{1, 2, 1}, {4, 3, 4}, {3, 2, 1}, {1, 1, 1}};
        SubrectangleQueries1 subrectangleQueries1 = new SubrectangleQueries1(rectangle);
        System.out.println(subrectangleQueries1.getValue(0, 0));
    }
}