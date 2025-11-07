package 栈和队列;

import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * @program: SoftExam
 * @description:
 * @author: 郭寅之(Clay_Guo)
 * @create: 2025/8/21 22:36
 **/
public class 有效的括号 {
    public static void main(String[] args) {
        System.out.println(new 有效的括号().isValid("()"));
    }

    public boolean isValid(String s) {
        Map<Character, Character> map = Map.of(')', '(', ']', '[', '}', '{');
        Set<Character> set = Set.of('(', '[', '{');
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                stack.push(ch);
            } else if (!stack.isEmpty() && stack.peek() == map.get(ch)) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
