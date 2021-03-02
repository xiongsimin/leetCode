/**
 * @author xiongsm
 * @Date 2021-03-02
 * @Description 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 *  
 * @示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * @示例 2：
 * <p>
 * 输入：height = [1,1]
 * 输出：1
 * @示例 3：
 * <p>
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 * @示例 4：
 * <p>
 * 输入：height = [1,2,1]
 * 输出：2
 *  
 * @提示： n = height.length
 * 2 <= n <= 3 * 10^4
 * 0 <= height[i] <= 3 * 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxArea {
    //注意：实际能装水的部分是高度较小的那一边

    //暴力解法：遍历所有组合
    public int maxArea(int[] height) {
        int ans = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int temp = (j - i) * (height[j] > height[i] ? height[i] : height[j]);
                ans = temp > ans ? temp : ans;
            }
        }
        return ans;
    }

    //双指针法：从最左和最右开始移动指针-->哪边高度更小将哪边抛弃向前/后移动，遍历一遍即可得到最大值
    //哪边高度更小将哪边抛弃向前/后移动---->关键在于如何求证此结论
    //【容纳的水量】=【两个指针指向的数字中较小值】 * 【指针之间的距离】


    //考虑第一步，假设当前左指针和右指针指向的数分别为 xx 和 yy，不失一般性，我们假设 x \leq yx≤y。同时，两个指针之间的距离为 tt。那么，它们组成的容器的容量为：
    //min(x, y) * t = x * t
    //我们可以断定，如果我们保持左指针的位置不变，那么无论右指针在哪里，这个容器的容量都不会超过 x * t了。注意这里右指针只能向左移动，因为 我们考虑的是第一步，也就是 指针还指向数组的左右边界的时候。
    // 我们任意向左移动右指针，指向的数为 y1.两个指针之间的距离为 t1,那么显然有 t1 < t，并且 min(x, y1) <= min(x, y)
    //如果 y1 <= y，那么 min(x, y1) <=min(x, y)
    //如果 y1 > y，那么 min(x, y1) = x = min(x, y)
    //因此有：min(x, yt) * t1 < min(x, y) * t

    //结论：1.求出当前双指针对应的容器的容量；  2.对应数字较小的那个指针以后不可能作为容器的边界了，将其丢弃，并移动对应的指针。
    public int maxArea1(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        int reslut = maxArea.maxArea(new int[]{4, 3, 2, 1, 4});
        System.out.println(reslut);
    }
}
