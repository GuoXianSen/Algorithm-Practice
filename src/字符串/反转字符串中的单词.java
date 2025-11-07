package 字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: SoftExam
 * @description:
 * @author: 郭寅之(Clay_Guo)
 * @create: 2025/8/8 21:59
 **/
public class 反转字符串中的单词 {
    public static void main(String[] args) {
        reverseWords("  hello world  ");
        String str = " abcdefg higklmn; ";
        System.out.println(str.substring(0));
        System.out.println(str.substring(1));
        // replace不支持正则
        String s1 = str.replace("\\s+", "");
        // replaceAll支持正则
        String s2 = str.replaceAll("\\s+", "");
        System.out.println(s1);
        System.out.println(s2);
    }

    public static String reverseWords(String s) {
        // 去除收尾空格
        String newStr = s.trim();
        // 反转字符串

        // 反转各个单词
        String[] strs = newStr.split("\\s+");
        // System.out.println(Arrays.toString(strs));
        List<String> list = new ArrayList<>();
        for (int i = strs.length - 1; i >= 0; i--) {
            list.add(strs[i]);
        }
        return String.join(" ", list);
    }
}
