import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: SoftExam
 * @description:
 * @author: 郭寅之(Clay_Guo)
 * @create: 2025/8/24 17:00
 **/
class Person {
    String name;
    int age;
    String city;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return name + " (" + age + ", " + city + ")";
    }
}

public class StreamExe {
    public static void main(String[] args) {
        /**
         * List<String> strings = Arrays.asList("Java", "Python", "C", "C++", "C#", "JavaScript", "PHP", "Ruby");
         *         // 遍历打印
         *         strings.stream().forEach(System.out::print);
         *         System.out.println();
         *         // 过滤
         *         String c = strings.stream().filter(s -> s.startsWith("C")).collect(Collectors.joining(","));
         *         System.out.println(c);
         *         // 映射
         *         System.out.println();
         *         strings.stream().map(String::toUpperCase).forEach(System.out::print);
         */


        List<Person> people = Arrays.asList(
                new Person("Alice", 23, "Beijing"),
                new Person("Bob", 30, "Shanghai"),
                new Person("Charlie", 28, "Beijing"),
                new Person("David", 35, "Guangzhou"),
                new Person("Eve", 40, "Shanghai"),
                new Person("Frank", 18, "Beijing")
        );
        // exe1();
        exe2();
    }
    public static void exe2() {
        // 扁平化 (flatMap)
        // 有一个 List<List<String>>，请把它“打平”成一个 List<String>。
        List<List<String>> nested = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("c", "d"),
                Arrays.asList("e", "f")
        );
        List<String> collect = nested.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(nested);
        System.out.println(collect);
        // 分区 (partitioningBy)
        // 把所有人按是否 年龄 >= 30 分为两组。
        //
        // 统计分组人数 (groupingBy + counting)
        // 按城市分组，并统计每个城市的人数。
        //
        // 求和 (reduce)
        // 计算所有人的年龄总和。
        //
        // 字符串最长名 (reduce)
        // 找出名字最长的人名。
        //
        // 映射后聚合
        // 统计所有人名字的总长度（比如 "Alice" 长度 5）。
        //
        // 多级分组
        // 按城市分组，再在每个城市里按年龄是否大于 25 再分组。
        //
        // Top N 排序
        // 找出年龄最大的 2 个人。
        //
        // 匹配操作
        //
        // 是否所有人都大于 18 岁？
        //
        // 是否有人来自 "Guangzhou"？
        //
        // 是否没有人小于 10 岁？
        //
        // 收集到 Map
        // 把所有人的名字作为 key，年龄作为 value，收集成一个 Map<String, Integer>。
    }

    public static void exe1(List<Person> people) {

        // 过滤：找出所有来自北京 (Beijing) 的人。
        people.stream().filter(p -> "Beijing".equals(p.getCity())).forEach(System.out::println);

        // 映射：获取所有人的名字列表。
        List<String> collect = people.stream().map(Person::getName).collect(Collectors.toList());
        System.out.println(collect);

        // 排序：按年龄升序排列，并输出姓名。
        people.stream().sorted(Comparator.comparingInt(Person::getAge)).map(Person::getName).forEach(System.out::println);

        // 去重：获取所有不重复的城市。
        people.stream().map(Person::getCity).distinct().forEach(System.out::println);

        // 统计：统计所有人中年龄大于 25 的人数。
        System.out.println(people.stream().filter(p -> p.getAge() > 25).count());

        // 最大/最小：找出年龄最大的人。
        System.out.println(people.stream().max(Comparator.comparingInt(Person::getAge)));
        System.out.println(people.stream().min(Comparator.comparingInt(Person::getAge)));

        // 聚合：计算所有人的平均年龄。
        System.out.println(people.stream().mapToInt(Person::getAge).average()); // OptionalDouble[29.0]
        System.out.println(people.stream().collect(Collectors.averagingInt(Person::getAge)));

        // 分组：按城市分组，输出每个城市有哪些人。
        Map<String, List<Person>> collect1 = people.stream().collect(Collectors.groupingBy(Person::getCity));
        System.out.println(collect1);

        // 拼接字符串：把所有人的名字用 , 拼接成一个字符串。
        System.out.println(people.stream().map(Person::getName).collect(Collectors.joining(",")));

        // 组合操作：找出来自北京、年龄大于 20 岁的人的名字，并按字母顺序输出。
        List<String> collect2 = people.stream().filter(p -> "Beijing".equals(p.city) && p.age > 20).map(Person::getName).sorted().collect(Collectors.toList());
        System.out.println(collect2);
    }
}

