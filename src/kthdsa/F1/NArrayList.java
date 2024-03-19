package kthdsa.F1;

import java.util.Arrays;

public class NArrayList<E> {
    private E[] data;
    private int nrElements;
    private int maxSize;
    public NArrayList(){
        nrElements = 0;
        maxSize = 10;
        data = (E[]) new Object[maxSize];
    }
    public boolean add(E element){
        if(nrElements==maxSize)
            reallocate();
        data[nrElements++]=element;
        return true;
    }
    public E get(int index){
        if(0<=index && index < nrElements)
            return data[index];
        throw new ArrayIndexOutOfBoundsException(index);
    }
    private void reallocate(){
        maxSize*=2;
        data=Arrays.copyOf(data,maxSize);
    }
    public void add(int index, E element){
        if(0<=index && index <= nrElements)
        {
            if(nrElements==maxSize)
                reallocate();
            for(int i=nrElements;i>index;i--)
                data[i]=data[i-1];
            data[index]=element;
            nrElements++;
            return;
        }
        throw new ArrayIndexOutOfBoundsException(index);
    }

    public E remove(int index) {
        E removed = data[index];
        for (int i = index; i < nrElements - 1; i++) {
            data[i] = data[i + 1];
        }
        nrElements--;
        return removed;
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < nrElements; i++) {
            if (data[i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    public E set(int index, E element) {
        if (0 <= index && index < nrElements) {
            E oldValue = data[index];
            data[index] = element;
            return oldValue;
        }
        throw new ArrayIndexOutOfBoundsException(index);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < nrElements; i++) {
            result.append(data[i]);
            if (i < nrElements - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
}
