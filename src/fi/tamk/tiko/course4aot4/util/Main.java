package fi.tamk.tiko.course4aot4.util;

/**
 * A test class
 * @author Eetu Kallio
 */
public class Main {

    public static void main(String[] args){

        MyLinkedList<Integer> list = new MyLinkedList<>();
        MyArrayList<Integer> arrayList = new MyArrayList<>();

        long elapsedTime;
        long startTime = System.nanoTime();

        for (int i = 0; i < 5000000; i++) {
            list.add(i);
        }
        elapsedTime = System.nanoTime() - startTime;
        System.out.println(elapsedTime/1000000 + "ms To add i to LinkedList");

        startTime = System.nanoTime();
        for (int i = 0; i < 5000000; i++) {
            arrayList.add(i);
        }
        elapsedTime = System.nanoTime() - startTime;
        System.out.println(elapsedTime/1000000 + "ms To add i to ArrayList");

        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list.get(i);
        }
        elapsedTime = System.nanoTime() - startTime;
        System.out.println(elapsedTime/1000000 + "ms To get i from LinkedList");

        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            arrayList.get(i);
        }
        elapsedTime = System.nanoTime() - startTime;
        System.out.println(elapsedTime/1000000 + "ms To get i from ArrayList");

    }

}
