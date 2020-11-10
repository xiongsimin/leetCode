/**
 * @Author aries
 * @Data 2020-11-08
 * @Description 买卖股票的最佳时机 II
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * @示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * @示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 *
 * @提示：
 *
 * 1 <= prices.length <= 3 * 10 ^ 4
 * 0 <= prices[i] <= 10 ^ 4
 */
public class BestProfit {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        BestProfit bestProfit = new BestProfit();
        bestProfit.maxProfit(prices);
    }

    //思路一：在上升曲线的最低点买入，最高点卖出
    public int maxProfit(int[] prices) {
        //当前是否买入
        boolean bought = false;
        //买入点价格
        int boughtPrice = 0;
        int len = prices.length;
        if (len < 1) {
            return 0;
        }
        int profit = 0;
        for (int i=0; i < len; i++) {
            //已经在上个最低点买入了
            if (bought) {
                //最后一天，之前会买入且没卖出说明该天是最高点，卖出
                if (i == len - 1) {
                    profit += (prices[i] - boughtPrice);
                    bought = false;
                }
                //不是最后一天，判断下一天是否更高
                else {
                    //下一天更高，不卖
                    if (prices[i+1] > prices[i]) {
                        continue;
                    }
                    //下一天不比今天高，卖出
                    else {
                        profit += (prices[i] - boughtPrice);
                        bought = false;
                    }
                }
            }
            //还没买入（在等待最低点）
            else {
                //最后一天了，之前没买入，直接跳过
                if (i == len - 1) {
                    //do nothing
                } else {
                    //下一天比当前高，说明当天是最低点，买入
                    if (prices[i+1] > prices[i]) {
                        boughtPrice = prices[i];
                        bought = true;
                    }
                }
            }
        }
        return profit;
    }
    //思路二：思路一变型，不用记录最低点价格和最高点价格，只要比前一天高就卖出（根据题意同一天内可以先卖出再买入）  (5-4)+(4-3)+(3-2)=5-2
    //实现略
}
