/**
 * @Author xiongsimin
 * @Date 2020-11-12
 * @Description 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * @示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * @示例 2: 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * @示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * @进阶: 你能不将整数转为字符串来解决这个问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Palindrome {
    //思路一：将数据转换成字符串，指针分别从最左和最右开始遍历
    public boolean isPalindrome(int x) {
        //负数或能被10整除的非0数肯定不是回文数
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        String strX = String.valueOf(x);
        int i = 0;
        int j = strX.length() - 1;
        while (i < j) {
            if (strX.charAt(i) != strX.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    //思路二：不将数字转换成字符串 反转一半数字，将反转的部分与剩余的部分比较，相等说明是回文数字
    public boolean isPalindrome1(int x) {
        //负数或能被10整除的非0数肯定不是回文数
        if (x % 10 == 0 && x != 0) {
            return false;
        }
        int palX = 0;
        while (x >= palX) {
            if (x == palX || x / 10 == palX) {
                return true;
            }
            palX = palX * 10 + x % 10;
            x = x / 10;
        }
        return false;
    }


    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome(121));
        System.out.println(palindrome.isPalindrome1(123));
    }
}
