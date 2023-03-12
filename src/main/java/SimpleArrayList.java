public class SimpleArrayList<T> implements SimpleList<T> {

    private int size;
    private T[] array;

    public SimpleArrayList() {
        this.array = (T[]) new Object[10];
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
        return false;
    }

    @Override
    public void add(final int index, final T value) {

    }

    @Override
    public T set(final int index, final T value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        this.array[index] = value;
        return this.array[index];
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
        return false;
    }

    @Override
    public T remove(final int index) {
        return null;
    }

    @Override
    public void clear() {
        this.array = new Object[capacity];
        this.size = 0;
    }

    private Object[] resize() {
        if (array.length < size + 1) {
            Object[] temp = array;
            capacity *= 2;
            this.array = new Object[capacity];
            for (int i = 0; i < size; i++) {
                array[i] = temp[i];
            }
        }
        return array;
    }
}
