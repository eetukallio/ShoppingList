package fi.tamk.tiko.course4aot4.util;

/**
 * A basic array list
 * @author Eetu Kallio
 * @version 1.0
 * @since 1.0
 * @param <T> Generic class
 */

public class MyArrayList<T> implements MyList<T> {

    private T[] array;
    private int currentMax;
    private int currentAmount;

    /**
     * Default constructor.
     */

    @SuppressWarnings("unchecked")
    public MyArrayList() {

        array = (T[])new Object[2];
        currentMax = 2;
        currentAmount = 0;
    }

    /**
     * @see MyList#add(T) equals
     */

    @Override
    public void add(T e) {
        if (currentAmount == currentMax) {
            extendArray();
        }

        array[currentAmount] = e;
        currentAmount++;
    }

    /**
     * @see MyList#clear() equals
     */

    @SuppressWarnings("unchecked")
    @Override
    public void clear() {

        array = (T[])new Object[2];
        currentMax = 2;
        currentAmount = 0;
    }

    /**
     * @see MyList#get(int) equals
     */

    @Override
    public T get(int index) {
        if (index >= 0 && index < currentAmount) {
            return array[index];
        }
        return null;
    }

    /**
     * @see MyList#isEmpty() equals
     */

    @Override
    public boolean isEmpty() {

        return currentAmount == 0;
    }

    /**
     * @see MyList#remove(int) equals
     */

    @Override
    public Object remove(int index) {
        Object tmp = null;
        if (index >= 0 && index < currentAmount) {
            tmp = array[index];

            rearrangeArray(index);

            currentAmount--;

            System.out.println("Removed value from index " + index + " Value was: " + tmp.toString() + " Current amount is: " + currentAmount);
        }

        return tmp;
    }

    /**
     * @see MyList#remove(T) equals
     */

    @Override
    public boolean remove(T o) {

        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(o)){
                remove(i);
                System.out.println("Removed object in index: " + i + " Removed object: " + array[i].toString());
                return true;
            }
        }

        return false;
    }

    /**
     * @see MyList#size() equals
     */

    @Override
    public int size() {
        return currentAmount;
    }

    /**
     * Extends the array when full
     */

    @SuppressWarnings("unchecked")
    private void extendArray() {

        currentMax *= 2;

        T[] temp = (T[])new Object[currentMax];

        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }

        array = temp;
    }

    /**
     * Rearranges the array when removing elements
     * @param index Index from which the rearranging starts
     */
    private void rearrangeArray(int index) {

        for (int i = index + 1; i < currentAmount; i++) {
            array[i-1] = array[i];
        }
    }

    /**
     * Getter for the currentAmount
     * @return Returns currentAmount
     */
    public int getCurrentAmount() {
        return currentAmount;
    }
}
