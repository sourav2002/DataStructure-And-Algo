package Sample;

public class Stack1 {
    int size;
    int top;
    String arr[];

public Stack1 (int n){
    size = n;
    arr = new String[size];
    top = -1;
}

public Boolean empty(){
    if(top == -1)
        return true;
    else
        return false;
}

public void push (String str){
    arr[++top] = str;
}

public String pop(){
    if(top > -1){
        String str = arr[top];
        arr[top] = null;
        top -- ;
        return str;
    }
    else
        return null;
}

public String peek(){
    return arr[top];
}

public static void main (String args[]){
    Stack1 myStack = new Stack1(7);
    myStack.push("apple");
    myStack.push("orange");
    myStack.push("banana");
    myStack.push("cherry");

    System.out.println(myStack.peek());
    System.out.println(myStack.empty());
    System.out.println(myStack.pop());
    System.out.println(myStack.peek());
    System.out.println(myStack.pop());
    System.out.println(myStack.pop());
    System.out.println(myStack.empty());
    System.out.println(myStack.pop());
}

}
