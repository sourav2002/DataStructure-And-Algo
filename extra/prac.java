package extra;

import java.util.Arrays;

public class prac {
    public static void main(String[] args) {
//        String str = "sourav";
//
//        System.out.println(str.charAt(0)); // 1st
//
//        char[] arr = str.toCharArray(); // 2nd
//        System.out.println(Arrays.toString(arr));
//
//
//        System.out.println(str.substring(0,2) +" "+ str.substring(4,str.length())); // 3rd
//
//        String half = str.substring(0,3);
//        System.out.println(half);







        String str = "geeks for geek is for geeks";
        String key = "for";



        boolean check = str.contains("for");
        System.out.println(check);

//        String key = "for";
//
//        System.out.println(findChar(str, key));




    }

    public static boolean findChar(String str, char  c){
        for(int i=0; i< str.length(); i++){
            if(str.charAt(i) == c){
                return true;
            }
        }

        return false;
    }
}
