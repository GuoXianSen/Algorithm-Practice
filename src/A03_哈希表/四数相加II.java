package A03_哈希表;

import java.util.HashMap;
import java.util.Map;

public class 四数相加II {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                map.merge(i + j, 1, Integer::sum);
                // 等价于
                // map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        for (int i : nums3) {
            for (int j : nums4) {
                if (map.containsKey(-i - j)) {
                    res += map.get(-i - j);
                }
                // 等价于
                // res += map.getOrDefault(-i - j, 0);
            }
        }
        return res;
    }
}