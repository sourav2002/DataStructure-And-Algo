package extra;

import java.util.Arrays;

public class LambdaExp {
    public interface Add{
        public int add(int a, int b);
    }
    public static int doAdd(int a, int b) {
        return a + b;
    }

    public interface Display{
        public int show(String s1, String s2);
        }

    public static void main(String[] args) {
        Add add = LambdaExp::doAdd;

        // #2
        String[] arr = {"delhi", "chd", "haryana","punjab", "hp"};
        Arrays.stream(arr).forEach(System.out::println);
        Display dp = String::indexOf;
        System.out.println(dp);
    }
}
