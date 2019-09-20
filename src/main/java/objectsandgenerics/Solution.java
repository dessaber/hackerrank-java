package objectsandgenerics;

interface Copy<T> {
    T copy();
}

class Folder<T> {
    private T item;

    public void put(T item) {
        this.item = item;
    }

    public T get() {
        return this.item;
    }
}

/**
 * Class to work with
 */
class Solution {
     /**
     * Multiply folders and put copies of original folder argument content in each.
     *
     * @param folder folder which content should be multiplicated
     * @param arraySize size of array to return.
     *     Each array element should have objectsandgenerics.Folder with copy of the original content inside
     * @return array of objectsandgenerics.Folder<T>[] objects
     */
    public static <T extends Copy<T>> Folder<T>[] multiply(Folder<T> folder, int arraySize) {
        Object[] copies = new Folder[arraySize];
        for (int i = 0; i < arraySize; i++) {
            Folder<T> newFolder = new Folder<>();
            newFolder.put(folder.get().copy());
            copies[i] = newFolder;
        }

        return (Folder<T>[]) copies;
    }
}
