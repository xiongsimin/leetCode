/**
 * @Author aries
 * @Data 2020-11-12
 * @Description 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * <p>
 *  
 * @示例 1: 输入: "III"
 * 输出: 3
 * @示例 2: 输入: "IV"
 * 输出: 4
 * @示例 3: 输入: "IX"
 * 输出: 9
 * @示例 4: 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * @示例 5: 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *  
 * @提示： 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
 * IC 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
 * 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RomanToInt {
    //思路一：从右向左遍历，根据题意处理即可
    public int romanToInt(String s) {
        int result = 0;
        int i = s.length() - 1;
        while (i != -1) {
            switch (s.charAt(i)) {
                case 'I':
                    result += 1;
                    i--;
                    break;
                case 'V':
                    if (i > 0 && s.charAt(i - 1) == 'I') {
                        result += 4;
                        i = i - 2;
                    } else {
                        result += 5;
                        i--;
                    }
                    break;
                case 'X':
                    if (i > 0 && s.charAt(i - 1) == 'I') {
                        result += 9;
                        i = i - 2;
                    } else {
                        result += 10;
                        i--;
                    }
                    break;
                case 'L':
                    if (i > 0 && s.charAt(i - 1) == 'X') {
                        result += 40;
                        i = i - 2;
                    } else {
                        result += 50;
                        i--;
                    }
                    break;
                case 'C':
                    if (i > 0 && s.charAt(i - 1) == 'X') {
                        result += 90;
                        i = i - 2;
                    } else {
                        result += 100;
                        i--;
                    }
                    break;
                case 'D':
                    if (i > 0 && s.charAt(i - 1) == 'C') {
                        result += 400;
                        i = i - 2;
                    } else {
                        result += 500;
                        i--;
                    }
                    break;
                case 'M':
                    if (i > 0 && s.charAt(i - 1) == 'C') {
                        result += 900;
                        i = i - 2;
                    } else {
                        result += 1000;
                        i--;
                    }
                    break;
            }
        }
        return result;
    }

    //思路一基础上代码优化：抽离出一个用于转换单个值的函数
    int getIntVal(char c) {
        int intVal = 0;
        switch (c) {
            case 'I':
                intVal = 1;
                break;
            case 'V':
                intVal = 5;
                break;
            case 'X':
                intVal = 10;
                break;
            case 'L':
                intVal = 50;
                break;
            case 'C':
                intVal = 100;
                break;
            case 'D':
                intVal = 500;
                break;
            case 'M':
                intVal = 1000;
                break;
        }
        return intVal;
    }

    //思路二：优化代码，往前看一位，如果前一位比当前小，则用当前减上一位
    public int romanToInt1(String s) {
        int result = 0;
        int i = s.length() - 1;
        while (i != -1) {
            if (i != 0 && getIntVal(s.charAt(i - 1)) < getIntVal(s.charAt(i))) {
                result += (getIntVal(s.charAt(i)) - getIntVal(s.charAt(i - 1)));
                i = i - 2;
            } else {
                result += getIntVal(s.charAt(i));
                i--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RomanToInt romanToInt = new RomanToInt();
        System.out.println(romanToInt.romanToInt("MCMXCIV"));
    }
}
