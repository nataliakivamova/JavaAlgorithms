package Lesson3;

public class Stack<T> {
    private int top;
    private T[] stack;

    public Stack() {
        this.top = -1;
        this.stack = (T[]) new Object[10];
    }

    public void push(T element){
        this.stack[++this.top] = element;
    }

    public T pop() {
       return this.stack[--this.top];
    }

    public boolean isEmpty(){
        return this.top == -1;
    }

    public boolean isFull(){
        return this.top == this.stack.length-1;
    }

    public T peek(){
        return this.stack[this.top];
    }
}
