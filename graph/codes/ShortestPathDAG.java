import java.util.*;

public class ShortestPathDAG {
    List<int[]>[] g; // Adjacency list storing (neighbor, weight)
    int[] dist; // Stores shortest distances
    int nodeCount; // Number of nodes

    
    ShortestPathDAG(int nodeCount) {
        this.nodeCount = nodeCount;
        g = new ArrayList[nodeCount];

        for (int i = 0; i < nodeCount; i++) {
            g[i] = new ArrayList<>();
        }

        dist = new int[nodeCount];
        Arrays.fill(dist, Integer.MAX_VALUE); // Set all distances to infinity
    }

  
    void addEdge(int u, int v, int weight) {
        g[u].add(new int[]{v, weight});
    }

    // Topological Sorting using DFS
    void topologicalSort(int node, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (int[] neighbor : g[node]) {
            int nextNode = neighbor[0];
            if (!visited[nextNode]) {
                topologicalSort(nextNode, visited, stack);
            }
        }
        stack.push(node);
    }

    // Function to compute shortest path in a DAG
    void shortestPath(int src) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[nodeCount];

        // Step 1: Perform Topological Sort
        for (int i = 0; i < nodeCount; i++) {
            if (!visited[i]) {
                topologicalSort(i, visited, stack);
            }
        }

        // Step 2: Initialize source distance
        dist[src] = 0;

        // Step 3: Process nodes in topological order
        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (dist[node] != Integer.MAX_VALUE) {
                for (int[] neighbor : g[node]) {
                    int nextNode = neighbor[0], weight = neighbor[1];

                    if (dist[node] + weight < dist[nextNode]) {
                        dist[nextNode] = dist[node] + weight;
                    }
                }
            }
        }
    }

    // Function to print shortest distances
    void printDistances(int src) {
        System.out.println("Shortest distances from node " + src + ":");
        for (int i = 0; i < nodeCount; i++) {
            System.out.println("Node " + i + " -> " + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
        }
    }

   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    
        int node = scanner.nextInt();
        int edge = scanner.nextInt();

        ShortestPathDAG graph = new ShortestPathDAG(node);

 
        for (int i = 0; i < edge; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int weight = scanner.nextInt();
            graph.addEdge(u, v, weight);
        }

   
        int src = scanner.nextInt();

        graph.shortestPath(src);
 
        
        graph.printDistances(src);

        scanner.close();
    }
}
