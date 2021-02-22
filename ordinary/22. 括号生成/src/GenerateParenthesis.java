import java.util.ArrayList;
import java.util.List;

/**
 * @Author aries
 * @Data 2021-02-22
 * @Description 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 *  
 * @示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * @示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 *  
 * @提示： 1 <= n <= 8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateParenthesis {

    //暴力解法：递归生成所有种序列组合，并且判断是否是有效括号
    //注：判断是否是有效括号的方法，从左到右，“(”的个数减“)”的个数不能小于0，且最终结果为0
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generates(result, new char[2 * n], 0);
        return result;
    }

    private void generates(List<String> result, char[] arr, int position) {
        if (position == arr.length) {
            if (isValid(arr)) {
                result.add(String.valueOf(arr));
            }
            return;
        }
        arr[position] = '(';
        generates(result, arr, position + 1);
        arr[position] = ')';
        generates(result, arr, position + 1);
    }

    /**
     * 判断是否是有效括号
     *
     * @param arr
     * @return
     */
    private boolean isValid(char[] arr) {
        int balance = 0;
        for (char c : arr) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> result = generateParenthesis.generateParenthesis(3);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
