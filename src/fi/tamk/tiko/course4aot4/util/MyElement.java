package fi.tamk.tiko.course4aot4.util;

/**
 * Element class to be used by MyLinkedList
 * @author Eetu Kallio
 * @param <T> Generic class
 */
public class MyElement<T> {

    private MyElement<T> next;
    private T content;

    /**
     * Setter for the next element in the list
     * @param next Next element in the list
     */
    public void setNext(MyElement<T> next) {
        this.next = next;
    }

    /**
     * Setter for the content of this element
     * @param content content to be stored in the element
     */
    public void setContent(T content) {
        this.content = content;
    }

    /**
     * Getter for the content in the element
     * @return Returns the content in the element
     */
    public T getContent() {
        return content;
    }

    /**
     * Getter for the next element in the list
     * @return Returns the next element in the list
     */
    public MyElement<T> getNext() {
        return next;
    }
}
