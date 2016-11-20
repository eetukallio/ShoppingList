package fi.tamk.tiko.course4aot4.util;

/**
 * List interface
 * @author Eetu Kallio
 * @param <T> Generic class
 */
public interface MyList<T> {

    /**
     * Appends the specified element to the end of this list
     * @param e Content to be added to the list
     */
    void add(T e);

    /**
     * Removes all of the elements from this list
     */
    void clear();

    /**
     * Returns the element at the specified position in this list.
     * @param index Index from which to get content
     * @return Returns the object at index
     */
    Object get(int index);

    /**
     * Returns true if this list contains no elements.
     * @return Returns true if successful, false if not
     */
    boolean isEmpty();

    /**
     * Removes the element at the specified position in this list. Returns the removed element.
     * @param index Index of the removed element
     * @return returns the removed object
     */
    Object remove(int index);

    /**
     * Removes the first occurrence of the specified element from this list, if it is present (return true)
     * @param o The element to be removed from the list
     * @return Returns true if successful, false if not
     */
    boolean remove(T o);

    /**
     * Returns the number of elements in this list.
     * @return Returns the number of elements in this list.
     */
    int size();
}
