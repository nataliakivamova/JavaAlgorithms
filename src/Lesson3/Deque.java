package Lesson3;

public class Deque<T> {
    private T[] deque;
    private int front;
    private int rear;
    private int size;

    public Deque(int size) {
        deque = (T[]) new Object[size];
    }

    public void insertRear(T element){
        if(rear == deque.length - 1) {
            rear = -1;
        }
        deque[++rear] = element;
        size++;
    }

    public void insertFront(T element){
        deque[--front] = element;
        if(front < 0){
            front = deque.length - 1;
        }
        size++;
    }

    public T removeRear(){
        T rar = deque[--rear];
        if(rear == -1){
           rear = deque.length - 1;
        }
        size--;
        return rar;
    }

    public T removeFront(){
        T temp = deque[front++];
        if(front == deque.length){
            front = 0;
        }
        size--;
        return temp;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == deque.length;
    }

}


