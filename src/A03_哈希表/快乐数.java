package A03_哈希表;

import java.util.HashSet;
import java.util.Set;

public class 快乐数 {
    public static void main(String[] args) {
        System.out.println(new 快乐数().isHappy(19));
    }

    public int getNextNum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNextNum(n);
        }
        return n == 1;
    }
}
