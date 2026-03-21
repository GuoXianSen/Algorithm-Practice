package A03_哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 四数之和 {
    public static void main(String[] args) {
        // int[] nums = {1, 0, -1, 0, -2, 2};
        // int[] nums = {2, 2, 2, 2, 2};
        int[] nums = {1000000000, 1000000000, 1000000000, 1000000000};
        System.out.println(new 四数之和().fourSum(nums, -294967296));

    }

    /**
     * 本题注意事项：
     * 1、注意去重需要在最外层和内层for循环均要加上
     * 2、针对整型sum可能溢出的情况，需要在左右两侧都要加上long修饰sum和四数之和
     *
     * @param nums   输入数组
     * @param target 目标和
     * @return 结果
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 转化为三数之和为target
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        result.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
