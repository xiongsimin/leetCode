/**
 * @Author aries
 * @Data 2020-11-22
 * @Description 剑指 Offer 64. 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * @示例 1：
 * <p>
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 * <p>
 * 输入: n = 9
 * 输出: 45
 * @限制： 1 <= n <= 10000
 * <p>
 * 作者：LeetCode-官方
 * 链接：https://leetcode-cn.com/problems/qiu-12n-lcof/solution/qiu-12n-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class SumNums {
    //分析：题目难在设定，不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）故可考虑递归实现，但限制了if和三目运算符，需要思考如何终止递归
    //思路一：递归+短路与
    public int sumNums(int n) {
        boolean temp = n != 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    /**
     * @参考LeetCode-官方 思路二：快乘法 此种思路需要明白“俄罗斯农民乘法”
     */
    //解释1：整数A和整数B相乘，每次A翻倍（即乘2），B减倍（即除2），如果B减倍余数不为0，则最后结果加上A翻倍的值。直到B减倍后为0。
    //解释2：考虑 A 和 B 两数相乘的时候我们如何利用加法和位运算来模拟，其实就是将 B 二进制展开，如果 B 的二进制表示下第 ii 位为 1，那么这一位对最后结果的贡献就是 A*(1<<i)A∗(1<<i) ，即 A<<iA<<i。我们遍历 B 二进制展开下的每一位，将所有贡献累加起来就是最后的答案
    public int quickMulti(int A, int B) {
        int result = 0;
        for (; B > 0; B >>= 1) {
            if ((B & 1) == 1) {
                result += A;
            }
            A <<= 1;
        }
        return result;
    }

    //上述是快乘法，但是注意到使用了for和if关键字，所以回到题目本身，因为规定了n最大为10000，即小于2^14，因此手动展开14次即可解决for关键字问题，短路与即可解决if关键字问题   注：1+2+……+n=n*(n+1)/2
    public int sumNums1(int n) {
        boolean temp;
        int result = 0;
        int A = n;
        int B = n + 1;
        //展开快乘法计算n*(n+1)
        temp = ((B & 1) > 0) && ((result += A) > 0);
        B>>=1;
        A<<=1;

        temp = ((B & 1) > 0) && ((result += A) > 0);
        B>>=1;
        A<<=1;

        temp = ((B & 1) > 0) && ((result += A) > 0);
        B>>=1;
        A<<=1;

        temp = ((B & 1) > 0) && ((result += A) > 0);
        B>>=1;
        A<<=1;

        temp = ((B & 1) > 0) && ((result += A) > 0);
        B>>=1;
        A<<=1;

        temp = ((B & 1) > 0) && ((result += A) > 0);
        B>>=1;
        A<<=1;

        temp = ((B & 1) > 0) && ((result += A) > 0);
        B>>=1;
        A<<=1;

        temp = ((B & 1) > 0) && ((result += A) > 0);
        B>>=1;
        A<<=1;

        temp = ((B & 1) > 0) && ((result += A) > 0);
        B>>=1;
        A<<=1;

        temp = ((B & 1) > 0) && ((result += A) > 0);
        B>>=1;
        A<<=1;

        temp = ((B & 1) > 0) && ((result += A) > 0);
        B>>=1;
        A<<=1;

        temp = ((B & 1) > 0) && ((result += A) > 0);
        B>>=1;
        A<<=1;

        temp = ((B & 1) > 0) && ((result += A) > 0);
        B>>=1;
        A<<=1;

        temp = ((B & 1) > 0) && ((result += A) > 0);
        B>>=1;
        A<<=1;

        //n*(n+1)/2
        result >>= 1;
        return result;
    }

    public static void main(String[] args) {
        SumNums sumNums = new SumNums();
        sumNums.sumNums(4);
    }
}
