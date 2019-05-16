package getmaxfunc;

import java.util.*;
import java.util.stream.Collectors;


public class Solution {

    public static void main(String[] args) {
        System.out.print(changeList(Arrays.stream(new Scanner(System.in).nextLine().split(" ")).collect(Collectors.toList())));
    }

    public static Integer maxElem(List<Integer> list){
        return Collections.max(list);
    }

    public static List<String> changeList(List<String> list){
        String longestWord = list.stream().max((s1, s2) -> Integer.compare(s1.length(), s2.length())).orElse("");
        return list.stream().map(x -> longestWord).collect(Collectors.toList());
    }
}
