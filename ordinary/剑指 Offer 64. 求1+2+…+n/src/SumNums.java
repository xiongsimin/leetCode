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
 */
public class SumNums {
    //分析：题目难在设定，不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）故可考虑递归实现，但限制了if和三目运算符，需要思考如何终止递归
    //思路一：递归+短路与
    public int sumNums(int n) {
        boolean temp = n != 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
    //思路二：快乘法 todo
    public static void main(String[] args) {
        SumNums sumNums=new SumNums();
        sumNums.sumNums(4);
    }
}
