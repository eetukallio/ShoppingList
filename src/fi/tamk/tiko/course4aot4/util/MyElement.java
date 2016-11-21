package fi.tamk.tiko.course4aot4.util;

/**
 * Element class to be used by MyLinkedList
 *
 * @author Eetu Kallio
 * @version 1.0
 * @since 1.0
 * @param <T> Generic class
 */
public class MyElement<T> {

    /**
     * Next element in the list.</p>
     */
    private MyElement<T> next;

    /**
     * Content on this element.</p>
     */
    private T content;

    /**
     * Sets the next element in the list.</p>
     *
     * @param next Next element in the list
     */
    public void setNext(MyElement<T> next) {
        this.next = next;
    }

    /**
     * Sets the content of this element.</p>
     *
     * @param content content to be stored in the element
     */
    public void setContent(T content) {
        this.content = content;
    }

    /**
     * Returns the content in the element.</p>
     *
     * @return Returns the content in the element
     */
    public T getContent() {
        return content;
    }

    /**
     * Returns the next element in the list.</p>
     *
     * @return Returns the next element in the list
     */
    public MyElement<T> getNext() {
        return next;
    }
}
