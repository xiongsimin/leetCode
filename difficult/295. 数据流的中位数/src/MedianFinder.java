import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author aries
 * @Data 2021-07-24
 * @Description 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * [2,3,4] 的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 * <p>
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 * <p>
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-median-from-data-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MedianFinder {
    //小顶堆
    PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>(10000);
    //大根堆
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10000, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    double median=0D;
    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if(minHeap.isEmpty()&&maxHeap.isEmpty()){
            minHeap.offer(num);
            median=(double)minHeap.peek();
        }else{
            if(minHeap.size()>maxHeap.size()){
                if(num<minHeap.peek()){
                    maxHeap.offer(num);
                }else{
                    minHeap.offer(num);
                    maxHeap.offer(minHeap.poll());
                }
                median=((double)(minHeap.peek()+maxHeap.peek()))/2;
            }else if(minHeap.size()<maxHeap.size()){
                if(num<minHeap.peek()){
                    maxHeap.offer(num);
                    minHeap.offer(maxHeap.poll());
                }else{
                    minHeap.offer(num);
                }
                median=((double)(minHeap.peek()+maxHeap.peek()))/2;
            }
            else{
                if(num<minHeap.peek()){
                    maxHeap.offer(num);
                    median=(double)maxHeap.peek();
                }else{
                    minHeap.offer(num);
                    median=(double)minHeap.peek();
                }
            }
        }
    }

    public double findMedian() {
        return median;
    }
}
