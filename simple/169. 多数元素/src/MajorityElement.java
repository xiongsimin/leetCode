import java.util.HashMap;
import java.util.Map;

/**
 * ((No javadoc))
 *
 * @author xiongsimin
 * @date 2023/8/5
 */
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int maxNum = 0;
        int maxNumX = 0;
        Map<Integer,Integer> numMap=new HashMap<>();
        for(int x:nums){
            int times = numMap.getOrDefault(x,0)+1;
            maxNumX = times>maxNum?x:maxNumX;
            maxNum = Math.max(times,maxNum);

            numMap.put(x,times);
        }
        return maxNumX;
    }

    public static void main(String[] args) {
        MajorityElement.majorityElement(new int[]{3,2,3});
    }
}
