import java.util.Stack;

/**
 * @Author aries
 * @Data 2021-07-19
 * @Description 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Calculate {
    public int calculate(String s) {
        Stack<Integer> stack=new Stack<>();
        int res=0;
        int num=0;
        //符号
        int sign=1;
        for(int i=0;i<s.length();i++){
            if(' '==s.charAt(i)){
                continue;
            }
            else if('0'<=s.charAt(i)&&s.charAt(i)<='9'){
                num=(num*10+s.charAt(i)-'0');
                if(i<s.length()-1&&s.charAt(i+1)>='0'&&s.charAt(i+1)<='9'){
                    continue;
                }
            }
            else if('('==s.charAt(i)){
                stack.push(res);
                stack.push(sign);
                res=0;
                num=0;
                sign=1;
            }
            else if(')'==s.charAt(i)){
                num=res;
                sign=stack.pop();
                res=stack.pop();
            }else{
                if('+'==s.charAt(i)){
                    sign=1;
                }else{
                    sign=-1;
                }
                num=0;
            }
            res+=sign*num;
        }
        return res;
    }

    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        System.out.println(calculate.calculate("2147483647"));
    }
}
