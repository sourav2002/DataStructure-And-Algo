package queue;

import java.util.EmptyStackException;

public class MyQueue<E> {
    private QueueNode<E> front;
    private QueueNode<E> rear;
    private int length;

    public MyQueue() {
        this.length = 0;
        this.front = this.rear = null;
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        queue.print();
        System.out.println("length is : " + queue.length);
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void enqueue(E data) {
        QueueNode<E> temp = new QueueNode<>(data);
        if (isEmpty()) {
            front = temp;
        } else {
            rear.next = temp;
        }
        rear = temp;
        length++;
    }

    public void dequeue() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            QueueNode<E> prev = front;
            while (prev.next != rear) {
                prev = prev.next;
            }
            prev.next = null;
            rear = prev;
        }
        length--;
    }

    public void print() {
        if (isEmpty()) {
            return;
        }
        QueueNode<E> current = front;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.print("null");
        System.out.println();
    }

    private static class QueueNode<E> {
        private E data;
        private QueueNode<E> next;

        public QueueNode(E data) {
            this.data = data;
            this.next = null;
        }
    }
}
