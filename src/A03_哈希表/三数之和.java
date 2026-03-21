package A03_哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 三数之和 {
    public static void main(String[] args) {
        三数之和 s = new 三数之和();
//        System.out.println(s.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(s.threeSum(new int[]{-1, 0, 1}));
    }

    /**
     * 使用双指针实现
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[0] > 0) {
                return res;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    res.add(List.of(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        Set<List<Integer>> res = new HashSet<>(); // List中元素是没有去重的修改为set

        Arrays.sort(nums);
        // 外层循环
        for (int i = 0; i < nums.length - 2; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (set.contains(-(nums[i] + nums[j]))) {
                    res.add(List.of(nums[i], nums[j], -(nums[i] + nums[j])));
                } else {
                    set.add(nums[j]);
                }
            }
        }
        return new ArrayList<>(res);
    }

    // 双指针解法
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                i++;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
