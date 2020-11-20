package Functional_programming;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.*;

//public class Stream_ {
//    public static void main(String[] args) {
//        Stream<String> stream = Stream.of("A", "B", "C", "D");
//        // forEach()方法相当于内部循环调用，
//        // 可传入符合Consumer接口的void accept(T t)的方法引用：
//        stream.forEach(System.out::println);
//
//    }
//}

//public class Stream_ {
//    public static void main(String[] args) {
//        Stream<String> stream1 = Arrays.stream(new String[]{"A", "B", "C"});
//        Stream<String> stream2 = List.of("X", "Y", "Z").stream();
//        stream1.forEach(System.out::println);
//        stream2.forEach(System.out::println);
//
//    }
//}

//public class Stream_ {
//    public static void main(String[] args) {
//        Stream<Integer> natural = Stream.generate(new NaturalSupplier());
//        natural.limit(100).forEach(System.out::println);
//    }
//}
//
//class NaturalSupplier implements Supplier<Integer> {
//    int n = 0;
//
//    public Integer get() {
//        n++;
//        return n;
//    }
//}

public class Stream_ {
    public static void main(String[] args) {
        Stream<Long> ls = Stream.generate(new FiboSupplier());
        ls.limit(20).forEach(System.out::println);

    }
}

class FiboSupplier implements Supplier<Long> {
    private long i = 0;
    private long x = 1;
    private long y = 0;

    public Long get() {
        if (i == 0) {
            i++;
        } else {
            i = x + y;
            y = x;
            x = i;
        }
        return i;
    }
}
