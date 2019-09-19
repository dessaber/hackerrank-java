package almostsorted;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        almostSorted(new int[]{2, 1});
    }

    static void almostSorted(int[] arr) {
        int[] newB = new int[arr.length];
        System.arraycopy(arr, 0, newB, 0, arr.length);
        Arrays.sort(newB);
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        List<Integer> origPos = new ArrayList<>();
        List<Integer> newPos = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (i != map.get(newB[i])) {
                origPos.add(map.get(newB[i]));
                newPos.add(i);
            }
        }

        System.out.println(origPos);
        System.out.println(newPos);
        System.out.println(Arrays.toString(newB));
        System.out.println(map);

        if (origPos.size() == 2) {
            System.out.println("yes");
            System.out.println("swap " + (newPos.get(0) + 1) + " " + (newPos.get(newPos.size() - 1) + 1));
        } else {
            for (int i = 0; i < origPos.size(); i++) {
                if (!origPos.get(i).equals(newPos.get(newPos.size() - 1 - i))) {
                    System.out.println("no");
                    return;
                }
            }

            System.out.println("yes");
            System.out.println("reverse " + (newPos.get(0) + 1) + " " + (newPos.get(newPos.size() - 1) + 1));
        }
    }
}