
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C {
    List<Integer>[] g;
    boolean[] visited;

    C(int nodeCnt){
        g = new List[nodeCnt + 1];
        visited = new boolean[nodeCnt + 1];

        for(int i = 0 ; i < nodeCnt ; i++){
            g[i] = new ArrayList<>();
        }
    }

    public void dfs(int node){
        visited[node] = true;
        for(int child : g[node]){
            if(!visited[child]){
                dfs(child);
            }
        }
    }

    public void addEdge(int x, int y){
        g[x].add(y);
        g[y].add(x);
    }

    public void printGraph(){
        for(int i = 0 ; i < g.length ; i++){
            System.out.print(i + " -> ");
            for(int child : g[i]){
                System.out.print(child + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int node = sc.nextInt();
        int edge = sc.nextInt();

        C graph = new C(node);

        for(int i = 0 ; i < edge ; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.addEdge(x, y);
        }
    }

}
