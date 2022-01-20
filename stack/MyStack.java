package stack;

import java.util.EmptyStackException;

public class MyStack<E> {
    private stackNode<E> top;
    private int length;

    public MyStack() {
        length = 0;
        top = null;
    }

    public static void main(String[] args) {

        MyStack<Integer> ms = new MyStack<>();
        ms.push(5);
        ms.push(7);
        ms.push(2);
        ms.push(89);
        System.out.println("length is : " + ms.length);
//        System.out.println(ms.peek());
        while (ms.top != null) {
            System.out.print(ms.pop() + " ");
        }
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void push(E data) {
        stackNode<E> newData = new stackNode<>(data);
        if (isEmpty()) {
            top = newData;
        } else {
            newData.next = top;
            top = newData;
        }
        length++;
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            E valueOfDeleted = top.data;
            top = top.next;
            length--;
            return valueOfDeleted;
        }
    }

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return top.data;
        }
    }

    private static class stackNode<E> {
        private stackNode<E> next;
        private E data;

        public stackNode(E data) {
            this.data = data;
            next = null;
        }
    }
}
