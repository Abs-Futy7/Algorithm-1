// Time Complexity: O(n log n) for sorting + O(n × d) for scheduling
// Space Complexity: O(d) for the slot array.

import java.util.*;
public class KruskalMST {

    // Array to store edges, each edge is [u, v, weight]
    int[][] edges;

    // Arrays for Disjoint Set Union (DSU) - to track connected components
    int[] parent, rank;

    int n, e; // Number of vertices (n) and edges (e)

    // Constructor to initialize the graph and DSU arrays
    KruskalMST(int n, int e) {
        this.n = n;
        this.e = e;
        edges = new int[e][3]; // Store all edges
        parent = new int[n];   // DSU parent array
        rank = new int[n];     // DSU rank array (used to keep tree flat)

        // Initialize DSU: each node is its own parent initially
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // DSU 'find' function with path compression
    int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]); // Path compression
        }
        return parent[node];
    }

    // DSU 'union' function using union by rank
    void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU != rootV) {
            // Attach smaller rank tree under root of higher rank tree
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }

    // Add an edge to the edge list
    void addEdge(int index, int u, int v, int w) {
        edges[index][0] = u;
        edges[index][1] = v;
        edges[index][2] = w;
    }

    // Main function to compute Minimum Spanning Tree using Kruskal's Algorithm
    void kruskalMST() {
        // Step 1: Sort all edges in ascending order of their weight
        Arrays.sort(edges, Comparator.comparingInt(a -> a[2]));

        int mstWeight = 0; // Total weight of the MST
        List<int[]> mstEdges = new ArrayList<>(); // Store edges that are part of the MST

        // Step 2: Pick the smallest edge. Check if it forms a cycle using DSU
        for (int i = 0; i < e; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            // If u and v are in different sets, include this edge in MST
            if (find(u) != find(v)) {
                union(u, v); // Merge the sets
                mstWeight += w; // Add weight to MST total
                mstEdges.add(new int[]{u, v, w}); // Save this edge
            }
        }

        // Step 3: Output the result
        System.out.println("Edges in Minimum Spanning Tree:");
        for (int[] edge : mstEdges) {
            System.out.println(edge[0] + " -- " + edge[1] + " == " + edge[2]);
        }
        System.out.println("Total MST Weight: " + mstWeight);
    }

    // Driver function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of vertices and edges
        System.out.print("Enter number of vertices and edges: ");
        int n = sc.nextInt();
        int e = sc.nextInt();

        KruskalMST graph = new KruskalMST(n, e);

        // Read each edge (source, destination, weight)
        System.out.println("Enter edges (u, v, weight):");
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph.addEdge(i, u, v, w);
        }

        // Compute and print the MST
        graph.kruskalMST();
        sc.close();
    }
}
