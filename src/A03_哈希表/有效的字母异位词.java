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

    public static boolean isAnagram(String s, String t) {
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
