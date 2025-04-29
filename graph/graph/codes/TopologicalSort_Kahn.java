import java.util.*;

public class TopologicalSort_Kahn {
    static List<Integer>[] g; // Adjacency list representation
    static int[] inDegree; // Array to track in-degree (number of incoming edges)
    static List<Integer> topoSort; // Stores the topological order

    // Function to perform Topological Sorting using Kahn's Algorithm (BFS)
    public static void topologicalSort(int nodeCount) {
        Queue<Integer> queue = new LinkedList<>();

        // Add all nodes with in-degree 0 to the queue
        for (int i = 1; i <= nodeCount; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll(); // Process the node with in-degree 0
            topoSort.add(node); // Store in topological order

            // Reduce in-degree for all its neighbors
            for (int child : g[node]) {
                inDegree[child]--;

                // If in-degree becomes 0, add it to the queue
                if (inDegree[child] == 0) {
                    queue.add(child);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of nodes and edges
        int node = scanner.nextInt();
        int edge = scanner.nextInt();

        g = new ArrayList[node + 1]; // Initialize adjacency list
        inDegree = new int[node + 1]; // Initialize in-degree array
        topoSort = new ArrayList<>(); // List to store topological order

        // Initialize adjacency list for each node
        for (int i = 1; i <= node; i++) {
            g[i] = new ArrayList<>();
        }

        // Read edges (Directed Graph)
        for (int i = 0; i < edge; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            g[x].add(y); // Directed edge from x → y
            inDegree[y]++; // Increase in-degree of y
        }

        // Perform Topological Sorting using Kahn's Algorithm
        topologicalSort(node);

        // Print Topological Sort Order
        System.out.println("Topological Sort Order:");
        if (topoSort.size() == node) {
            for (int val : topoSort) {
                System.out.print(val + " ");
            }
        } else {
            System.out.println("Graph contains a cycle! Topological Sort not possible.");
        }

        scanner.close(); // Close the scanner
    }
}

