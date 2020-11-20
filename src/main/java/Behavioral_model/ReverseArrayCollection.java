package Behavioral_model;

import java.util.Arrays;
import java.util.Iterator;

public class ReverseArrayCollection<T> implements Iterable<T> {

    private T[] array;

    @SafeVarargs
    public ReverseArrayCollection(T... objs) {
        this.array = Arrays.copyOfRange(objs, 0, objs.length);
    }

    public Iterator<T> iterator() {
        return new ReverseIterator();

    }

    class ReverseIterator implements Iterator<T> {

        int index;

        public ReverseIterator() {
            this.index = ReverseArrayCollection.this.array.length;

        }

        public boolean hasNext() {

            return index > 0;
        }

        public T next() {
            index--;
            return array[index];
        }
    }
}
//
//class Main {
//
//    public static void main(String[] args) {
//        var rarray = new ReverseArrayCollection<String>("apple", "pear", "orange", "banana");
//        for (String fruit : rarray) {
//            System.out.println(fruit);
//        }
//    }
//}
