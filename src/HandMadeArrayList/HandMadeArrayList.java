package HandMadeArrayList;

public class HandMadeArrayList<T> {

    private int size = 0;
    private Object[] elements;

    public HandMadeArrayList() {
        this.elements = new Object[10];
    }

    public void add(T newElement) {
        if (elements.length == size) {
            grow();
        }
        elements[size] = newElement;
        size++;
    }

    public void add(int index, T element) {
        if (elements.length == size) {
            grow();
        }
        elements[index] = element;
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Element with index " + index + " does not exist");
        }
        return (T) this.elements[index];
    }

    private void grow() {
        Object[] newArray = new Object[elements.length + elements.length / 2];

        for (int i = 0; i < elements.length; i++) {
            newArray[i] = elements[i];
        }

        this.elements = newArray;
    }

    public static void main(String[] args) {
        final var ar = new HandMadeArrayList<Integer>();
        for (int i = 0; i < 2000; i++) {
            ar.add(i);
        }
        System.out.println(ar.size);
    }
}