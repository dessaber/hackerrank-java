package minpathstonodes;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named minpathstonodes.Solution. */
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        for (int i = 0; i < queries; i++) {
            int nodes = scanner.nextInt();
            int edges = scanner.nextInt();
            Graph graph = new Graph(nodes);
            for (int j = 1; j <= nodes; j++) {
                graph.getVertices()[j] = new Node(j);
            }

            /*for (minpathstonodes.Node node : graph.getVertices()) {
                System.out.println(node);
            }*/

            for (int j = 0; j < edges; j++) {
                Node source = graph.getVertices()[scanner.nextInt()];
                Node target = graph.getVertices()[scanner.nextInt()];
                source.getAdjacent().add(target);
                target.getAdjacent().add(source);
            }

            Node start = graph.getVertices()[scanner.nextInt()];
            Set<Node> visited = new HashSet<>();
            visited.add(start);

            Queue<Node> toProcess = new LinkedList<>();
            toProcess.add(start);

            int[] distances = new int[graph.getVertices().length];
            Arrays.fill(distances, -1);
            distances[start.getData()] = 0;

            while (!toProcess.isEmpty()) {
                Node currentNode = toProcess.poll();
                for (Node neighbour : currentNode.getAdjacent()) {
                    if (!visited.contains(neighbour)) {
                        toProcess.add(neighbour);
                        distances[neighbour.getData()] = distances[currentNode.getData()] + 6;
                        visited.add(neighbour);
                    }
                }
            }

            for (int j = 1; j < distances.length; j++) {
                if (j != start.getData()) {
                    System.out.print(distances[j] + " ");
                }
            }
            System.out.println();
        }
    }
}

class Graph {

    private Node[] vertices;

    public Graph(int size) {
        vertices = new Node[size + 1];
    }

    public Node[] getVertices() {
        return vertices;
    }
}

class Node {
    private int data;
    private List<Node> adjacent;

    public Node(int data) {
        this.data = data;
        this.adjacent = new LinkedList<>();
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(data).hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Node)) {
            return false;
        }
        return Integer.valueOf(data).equals(((Node) o).data);
    }

    public List<Node> getAdjacent() {
        return adjacent;
    }

    public int getData() {
        return data;
    }

    @Override
    public String toString() {
        return "minpathstonodes.Node{" +
                "data=" + data +
                '}';
    }
}