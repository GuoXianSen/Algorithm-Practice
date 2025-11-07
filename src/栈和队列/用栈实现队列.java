package 栈和队列;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @program: SoftExam
 * @description:
 * @author: 郭寅之(Clay_Guo)
 * @create: 2025/8/9 18:21
 **/
public class 用栈实现队列 {
    public static Stack<Integer> stackOut;
    public static Stack<Integer> stackIn;

    public static void main(String[] args) {
        /**
         * ["MyQueue","push","push","push","push","pop","push","pop","pop","pop","pop"]
         * [[],[1],[2],[3],[4],[],[5],[],[],[],[]]
         */
        List<Integer> userIds = Arrays.asList(0, 1, 2, 2, 3, 4, 5);
        List<User> collect = userIds.stream().distinct().map(id -> new User(id, "name" + id)).filter(user -> user.getId() != 1).filter(user -> user.getId() != 2)
                .sorted(Comparator.comparingInt(User::getId).reversed()).collect(Collectors.toList());
        System.out.println(collect);

        // 用栈实现队列 myQueue = new 用栈实现队列();
        // myQueue.push(1);
        // myQueue.push(2);
        // myQueue.push(3);
        // myQueue.push(4);
        // System.out.println(myQueue.pop());
        // myQueue.push(5);
        // System.out.println(myQueue.pop());
        // System.out.println(myQueue.pop());
        // System.out.println(myQueue.pop());
        // System.out.println(myQueue.pop());

    }

    public 用栈实现队列() {
        stackOut = new Stack<>();
        stackIn = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        clearStackIn();
        return stackOut.pop();
    }

    public int peek() {
        clearStackIn();
        // 把In中的元素全部弹出到out
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.empty() && stackOut.isEmpty();
    }

    public void clearStackIn() {
        if (!stackOut.isEmpty()) return;
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }

    }
}

class User {
    private int id;
    private String name;

    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * 获取
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "User{id = " + id + ", name = " + name + "}";
    }
}