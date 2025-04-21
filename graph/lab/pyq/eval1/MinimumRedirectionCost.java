import java.util.*;

public class MinimumRedirectionCost {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int R = scanner.nextInt(); // Number of cities/roads
        
        int[][] roads = new int[R][3];
        for (int i = 0; i < R; i++) {
            roads[i][0] = scanner.nextInt(); // a_i (source city)
            roads[i][1] = scanner.nextInt(); // b_i (destination city)
            roads[i][2] = scanner.nextInt(); // c_i (redirection cost)
        }
        
        int result = minimumCost(R, roads);
        System.out.println(result);
        
        scanner.close();
    }
    
    public static int minimumCost(int R, int[][] roads) {
        // Build an undirected graph to infer the original ring structure
        Map<Integer, Set<Integer>> undirectedGraph = new HashMap<>();
        for (int i = 1; i <= R; i++) {
            undirectedGraph.put(i, new HashSet<>());
        }
        
        // Create a map to store the directed edges and their costs
        Map<String, Integer> directedEdges = new HashMap<>();
        
        // Add edges to the undirected graph and store directed edges
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            int cost = road[2];
            
            // Cities a and b were adjacent in the original ring
            undirectedGraph.get(a).add(b);
            undirectedGraph.get(b).add(a);
            
            // Store the directed edge a->b and its cost
            String edge = a + "," + b;
            directedEdges.put(edge, cost);
        }
        
        // Infer the original ring structure
        List<Integer> ringOrder = new ArrayList<>();
        boolean[] visited = new boolean[R + 1];
        
        int startCity = 1; // Start from city 1
        ringOrder.add(startCity);
        visited[startCity] = true;
        
        int currentCity = startCity;
        while (ringOrder.size() < R) {
            for (int neighbor : undirectedGraph.get(currentCity)) {
                if (!visited[neighbor]) {
                    ringOrder.add(neighbor);
                    visited[neighbor] = true;
                    currentCity = neighbor;
                    break;
                }
            }
        }
        
        // Calculate the cost of redirecting all roads to go clockwise
        int clockwiseCost = 0;
        for (int i = 0; i < R; i++) {
            int city1 = ringOrder.get(i);
            int city2 = ringOrder.get((i + 1) % R);
            
            String clockwiseEdge = city1 + "," + city2;
            String counterClockwiseEdge = city2 + "," + city1;
            
            if (directedEdges.containsKey(counterClockwiseEdge)) {
                // If the road goes counter-clockwise, we need to redirect it
                clockwiseCost += directedEdges.get(counterClockwiseEdge);
            }
        }
        
        // Calculate the cost of redirecting all roads to go counter-clockwise
        int counterClockwiseCost = 0;
        for (int i = 0; i < R; i++) {
            int city1 = ringOrder.get(i);
            int city2 = ringOrder.get((i + 1) % R);
            
            String clockwiseEdge = city1 + "," + city2;
            String counterClockwiseEdge = city2 + "," + city1;
            
            if (directedEdges.containsKey(clockwiseEdge)) {
                // If the road goes clockwise, we need to redirect it
                counterClockwiseCost += directedEdges.get(clockwiseEdge);
            }
        }
        
        // Choose the direction with the lower total cost
        return Math.min(clockwiseCost, counterClockwiseCost);
    }
}
