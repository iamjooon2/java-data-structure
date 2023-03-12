public class SimpleArrayList<T> implements SimpleList<T> {

    private int size;
    private T[] array;
    private int capacity = 10;

    public SimpleArrayList() {
        this.array = (T[]) new Object[capacity];
        this.size = 0;
    }

    public SimpleArrayList(T... values) {
        this.array = (T[]) new Object[values.length];
        for (int i = 0; i < values.length; i++) {
            this.array[i] = values[i];
        }
        this.size = values.length;
    }


    @Override
    public boolean add(final T value) {
        size++;
        this.array[size - 1] = value;
        return true;
    }

    @Override
    public void add(final int index, final T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        array = resize();
        size++;
        T[] temp = (T[]) new Object[capacity];
        for (int i = 0; i < index; i++) {
            temp[i] = array[i];
        }
        temp[index] = value;
        for (int i = index + 1; i < size; i++) {
            temp[i] = array[i - 1];
        }
        array = temp;
    }

    @Override
    public T set(final int index, final T value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T old = array[index];
        this.array[index] = value;
        return old;
    }

    @Override
    public T get(final int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public boolean contains(final T value) {
        for (int i = 0; i < size; i++) {
            if (this.array[i] == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(final T value) {
        for (int i = 0; i < size; i++) {
            if (this.array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean remove(final T value) {
        T[] temp = (T[]) new Object[capacity];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                continue;
            }
            temp[j++] = array[i];
        }
        array = temp;
        size--;
        return true;
    }

    @Override
    public T remove(final int index) {
        T element = get(index);
        for (int i = index; i < size - 1; i++) {
            this.array[i] = array[i + 1];
        }
        size--;
        return element;
    }

    @Override
    public void clear() {
        this.array = (T[]) new Object[10];
        this.size = 0;
    }

    private T[] resize() {
        if (array.length < size + 1) {
            T[] temp = array;
            capacity *= 2;
            this.array = (T[]) new Object[capacity];
            for (int i = 0; i < size; i++) {
                array[i] = temp[i];
            }
        }
        return array;
    }
}
