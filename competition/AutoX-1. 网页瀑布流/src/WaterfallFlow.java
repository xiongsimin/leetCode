/**
 * ((No javadoc))
 *
 * @author xiongsimin
 * @date 2022/9/3
 * 网页布局中有一种瀑布流布局方式，表现为参差不齐的多栏布局。随着页面滚动条向下，还会不断加载数据块并附加至当前尾部。页面在加载时遵循以下规则：
 *
 * 当有数据块需要加载时，优先加载在高度最短的那一列；
 * 若存在多个高度相同且最短的情况，则加载在其中最靠左的那一列
 * 已知当前网页共分割为 num 列，该网页有若干数据块可以加载，block[i] 表示第 i 个数据块的高度。当页面按顺序加载完所有的数据块后，请返回高度最大的那一列的高度。
 *
 * 示例 1：
 *
 * 输入：num = 3, block = [5,9,8,6]
 *
 * 输出：11
 *
 * 解释：如下图所示，返回 11
 * image.png
 *
 * 示例 2：
 *
 * 输入：num = 2, block = [9,1,1,1,1,1]
 *
 * 输出：9
 *
 * 提示：
 *
 * 0 < num <= 100
 * 0 < block.length <= 10^4
 * 0 < block[i] <= 10^3
 */
public class WaterfallFlow {
    public static int getLengthOfWaterfallFlow(int num, int[] block) {
        int[] nums = new int[num];
        int maxHeight = 0;
        for (int i = 0; i < block.length; i++) {
            int minHeightPos = 0;
            for (int j = 0; j < num; j++) {
                if (nums[j] == 0) {
                    minHeightPos = j;
                    break;
                }
                if (nums[j] < nums[minHeightPos]) {
                    minHeightPos = j;
                }
            }
            nums[minHeightPos] += block[i];
            if (maxHeight < nums[minHeightPos]) {
                maxHeight = nums[minHeightPos];
            }
        }

        return maxHeight;
    }

    public static void main(String[] args) {
        WaterfallFlow.getLengthOfWaterfallFlow(2,new int[]{9,1,1,1,1,1});
    }
}
