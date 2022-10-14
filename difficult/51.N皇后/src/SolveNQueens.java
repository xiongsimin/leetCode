import java.util.ArrayList;
import java.util.List;

/**
 * ((No javadoc))
 *
 * @author xiongsimin
 * @date 2022/10/14
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 *
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[["Q"]]
 *  
 *
 * 提示：
 *
 * 1 <= n <= 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolveNQueens {
    List<List<String>> res=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] N = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                N[i][j] = '.';
            }
        }
        backtrack(N,0);
        return res;
    }
    void backtrack(char[][] N,int row){
        if(row==N.length){
            List<String> oneRes=new ArrayList<>();
            for(int i=0;i<N.length;i++){
                String list = "";
                for(int j=0;j<N.length;j++){
                    list += N[i][j];
                }
                oneRes.add(list);
            }
            res.add(oneRes);
        }
        for(int col=0;col<N.length;col++){
            if(!isValid(N,row,col)){
                continue;
            }
            N[row][col] = 'Q';
            backtrack(N,row+1);
            N[row][col] = '.';
        }
    }

    boolean isValid(char[][] N,int row,int col){
        // 列上是否有皇后
        for(int y=0;y<N.length;y++){
            if(y==row){
                continue;
            }
            if(N[y][col]=='Q'){
                return false;
            }
        }
        // 左斜角
        for(int k = -N.length;k<N.length;k++){
            int tempR=row+k;
            int tempC=col+k;
            if(tempR<0||tempC<0||tempC>=N.length||tempR>=N.length||(tempR==row&&tempC==col)){
                continue;
            }
            if(N[tempR][tempC]=='Q'){
                return false;
            }
        }
        // 右斜角
        // 左斜角
        for(int k = -N.length;k<N.length;k++){
            int tempR=row-k;
            int tempC=col+k;
            if(tempR<0||tempC<0||tempC>=N.length||tempR>=N.length||(tempR==row&&tempC==col)){
                continue;
            }
            if(N[tempR][tempC]=='Q'){
                return false;
            }
        }

        return true;
    }
}
