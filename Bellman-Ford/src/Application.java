import static java.lang.Integer.MAX_VALUE;

public class Application {
    public static void main(String[] args) {
        final Graph graph = createGraph();
        int[] distance = new int[graph.getVertex()];
        boolean hasNegativeCycle = BellmanFordImpl.hasNegativeCycle(graph, 1, distance);
        if (!hasNegativeCycle) {
            System.out.println("Vertex \t: Distance");
            for (int i = 1; i < distance.length; i++)
                System.out.println("\t" + i + " " + "\t\t" + (distance[i] == MAX_VALUE ? "-" : distance[i]));
        } else {
            System.out.println("Negative cycle exists in the graph, no solution found!!!");
        }
    }

    private static Graph createGraph() {
        int v = 7;
        Graph g = new Graph(v);
        g.addEdge(1, 2, 4);
        g.addEdge(1, 4, 9);
        g.addEdge(2, 3, -1);
        g.addEdge(3, 6, 3);
        g.addEdge(4, 3, 2);
        g.addEdge(4, 5, -5);
        g.addEdge(5, 6, 0);
        return g;
    }
}
