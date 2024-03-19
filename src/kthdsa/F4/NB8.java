package kthdsa.F4;

public class NB8<E> {
        private E[] queue;
        int size;
        int maxSize;
        int front, rear;

        public NB8(int maxSize) {
            this.maxSize = maxSize;
            this.size = 0;
            this.front = 0;
            this.rear = maxSize - 1;
            queue = (E[]) new Object[maxSize];
        }

        public boolean offer(E element) {
            if (size == maxSize) {
                reallocate(2 * maxSize);
            }
            rear = (rear + 1) % maxSize;
            queue[rear] = element;
            size++;
            return true;
        }

        public E peek() {
            if (size == 0) return null;
            return queue[front];
        }

        public E poll() {
            if (size == 0) return null;
            else {
                size--;
                E element = queue[front];
                front = (front + 1) % maxSize;
                shrink();
                return element;
            }
        }

        private void reallocate(int newMaxSize) {
            E[] newData = (E[]) new Object[newMaxSize];
            int j = front;
            for (int i = 0; i < size; i++) {
                newData[i] = queue[j];
                j = (j + 1) % maxSize;
            }
            front = 0;
            rear = size - 1;
            maxSize = newMaxSize;
            queue = newData;
        }

        private void shrink() {
            if (size <= maxSize / 4) reallocate(maxSize / 2);
        }


        @Override
        public String toString() {
            StringBuilder result = new StringBuilder("[");
            for (int i = 0; i < size; i++) {
                result.append(queue[(front + i) % maxSize]);
                if (i < size - 1) {
                    result.append(", ");
                }
            }
            result.append("]");
            return result.toString();
        }
}
