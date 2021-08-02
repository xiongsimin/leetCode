/**
 * @Author aries
 * @Data 2021-08-02
 * @Description 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,5,6,4]
 * 输出: 5
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 50000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReversePairs {
    int res=0;
    public int reversePairs(int[] nums) {
        if(nums.length==0||nums.length==1){
            return 0;
        }
        int[] temp=new int[nums.length];
        mergeSort(nums,0,nums.length-1,temp);
        return res;
    }
    void mergeSort(int[] nums,int left, int right,int[] temp){
        if(left==right){
            return ;
        }
        int mid=left+(right-left)/2;
        mergeSort(nums,left,mid,temp);
        mergeSort(nums,mid+1,right,temp);
        merge(nums,left,mid,right,temp);
    }
    void merge(int[] nums,int left,int mid,int right,int[] temp){
        if(nums[mid]<=nums[mid+1]){
            return;
        }
        for (int i=left;i<=right;i++){
            temp[i]=nums[i];
        }
        int m=left;
        int n=mid+1;
        int index=left;
        while(m<=mid&&n<=right){
            if(temp[m]<=temp[n]){
                nums[index]=temp[m];
                m++;
                index++;
            }else{
                nums[index]=temp[n];
                n++;
                index++;
                res+=(mid-m+1);
            }
        }
        while(index<=right){
            if(m<=mid){
                nums[index]=temp[m];
                m++;
                index++;
            }else{
                break;
            }
        }
    }

    public static void main(String[] args) {
        ReversePairs reversePairs = new ReversePairs();
        System.out.println(reversePairs.reversePairs(new int[]{7, 5, 6, 4}));

    }
}
