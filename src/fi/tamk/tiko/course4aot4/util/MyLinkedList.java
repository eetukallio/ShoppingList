package fi.tamk.tiko.course4aot4.util;

/**
 * A basic linked list
 *
 * @author Eetu Kallio
 * @version 1.0
 * @since 1.0
 * @param <T> Generic class
 */
public class MyLinkedList<T> implements MyList<T> {

    /**
     * The first element.</p>
     */
    private MyElement<T> first;

    /**
     * Size of the array.</p>
     */
    private int size;

    /**
     * Default constructor.</p>
     */
    public MyLinkedList() {
        size = 0;
    }

    /**
     * Adds an item.</p>
     *
     * @see MyList#add(T) equals
     */
    @Override
    public void add(T e) {

        if (first == null) {
            first = new MyElement<>();
            first.setNext(null);
            first.setContent(e);
            size++;
        } else {
            MyElement<T> newElement = new MyElement<>();
            newElement.setContent(e);
            newElement.setNext(first);
            first = newElement;
            size++;
        }
    }

    /**
     * Clears the list.</p>
     *
     * @see MyList#clear() equals
     */
    @Override
    public void clear() {
        first = null;
    }

    /**
     * Returns and item.</p>
     *
     * @see MyList#get(int) equals
     */
    @Override
    public T get(int index) {

        if (index < 0 || index > size) return null;

        MyElement<T> currentElement;

        if (first != null) {
            currentElement = first;
        } else {
            return null;
        }

        if (index == 0) {
            return currentElement.getContent();
        }

        for (int i = 0; i < index; i++) {
            if (currentElement.getNext() == null) {
                return null;
            }

            currentElement = currentElement.getNext();
        }

        return currentElement.getContent();
    }

    /**
     * Returns boolean.</p>
     *
     * @see MyList#isEmpty() equals
     */
    @Override
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the removed object.</p>
     *
     * @see #remove(int) equals
     */
    @Override
    public Object remove(int index) {
        if (index < 0 || index > size) return null;

        MyElement<T> currentElement;

        if (first != null) {
            currentElement = first;
        } else {
            return null;
        }

        if (index == 0) {
            first = first.getNext();
            return currentElement;
        }

        if (index == 1) {
            first.setNext(first.getNext().getNext());
        }

        for (int i = 0; i < index - 1; i++) {
            if (currentElement.getNext() == null) {
                return null;
            }

            currentElement = currentElement.getNext();
        }

        currentElement.setNext(currentElement.getNext().getNext());

        return currentElement;
    }

    /**
     * Returns boolean.</p>
     *
     * @see MyList#remove(T) equals
     */
    @Override
    public boolean remove(T o) {

        if (first == null) return false;

        MyElement<T> currentElement = first;

        for (int i = 0; i < size; i++) {

            if (currentElement.getNext() == null) {
                return false;
            }

            if (currentElement.getNext().getContent() == o) {
                currentElement.setNext(currentElement.getNext().getNext());
                return true;
            }

            currentElement = currentElement.getNext();
        }

        return false;
    }

    /**
     * Returns size.</p>
     *
     * @see MyList#size() equals
     */
    @Override
    public int size() {
        return size;
    }
}
