/*

A bipartite graph is a type of graph in which the set of vertices can be divided into two disjoint sets such that no two vertices 
within the same set are adjacent. In other words, there are no edges that connect vertices within the same set. 
Bipartite graphs are also known as 2-colorable graphs because you can assign one of two colors to the vertices in such a way that no adjacent vertices have the same color.
Here's an example of how to represent and check if a graph is bipartite using an adjacency list representation in Java:

*/
import java.util.*;

public class BipartiteGraph {
    public static boolean isBipartite(List<List<Integer>> graph) {
        int n = graph.size();
        int[] colors = new int[n]; // Store the color of each vertex (-1, 0, or 1)
        Arrays.fill(colors, -1); // Initialize all colors to -1 (unassigned)

        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                if (!isBipartiteHelper(graph, i, colors)) {
                    return false; // The graph is not bipartite
                }
            }
        }
        return true; // All connected components are bipartite
    }

    private static boolean isBipartiteHelper(List<List<Integer>> graph, int vertex, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(vertex);
        colors[vertex] = 0; // Assign the color 0 to the initial vertex

        while (!queue.isEmpty()) {
            int currVertex = queue.poll();
            int currColor = colors[currVertex];

            for (int neighbor : graph.get(currVertex)) {
                if (colors[neighbor] == currColor) {
                    return false; // Found an edge within the same set, not bipartite
                }

                if (colors[neighbor] == -1) {
                    colors[neighbor] = 1 - currColor; // Assign the opposite color
                    queue.offer(neighbor);
                }
            }
        }

        return true; // This connected component is bipartite
    }

    public static void main(String[] args) {
        // Create an example bipartite graph as an adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        int n = 4; // Number of vertices

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(1).add(0);
        graph.get(2).add(3);
        graph.get(3).add(2);

        boolean isBipartite = isBipartite(graph);
        if (isBipartite) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
    }
}
