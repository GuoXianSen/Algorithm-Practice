package 字符串;

/**
 * @program: SoftExam
 * @description:
 * @author: 郭寅之(Clay_Guo)
 * @create: 2026/1/6 23:40
 **/
public class 反转字符串 {
    public void reverseString(char[] s) {
        int right = s.length - 1;
        int left = 0;
        char tmp;
        while (left < right) {
            tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
    public void reverseString2(char[] s) {
        int right = s.length - 1;
        int left = 0;
        while (left < right) {
            s[left] = (char) (s[left] ^ s[right]);
            s[right] = (char) (s[left] ^ s[right]);
            s[left] = (char) (s[left] ^ s[right]);
            left++;
            right--;
        }
    }
}
