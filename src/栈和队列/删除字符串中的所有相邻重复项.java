package 栈和队列;

import java.util.ArrayDeque;
import java.util.Random;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @program: SoftExam
 * @description:
 * @author: 郭寅之(Clay_Guo)
 * @create: 2025/8/22 23:14
 **/
public class 删除字符串中的所有相邻重复项 {
    public static void main(String[] args) {
        // System.out.println(new 删除字符串中的所有相邻重复项().removeDuplicates2("abbaca"));
        new Random().ints().limit(10).filter(i -> i >= 0).forEach(System.out::println);
    }

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty()) {
                if (stack.peek() == ch) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(ch);
        }
        // return stack.stream().map(String::valueOf).collect(Collectors.joining());
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }

    public String removeDuplicates2(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (sb.length() != 0 && sb.charAt(sb.length() - 1) == ch) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public String removeDuplicates3(String s) {
        ArrayDeque<Character> characters = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (!characters.isEmpty() && characters.peek() == ch) {
                characters.pop();
            } else {
                characters.push(ch);
            }
        }
        return characters.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
