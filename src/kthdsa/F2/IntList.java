package kthdsa.F2;

import java.util.Arrays;

public class IntList {
    int[] list;
    int nrOfElements;
    int capacity;

    public IntList(int initialCapacity) {
        this.list = new int[initialCapacity];
        this.nrOfElements = 0;
        this.capacity = initialCapacity;
    }

    public IntList(){
        this(10);
    }

    public void add(int element){
        if(nrOfElements >= capacity) reallocate();
        this.list[nrOfElements++] = element;
    }

    public void add(int index, int element){
        if(index < 0 || index >= nrOfElements) throw new ArrayIndexOutOfBoundsException("Invalid index");
        if(nrOfElements >= capacity) reallocate();

        for(int i = index; i < nrOfElements; i++){
            this.list[i+1] = this.list[i];
        }
        this.list[index] = element;
        this.nrOfElements++;
    }

    public int get(int index){
        if(index < 0 || index >= nrOfElements) throw new ArrayIndexOutOfBoundsException("Invalid index");
        return this.list[index];
    }

    public int indexOf(int element){
        for(int i = 0; i < nrOfElements; i++){
            if(this.list[i] == element) return i;
        }
        return -1;
    }

    public int remove(int index){
        if(index < 0 || index >= nrOfElements) throw new ArrayIndexOutOfBoundsException("Invalid index");
        int old = this.list[index];

        for(int i = index; i < nrOfElements-1; i++){
            this.list[i] = this.list[i+1];
        }

        this.nrOfElements--;
        return old;
    }

    public int set(int index, int element){
        if(index < 0 || index >= nrOfElements) throw new ArrayIndexOutOfBoundsException("Invalid index");
        int old = this.list[index];
        this.list[index] = element;
        return old;
    }

    public int size(){
        return this.nrOfElements;
    }

    private void reallocate(){
        this.capacity *= 2;
        this.list = Arrays.copyOf(this.list, this.capacity);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < nrOfElements; i++) {
            result.append(list[i]);
            if (i < nrOfElements - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
}
