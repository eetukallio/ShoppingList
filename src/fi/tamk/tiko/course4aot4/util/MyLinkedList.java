package fi.tamk.tiko.course4aot4.util;

/**
 * A basic linked list
 * @author Eetu Kallio
 * @param <T> Generic class
 */
public class MyLinkedList<T> implements MyList<T> {

    private MyElement<T> first;
    private int size;

    public MyLinkedList(){
        size = 0;
    }

    /**
     * @see MyList#add(T) equals
     */
    @Override
    public void add(T e) {

        if (first == null){
            first = new MyElement<>();
            first.setNext(null);
            first.setContent(e);
            size++;
            //System.out.println("Added the first Element");
        }else {
            MyElement<T> newElement = new MyElement<>();
            newElement.setContent(e);
            newElement.setNext(first);
            first = newElement;
            size++;
            //System.out.println("Added a new Element");
        }

    }

    /**
     * @see MyList#clear() equals
     */
    @Override
    public void clear() {
        first = null;
    }

    /**
     * @see MyList#get(int) equals
     */
    @Override
    public T get(int index) {

        if (index<0 || index >size) return null;

        MyElement<T> currentElement;

        if (first != null) {
            currentElement = first;
        }else {
            return null;
        }

        if (index == 0){
            return currentElement.getContent();
        }


        for (int i = 0; i < index; i++) {
            if (currentElement.getNext() == null){
                return null;
            }
            currentElement = currentElement.getNext();
        }
        return currentElement.getContent();

    }

    /**
     * @see MyList#isEmpty() equals
     */
    @Override
    public boolean isEmpty() {
        return first==null;
    }

    /**
     * @see #remove(int) equals
     */
    @Override
    public Object remove(int index) {
        if (index<0 || index >size) return null;

        MyElement<T> currentElement;

        if (first != null) {
            currentElement = first;
        }else {
            return null;
        }

        if (index == 0){
            first = first.getNext();
            return currentElement;
        }

        if (index == 1){
            first.setNext(first.getNext().getNext());
        }

        for (int i = 0; i < index-1; i++) {
            if (currentElement.getNext() == null){
                return null;
            }
            currentElement = currentElement.getNext();
        }

        currentElement.setNext(currentElement.getNext().getNext());

        return currentElement;
    }

    /**
     * @see MyList#remove(T) equals
     */
    @Override
    public boolean remove(T o) {
        if (first==null) return false;

        MyElement<T> currentElement = first;

        for (int i = 0; i < size; i++) {
            if (currentElement.getNext() == null){
                return false;
            }
            if (currentElement.getNext().getContent()== o){
                currentElement.setNext(currentElement.getNext().getNext());
                return true;
            }
            currentElement = currentElement.getNext();
        }

        return false;
    }

    /**
     * @see MyList#size() equals
     */
    @Override
    public int size() {
        return size;
    }
}
