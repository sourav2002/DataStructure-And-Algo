package extra;

import java.util.Arrays;
import java.util.Scanner;

public class new1 {
    public static void main(String[] args) {
        int[] arr = {8,9,5,6,7,2,4};
        System.out.println(Arrays.toString(arr));
        int[] result = Arrays.copyOfRange(arr, 0,3);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.mismatch(arr,result));

        String s = "simeoan";
        char[] ch = new char[s.length()];
        for (int i =0; i<s.length();i++){
            ch[i] = s.charAt(i);
            System.out.print(ch[i]);
        }


    }
}
