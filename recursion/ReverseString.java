package recursion;

// time complexity is O(n) because we are calling reverse function till the length of string i.e n
public class ReverseString {

    public static void reverseString(String st, int index){

        System.out.print(st.charAt(index));
        if (index==0){
            return;
        }
        reverseString(st, index-1);

    }

    public static void main(String[] args) {
            String st = "sourav";
            reverseString(st,st.length()-1);
    }
}
