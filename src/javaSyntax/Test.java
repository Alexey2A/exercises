package javaSyntax;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) throws IOException {

        String s = "gh dj fghg gh fghg fghg";

//        String[] str = s.split(" ");
//        String arrayString = Arrays.toString(str);
//        System.out.println(arrayString);
//
//        Map<String, Integer> map = new HashMap<>();
//        for (int i = 0; i < str.length; i++) {
//            int count = 0;
//            for (int j = 0; j < str.length; j++) {
//                if (str[i].equals(str[j])) ++count;
//            }
//            map.put(str[i], count);
//            count = 0;
//        }
//        System.out.println(map);

        Map<String, Long> map = Arrays.stream(s.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
        System.out.println("------------------");

        File file = new File("C:\\IdeaProjects\\exercises\\src\\javaSyntax\\auto.txt");

        FilterImpl filter = new FilterImpl();
        System.out.println(filter.filter1(file));
        System.out.println("------------------");
        System.out.println(filter.filter2(file));
        System.out.println("------------------");
        System.out.println(filter.filter3(file));
        System.out.println("------------------");
        System.out.println(filter.filter4(file));
        System.out.println("------------------");
    }
}
