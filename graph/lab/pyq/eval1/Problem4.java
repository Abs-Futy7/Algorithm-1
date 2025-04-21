import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Problem4 {
    List<Integer>[] g;  
    List<Integer>[] rg; 
    boolean[] visited;
    Stack<Integer> st;
    int count;
    int[] kingdom;


    public Problem4(int nodeCnt) {
        g = new ArrayList[nodeCnt + 1]; 
        rg = new ArrayList[nodeCnt + 1]; 
        visited = new boolean[nodeCnt + 1]; 
        st = new Stack<>(); 
        count = 0;
        kingdom = new int[nodeCnt + 1]; 

      
        for (int i = 1; i <= nodeCnt; i++) {
            g[i] = new ArrayList<>();
            rg[i] = new ArrayList<>();
        }
    }

  
    public void addEdge(int x, int y) {
        g[x].add(y);
        rg[y].add(x); 
    }


    public void dfs1(int node) {
        visited[node] = true;
        for (int child : g[node]) {
            if (!visited[child]) {
                dfs1(child);
            }
        }
        st.push(node);
    }

    
    public void dfs2(int node, int label) {
        visited[node] = true;
        kingdom[node] = label; // Assign kingdom label to node
        for (int child : rg[node]) {
            if (!visited[child]) {
                dfs2(child, label);
            }
        }
    }


    public void findKingdom(int nodeCnt) {
        Arrays.fill(visited, false);

     
        for (int i = 1; i <= nodeCnt; i++) {
            if (!visited[i]) {
                dfs1(i);
            }
        }

        Arrays.fill(visited, false);

        // Second DFS to assign SCC labels based on stack order
        while (!st.isEmpty()) {
            int node = st.pop();
            if (!visited[node]) {
                count++; // New SCC (kingdom) found
                dfs2(node, count);
            }
        }
    }
    public void printResult(int n) {
        System.out.println(count); // Number of SCCs (kingdoms)
        for (int i = 1; i <= n; i++) {
            System.out.print(kingdom[i] + " "); // Print the kingdom label for each planet
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        Problem4 obj = new Problem4(n);

        // Reading the edges
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            obj.addEdge(x, y);
        }

 
        obj.findKingdom(n);
        obj.printResult(n);

        sc.close();
    }
}
