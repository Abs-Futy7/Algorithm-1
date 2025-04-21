
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem1 {

    List<List<Integer>> g;
    boolean[] visited;
    boolean[] reachable;
    int C;

    public Problem1(int C) {
        this.C = C;
        g = new ArrayList<>();
        visited = new boolean[C + 1];
        reachable = new boolean[C + 1];
        for (int i = 0; i <= C; i++) {
            g.add(new ArrayList<>());
        }
    }

    public void dfs(int node, int fuelLeft){
        reachable[node] = true;
        visited[node] = true;

        if(fuelLeft == 0){
            visited[node] = false;
            return;
        }

        for(int neighbour : g.get(node)){
            if(!visited[neighbour]){
                dfs(neighbour, fuelLeft-1);
            }
        }

        visited[node] = false;
    }

    
    


    public void addEdge(int x, int y){
        g.get(x).add(y);
        g.get(y).add(x);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();
        int R = sc.nextInt();
        int K = sc.nextInt();
        int L = sc.nextInt();

        Problem1 obj = new Problem1(C);

        for(int i = 0 ; i < R ; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            obj.addEdge(x, y);
        }

        obj.dfs(L, K);

        int count = 0;

        for(int i = 1; i <= C ; i++){
            if(obj.reachable[i]){
                count++;
            }
        }

        System.out.println(count);
        sc.close();
    }
}
