/**
 * @Author aries
 * @Data 2020-11-10
 * @Description 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * @示例 1: 输入: 123
 * 输出: 321
 *  
 * @示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * @示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * @注意: 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConvertInt {
    //思路一：用字符串转换处理   效率较低
  /*
    public int reverse(int x) {
        String strX = String.valueOf(x);
        String numPart = "";
        boolean isPositive = true;
        if (strX.charAt(0) == '-') {
            numPart = strX.substring(1, strX.length());
            isPositive = false;
        } else {
            numPart = strX;
        }
        String convertedStr = "";
        for (int i = 0; i < numPart.length(); i++) {
            convertedStr = numPart.charAt(i) + convertedStr;
        }
        long convertedLong = Long.parseLong(convertedStr);
        if ((convertedLong > new Long(Integer.MAX_VALUE) && isPositive) || (-convertedLong < new Long(Integer.MIN_VALUE) && !isPositive)) {
            return 0;
        } else {
            return isPositive ? (int) convertedLong : (int) -convertedLong;
        }
    }
    */
    //思路二：利用数学知识 循环将转换后的数*10并加上转换前的末位数字  convert=convert*10+pop
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            //如果是正数且加上下一位将溢出
            if (rev > Integer.MAX_VALUE / 10 || rev * 10 + pop > Integer.MAX_VALUE) {
                return 0;
            }
            //如果是负数且加上下一位将溢出
            if (rev < Integer.MIN_VALUE / 10 || rev * 10 + pop < Integer.MIN_VALUE) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
