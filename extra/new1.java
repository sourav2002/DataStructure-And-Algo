package extra;

import java.util.Arrays;
import java.util.HashMap;

public class new1 {
    public static void main(String[] args) {
//        int[] arr = {8,9,5,6,7,2,4};
//        System.out.println(Arrays.toString(arr));
//        int[] result = Arrays.copyOfRange(arr, 0,3);
//        System.out.println(Arrays.toString(result));
//        System.out.println(Arrays.mismatch(arr,result));
//
//        String s = "simeoan";
//        char[] ch = new char[s.length()];
//        for (int i =0; i<s.length();i++){
//            ch[i] = s.charAt(i);
//            System.out.print(ch[i]);
//        }

//        int i = 6;
//        for (int j=0; j<i;j++){
//            if(j<1){
//                continue;
//            }
//            if (j==0){
//                System.out.println("zero");
//            }
//            if (j==1){
//                System.out.println("one");
//            }
//            if (j==5){
//                System.out.println("5");
//            }
//        }

//        int [] arr = {6,8,9,4,5,6};
//        String s = Arrays.toString(arr).replaceAll("\\[|\\]|,|\\s", "");
//        System.out.println(s);
//        int n = (int)Integer.parseInt(s);
//        System.out.println(n);
        HashMap<String, Integer> hm
                = new HashMap<String, Integer>();

        // Adding mappings to HashMap
        // using put() method
        hm.put("GeeksforGeeks", 54);
        hm.put("A computer portal", 80);
        hm.put("For geeks", 82);

        // Printing all elements of above HashMap
        System.out.println("Created hashmap is" + hm);

        // Display message only
        System.out.println(
                "HashMap after adding bonus marks:");

        hm.forEach((k,v)-> {
            System.out.println(k + " " + v);
        });

    }
}
