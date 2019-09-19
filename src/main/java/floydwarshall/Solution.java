package floydwarshall;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    // Complete the findShortest function below.

    /*
     * For the unweighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] to <name>To[i].
     *
     */
    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
        // solve here
        Map<Integer, Vertex> vertices = new HashMap<>();
        Set<Integer> targetColorSet = new HashSet<>();
        for (int i = 1; i <= graphNodes; i++) {
            Vertex newVertex = new Vertex(i, ids[i - 1]);
            vertices.put(i, newVertex);
            if (ids[i - 1] == val) {
                targetColorSet.add(i);
            }
        }

        Stream.of(1, 2, 3).mapToInt(x -> x).boxed().collect(Collectors.toSet());

        for (int i = 0; i < graphFrom.length; i++) {
            vertices.get(graphFrom[i]).neighbours.add(i + 1);
            vertices.get(graphTo[i]).neighbours.add(i);
        }

       /* for (Vertex vertex: vertices.values()) {
            System.out.println(vertex);
        }*/

        Double[][] proximity = new Double[vertices.size()][vertices.size()];

        for (int i = 0; i < proximity.length; i++) {
            for (int j = 0; j < proximity.length; j++) {
                if (i == j) {
                    proximity[i][j] = 0d;
                } else if (vertices.get(i + 1).neighbours.contains(vertices.get(j + 1))) {
                    proximity[i][j] = 1d;
                } else {
                    proximity[i][j] = Double.POSITIVE_INFINITY;
                }
            }
        }

        for (int k = 0; k < proximity.length; k++) {
            for (int i = 0; i < proximity.length; i++) {
                for (int j = 0; j < proximity.length; j++) {
                    if (proximity[i][j] > proximity[i][k] + proximity[k][j]) {
                        proximity[i][j] = proximity[i][k] + proximity[k][j];
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;
        boolean wasFound = false;
        for (int i = 0; i < proximity.length; i++) {
            if (targetColorSet.contains(i + 1)) {
                for (int j = 0; j < proximity.length; j++) {
                    if (i != j && targetColorSet.contains(j + 1)) {
                        wasFound = true;
                        int intProximity = proximity[i][j].intValue();
                        if (intProximity < result) {
                            result = intProximity;
                        }
                    }
                }
            }
        }

        return wasFound ? result : - 1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] graphNodesEdges = scanner.nextLine().split(" ");
        int graphNodes = Integer.parseInt(graphNodesEdges[0].trim());
        int graphEdges = Integer.parseInt(graphNodesEdges[1].trim());

        int[] graphFrom = new int[graphEdges];
        int[] graphTo = new int[graphEdges];

        for (int i = 0; i < graphEdges; i++) {
            String[] graphFromTo = scanner.nextLine().split(" ");
            graphFrom[i] = Integer.parseInt(graphFromTo[0].trim());
            graphTo[i] = Integer.parseInt(graphFromTo[1].trim());
        }

        long[] ids = new long[graphNodes];

        String[] idsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < graphNodes; i++) {
            long idsItem = Long.parseLong(idsItems[i]);
            ids[i] = idsItem;
        }

        int val = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int ans = findShortest(graphNodes, graphFrom, graphTo, ids, val);

        System.out.println(ans);

        /* bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close(); */
    }
}

class Vertex {
    int id;
    long color;
    Set<Integer> neighbours;

    Vertex(int id, long color) {
        this.id = id;
        this.color = color;
        neighbours = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {

        return "Vertex{" +
                "id=" + id +
                ", color=" + color +
                ", neighbours=" + neighbours +
                '}';
    }
}