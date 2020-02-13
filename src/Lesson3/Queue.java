package Lesson3;

public class Queue<T> {
    private T[] queue;
    private int front;
    private int rear;
    private int size;


    public Queue(int size) {
        queue = (T[]) new Object[size];
        rear = -1;
        front = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == queue.length;
    }

    public T peek(){
        return queue[front];
    }

    public void insert(T element){
        if (rear == queue.length - 1) {
            rear = -1;
        }
        queue[++rear] = element;
        size++;
    }

    public T remove(){
        T temp = queue[front++];
        if (front == queue.length){
            front = 0;
        }
        size--;
        return temp;
    }

}
