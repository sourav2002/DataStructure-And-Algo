package stack;

import java.util.Scanner;

public class ReverseString {

    public static String reverse(String str){
        MyStack<Character> myStack = new MyStack<>();
        char[] chars = str.toCharArray();

        for (char c : chars){
            myStack.push(c);
        }
        for (int j=0; j<str.length(); j++){
            chars[j]= myStack.pop();
        }
        return new String(chars);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("Before reverse : "+ str);

        System.out.println("After reverse : "+ reverse(str));
    }
}
