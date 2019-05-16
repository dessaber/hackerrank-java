package minpoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Interval> intervals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] points = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            intervals.add(new Interval(points));
        }
        Collections.sort(intervals);
        int current = intervals.get(0).getEnd();
        List<Integer> solutions = new ArrayList<>();
        solutions.add(current);
        for (int i = 1; i < n; i++) {
            if (!intervals.get(i).isIncluding(current)) {
                current = intervals.get(i).getEnd();
                solutions.add(current);
            }
        }
        System.out.println(solutions.size());
        for (Integer solution : solutions) {
            System.out.print(solution + " ");
        }
    }
}

class Interval implements Comparable<Interval>{
    private int start, end;

    Interval(int[] points) {
        this.start = points[0];
        this.end = points[1];
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public int compareTo(Interval o) {
        return Integer.compare(this.end, o.end);
    }

    public boolean isIncluding(int point) {
        return point >= this.start && point <= this.end;
    }
}


