package checkbox;

import java.util.LinkedList;
import java.util.List;

interface Box<T> {
    T get();

    void put(T put);
}

class MyBox<T> implements Box<T> {
    T data;

    public T get() {
        return data;
    }

    public void put(T item) {
        data = item;
    }
}

class Bakery { }

class Cake extends Bakery {}

class Paper {}

class Solution {
    public static void main(String[] args) {
        Box<Cake> box = new MyBox<>();
        box.put(new Cake());
        List<Box<? extends Bakery>> list = new LinkedList<>();
        list.add(box);
        System.out.print(check(list));
    }

    public static boolean check(List<Box<? extends Bakery>> boxList) {
        if (boxList.isEmpty()) {
            return true;
        }

        for (Object object: boxList) {
            if (!(object instanceof Box)) {
                return false;
            }

            Object contents = ((Box) object).get();
            if (contents == null) {
                return false;
            }

            if (!(contents instanceof Bakery)) {
                return false;
            }
        }

        return true;
    }
}