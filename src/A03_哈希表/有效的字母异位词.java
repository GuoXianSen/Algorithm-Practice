package A03_哈希表;

import java.util.*;

/**
 * @program: SoftExam
 * @description:
 * @author: 郭寅之(Clay_Guo)
 * @create: 2025/8/5 21:07
 **/
public class 有效的字母异位词 {
    public static void main(String[] args) {

    }

    /**
     * 使用数组作为哈希表进行映射，用ch-'a'作为下标记录26个字母的出现次数
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            count[ch - 'a']--;
        }
        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        for (char c : s.toCharArray()) {
            mapS.merge(c, 1, Integer::sum);
        }
        for (char c : t.toCharArray()) {
            mapT.merge(c, 1, Integer::sum);
        }
        return mapS.equals(mapT);
    }
}
