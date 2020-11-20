package Functional_programming;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//public class OutputCollection {
//    public static void main(String[] args){
//        Stream<Long> s1=Stream.generate(new NaturalSupplier());
//        Stream<Long> s2 = s1.map(n -> n * n);
//        Stream<Long> s3 = s2.map(n -> n - 1);
//        System.out.println(s3);
//
//    }
//}
//class NaturalSupplier implements Supplier<Long> {
//    long n = 0;
//    public Long get() {
//        n++;
//        return n;
//    }
//}

//public class OutputCollection {
//    public static void main(String[] args) {
//        Stream<String> stream=Stream.of("Apple", "", null, "Pear", "  ", "Orange");
//        List<String> list=stream.filter(s->s!=null&&!s.isBlank()).collect(Collectors.toList());
//        System.out.println(list);
//    }
//}

public class OutputCollection {
    public static void main(String[] args) {
//        Stream<String> stream=Stream.of("Apple", "", null, "Pear", "  ", "Orange");
//        List<String> list=stream.filter(s->s!=null&&!s.isBlank()).collect(Collectors.toList());
//        System.out.println(list);

//        List<String> list = List.of("Apple", "Banana", "Orange");
//        String[] array = list.toArray(String[]::new);
//        System.out.println(Arrays.toString(array));

//        Stream<String> stream=Stream.of("APPL:Apple", "MSFT:Microsoft");
//        Map<String,String> map=stream.collect(Collectors.toMap(s->s.substring(0,s.indexOf(":")),s->s.substring(s.indexOf(":")+1)));
//        System.out.println(map);

        List<String> list = List.of("Apple", "Banana", "Blackberry", "Coconut", "Avocado", "Cherry", "Apricots");
        Map<String,List<String>> groups=list.stream().collect(Collectors.groupingBy(s->s.substring(0,1),
                Collectors.toList()));
        System.out.println(groups);
    }
}