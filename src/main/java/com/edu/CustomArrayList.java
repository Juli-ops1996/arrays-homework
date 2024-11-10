import java.util.Arrays;

public class MyArrayList<T> {
    private T[] elements;
    private int size;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        elements = (T[]) new Object[10]; // начальный размер массива
        size = 0;
    }

    public void add(T element) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = element;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return elements[index];
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index, size);
        }
        T removedElement = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null; // освобождение ссылки
        return removedElement;
    }

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        elements = Arrays.copyOf(elements, elements.length * 2);
    }
}
