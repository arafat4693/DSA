package kthdsa.F4;

import java.util.Arrays;

public class NB81<E> {
    private int front, rear, size, maxSize;
    private E[] data;
    public NB81(int initialSize){
        size = 0;
        front = 0;
        maxSize = initialSize;
        rear = 0;
        data = (E[]) new Object[maxSize];
    }
    public boolean offer(E element){
        if(size==maxSize)
            reallocate();
        data[rear] = element;
        // BAD: The % (modulo) operator has higher precedence than +
//        rear = rear+1%maxSize;
         rear = (rear + 1) % maxSize;
        size++;
        return true;
    }
    public E peek(){
        if(size==0) return null;
        return data[front];
    }
    public E poll(){
        if(size==0){
            return null;
        }else{
            size--;
            E element = data[front];
//            front =front+1%maxSize;
             front = (front + 1) % maxSize;
            return element;
        }
    }
    private void reallocate() {
        maxSize*=2;
        data= Arrays.copyOf(data,maxSize);
    }
}
