/**
 * @Author aries
 * @Data 2020-11-16
 * @Description 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
 * <p>
 * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
 * <p>
 *  
 * @示例 1：
 * <p>
 * 输入：nums = [2,5,1,3,4,7], n = 3
 * 输出：[2,3,5,4,1,7]
 * 解释：由于 x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]
 * @示例 2：
 * <p>
 * 输入：nums = [1,2,3,4,4,3,2,1], n = 4
 * 输出：[1,4,2,3,3,2,4,1]
 * @示例 3：
 * <p>
 * 输入：nums = [1,1,2,2], n = 2
 * 输出：[1,2,1,2]
 *  
 * @提示： 1 <= n <= 500
 * nums.length == 2n
 * 1 <= nums[i] <= 10^3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shuffle-the-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Shuffle {
    //思路一：根据规律发现转换后的数组下标有以下规律--0~n-1转换后对应2*(0~n-1)；n~2n-1转换后对应2((n~2n-1)-n)+1
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            if (i < n) {
                result[2 * i] = nums[i];
            } else {
                result[2 * (i - n) + 1] = nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] demo = new int[]{1, 2, 3, 4, 4, 3, 2, 1};
        Shuffle shuffle = new Shuffle();
        int[] result = shuffle.shuffle(demo, 4);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
