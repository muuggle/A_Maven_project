package Functional_programming;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

//public class MAP {
//    public static void main(String[] args) {
//        List.of("  Apple ", " pear ", " ORANGE", " BaNaNa ").stream().map(String::trim).
//                map(String::toLowerCase).forEach(System.out::println);
//    }
//}

public class MAP {

    public static void main(String[] args) {
        String[] array = new String[] { " 2019-12-31 ", "2020 - 01-09 ", "2020- 05 - 01 ", "2022 - 02 - 01",
                " 2025-01 -01" };
        // 请使用map把String[]转换为LocalDate并打印:
        Arrays.stream(array).map(s -> s.replaceAll(" ","")).map(LocalDate::parse)
        .forEach(System.out::println);
    }
}