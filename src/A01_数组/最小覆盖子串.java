package A01_数组;

import java.util.*;

/**
 * @program: SoftExam
 * @description:
 * @author: 郭寅之(Clay_Guo)
 * @create: 2025/8/2 9:19
 **/
public class 最小覆盖子串 {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
        int len = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int start = 0;
        int left = 0;
        int valid = 0;

        for (int i = 0; i < t.length(); i++) {
            map.merge(t.charAt(i), 1, Integer::sum);
        }
        for (int right = 0; right < s.length(); right++) {
            char key = s.charAt(right);
            if (map.containsKey(key)) {
                window.merge(key, 1, Integer::sum);
                if (window.get(key).equals(map.get(key))) {
                    valid += 1;
                }
            }
            while (valid == map.size()) {
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    start = left;
                }
                char out = s.charAt(left);
                left++;
                if (window.containsKey(out)) {
                    // 这里不能写== 因为Integer是对象的比较，而不是值的比较
                    // if (window.get(out) == map.get(out)) {
                    if (window.get(out).equals(map.get(out))) {
                        valid--;
                    }
                    window.put(out, window.get(out) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE || start + len > s.length() ? "" : s.substring(start, start + len);
    }
}
