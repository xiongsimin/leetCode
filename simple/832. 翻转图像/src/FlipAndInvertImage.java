/**
 * @author xiongsm
 * @Date 2021-02-24
 * @Description 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 * <p>
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 * <p>
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 * <p>
 *  
 * @示例 1：
 * <p>
 * 输入：[[1,1,0],[1,0,1],[0,0,0]]
 * 输出：[[1,0,0],[0,1,0],[1,1,1]]
 * 解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 * 然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 * @示例 2：
 * <p>
 * 输入：[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 * 然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 *  
 * @提示： 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flipping-an-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FlipAndInvertImage {
    //注意：翻转到中线，实际已经结束
    public int[][] flipAndInvertImage(int[][] A) {
        for (int t = 0; t < A.length; t++) {
            for (int i = 0; i < A[t].length; i++) {
                //中间线的值不需互换，只需翻转
                if (i == A[t].length - i - 1) {
                    A[t][i] = 1 - A[t][i];
                    break;
                } else {
                    //将位置i和n-i-1上的值互换并翻转
                    int temp = A[t][i];
                    A[t][i] = 1 - A[t][A[t].length - i - 1];
                    A[t][A[t].length - i - 1] = 1 - temp;
                    if (i == A[t].length - i - 1 - 1) {
                        break;
                    }
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        FlipAndInvertImage flipAndInvertImage = new FlipAndInvertImage();
        int A[][] = flipAndInvertImage.flipAndInvertImage(new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}});
        System.out.println(A);
    }

}
