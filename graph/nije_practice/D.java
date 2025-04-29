
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class D {
    List<Integer>[] g;
    boolean[] visited;
    Stack<Integer> st;

    D(int nodeCnt){
        g = new List[nodeCnt + 1];
        visited = new boolean[nodeCnt + 1];
        st = new Stack<>();

        for(int i = 0 ; i < nodeCnt ; i++){
            g[i] = new ArrayList<>();
        }
    }

    public void addEdge(int x, int y){
        g[x].add(y);
    }

    public void dfs(int node){
        visited[node] = true;
        for(int child : g[node]){
            if(!visited[child]){
                dfs(child);
            }
        }
        st.push(node);
    }

    public void topoSort(){
        for(int i = 0 ; i < g.length ; i++){
            if(!visited[i]){
                dfs(i);
            }
        }
    }

    public void printTopoSort(){
        System.out.println("Topological Sort:");
        while(!st.isEmpty()){
            System.out.print(st.pop() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int node = sc.nextInt();
        int edge = sc.nextInt();

        D graph = new D(node);

        for(int i = 0 ; i < edge ; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.addEdge(x, y);
        }

        graph.topoSort();
        graph.printTopoSort();
        sc.close();
    }
}
