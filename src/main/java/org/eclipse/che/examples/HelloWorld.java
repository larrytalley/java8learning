package org.eclipse.che.examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.Executors;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

public class HelloWorld {

    static Comparator<String> lengthComparator = new Comparator<String>() {
        public int compare(String s1, String s2) {
            return Integer.compare(s1.length(), s2.length());
        }
    };  
    static Runnable r = new Runnable() {
        public void run() {
            int i = 0;
            while (i++ < 3) {
                System.out.println("Hi!");
            }
        };
    };
    
    static Comparator<String> lengthComparator2 = (s1, s2) -> Integer.compare(s1.length(), s2.length());
    static Runnable r2 = () -> {
        int i = 0;
        while (i++ < 2) {
            System.out.println("Hi!");
        }
    };
    BinaryOperator<Integer> sum = Integer::sum ;
    Consumer<String> p = s -> System.out.println(s);
    
    public static void main(String... argvs) {
        String a = "Che";
        String[] strings = {"Bob", "Jane", "Malcolm"};
        Arrays.sort(strings, lengthComparator2);
        System.out.println("Hello World " + a + "!");
        Arrays.stream(strings).forEach(System.out::println);
        Executors.newSingleThreadExecutor().execute(r2);
        System.out.println(Integer.sum(1,2)); 
    };

        


}
