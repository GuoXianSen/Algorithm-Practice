package A03_哈希表;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: SoftExam
 * @description:
 * @author: 郭寅之(Clay_Guo)
 * @create: 2025/8/5 21:38
 **/
public class 两个数组的交集 {
    public static void main(String[] args) {

    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> tmp = new HashSet<>();
        for (int n1 : nums1) {
            tmp.add(n1);
        }
        Set<Integer> res = new HashSet<>();
        for (int n2 : nums2) {
            if (tmp.contains(n2)) {
                res.add(n2);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> tmp = new HashSet<>();
        for (int n1 : nums1) {
            tmp.add(n1);
        }
        int[] res = new int[tmp.size()];
        int index = 0;
        for (int n2 : nums2) {
            if (tmp.remove(n2)) {
                res[index++] = n2;
            }
        }
        // Arras.copyOf(res, index); 含义为 将res数组的前index个元素复制到一个新的数组中，并返回该数组
        return Arrays.copyOf(res, index);
    }
}
