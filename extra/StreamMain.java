package extra;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamMain {
    public static void main(String[] args){
        InputStreamReader a = new InputStreamReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        List<Integer> list =  List.of(2,3,4,5,6,4,23,11,77,45,65,44);
        System.out.println(list);

         Stream<Integer> st = list.stream();
        List<Integer> list1 = st.filter(i -> i %2 ==0).collect(Collectors.toList());
        pw.println(list1);

        List<Integer> lll = new ArrayList<>();
        list= list.stream().sorted().collect(Collectors.toList());
        System.out.println(list);

        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> pw.println("Mapped value: " + e))
                .collect(Collectors.toList());
        lll.forEach(System.out::print);
        Optional<Integer> asd = lll.stream().findAny();
        pw.println(asd);

    }
}
