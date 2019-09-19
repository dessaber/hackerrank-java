package breakQA;

import java.util.Arrays;
import java.util.List;

class Bakery {}

class Cake extends Bakery {}

/* But this should not */
class Paper {}

/* These boxes are used to pack stuff */
class Box<T> {
    T data;
    void put(T item) { data = item; }
    T get() { return data; }
}

/* This quality checker ensures that boxes for sale contain breakQA.Bakery and anything else */
class NaiveQualityControl {

    public static boolean check(List<Box<? extends Bakery>> boxes) {
    /* Method signature guarantees that all illegal 
       calls will produce compile-time error... or not? */
        return true;
    }

}

class Violator {

    public static List<Box<? extends Bakery>> defraud() {
        Object[] trick = new Object[]{new Paper()};
        Box box = new Box();
        box.put(new Paper());
        return Arrays.asList(box);
    }

}

class Solution {
    public static void main(String[] args) {
        System.out.print(NaiveQualityControl.check(Violator.defraud()));
    }
}